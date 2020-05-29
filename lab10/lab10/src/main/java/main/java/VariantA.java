package main.java;

import java.util.Scanner;
import java.util.Stack;

import static com.sun.org.apache.xalan.internal.lib.ExsltMath.power;

public class VariantA {

    public static int getNumber() {
        System.out.println("Введите число:");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static void stackDemo(int number) {
        System.out.println("Введенное число: " + number);

        Stack<Integer> stack = new Stack<>();

        while (number != 0) {
            int digit = number % 10;
            stack.push(digit);
            number /= 10;
        }
        int result = 0;

        int i = 0;
        while (stack.size() != 0) {
            Integer newDigit = stack.pop();
            result += newDigit * power(10, i);
            i += 1;
        }

        System.out.println("Полученное число: " + result);
    }

    public static void main(String[] args) {
        int number = getNumber();
        stackDemo(number);
    }
}
