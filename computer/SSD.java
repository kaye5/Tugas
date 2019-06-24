package Computer;

public class SSD extends Storage {
    public int capacity;
    public SSD(int capacity){
        super(capacity);
    }
    public String getName(){
        return "SSD";
    }
}
