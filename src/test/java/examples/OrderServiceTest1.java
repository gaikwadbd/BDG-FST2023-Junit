package examples;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("service")
public class OrderServiceTest1 {

    @Test
    @Tag("slow")
    public void placeOrderTest() {
    }

    @Test
    @Tag("fast")
    public void checkout() {
    }

    @Test
    @Tag("slow")
    public void doPayment() {
    }

    @Test
    @Tag("fast")
    public void validateOrder() {
    }
}