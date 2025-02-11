package com.psd;

public class SmallInteger {
    private static final int MAX_VALUE = 10000;
    private final int value;

    public SmallInteger(int value) {
        if (Math.abs(value) > MAX_VALUE) {
            throw new OutOfRangeException("Значение выходит за пределы диапазона");
        }
        this.value = value;
    }

    public SmallInteger add(SmallInteger other) {
        int result = this.value + other.value;
        return new SmallInteger(result);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
