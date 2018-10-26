package ken.dev.edulinkclassroom.Model;


import android.support.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class Lesson implements Comparable<Lesson>{
    private String unitName, venue, extraInfo, lecturer;
    private Date startTime,date, endTime;
    private GROUP forGroup = GROUP.BOTH;

    public  enum TYPE {
        PERSONAL, REGULAR_CLASS //GROUP
    }
    private static FirebaseDatabase database = DataStore.firebaseDatabase;
    private static DatabaseReference lessonsRef = database.getReference("lessons");

//TODO: Organize lessons by course

    public Lesson(){}

    @Override
    public int compareTo(@NonNull Lesson lesson) {
        if (startTime.before(lesson.getStartTime())) {
            return 1;
        } else {
            return 0;
        }
    }

    public enum GROUP{
        GROUP_A, GROUP_B, BOTH
    }
//getters and setters

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String dateVenue) {
        this.unitName = unitName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
