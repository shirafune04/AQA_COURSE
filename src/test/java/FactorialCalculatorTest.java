import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    private FactorialCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new FactorialCalculator();
    }

    @Test
    void testFactorialOfZero() {
        assertEquals(1, calculator.calculateFactorial(0));
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, calculator.calculateFactorial(1));
    }

    @Test
    void testFactorialOfFive() {
        assertEquals(120, calculator.calculateFactorial(5));
    }

    @Test
    void testFactorialOfNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateFactorial(-5);
        });
    }

    @Test
    void testFactorialOverflow() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculateFactorial(100);
        });
    }
}