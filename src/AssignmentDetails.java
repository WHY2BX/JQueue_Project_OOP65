public class  AssignmentDetails {
    private static int workNumber;
    private static String assignmentName;
    private static String assignmentDeadline;
    
    public AssignmentDetails(){
        this(0, "", "");
    }
    public AssignmentDetails(int workNumber, String name, String deadline){
        this.workNumber = workNumber;
        this.assignmentName = name;
        this.assignmentDeadline = deadline;
    }

    public void setWorkNumber(int workNumber) {
        this.workNumber = workNumber;
    }

    public int getWorkNumber() {
        return workNumber;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public String getAssignmentDeadline() {
        return assignmentDeadline;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public void setAssignmentDeadline(String assignmentDeadline) {
        this.assignmentDeadline = assignmentDeadline;
    }
    
    
}
