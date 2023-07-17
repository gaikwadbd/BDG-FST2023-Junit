package examples;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calc;
    @BeforeEach

    public void setup(){
         calc=new Calculator();

    }


    @Test
    @DisplayName("Test for Addition ")
    @RepeatedTest(5)
    public void addTest(){
        int num1 = new Random().nextInt(10);
        int num2 = new Random().nextInt(20);
        int result = calc.add(num1,num2);
        System.out.println("Number 1 is:"+num1 +"Number 2 is:"+num2);
        System.out.println("The Result of addTest is:"+result);
        assertAll(
                ()-> assertEquals(20, result),
                () -> assertEquals(20, result),
                () -> assertEquals(20, result));
        Assertions.assertEquals(20, result);
            }
    @Test
    public void squareTest(){
        int result = calc.square(20);
        System.out.println("The Result of squareTest is:"+result);
    }

    @Test
    @Disabled("Function multiplyTest is not implemented")
    public void multiplyTest(){
        int result = calc.multiply(20, 30);
        System.out.println("The Result of multiplyTest is:"+result);
    }

    @Test
    @DisplayName("Simple multiplication should work")
    public void testMultiply() {
        assertEquals(20, calc.multiply(4, 5));
    }
    @Test
    void addNumbers() {
        // Assertion
        assertEquals(3, calc.add(1, 2)); // Passes
        assertNotEquals(5, calc.add(1, 2)); // Fails
    }

    @Test
    void iterablesEqual() {
        final List<String> list = Arrays.asList("orange", "mango", "banana");
        final List<String> expected = Arrays.asList("banana", "mango", "orange");
        // Sort array
        Collections.sort(list);
        // Assertion
        assertIterableEquals(expected, list); //Pass
    }
    @Test
    void arraysEqual() {
        final int[] array = { 3, 2, 1,9 };
        final int[] expected = { 1, 2, 3,9 };

        // Sorting an Array
        Arrays.sort(array);
        // Assertion
        Assertions.assertArrayEquals(expected, array);
    }
}
