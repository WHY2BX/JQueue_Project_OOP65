
import java.io.Serializable;

public class User implements Serializable {
    public String fullname;
    public String student_id;
    public String role;

    public User(){
        this("", "", "");
    }

    public User(String fullname, String student_id, String role){
        this.fullname = fullname;
        this.student_id = student_id;
        this.role = role;
    }

    public User(String fullname, int student_id, String role){
        this.fullname = fullname;
        this.student_id = String.valueOf(student_id);
        this.role = role;
    }


      public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }




}