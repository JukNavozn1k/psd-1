import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SmallIntegerTest {

    @Test
    public void testAdditionWithinRange() {
        SmallInteger a = new SmallInteger(5000);
        SmallInteger b = new SmallInteger(3000);
        SmallInteger result = a.add(b);
        assertEquals(new SmallInteger(8000), result);
    }

    @Test
    public void testAdditionOutOfRange() {
        SmallInteger a = new SmallInteger(8000);
        SmallInteger b = new SmallInteger(3000);
        assertThrows(OutOfRangeException.class, () -> a.add(b));
    }

    @Test
    public void testSubtractionWithinRange() {
        SmallInteger a = new SmallInteger(5000);
        SmallInteger b = new SmallInteger(3000);
        SmallInteger result = a.subtract(b);
        assertEquals(new SmallInteger(2000), result);
    }

    @Test
    public void testSubtractionOutOfRange() {
        SmallInteger a = new SmallInteger(-8000);
        SmallInteger b = new SmallInteger(3000);
        assertThrows(OutOfRangeException.class, () -> a.subtract(b));
    }

    @Test
    public void testMultiplicationWithinRange() {
        SmallInteger a = new SmallInteger(50);
        SmallInteger b = new SmallInteger(100);
        SmallInteger result = a.multiply(b);
        assertEquals(new SmallInteger(5000), result);
    }

    @Test
    public void testMultiplicationOutOfRange() {
        SmallInteger a = new SmallInteger(200);
        SmallInteger b = new SmallInteger(100);
        assertThrows(OutOfRangeException.class, () -> a.multiply(b));
    }

    @Test
    public void testDivisionWithinRange() {
        SmallInteger a = new SmallInteger(8000);
        SmallInteger b = new SmallInteger(2);
        SmallInteger result = a.divide(b);
        assertEquals(new SmallInteger(4000), result);
    }

    @Test
    public void testDivisionByZero() {
        SmallInteger a = new SmallInteger(8000);
        SmallInteger b = new SmallInteger(0);
        assertThrows(ArithmeticException.class, () -> a.divide(b));
    }

    @Test
    public void testRemainderWithinRange() {
        SmallInteger a = new SmallInteger(8000);
        SmallInteger b = new SmallInteger(3);
        SmallInteger result = a.remainder(b);
        // 8000 % 3 = 2
        assertEquals(new SmallInteger(2), result);
    }

    @Test
    public void testRemainderDivisionByZero() {
        SmallInteger a = new SmallInteger(8000);
        SmallInteger b = new SmallInteger(0);
        assertThrows(ArithmeticException.class, () -> a.remainder(b));
    }

    @Test
    public void testCopyConstructor() {
        SmallInteger a = new SmallInteger(1234);
        SmallInteger b = new SmallInteger(a);
        assertEquals(a, b);
    }
}
