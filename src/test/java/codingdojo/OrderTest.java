package codingdojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void setup() {
        order =new Order("1", new Date(), null, new Product[0]);
    }

    @Test
    void totalDollars() {
        assertEquals(0d, order.totalDollars());

        double expected = 0d;
        for (int i = 0; i < 100; i++) {
            expected += i;
            order.addProducts(new Product("Product" + i, "00" + i, 100, new Price(i, "USD")));
        }
        assertEquals(expected, order.totalDollars());

        order.addProducts(new Product("Product2", "002", 30, new Price(100, "EUR")));
        assertThrows(UnsupportedOperationException.class, () -> order.totalDollars());
    }

    @Test
    void testToString() {
        assertEquals("Order{1}", order.toString());
    }

    @Test
    void addProducts() {
        for(int i = 0; i < 100; i++)
            order.addProducts(new Product("Product" + i, "00" + i, 30, new Price(i, "USD")));

        assertEquals(100, order.getProducts().size());
    }
}