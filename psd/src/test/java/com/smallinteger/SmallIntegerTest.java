package com.smallinteger;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SmallIntegerTest {

    @Test
    void testAddition() {
        SmallInteger a = new SmallInteger(50);
        SmallInteger b = new SmallInteger(30);
        assertEquals(80, a.add(b).getValue());
    }

    @Test
    void testSubtraction() {
        SmallInteger a = new SmallInteger(50);
        SmallInteger b = new SmallInteger(30);
        assertEquals(20, a.subtract(b).getValue());
    }

    @Test
    void testMultiplication() {
        SmallInteger a = new SmallInteger(5);
        SmallInteger b = new SmallInteger(-10);
        assertEquals(-50, a.multiply(b).getValue());
    }

    @Test
    void testDivision() {
        SmallInteger a = new SmallInteger(50);
        SmallInteger b = new SmallInteger(10);
        assertEquals(5, a.divide(b).getValue());
    }

    @Test
    void testModulo() {
        SmallInteger a = new SmallInteger(50);
        SmallInteger b = new SmallInteger(7);
        assertEquals(50 % 7, a.mod(b).getValue());
    }

    @Test
    void testDivisionByZero() {
        SmallInteger a = new SmallInteger(50);
        SmallInteger b = new SmallInteger(0);
        assertThrows(ArithmeticException.class, () -> a.divide(b));
    }

    @Test
    void testModuloByZero() {
        SmallInteger a = new SmallInteger(50);
        SmallInteger b = new SmallInteger(0);
        assertThrows(ArithmeticException.class, () -> a.mod(b));
    }

    @Test
    void testOutOfRangeException() {
        assertThrows(SmallInteger.SmallIntegerOutOfRangeException.class, () -> new SmallInteger(10001));
        assertThrows(SmallInteger.SmallIntegerOutOfRangeException.class, () -> new SmallInteger(-10001));
    }

    @Test
    void testOutOfRangeOnAddition() {
        SmallInteger a = new SmallInteger(10000);
        SmallInteger b = new SmallInteger(1);
        assertThrows(SmallInteger.SmallIntegerOutOfRangeException.class, () -> a.add(b));
    }

    @Test
    void testOutOfRangeOnMultiplication() {
        SmallInteger a = new SmallInteger(1000);
        SmallInteger b = new SmallInteger(11);
        assertThrows(SmallInteger.SmallIntegerOutOfRangeException.class, () -> a.multiply(b));
    }    
}
