import java.util.ArrayList;

public class IndexPass extends getThatIndexOf{
    private ArrayList<Integer> index;
    
    public IndexPass(){
        index = new ArrayList<Integer>();
        index.add(0);
    }
    
    public void setIndex(int index){
        this.index.set(0, index);
    }
    
    public int getIndex(){
        return this.index.get(0);
    }

    @Override
    public int getindexof(String x) {
        return this.index.get(0);    
    }
    
    
}

