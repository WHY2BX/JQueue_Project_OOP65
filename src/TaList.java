import java.util.ArrayList;

public class TaList {
    private ArrayList<Ta> AllTA;
    private Ta ta01, ta02, ta03, ta04;
    private BookingList bk01, bk02, bk03, bk04;
    
    
    public TaList(){
    AllTA = new ArrayList();
        bk01 = new BookingList(); 
        bk02 = new BookingList();
        bk03 = new BookingList();  
        bk04 = new BookingList();
                
        ta01 = new Ta("Sahasawas W.", bk01);
        ta02 = new Ta("Sirimongkol T.",  bk02);
        ta03 = new Ta("Supitcha W.", bk03);
        ta04 = new Ta("Raiden Shogun", bk04);
        
        AllTA.add(ta01);
        AllTA.add(ta02);
        AllTA.add(ta03);
        AllTA.add(ta04);
    }
    
    public void add(Ta ta){
        AllTA.add(ta);
    }
    
    public Ta get(int index){
        return AllTA.get(index);
    }
    
    public int size(){
        return AllTA.size();
    }
    
    public int getIndexOf(String x){
        if(ta01.getFullname().equals(x)){
            return 0;
        }
        else if(ta02.getFullname().equals(x)){
            return 1;
        }
        else if(ta03.getFullname().equals(x)){
            return 2;
        }
        else if(ta04.getFullname().equals(x)){
            return 3;
        }
        else{
            return 0;
        }
    }
}
