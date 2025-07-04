package service;

import util.Shippable; // تأكد إنه ده نفس اللي في ملفك
import java.util.Map;

public class ShippingService {
    public static void ship(Map<Shippable, Integer> items) {
        System.out.println("** Shipment notice **");

        double totalWeight = 0;

        for (Map.Entry<Shippable, Integer> entry : items.entrySet()) {
            Shippable product = entry.getKey();
            int quantity = entry.getValue();
            double itemTotalWeight = product.getWeight() * quantity;

            System.out.println(quantity + "x " + product.getName() + "     " + itemTotalWeight + "g");
            totalWeight += itemTotalWeight;
        }

        System.out.println("Total package weight " + (totalWeight / 1000.0) + "kg\n");
    }
}
