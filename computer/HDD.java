package Computer;
public class HDD extends Storage{
    public int capacity;
    public HDD(int capacity){
        super(capacity);
    }
    public String getName(){
        return "HDD";
    }
}
