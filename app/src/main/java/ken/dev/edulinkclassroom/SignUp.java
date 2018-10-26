package ken.dev.edulinkclassroom;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import ken.dev.edulinkclassroom.Model.User;

public class SignUp extends AppCompatActivity {

    MaterialEditText editName, editEmail, editReg, editCourse, editPhone, editPassword, editcPassword;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editName = (MaterialEditText)findViewById(R.id.editName);
        editEmail = (MaterialEditText)findViewById(R.id.editEmail);
        editReg = (MaterialEditText)findViewById(R.id.editReg);
        editCourse = (MaterialEditText)findViewById(R.id.editCourse);
        editPhone = (MaterialEditText)findViewById(R.id.editPhone);
        editPassword = (MaterialEditText)findViewById(R.id.editPassword);
        editcPassword = (MaterialEditText)findViewById(R.id.editcPassword);


        btnSignUp = (Button)findViewById(R.id.btnSignUp);

        //Initialize Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("users");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                mDialog.setMessage("Please wait...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //check if the phone number is already registered
                        if(dataSnapshot.child(editPhone.getText().toString()).exists() || dataSnapshot.child(editReg.getText().toString()).exists()){
                            mDialog.dismiss();
                            if(dataSnapshot.child(editPhone.getText().toString()).exists()) {
                                Toast.makeText(SignUp.this, "Phone number is already registered.", Toast.LENGTH_SHORT).show();
                            }
                            else if(dataSnapshot.child(editReg.getText().toString()).exists()){
                                Toast.makeText(SignUp.this, "Registration number is already registered.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            mDialog.dismiss();
                            User user = new User(editName.getText().toString(), editEmail.getText().toString(), editReg.getText().toString(), editCourse.getText().toString(), editPassword.getText().toString());
                            table_user.child(editPhone.getText().toString()).setValue(user);

                            Toast.makeText(SignUp.this, "Signed up successfully.", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
