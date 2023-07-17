package examples;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Disabled("Disabled until CustomerService is up!")
public class DisabledTestMethodExample {

    @Test
    void testCustomerServiceGet() {
        assertEquals(2, 1 + 1);
    }


    @Test
    void test3Plus3() {
        assertEquals(6, 3 + 3);
    }

    @Test
    void test1Plus1() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void test2Plus2() {
        assertEquals(4, 2 + 2);
    }
}
