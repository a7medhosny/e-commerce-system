package service;

import model.CartItem;
import model.Customer;
import model.Product;
import data.Cart;
import util.Shippable;
import java.util.*;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty. Please add items before checking out.");
        }

        double subtotal = 0;
        Map<Shippable, Integer> shippablesMap = new LinkedHashMap<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();

            if (p.isExpired()) {
                throw new IllegalArgumentException("Product \"" + p.getName() + "\" is expired and cannot be purchased.");
            }

            if (item.getQuantity() > p.getQuantity()) {
                throw new IllegalArgumentException("Requested quantity for product \"" + p.getName() + "\" is not available.");
            }

            subtotal += item.getTotalPrice();

            if (p instanceof Shippable) {
                Shippable shippable = (Shippable) p;
                shippablesMap.put(shippable, shippablesMap.getOrDefault(shippable, 0) + item.getQuantity());
            }

            p.reduceQuantity(item.getQuantity());
        }

        double shipping = shippablesMap.isEmpty() ? 0 : 30;
        double total = subtotal + shipping;

        if (customer.getBalance() < total) {
            throw new IllegalArgumentException("Customer balance is insufficient. Required amount: " + total);
        }

        if (!shippablesMap.isEmpty()) {
            ShippingService.ship(shippablesMap);
        }

        customer.pay(total);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "     " + item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal         " + subtotal);
        System.out.println("Shipping         " + shipping);
        System.out.println("Total Amount     " + total);
        customer.printBalance();
    }
}
