import java.util.List;

public class Order {
	private final String code;
    private final String customerName;
    private final List<OrderItems> items;
 
    Order(String code, String customerName, List<OrderItems> items) {
        this.code = code;
        this.customerName = customerName;
        this.items = List.copyOf(items);
    }
 
    public String getCode()           { 
    	return code; 
    	}
    String getCustomerName()   { 
    	return customerName; 
    }
    List<OrderItems> getItems() { 
    	return items; 
    	}
 
    public double getTotal() {
        double total = 0;
        for (OrderItems item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

}
