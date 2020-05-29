package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VariantB {
    private static void pullUp(List<Integer> list, int index) {
        for (int j = list.size() - 1; j > index; j -= 1) {
            if (list.get(j - 1) > list.get(j)) {
                swap(j, j - 1, list);
            }
        }
    }

    private static void swap(int index1, int index2, List<Integer> list) {
        list.set(index2, list.get(index2) + list.get(index1));
        list.set(index1, list.get(index2) - list.get(index1));
        list.set(index2, list.get(index2) - list.get(index1));
    }
    public static void bubbleSort(List<Integer> list) {
        for (int i = 0; i < list.size(); ++i)
            pullUp(list, i);
    }



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        System.out.println("Введите размер списка:");
        int size = -1;
        while (size <= 0) {
            size = in.nextInt();
            if (size <= 0) {
                System.out.println("Число должно быть положительным! Введите ещё раз:");
            }
        }

        System.out.println("Введите число X: ");
        int x = in.nextInt();
        list.add(x);

        for (int i = 0; i < size - 1; i += 1) {
            System.out.println("Введите " + (i + 1) + "-е число");
            int n = in.nextInt();
            list.add(n);
        }

        System.out.println("Введенный список: " + list.toString());
        System.out.println("Число X: " + x);

        bubbleSort(list);
        System.out.println("Полученный список: " + list.toString());
    }
}
