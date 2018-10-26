package ken.dev.edulinkclassroom.Model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataStore {
    //private Gson gson = new Gson();
//TODO: Store data in files/local db
    public static final List<CourseUnit> CURRENT_UNITS = new ArrayList<>();
    public static final List<CourseUnit> COMPLETED_UNITS = new ArrayList<>();
    public static int CURRENT_YEAR = 2;
    public static final List<Lesson> LESSONS = new ArrayList<>();

    public static final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private static DatabaseReference unitsRef = firebaseDatabase.getReference("units");

    static {
        // Add sample item
        //addUnit(new CourseUnit("BCT 11","Dummy","d...","D.E",6));

        unitsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                CourseUnit x = dataSnapshot.getValue(CourseUnit.class);
                DataStore.addUnit(x);
                Log.println(Log.INFO, "checkpoint :", x.toString());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                CURRENT_UNITS.remove(dataSnapshot.getValue(CourseUnit.class));
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public DataStore(){}

    public static void addUnit(CourseUnit unit) {
        if (unit.getYear() == CURRENT_YEAR) {
            CURRENT_UNITS.add(unit);
        }else{
            COMPLETED_UNITS.add(unit);
        }

    }

    public static void addLesson(Lesson lesson) {
        LESSONS.add(lesson);
        Collections.sort(LESSONS);
    }


}