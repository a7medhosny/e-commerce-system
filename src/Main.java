import data.Cart;
import model.Cheese;
import model.Customer;
import model.ScratchCard;
import service.CheckoutService;

public class Main {
    public static void main(String[] args) {

        // 1. Successful checkout
        System.out.println("==== Case 1: Successful Checkout ====");
        Customer customer1 = new Customer("Ahmed", 500);
        Cart cart1 = new Cart();
        try {
            Cheese cheese = new Cheese("Cheese", 100, 5, false, 200);
            ScratchCard card = new ScratchCard("Scratch Card", 50, 10);

            cart1.add(cheese, 3);
            cart1.add(card, 1);
            CheckoutService.checkout(customer1, cart1);
        } catch (IllegalArgumentException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }

        //  2. Empty cart
        System.out.println("\n==== Case 2: Empty Cart ====");
        Customer customer2 = new Customer("Fathy", 300);
        Cart cart2 = new Cart();
        try {
            CheckoutService.checkout(customer2, cart2);
        } catch (IllegalArgumentException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }

        //  3. Expired product
        System.out.println("\n==== Case 3: Expired Product ====");
        Customer customer3 = new Customer("Omar", 400);
        Cart cart3 = new Cart();
        try {
            Cheese expiredCheese = new Cheese("Old Cheese", 80, 2, true, 150);
            cart3.add(expiredCheese, 1);
            CheckoutService.checkout(customer3, cart3);
        } catch (IllegalArgumentException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }

        //  4. Quantity exceeds stock
        System.out.println("\n==== Case 4: Quantity Exceeds Stock ====");
        Customer customer4 = new Customer("Mostafa", 300);
        Cart cart4 = new Cart();
        try {
            Cheese cheese = new Cheese("Cheese", 100, 2, false, 200);
            cart4.add(cheese, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error while adding item to cart: " + e.getMessage());
        }

        //  5. Insufficient balance
        System.out.println("\n==== Case 5: Insufficient Balance ====");
        Customer customer5 = new Customer("Ali", 100);
        Cart cart5 = new Cart();
        try {
            Cheese cheese = new Cheese("Cheese", 100, 5, false, 200);

            cart5.add(cheese, 3);

            CheckoutService.checkout(customer5, cart5);
        } catch (IllegalArgumentException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
    }
}
