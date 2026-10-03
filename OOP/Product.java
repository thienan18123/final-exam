
public class Product {
	private final String name;
	private final double price;
	private int stock = 0;
	
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getStock() {
		return stock;
	}
	
	
	public boolean adjustStock(int delta) {
		if (stock + delta < 0) {
			return false;
		}
		stock += delta;
		return true;
	}
	
	@Override
    public String toString() {
        return String.format("Product%nName: %s%nPrice: %.0f%nStock: %d", name, price, stock);
    }

}
