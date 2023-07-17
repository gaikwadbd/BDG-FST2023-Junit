package examples;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class MethodAlphanumericOrderTest {

    @Test
    void testZ11() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testA12() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void test13Y() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testE11() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testB() {
        assertEquals(2, 1 + 1);
    }
}
