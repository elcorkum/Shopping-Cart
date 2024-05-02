package shop;

public class Sweater extends Clothing implements Wearable{
    public Sweater(String productName, Size size, double price) {
        super(productName, size, price);
    }

    @Override
    public boolean isWearable() {
        System.out.println("Eligible for 30-day return.");
        return true;
    }
}
