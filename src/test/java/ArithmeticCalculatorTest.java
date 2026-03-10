import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArithmeticCalculatorTest {
    private ArithmeticCalculator calculator;

    @BeforeEach
    void setUp () {
        calculator = new ArithmeticCalculator();
    }
    @Test
    void testAdd(){
        assertEquals(calculator.add(3,5),8);
        assertEquals(calculator.add(20,15),35);
        assertEquals(calculator.add(2,2),4);
    }
    @Test
    void testSubtract(){
        assertEquals(calculator.subtract(9,8),1);
        assertEquals(calculator.subtract(2,2),0);
        assertEquals(calculator.subtract(4,1),3);
    }
    @Test
    void testMultiply(){
        assertEquals(calculator.multiply(2,2),4);
        assertEquals(calculator.multiply(8,9),72);
        assertEquals(calculator.multiply(5,1),5);
    }
    @Test
    void testDivide(){
        assertEquals(calculator.divide(2,2),1);
        assertEquals(calculator.divide(9,3),3);
        assertEquals(calculator.divide(10,5),2);
    }
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(7,0);
        });
    }

}