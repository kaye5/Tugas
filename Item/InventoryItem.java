import java.util.Comparator;
public class InventoryItem {
	private Item item;
	private int qty =0 ;

	// default qty = 0
	public InventoryItem(Item item) {
            this.item = item;
            this.qty++; 
	}

	// default qty = qty
	public InventoryItem(Item item, int qty) {
            this.item = item;
            this.qty = qty;
	}

	// kembalikan item
	public Item getItem() { return item;}

	// kembalikan jumlah qty
	public int getQty() { return qty; }

	// ubah qty menjadi sebanyak qty
	// jika qty < 0 throw IllegalArgumentException
	public int setQty(int qty) { 
            if(qty<0){
               throw new IllegalArgumentException("Quantity value error");
            }
            else {
                return this.qty = qty;
            }     
        }
	
	public String toString() {
		return String.format("<InventoryItem:%s:%d>", item.toString(), qty);
	}
        
        public static Comparator<InventoryItem> QtyComparator= new Comparator<InventoryItem>() {

	public int compare(InventoryItem s1, InventoryItem s2) {
	   int qty1 = s1.getQty();
	   int qty2 = s2.getQty();
           return qty2-qty1;
    }};
}
