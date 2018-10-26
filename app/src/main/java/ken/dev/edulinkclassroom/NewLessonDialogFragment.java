package ken.dev.edulinkclassroom;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ken.dev.edulinkclassroom.Model.Lesson;


public class NewLessonDialogFragment extends DialogFragment {

    private static final String ARG_LESSONTYPE = "lessontype";

    private Lesson.TYPE mLessonType;

    public NewLessonDialogFragment() {
        // Required empty public constructor
    }

    //Factory method
    public static NewLessonDialogFragment newInstance(String lessonType) {
        NewLessonDialogFragment fragment = new NewLessonDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_LESSONTYPE, lessonType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String tmp = getArguments().getString(ARG_LESSONTYPE);
            mLessonType = Lesson.TYPE.valueOf(tmp);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_lesson_dialog, container, false);
        //TODO: Bind views with data
        Button submitBtn = view.findViewById(R.id.new_lesson_submit_btn);
        Button cancelBtn = view.findViewById(R.id.new_lesson_cancel_btn);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

}
