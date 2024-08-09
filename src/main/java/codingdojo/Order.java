package codingdojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class Order {

    private final String id;
    private final Date date;
    private final Collection<Product> products = new ArrayList<>();
    private final Store store;

    public Order(String id, Date date, Store store, Product[] products) {
        this.id = id;
        this.date = date;
        this.store = store;
        addProducts(products);
    }

    public double totalDollars() {
        return products.stream(). //
                mapToDouble(Product::getPriceInUSD).
                sum();
    }

    @Override
    public String toString() {
        return "Order{" + id + '}';
    }

    public void saveToDatabase() {
        throw new UnsupportedOperationException("missing from this exercise - shouldn't be called from a unit test");
    }

    public String getId() {
        return id;
    }

    public Collection<Product> getProducts() {
        return Collections.unmodifiableCollection(products);
    }

    public Date getDate() {
        return date;
    }

    public void addProducts(Product... products) {
        this.products.addAll(Arrays.asList(products));
    }

    public Store getStore() {
        return store;
    }

    private boolean isBeforeFirst2018() {
        return getDate().before(Util.fromIsoDate("2018-01-01T00:00Z"));
    }

    private double getOrderTax() {
        return isBeforeFirst2018() ? 10 : 20;
    }

    public double getTotalTax() {
        return getOrderTax() + getProductsTax();
    }

    private double getProductsTax() {
        return products.stream()
                .mapToDouble(Product::getTax)
                .sum();
    }

}
