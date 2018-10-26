package ken.dev.edulinkclassroom.Model;

public class User {
    private String Name;
    private String Email;
    private String Reg_No;
    private String Course;
    private String Password;
    private String ConfirmPassword;


    public User() {
    }

    public User(String name, String email, String reg_No, String course, String password) {
        Name = name;
        Email = email;
        Reg_No = reg_No;
        Course = course;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getReg_No() {
        return Reg_No;
    }

    public void setReg_No(String reg_No) {
        Reg_No = reg_No;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }
}
