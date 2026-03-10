import static org.testng.Assert.*;
import org.testng.annotations.*;

public class TriangleAreaCalculatorTest {

    private TriangleAreaCalculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new TriangleAreaCalculator();
    }

    @Test
    public void testCalculateAreaNormal() {
        assertEquals(calculator.calculateArea(5, 4), 10.0);
        assertEquals(calculator.calculateArea(3, 4), 6.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testBaseNegative() {
        calculator.calculateArea(-5, 4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testBaseZero() {
        calculator.calculateArea(0, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testHeightNegative() {
        calculator.calculateArea(5, -2);
    }
}