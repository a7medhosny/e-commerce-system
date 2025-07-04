package model;
import util.Shippable;
public  class PerishableShippableProduct extends Product implements Shippable {
    final private boolean expired;
    final private double weight;

    public PerishableShippableProduct(String name, double price, int quantity, boolean expired, double weight) {
        super(name, price, quantity);
        this.expired = expired;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return expired;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
