package codingdojo;

import java.util.Collection;

public class TaxCalculator {

    private TaxCalculator() {
    }
    public static double calculateAddedTax(Collection<Order> orders) {
        return orders
                .stream()
                .mapToDouble(Order::getTotalTax)
                .sum();
    }
}
