package examples;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ArithmeticExceptionTest {

    @Test
    void toTestArithmeticException() {

        Exception exception = assertThrows(ArithmeticException.class, () -> divide(1, 0));

        assertEquals("/ by zero", exception.getMessage());

        assertTrue(exception.getMessage().contains("zero"));

    }
    int divide(int input, int divide) {
        return input / divide;
    }
}