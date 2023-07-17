package examples;

import org.junit.jupiter.api.Test;

import javax.naming.NameNotFoundException;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class NameNotFoundExceptionTest {

    @Test
    void testNameNotFoundExcetion() {
        Exception exception = assertThrows(NameNotFoundException.class, () -> findByName("FullStack Tester Batch July 2023"));
        assertTrue(exception.getMessage().contains("not found"));
    }

    String findByName(String name) throws NameNotFoundException{
        throw new NameNotFoundException( name + " not found!");
    }
}
