import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaCalculatorTest {
    private TriangleAreaCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new TriangleAreaCalculator();
    }

    @Test
    void testCalculateAreaNormal() {
        assertEquals(10.0, calculator.calculateArea(5,4));  // ✅ expected first
        assertEquals(6.0, calculator.calculateArea(3,4));   // ✅ expected first
    }

    @Test
    void testBaseNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateArea(-5,4);
        });
    }

    @Test
    void testBaseZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateArea(0,5);
        });
    }

    @Test
    void testHeightZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateArea(5, 0);
        });
    }

    @Test
    void testHeightNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateArea(5, -4);
        });
    }
}