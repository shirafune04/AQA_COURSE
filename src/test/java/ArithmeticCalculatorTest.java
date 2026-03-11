import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticCalculatorTest {
    private ArithmeticCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new ArithmeticCalculator();
    }

    @Test
    void testAdd() {
        assertEquals(8, calculator.add(3, 5));
        assertEquals(35, calculator.add(20, 15));
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(9, 8));
        assertEquals(0, calculator.subtract(2, 2));
        assertEquals(3, calculator.subtract(4, 1));
    }

    @Test
    void testMultiply() {
        assertEquals(4, calculator.multiply(2, 2));
        assertEquals(72, calculator.multiply(8, 9));
        assertEquals(5, calculator.multiply(5, 1));
    }

    @Test
    void testDivide() {
        assertEquals(1, calculator.divide(2, 2));
        assertEquals(3, calculator.divide(9, 3));
        assertEquals(2, calculator.divide(10, 5));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(7, 0);
        });
    }
}