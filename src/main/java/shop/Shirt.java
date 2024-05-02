package shop;

public class Shirt extends Clothing implements Wearable{
    public Shirt(String productName, Size size, double price) {
        super(productName, size, price);
    }

    @Override
    public boolean isWearable() {
        System.out.println("Eligible for 60-day returns.");
        return true;
    }
}
