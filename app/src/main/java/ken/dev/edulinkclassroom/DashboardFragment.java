package ken.dev.edulinkclassroom;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import ken.dev.edulinkclassroom.Model.Lesson;


public class DashboardFragment extends Fragment {

    private Context context;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedinstancestate){
        super.onCreate(savedinstancestate);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //TODO: if any lessons exist
        FragmentTransaction ft = getFragmentManager().beginTransaction();
//TODO: get next lesson, pass it to 57
        //dummy lesson
        Lesson l = new Lesson();
        l.setVenue("Venue here");
        l.setUnitName("Unit name/code");
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        try {
            l.setDate(sf.parse("16-10-2018"));
            sf = new SimpleDateFormat("HH:mm", Locale.US);
            l.setStartTime(sf.parse("10:30"));
            l.setEndTime(sf.parse("13:30"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        l.setExtraInfo("additional data here, topic");
//57
        LessonDisplayFragment nextLessonDisplayFragment = LessonDisplayFragment.newInstance(l);
        ft.replace(R.id.nextLessonHolder, nextLessonDisplayFragment);
        ft.commit();
        //end if
        displayUpcoming(view);

        ImageButton addLessonBtn = view.findViewById(R.id.dashboardAddLessonImageButton);
        addLessonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: dialog to add lesson
                DialogFragment dialogFragment = NewLessonDialogFragment.newInstance(Lesson.TYPE.REGULAR_CLASS.toString());
                dialogFragment.setStyle(DialogFragment.STYLE_NORMAL,R.style.ThemeOverlay_AppCompat_Dialog);

                dialogFragment.show(getFragmentManager(), "AddLesson");
            }
        });
        return view;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    private void displayUpcoming(View dashb){
        //TODO: Count upcoming events and display them


    }
}
