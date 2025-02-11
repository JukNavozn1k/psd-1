package com.psd;

public class Main {
    public static void main(String[] args) {
        SmallInteger a = new SmallInteger(5000);
        SmallInteger b = new SmallInteger(2000);
        SmallInteger sum = a.add(b);

        System.out.println("Sum: " + sum);
    }
}
