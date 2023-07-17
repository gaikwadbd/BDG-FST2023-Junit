package examples;

import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DisplayNameTest {

    @Test
    void test_spaces_pass() {
    }

    @Test
    void test_spaces_fail() {
    }

    @ParameterizedTest(name = "#{index} - Test with TimeUnit: {0}")
    @EnumSource(value = TimeUnit.class, names = {"MINUTES", "SECONDS"})
    void test_timeunit_ok(TimeUnit time) {
    }


    @ParameterizedTest(name = "#{index} - Test with {0} and {1}")
    @MethodSource("argumentProvider")
    void test_method_multi(String str, int length) {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
                arguments("My", 10),
                arguments("Test", 20)
        );
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
}
