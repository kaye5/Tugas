public class Item {
	private String name;
	private double weight;
	private double price;
	public Item(String name, double weight, double price) {
		this.name = name; 
                this.weight = weight;
                this.price = price; 
	}

	// implementasi getter untuk name, weight, price
        public String getName(){
            return name;
        }
        public double getWeight(){
            return weight;
        }
        public double getPrice(){
            return price;
        }
	public String toString() {
		return String.format("Item<%s:%.2f:%.2f>", name, weight, price);
	}
}
