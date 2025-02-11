package com.smallinteger;

public class Main {
    public static void main(String[] args) {
        SmallInteger a = new SmallInteger(10);
        SmallInteger b = new SmallInteger(5);

        System.out.println("a + b = " + a.add(b));
        System.out.println("a - b = " + a.subtract(b));
        System.out.println("a * b = " + a.multiply(b));
        System.out.println("a / b = " + a.divide(b));
        System.out.println("a % b = " + a.mod(b));
    }
}
