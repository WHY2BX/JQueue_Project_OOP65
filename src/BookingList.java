
import java.util.ArrayList;

public class BookingList extends getThatIndexOf{
    private ArrayList<BookingDetails> AllBookingDetails;
    
    public BookingList(){
    AllBookingDetails = new ArrayList();
    }
    
    public void add(BookingDetails bd){
        AllBookingDetails.add(bd);
    }
    
    public BookingDetails get(int index){
        return AllBookingDetails.get(index);
    }
    
    public int size(){
        return AllBookingDetails.size();
    }
    public void remove(int x){
        AllBookingDetails.remove(x);
    }
//    public int getIndexOf(String x){
//        return AllBookingDetails.indexOf(x);
//    }
    public void forEach(){
        if(AllBookingDetails.size()==0){
            System.out.println("Blank");
        }
        else{
            System.out.println("Still remain");
        }
            
    }

    @Override
    public int getindexof(String x) {
        return AllBookingDetails.indexOf(x);
    }
}
