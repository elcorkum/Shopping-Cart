package shop;

public class Soda extends Food implements Perishable{
    public Soda(String productName, Size size, double price) {
        super(productName, size, price);
    }
    @Override
    public boolean isPerishable() {
        System.out.println("Eligible for 5-day return for store credit");
        return true;
    }
}
