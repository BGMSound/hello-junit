package kr.bgmsound.junit.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class JUnitTests {

    @BeforeAll
    static void beforeAll() {
        System.out.println("JUnit Test Start");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Test Method Start");
    }

    @DisplayName("Equal Test")
    @Test
    void equalTest() {
        int a = 10;
        int b = 20;

        System.out.println("Equal Test");
        assertEquals(30, a + b);
    }

    @DisplayName("Array Equal Test")
    @Test
    void arrayEqualTest() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{1, 2, 3, 4, 5};

        System.out.println("Array Equal Test");
        assertArrayEquals(a, b);
    }

    @DisplayName("Not Equal Test")
    @Test
    void notEqualTest() {
        System.out.println("False Test");
        assertNotEquals("Hello, World!", "Hello, World");
    }

    @DisplayName("Null Test")
    @Test
    void nullTest() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("key", "value");

        System.out.println("Null Test");
        assertNull(map.get("key1"));
    }

    @DisplayName("True Test")
    @Test
    void trueTest() {
        int n = 10;
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            integerList.add(i);
        }
        int sum = integerList.stream().mapToInt(Integer::intValue).sum();

        System.out.println("True Test");
        assertTrue((sum == n * (n + 1) / 2));
    }

    @DisplayName("False Test")
    @Test
    void falseTest() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);

        System.out.println("False Test");
        assertFalse(integerList.contains(-1));
    }

    @DisplayName("Same Test")
    @Test
    void sameTest() {
        String a = "Hello, World!";
        String b = "Hello, World!";

        System.out.println("Same Test");
        assertSame(a, b);
    }

    @DisplayName("Not Same Test")
    @Test
    void notSameTest() {
        String a = "Hello,World!";
        String b = "Hello, World!".replace(", ", ",");

        System.out.println("Not Same Test");
        assertNotSame(a, b);
    }

    @DisplayName("Exception Test")
    @Test
    void exceptionTest() {
        System.out.println("Exception Test");

        assertThrows(ArithmeticException.class, () -> {
            int a = 10;
            int b = 0;
            int c = a / b;
        });
    }

    @DisplayName("Repeated Test")
    @RepeatedTest(value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    void repeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println("Repeated Test");
        System.out.println("Current Repetition: " + repetitionInfo.getCurrentRepetition());
        System.out.println("Total Repetitions: " + repetitionInfo.getTotalRepetitions());

        assertTrue(repetitionInfo.getCurrentRepetition() <= repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("Parameterized Test1")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void parameterizedTest1(Integer value) {
        System.out.println("Parameterized Test");
        System.out.println("Value: " + value);

        assertNotNull(value);
    }

    @DisplayName("Parameterized Test2")
    @ParameterizedTest
    @EnumSource(value = TestEnum.class)
    void parameterizedTest2(TestEnum testEnum) {
        System.out.println("Parameterized Test");
        System.out.println("Value: " + testEnum);
    }

    @AfterEach
    void afterEach() {
        System.out.println("Test Method End");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("JUnit Test End");
    }
}
