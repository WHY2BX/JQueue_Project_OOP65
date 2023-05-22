import java.util.*;

public class Ta extends User{
    private final boolean is_Ta = true;
    private boolean is_Empty;
    private BookingList bk;
    private int remainQ;

     public Ta(){
        this("", "", "", null);

    }

    public Ta(String fullname, String student_id,String role, BookingList bk){
        super(fullname, student_id, role);
        this.bk = bk;

    }

    public Ta(String fullname, int student_id, String role, BookingList bk){
        super(fullname, student_id, role);
        this.bk = bk;
    }

    public Ta(String fullname, BookingList bk){
        this.fullname = fullname;
        this.bk = bk;
        this.is_Empty = true;
    }


    public BookingList getQueue() {
        return bk;
    }

    public void setQueue(BookingList bk) {
        this.bk = bk;
    }


    public void setis_Empty(boolean is_Empty){
        this.is_Empty = is_Empty;
    }

    public boolean getis_Empty(){
        return is_Empty;
    }
    
    public void addRemainQ(){
        remainQ++;
    }
    
    public void delRemainQ(){
        remainQ--;
    }
    
    public void setRemainQ(int i){
        this.remainQ = i;
    }
    
    public int getRemainQ(){
        return this.remainQ;
    }
    
//    public BookingList getIndexOfWork(String x){
//        return this.bk;
//    }
    
//    public void returnVal(){
//        
//    }
//    public void checkQueue(){
//        if(queue.size() == 6){
//            is_Empty = false;
//        }
//        else{
//            is_Empty = true;
//        }
//    }


}