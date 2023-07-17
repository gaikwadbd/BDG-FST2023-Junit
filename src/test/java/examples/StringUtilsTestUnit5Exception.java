package examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTestUnit5Exception {


    @Test
    public void convertToIntNullParameterAssertThrows() {
        String st = null;
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.convertToInt(st);
        });

    }

    @Test
    public void convertToIntNullParameterExpectThrows() {
        String st = null;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.convertToInt(st);
        });
        assertEquals("String must be not null or empty", exception.getMessage());
    }

    @Test
    public void convertToIntNullParameterTryCatchIdiom() {
        String st = null;
        try {
            StringUtils.convertToInt(st);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("String must be not null or empty", e.getMessage());
        }
    }

}