package examples;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.Assert.assertNotNull;

public class ArgumentsSourceTest {

    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsProvider.class)
    void test_argument_custom(String arg) {
        assertNotNull(arg);
    }

}