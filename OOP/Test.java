import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
    	
    	//level1:
//        Inventory inv = new Inventory();
//
//        System.out.println(inv.addProduct("iPhone", 1000));      
//        System.out.println(inv.findProduct("iPhone").get());     
//        System.out.println(inv.addProduct("iPhone", 1200));      
//        System.out.println(inv.addProduct("", 50));              
//        System.out.println(inv.addProduct("Pixel", 0));          
//
//        System.out.println(inv.updateStock("iPhone", -5));       
//        System.out.println("iPhone stock = " + inv.findProduct("iPhone").get().getStock()); 
//
//        System.out.println(inv.updateStock("iPhone", 10));       
//        System.out.println(inv.updateStock("iPhone", -4));       
//        System.out.println("iPhone stock = " + inv.findProduct("iPhone").get().getStock());  
//
//        System.out.println(inv.updateStock("Nokia", 5));         
    	
    	//level 2:
    	Inventory inv = new Inventory();
        inv.addProduct("iPhone", 1000);
        inv.addProduct("Samsung", 800);
        inv.updateStock("iPhone", 10);
        inv.updateStock("Samsung", 10);

        System.out.println("Storage:");
        System.out.println(inv.findProduct("iPhone").get() + "\n");
        System.out.println(inv.findProduct("Samsung").get() + "\n");

        
        Map<String, Integer> cart = new LinkedHashMap<>();
        cart.put("iPhone", 3);
        cart.put("Samsung", 2);

        Order o1 = inv.buy("John", cart).orElseThrow();
        System.out.println("Order:");
        System.out.println(o1);                                    
        System.out.println("\nInventory:");
        System.out.println("iPhone stock = "
                + inv.findProduct("iPhone").get().getStock());    
        System.out.println("Samsung stock = "
                + inv.findProduct("Samsung").get().getStock());    
    }
}