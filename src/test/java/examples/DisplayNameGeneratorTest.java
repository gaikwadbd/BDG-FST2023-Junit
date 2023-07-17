package examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DisplayNameGeneratorTest {

    @Test
    void test_spaces_pass() {
        System.out.println("test_spaces_pass Method name underscore is replaced");
    }

    @Test
    void test_spaces_fail() {
        System.out.println("test_spaces_fail Method name underscore is replaced");
    }

    @Test
    void test_spaces_pass1() {
    }

    @Test
    void test_spaces_fail2() {
    }

    static class CustomDisplayNameGenerator extends DisplayNameGenerator.Standard {

        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return "New Name for test class";
        }

        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return super.generateDisplayNameForNestedClass(nestedClass);
        }

        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String name = testMethod.getName();
            return Arrays.stream(name.split("_")).collect(Collectors.joining(" | "));
        }
    }

    @Test
    @DisplayName("Test with spaces, expected ok")
    void test_spaces_passed() {
    }

    @DisplayName("Test with spaces, expected failed")
    @Test
    void test_spaces_failed() {
    }
}