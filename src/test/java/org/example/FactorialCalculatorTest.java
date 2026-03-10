package org.example;

import static org.testng.Assert.*;
import org.testng.annotations.*;

public class FactorialCalculatorTest {

    private FactorialCalculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new FactorialCalculator();
    }

    @Test
    public void testFactorialOfZero() {
        assertEquals(calculator.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(calculator.calculateFactorial(1), 1);
    }

    @Test
    public void testFactorialOfFive() {
        assertEquals(calculator.calculateFactorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegative() {
        calculator.calculateFactorial(-6);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testFactorialOverflow() {
        calculator.calculateFactorial(200);
    }
}