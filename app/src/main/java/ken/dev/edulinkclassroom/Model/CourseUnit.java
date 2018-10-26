package ken.dev.edulinkclassroom.Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CourseUnit {

    private String unitCode, unitName, unitDescription, unitLecturer;
    private  int year;
    // Write to database
    private static FirebaseDatabase database = DataStore.firebaseDatabase;
    private static final DatabaseReference unitsRef = database.getReference("units");

    public static void addCourseUnit(CourseUnit x) {
            unitsRef.child(x.unitCode).setValue(x); //new child, unit code as key
    }

    public CourseUnit() {
    }

    public CourseUnit(String unitCode, String unitName, String unitDescription, String unitLecturer, int year) {
        this.unitCode = unitCode;
        this.unitName = unitName;
        this.unitDescription = unitDescription;
        this.unitLecturer = unitLecturer;
        this.year = year;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitDescription() {
        return unitDescription;
    }

    public void setUnitDescription(String unitDescription) {
        this.unitDescription = unitDescription;
    }

    public String getUnitLecturer() {
        return unitLecturer;
    }

    public void setUnitLecturer(String unitLecturer) {
        this.unitLecturer = unitLecturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return unitCode + "\t" + unitName + "\t" + year;
    }
}