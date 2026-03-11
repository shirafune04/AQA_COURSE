import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberComparatorTest {
    private NumberComparator comparator;

    @BeforeEach
    void setUp(){
        comparator = new NumberComparator();
    }

    @Test
    void testFirstLessThanSecond() {
        assertEquals(-1, comparator.compare(1,5));
        assertEquals(-1, comparator.compare(6,9));
    }

    @Test
    void testFirstGreaterThanSecond() {
        assertEquals(1, comparator.compare(3,1));
        assertEquals(1, comparator.compare(12,5));
    }

    @Test
    void testFirstEqualSecond() {
        assertEquals(0, comparator.compare(6,6));
        assertEquals(0, comparator.compare(2,2));
    }
}