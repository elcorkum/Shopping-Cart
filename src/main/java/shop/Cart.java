package shop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products;
    private final float TAX = 0.06f;
    private SaleSchedule special;

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public Cart(){
        this.products = new HashMap<>();
        printSpecial();
    }

    @Override
    public String toString() {
        return "Shopping Cart\n" +
                "Current list of products: " + products;
    }

    public void printSpecial(){
        System.out.println("Welcome to our store...");
        Date date = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("EEEE");
        String dayOfWeek = simpleDate.format(date);
        special = SaleSchedule.valueOf(dayOfWeek.toUpperCase());
        switch(special){
            case SUNDAY:
                System.out.println("Get 10% off your total purchase today!");
                break;
            case MONDAY:
                System.out.println("Seniors(65+) get 30% off total purchase today!");
                break;
            case TUESDAY:
                System.out.println("Get 5% off all food items purchased today");
                break;
            case WEDNESDAY:
                System.out.println("Wear Wednesday! 5% off all clothing items excluding jewelery and accessories");
                break;
            case THURSDAY:
                System.out.println("BOGO up to 10 items under $25. That's 10 items for the price of 5!");
                break;
            case FRIDAY:
                System.out.println("TGIF! Clearance items staring at $.99");
                break;
            case SATURDAY:
                System.out.println("Snag our BOGO half-off deal. That's 50% of your second item!");
                break;
        }
        System.out.println("-------------------------------------------------------");
    }

    public double calculateSubtotal(){
        double subtotal = 0;
        for(Map.Entry<Product, Integer> entry: products.entrySet()){
            Product product = entry.getKey();
            double quantity = entry.getValue();
            subtotal += product.getPrice() * quantity;
        }
        return ((double) Math.round(subtotal * 100) / 100);
    }

    public double calculateTotalAfterTax(){
        double totalAfterTax = 0;
        double subtotal = calculateSubtotal();
        double totalTax = subtotal * this.TAX;
        totalAfterTax = subtotal + totalTax;
        return ((double) Math.round(totalAfterTax * 100) / 100);
    }

    public void checkOut(){
        StringBuilder receipt = new StringBuilder();
        Date date = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("EEEE, MMMM dd, y");
        String todaysDate = simpleDate.format(date);
        receipt.append("\n----------------------------------------------\n");
        receipt.append("\t\t\tYour purchases today:\n\n");
        for(Map.Entry<Product, Integer> entry: products.entrySet()){
            Product product = entry.getKey();
            double quantity = entry.getValue();
            receipt.append(String.format("%s(Size %s)\t\tPrice %c%.2f\t\tQuantity %d\n",product.getProductName(), product.getSize(), '$', product.getPrice(), ((int)quantity)));
        }
        receipt.append(String.format("\n\t\t\tSubTotal\t %-10.2f", calculateSubtotal()))
                .append(String.format("\n\t\t\tTotal Tax\t %-10.2f", calculateSubtotal() * this.TAX))
                .append(String.format("\n\t\t\tTotal\t\t %-10.2f", calculateTotalAfterTax()))
                .append(String.format("\n\n\t\t\t%s", todaysDate));
        receipt.append("\n----------------------------------------------\n");
        System.out.println(receipt);
    }
}
