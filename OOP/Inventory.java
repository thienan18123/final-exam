import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Inventory {
	private final Map<String, Product> products = new HashMap<>();
	private final List<Order> orders = new ArrayList<>();
	private int orderCounter = 0;
	
	
	public boolean addProduct(String name, double price) {
		if (name == null || name.isBlank()) {
			System.out.println("product name must not be empty");
			return false;
		}
		if (price <= 0) {
			System.out.println("price must be greater than 0");
			return false;
		}
		if(products.containsKey(name) ) {
			System.out.println("product already exists");
			return false;
		}
		products.put(name, new Product(name,price));
		return true;
		
	}
	
	public boolean updateStock(String productName, int delta) {
		Product p = products.get(productName);
		if (p == null) {
			System.out.println("Products " + productName + " does not exist");
			return false;
		}
		if (!p.adjustStock(delta)) {
			System.out.println("Invalid Stock");
			return false;
		}
		return true;
	}
	
	public Optional<Product> findProduct(String name) {
		return Optional.ofNullable(products.get(name));
	}
	              
	public Optional<Order> buy(String customerName, Map<String, Integer> items) {
		if ( customerName == null || customerName.isBlank()) {
            System.out.println("Customer name must not be empty.");
            return Optional.empty();
        }
        if (items == null || items.isEmpty()) {
            System.out.println("Order has no items.");
            return Optional.empty();
        }
        
        for (Map.Entry<String, Integer> e : items.entrySet()) {
            String name = e.getKey();
            Integer qty = e.getValue();
            Product p = products.get(name);
 
            if (p == null) {
                System.out.println("Order rejected: product '" + name + "' does not exist.");
                return Optional.empty();
            }
            if (qty == null || qty <= 0) {
                System.out.println("Order rejected: quantity for '" + name + "' must be greater than 0.");
                return Optional.empty();
            }
            if (p.getStock() < qty) {
                System.out.println("Order rejected: not enough stock for '" + name
                        + "' (requested " + qty + ", available " + p.getStock() + ").");
                return Optional.empty();
            }
        }
        
        String code = String.format("ORD-%03d", ++orderCounter);
        List<OrderItems> lines = new ArrayList<>();
        for (Map.Entry<String, Integer> e : items.entrySet()) {
            Product p = products.get(e.getKey());
            int qty = e.getValue();
            p.adjustStock(-qty);
            lines.add(new OrderItems(p.getName(), qty, p.getPrice()));
        }
 
        Order order = new Order(code, customerName, lines);
        orders.add(order);
        return Optional.of(order);
	}


}
