
import java.util.ArrayList;

public class AssignmentList {
    private static ArrayList<AssignmentDetails> AllAssignDetails;
    
    public AssignmentList(){
        AllAssignDetails = new ArrayList();
    }
    
    public static void add(AssignmentDetails ad){
        AllAssignDetails.add(ad);
    }
    
    public  static AssignmentDetails get(int index){
        return AllAssignDetails.get(0);
    }
}
