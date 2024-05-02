package shop;

public class Fries extends Food implements Perishable{
    public Fries(String productName, Size size, double price) {
        super(productName, size, price);
    }

    @Override
    public boolean isPerishable() {
        System.out.println("Not eligible for return. Purchase is final");
        return true;
    }
}
