package com.smallinteger;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("SmallInteger calculator!!!");
        try {

            System.out.print("Enter first num: ");
            int firstVal = scanner.nextInt();
            SmallInteger first = new SmallInteger(firstVal);

            System.out.print("Enter op: (+, -, *, /, %): ");
            String operator = scanner.next();

            System.out.print("Enter second num: ");
            int secondVal = scanner.nextInt();
            SmallInteger second = new SmallInteger(secondVal);

            SmallInteger result;
            switch (operator) {
                case "+":
                    result = first.add(second);
                    break;
                case "-":
                    result = first.subtract(second);
                    break;
                case "*":
                    result = first.multiply(second);
                    break;
                case "/":
                    result = first.divide(second);
                    break;
                case "%":
                    result = first.mod(second);
                    break;
                default:
                    System.out.println("Неизвестный оператор: " + operator);
                    return;
            }
            System.out.println("Результат: " + result);
        } catch (SmallInteger.SmallIntegerOutOfRangeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
