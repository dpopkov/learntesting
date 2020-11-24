package learn.junitia.ch02core.dynamic;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class DynamicTestFactoryTest {
    private final IntPredicate positive = n -> n > 0;

    @BeforeAll
    static void setUpClass() {
        System.out.println("@BeforeAll method");
    }

    @AfterAll
    static void tearDownClass() {
        System.out.println("@AfterAll method");
    }

    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach method");
    }

    @TestFactory
    @DisplayName("Генерация тест кейсов")
    Iterator<DynamicTest> generateTestCases() {
        return Arrays.asList(
                    dynamicTest("отрицательное число", () -> assertFalse(positive.test(-1))),
                    dynamicTest("ноль", () -> assertFalse(positive.test(0))),
                    dynamicTest("положительное число", () -> assertTrue(positive.test(1))))
                .iterator();
    }
}
