public class BookingDetails {
    private Student student;
    private String assignName;
    private String tableNum;
    
    public BookingDetails(){
        this(null, "", "");
    }
    public BookingDetails(Student student, String assignTxt, String tableNum){
        this.student = student;
        this.assignName = assignTxt;
        this.tableNum = tableNum;
    }
    
    public Student getStudent(){
        return this.student;
    }
    public void setStudent(Student student){
        this.student = student;
    }
    
    public String getAssignName(){
        return this.assignName;
    }
    public void setAssignName(String name){
        this.assignName = name;
    }
    
    public String getTableNum(){
        return this.tableNum;
    }
    public void setTableNum(String num){
        this.tableNum = num;
    }

}
