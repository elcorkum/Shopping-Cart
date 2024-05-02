package shop;

public class Hat extends Clothing implements Wearable{
    public Hat(String productName, Size size, double price) {
        super(productName, size, price);
    }

    @Override
    public boolean isWearable() {
        System.out.println("Eligible for 30-day return.");
        return true;
    }
}
