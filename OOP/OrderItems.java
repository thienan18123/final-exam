
public class OrderItems {
	private final String productName;
    private final int quantity;
    private final double unitPrice;
    
    public OrderItems(String productName, int quantity, double unitPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
 
    public String getProductName() { 
    	return productName; 
    	}
    public int getQuantity()       { 
    	return quantity; 
    }
    double getUnitPrice()   { 
    	return unitPrice; 
    }
    public double getSubtotal()    { 
    	return quantity * unitPrice; 
    	}
}


 