import java.util.*;

public class Student extends User {
    private final boolean is_Ta = false;
    private ArrayList<Student> queue;


     public Student(){
        this("", "", "");

    }

    public Student(String fullname, String student_id,String role){
        super(fullname, student_id, role);

    }

    public Student(String fullname, int student_id, String role){
        super(fullname, student_id, role);


    }

}