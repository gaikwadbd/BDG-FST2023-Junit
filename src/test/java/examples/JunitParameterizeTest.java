package examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

public class JunitParameterizeTest {
    enum Size {
        XXS, XS, S, M, L, XL, XXL, XXXL;
    }

    // This test will run 3 times with different arguments
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3,4})
    void test_int_arrays(int arg) {
        assertTrue(arg < 8);
    }

    @ParameterizedTest(name = "#{index} - Run test with args={0}")
    @ValueSource(ints = {1, 2, 3,5})
    void test_int_arrays_custom_name(int arg) {
        assertTrue(arg >=1);
    }

    @ParameterizedTest(name = "#{index} - Run test with args={0}")
    @ValueSource(strings = {"apple", "banana", "orange"})
    void test_string_arrays_custom_name(String arg) {
        assertTrue(arg.length() > 3);
    }


    boolean isEmpty(String input) {
        return (input == null || input.length() == 0);
    }

    // run 3 times, 1 for empty, 1 for null, 1 for ""

    @ParameterizedTest(name = "#{index} - isEmpty()? {0}")
    @EmptySource
    @NullSource
    //@NullAndEmptySource
    @ValueSource(strings = {""})
    void test_is_empty_true(String arg) {
        assertTrue(isEmpty(arg));
    }

    @ParameterizedTest(name = "#{index} - isEmpty()? {0}")
    @ValueSource(strings = {" ", "\n", "a", "\t"})
    void test_is_empty_false(String arg) {
        assertFalse(isEmpty(arg));
    }

    @ParameterizedTest(name = "#{index} - Is size contains {0}?")
    @EnumSource(value = Size.class, names = {"L", "XL", "XXL", "XXXL"})
    void test_enum_include(Size size) {
        assertTrue(EnumSet.allOf(Size.class).contains(size));
    }

    // Size = M, L, XL, XXL, XXXL
    @ParameterizedTest
    @EnumSource(value = Size.class, mode = EXCLUDE, names = {"XXS", "XS", "S"})
    void test_enum_exclude(Size size) {
        EnumSet<Size> excludeSmallSize = EnumSet.range(Size.M, Size.XXXL);
        assertTrue(excludeSmallSize.contains(size));
    }
     // ********** Method source Test *********************
    @ParameterizedTest(name = "#{index} - Test with String : {0}")
    @MethodSource("stringProvider")
    void test_method_string(String arg) {
        assertNotNull(arg);
    }

    // this need static
    static Stream<String> stringProvider() {
        return Stream.of("java", "rust");
    }

    @ParameterizedTest(name = "#{index} - Test with Int : {0}")
    @MethodSource("rangeProvider")
    void test_method_int(int arg) {
        assertTrue(arg < 10);
    }

    // this need static
    static IntStream rangeProvider() {
        return IntStream.range(0, 10);
    }
    // ********** Method source Test *********************
    // ********* Multiple arguments***********************
    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int length, List<String> list) {
        assertTrue(str.length() > 0);
        assertEquals(length, list.size());
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("abc", 3, Arrays.asList("a", "b", "c")),
                arguments("lemon", 2, Arrays.asList("x", "y"))
        );
    }
    // ********* Multiple arguments***********************

    //****Run tests that take a comma-separated values (csv) as arguments.
    @ParameterizedTest
    @CsvSource({
            "java,      4",
            "clojure,   7",
            "python,    6"
    })
    void test_csv(String str, int length) {
        assertEquals(length, str.length());
    }
    //****Run tests that take a comma-separated values (csv) as arguments.

    //********Imports comma-separated values (csv) from a file as arguments.
    @ParameterizedTest
    @CsvFileSource(resources = "/sample.csv", numLinesToSkip = 0)
    void test_csv_file(String str, int length) {
        assertEquals(length, str.length());
    }

    //*****Create a reusable argument provider.******
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void testWithValueSource(int argument) {
        assertTrue(argument > 0 && argument < 4);
    }
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { " ", "   ", "\t", "\n" })
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }
    @ParameterizedTest
    @CsvSource({
            "apple,         1",
            "banana,        2",
            "'lemon, lime', 0xF1"
    })
    void testWithCsvSource(String fruit, int rank) {
        assertNotNull(fruit);
        assertNotEquals(0, rank);
    }
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/two-column.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromFile(String country, int reference) {
        assertNotNull(country);
        assertNotEquals(0, reference);
    }
}

