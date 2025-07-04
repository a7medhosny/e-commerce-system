package model;

public class Cheese extends PerishableShippableProduct {
    public Cheese(String name, double price, int quantity, boolean expired, double weight) {
        super(name, price, quantity, expired, weight);
    }
}
