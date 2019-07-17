import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.util.Comparator;
public class Inventory {
	// Item, Qty
	private List<InventoryItem> items;

	public Inventory() {
		this.items = new ArrayList<InventoryItem>();
	}

	public List<InventoryItem> getItems() { return items; }
	// mengembalikan banyak total item
	public int getItemTotalCount() {  
            int countItem = 0 ;
            for(InventoryItem item : items){
                
                countItem += item.getQty();
            }
            
            return countItem;
        }
	// mengembalikan item tertentu, kembalikan -1 jika tidak ditemukan
	public int getItemCount(Item item) { 
            
            for(InventoryItem myitem : items){
                Item myItemName = myitem.getItem();
                if(myItemName.equals(item)){
                    return myitem.getQty();
                }
            }
            return -1;
        }
	// mengurangi jumlah qty item tertentu, kembalikan jumlah qty yang berhasil diambil
	// jika qty > banyak item di inventory, kembalikan banyak item di inventory
	// jika tidak temukan throw NoSuchElementException
	// jika qty <= 0 throw IllegalArgumentException
	public int takeItem(Item item, int qty) { 
            String ItemName = item.getName();
            
            for(InventoryItem myitem : items){
                Item CurrentItem = myitem.getItem();
                String CurrentItemName = CurrentItem.getName();
                if(CurrentItemName.equals(ItemName)){
                    int itemQty = myitem.getQty();
                    if(qty<=0){
                        throw new IllegalArgumentException();
                    }
                    if(itemQty>qty){
                        myitem.setQty(itemQty-qty);
                        return qty;
                    }
                    else {
                        myitem.setQty(0);
                        return itemQty;
                    }
                        
                }
    
            }
            throw new NoSuchElementException("No Element Found");
        }
	// menambahkan item tertentu ke inventory sebanyak inventory
	// jika qty <= 0 throw IllegalArgumentException
	public void putItem(Item item, int qty) { 
            if(qty<=0)
                throw new IllegalArgumentException("Quantity value error");
            else {
                items.add(new InventoryItem(item,qty));
            }
        }
	// kembalikan list items yang diurutkan berdasarkan harga item (descending)
	public List<InventoryItem> getOrderByPrice() { 
            this.items.sort(new Comparator<InventoryItem>() {
				public int compare(InventoryItem I1, InventoryItem I2) {
					return (int)(I1.getItem().getPrice()- I2.getItem().getPrice()) * -1;
				}
		});
		return this.items;
                
           
        }
	// kembalikan list items yang diurutukan berdasarkan berat item (descending)
	public List<InventoryItem> getOrderByWeight() { 
            this.items.sort(new Comparator<InventoryItem>() {
				public int compare(InventoryItem I1, InventoryItem I2) {
					return (int)(I1.getItem().getWeight()*100- I2.getItem().getWeight()*100) * -1;
				}
		});
            return this.items;
        }
	// kembalikan list items yang diurutkan berdasarkan qty item (descending)
	public List<InventoryItem> getOrderByQty() { 
            this.items.sort(new Comparator<InventoryItem>() {
				public int compare(InventoryItem I1, InventoryItem I2) {
					return (int)(I1.getQty()- I2.getQty()) * -1;
				}
		});
		return this.items;
	}
}


