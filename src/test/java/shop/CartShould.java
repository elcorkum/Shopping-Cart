package shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartShould {
    @Test
    public void returnCorrectSubtotal(){
        Hat hat = new Hat("Bucket Hat", Size.L, 6.50);
        Shirt shirt = new Shirt("Tee", Size.S, 3.50);
        User user = new User();
        user.addToCart(hat,3);
        user.addToCart(shirt, 6);
        double subtotal = 3 * 6.50 + 6 * 3.50;
        assertEquals(subtotal, user.getCart().calculateSubtotal());
    }

    @Test
    public void returnCorrectTotalAfterTax(){
        Hat hat = new Hat("Bucket Hat", Size.L, 6.50);
        Shirt shirt = new Shirt("Tee", Size.S, 3.50);
        User user = new User();
        user.addToCart(hat,3);
        user.addToCart(shirt, 6);
        double subtotal = (3 * 6.50) + (6 * 3.50);
        double totalAfterTax = subtotal + subtotal * user.getCart().getTAX();
        double expected = (double) Math.round(totalAfterTax * 100) / 100;
        assertEquals(expected, user.getCart().calculateTotalAfterTax());

    }

    @Test
    public void returnCorrectNumberOfItemsInCart(){
        Hat hat = new Hat("Bucket Hat", Size.L, 6.50);
        Shirt shirt = new Shirt("Tee", Size.S, 3.50);
        User user = new User();
        user.addToCart(hat,3);
        user.addToCart(shirt, 6);
        int cartQuantity = 3 + 6;
        assertEquals(cartQuantity, user.getCart().cartQuantity());
    }

}