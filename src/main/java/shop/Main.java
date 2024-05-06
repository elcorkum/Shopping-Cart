package shop;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        Soda soda1 = new Soda("FruitPunch", Size.M, 2.99);
        Soda soda2 = new Soda("FruitPunch", Size.L, 4.39);
        user.addToCart(soda1,3);
        user.addToCart(soda2, 5);



        System.out.println(user.getCart());
        user.addToCart(soda2, 4);
        System.out.println(user.getCart());

       user.removeFromCart(soda1, 1);
       System.out.println(user.getCart());
       double subtotal = user.getCart().calculateSubtotal();
       System.out.println(subtotal);
       double total = user.getCart().calculateTotalAfterTax();
       System.out.println(total);
       user.getCart().checkOut();
       user.getCart().checkReturnPolicy(soda1);

       user.getCart().checkReturnPolicy(soda1);
       System.out.println(user.getCart().cartQuantity());
    }
}
