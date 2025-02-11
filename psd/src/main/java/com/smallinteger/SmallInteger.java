package com.smallinteger;

public class SmallInteger {
    private static final int MIN_VALUE = -10000;
    private static final int MAX_VALUE = 10000;
    private final int value;

    // Исключение при выходе за границы допустимых значений
    public static class SmallIntegerOutOfRangeException extends RuntimeException {
        public SmallIntegerOutOfRangeException(String message) {
            super(message);
        }
    }

    // Конструктор с проверкой границ
    public SmallInteger(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new SmallIntegerOutOfRangeException("Value out of range: " + value);
        }
        this.value = value;
    }

    // Конструктор копирования
    public SmallInteger(SmallInteger other) {
        this.value = other.value;
    }

    public SmallInteger add(SmallInteger arg) {
        return new SmallInteger(this.value + arg.value);
    }

    public SmallInteger subtract(SmallInteger arg) {
        return new SmallInteger(this.value - arg.value);
    }

    public SmallInteger multiply(SmallInteger arg) {
        return new SmallInteger(this.value * arg.value);
    }

    public SmallInteger divide(SmallInteger arg) {
        if (arg.value == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return new SmallInteger(this.value / arg.value);
    }

    public SmallInteger mod(SmallInteger arg) {
        if (arg.value == 0) {
            throw new ArithmeticException("Modulo by zero");
        }
        return new SmallInteger(this.value % arg.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public int getValue() {
        return value;
    }
}
