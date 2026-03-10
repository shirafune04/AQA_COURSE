package org.example;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class NumberComparatorTest {

    private NumberComparator comparator;

    @BeforeMethod
    public void setUp() {
        comparator = new NumberComparator();
    }

    @Test
    public void testFirstLessThanSecond() {
        assertEquals(comparator.compare(1, 5), -1);
        assertEquals(comparator.compare(6, 9), -1);
    }

    @Test
    public void testFirstGreaterThanSecond() {
        assertEquals(comparator.compare(3, 1), 1);
        assertEquals(comparator.compare(12, 5), 1);
    }

    @Test
    public void testFirstEqualSecond() {
        assertEquals(comparator.compare(6, 6), 0);
        assertEquals(comparator.compare(2, 2), 0);
    }
}