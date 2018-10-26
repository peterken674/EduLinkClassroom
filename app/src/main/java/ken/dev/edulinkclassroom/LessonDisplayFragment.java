package ken.dev.edulinkclassroom;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.text.SimpleDateFormat;
import java.util.Locale;

import ken.dev.edulinkclassroom.Model.Lesson;


public class LessonDisplayFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam2;
    private Lesson lesson;
    private OnFragmentInteractionListener mListener;

    public LessonDisplayFragment() {
        // Required empty public constructor
    }

    public void setLesson(Lesson l){
        this.lesson = l;
    }

    public static LessonDisplayFragment newInstance(Lesson lesson) {
        LessonDisplayFragment lf = new LessonDisplayFragment();
        lf.setLesson(lesson);
        return  lf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lesson_display, container, false);
        TextView lessonDate = view.findViewById(R.id.lessonDate);
        TextView lessonStartTime = view.findViewById(R.id.lessonStartTimeVenue);
        TextView lessonEndTime = view.findViewById(R.id.lessonEndTime);
        TextView extraInfo = view.findViewById(R.id.lessonTopicInfo);

        String tmp;
        SimpleDateFormat sf = new SimpleDateFormat("EEEE, d MMMM", Locale.US);

        tmp = sf.format(lesson.getDate()) + " at " + lesson.getVenue();
        lessonDate.setText(tmp);
        sf = new SimpleDateFormat("h:mm a", Locale.US);
        tmp = "From\t" + sf.format(lesson.getStartTime());
        lessonStartTime.setText(tmp);
        tmp = "To\t" + sf.format(lesson.getEndTime());
        lessonEndTime.setText(tmp);
        tmp = lesson.getExtraInfo() + "\nLecturer: " + lesson.getLecturer();
        extraInfo.setText(tmp);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
