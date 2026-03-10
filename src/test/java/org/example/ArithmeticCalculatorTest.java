import org.example.ArithmeticCalculator;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class ArithmeticCalculatorTest {

    private ArithmeticCalculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new ArithmeticCalculator();
    }

    @Test
    public void testAdd() {
        assertEquals(calculator.add(3, 5), 8);
        assertEquals(calculator.add(20, 15), 35);
        assertEquals(calculator.add(2, 2), 4);
    }

    @Test
    public void testSubtract() {
        assertEquals(calculator.subtract(9, 8), 1);
        assertEquals(calculator.subtract(2, 2), 0);
        assertEquals(calculator.subtract(4, 1), 3);
    }

    @Test
    public void testMultiply() {
        assertEquals(calculator.multiply(2, 2), 4);
        assertEquals(calculator.multiply(8, 9), 72);
        assertEquals(calculator.multiply(5, 1), 5);
    }

    @Test
    public void testDivide() {
        assertEquals(calculator.divide(2, 2), 1.0);
        assertEquals(calculator.divide(9, 3), 3.0);
        assertEquals(calculator.divide(10, 5), 2.0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(7, 0);
    }
}