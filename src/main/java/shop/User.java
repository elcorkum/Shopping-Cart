package shop;
import java.util.Map;

public class User {
    private static int sharedID;
    private int id;
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public User(){
        id = sharedID++;
        cart = new Cart();
    }

    public void addToCart(Product product, int quantity){
        Map<Product, Integer> currentInventory = Product.inventory;
        int numberOfThisProductInStock = currentInventory.get(product);
        Map<Product, Integer> currentListOfProducts = cart.getProducts();
        if (numberOfThisProductInStock - quantity >= 0){
            if(currentListOfProducts.containsKey(product)){
                currentListOfProducts.put(product, currentListOfProducts.get(product) + quantity);
            } else {
                currentListOfProducts.put(product, quantity);
            }
            numberOfThisProductInStock -= quantity;
            Product.inventory.put(product, numberOfThisProductInStock);
        } else {
            System.out.println("This product is currently low in inventory or out of stock\nPlease enter a lower quantity or pick a different item");
            System.out.println("-------------------------------------------------------");
        }
    }
    public void removeFromCart(Product product, Integer quantity){
        Map<Product, Integer> currentInventory = Product.inventory;
        int numberOfThisProductInStock = currentInventory.get(product);
        Map<Product, Integer> currentListOfProducts = cart.getProducts();

        try {
            if (currentListOfProducts.get(product) - quantity <= 0) {
                currentListOfProducts.remove(product);
            }else if(currentListOfProducts.get(product) - quantity > 0){
                currentListOfProducts.put(product, currentListOfProducts.get(product) - quantity);
            }
            Product.inventory.put(product, numberOfThisProductInStock + quantity);
        }
        catch(Exception e){
            System.out.println(product.getProductName() + " Size(" + product.getSize() + ") is not in the cart. Add to cart first");
            System.out.println("-------------------------------------------------------");
            }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", cart=" + cart +
                '}';
    }

}
