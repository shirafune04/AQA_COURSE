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
    void testFirstLessThanSecond (){
        assertEquals(comparator.compare(1,5),-1);
        assertEquals(comparator.compare(6,9),-1);
    }
    @Test
    void testFirstGreaterThanSecond (){
        assertEquals(comparator.compare(3,1),1);
        assertEquals(comparator.compare(12,5),1);
    }
    @Test
    void testFirstEqualSecond (){
        assertEquals(comparator.compare(6,6),0);
        assertEquals(comparator.compare(2,2),0);
    }



}