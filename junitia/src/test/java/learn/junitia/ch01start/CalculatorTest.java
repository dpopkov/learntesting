package learn.junitia.ch01start;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator calc = new Calculator();
        double result = calc.add(10, 50);
        assertEquals(60, result, 0);
    }

    @Nested
    class NestedCalculatorTest {
        @Test
        void testInNestedClass() {
            System.out.println("Hello from nested class!");
        }
    }
}
