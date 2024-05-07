package shop;

import java.util.HashMap;
import java.util.Map;

public abstract class Product{
    private static int sharedID = 0;
    private int id;

    private String productName;
    private Size size;
    private  double price;
    private Map<Product, Integer> inventory = new HashMap<>();

    public Map<Product, Integer> getInventory() {
        return inventory;
    }

    public String getProductName() {
        return productName;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0){
            this.price = price;
        }
    }

    public Product(String productName, Size size, double price){
        sharedID++;
        id = sharedID;
        inventory.put(this, 10);
        this.productName = productName;
        this.size = size;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n" +
                "Product id: " + id +
                ", Product Name: '" + productName + '\'' +
                ", Size: " + size +
                ", Price: " + price +
                ", Quantity: ";
    }
}
