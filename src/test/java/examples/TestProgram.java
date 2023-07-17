package examples;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.Assert.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestProgram {

    @Test
    void test0() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Order(3)
    void test1() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Order(1)
    void test2() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Order(2)
    void test3() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void test4() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testZ() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testA() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testY() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testE() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testB() {
        assertEquals(2, 1 + 1);
    }
}

