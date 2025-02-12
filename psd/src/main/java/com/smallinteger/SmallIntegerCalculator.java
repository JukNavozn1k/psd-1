package com.smallinteger;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmallIntegerCalculator {
    private static final Pattern TOKEN_PATTERN = Pattern.compile("\\s*([()*/%]|-?\\d+|[-+])\\s*");
    private static int pos;
    private static String[] tokens;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an expression (e.g., (5 + 3) * 2):");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            try {
                SmallInteger result = evaluateExpression(input);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static SmallInteger evaluateExpression(String input) {
        Matcher matcher = TOKEN_PATTERN.matcher(input);
        StringBuilder parsedInput = new StringBuilder();
        while (matcher.find()) {
            parsedInput.append(matcher.group(1)).append(" ");
        }
        tokens = parsedInput.toString().trim().split(" ");
        pos = 0;
        return parseExpression();
    }

    private static SmallInteger parseExpression() {
        SmallInteger result = parseTerm();
        while (pos < tokens.length && (tokens[pos].equals("+") || tokens[pos].equals("-"))) {
            String operator = tokens[pos++];
            SmallInteger nextTerm = parseTerm();
            switch (operator) {
                case "+":
                    result = result.add(nextTerm);
                    break;
                case "-":
                    result = result.subtract(nextTerm);
                    break;
                default:
                    throw new IllegalStateException("Unknown operator: " + operator);
            }
        }
        return result;
    }

    private static SmallInteger parseTerm() {
        SmallInteger result = parseFactor();
        while (pos < tokens.length && (tokens[pos].equals("*") || tokens[pos].equals("/") || tokens[pos].equals("%"))) {
            String operator = tokens[pos++];
            SmallInteger nextFactor = parseFactor();
            switch (operator) {
                case "*":
                    result = result.multiply(nextFactor);
                    break;
                case "/":
                    result = result.divide(nextFactor);
                    break;
                case "%":
                    result = result.mod(nextFactor);
                    break;
                default:
                    throw new IllegalStateException("Unknown operator: " + operator);
            }
        }
        return result;
    }

    private static SmallInteger parseFactor() {
        if (pos >= tokens.length) {
            throw new IllegalArgumentException("Unexpected end of expression");
        }

        String token = tokens[pos++];
        if (token.equals("(")) {
            SmallInteger result = parseExpression();
            if (pos >= tokens.length || !tokens[pos++].equals(")")) {
                throw new IllegalArgumentException("Expected closing parenthesis");
            }
            return result;
        } else if (token.equals("-")) {
            return new SmallInteger(parseFactor().getValue() * -1);
        } else if (token.equals("+")) {
            return parseFactor();
        } else {
            return new SmallInteger(Integer.parseInt(token));
        }
    }
}
