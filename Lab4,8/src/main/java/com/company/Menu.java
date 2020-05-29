package com.company;

import com.company.exceptions.MenuException;
import com.company.flowers.Bouquet;
import com.company.flowers.subtropical.bougainvillea.BougainvilleaFlower;
import com.company.flowers.temperate.peonies.Peony;
import com.company.flowers.temperate.roses.Rose;
import com.company.flowers.temperate.roses.YellowRose;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    private Bouquet bouquet;

    private void showVariantForFlowers() {
        System.out.println("Какой цветок добавить?");
        System.out.println(
                "1) Bougainvillea\n" +
                "2) Peony\n" +
                "3) Rose\n" +
                "4) Yellow rose\n"
        );
    }

    private void addBougainvillea() {
        Scanner in = new Scanner(System.in);
        System.out.println("Есть только Bougainvillea glabra");
        System.out.println("Введите длину");
        int length = in.nextInt();
        System.out.println("Введите цену");
        float price = in.nextFloat();
        BougainvilleaFlower bougainvilleaFlower = new BougainvilleaFlower("Bougainvillea glabra", length, price, false);
        this.bouquet.add(bougainvilleaFlower);
    }

    private void addRose() {
        Scanner in = new Scanner(System.in);
        System.out.println("Есть только красная роза");
        System.out.println("Введите длину");
        int length = in.nextInt();
        System.out.println("Введите цену");
        float price = in.nextFloat();
        Rose rose = new Rose("Red rose", length, price, "red");
        this.bouquet.add(rose);
    }

    private void addYellowRose() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину");
        int length = in.nextInt();
        System.out.println("Введите цену");
        float price = in.nextFloat();
        YellowRose yellowRose = new YellowRose("Yellow rose", length, price);
        this.bouquet.add(yellowRose);
    }

    private void addPeony() {
        Scanner in = new Scanner(System.in);
        System.out.println("Есть только Paeonia Sarah Bernhardt розового цвета");
        System.out.println("Введите длину");
        int length = in.nextInt();
        System.out.println("Введите цену");
        float price = in.nextFloat();
        Peony peony = new Peony("Paeonia Sarah Bernhardt", length, price, "pink");
        this.bouquet.add(peony);
    }

    private void addFlower(int variant) {
        switch(variant) {
            case 1:
                addBougainvillea();
                break;
            case 2:
                addPeony();
                break;
            case 3:
                addRose();
                break;
            case 4:
                addYellowRose();
                break;
            default:
                System.out.println("Неверный вариант!");
        }
    }

    private void showVariants() {
        System.out.println(
                "1) Показать букет\n" +
                "2) Добавить цветок в букет\n" +
                "3) Показать стоимость букета\n" +
                "4) Отсортировать букет по степени свежести цветов\n" +
                "5) Найти цветок в букете, соответствующий заданному диапазону длин стеблей\n" +
                "6) Выход"
        );
        System.out.println("Выберите пункт меню:");
    }

    private int getVariant() throws MenuException {
        Scanner in = new Scanner(System.in);
        int variant = in.nextInt();
        if (variant < 1 || variant > 6) {
            throw new MenuException("Вариант не может быть " + variant, variant);
        }
        return variant;
    }

    private int[] getRange() {
        int[] range = new int[2];
        Scanner in = new Scanner(System.in);
        System.out.println("Введите нижнюю границу");
        int lowLimit = in.nextInt();
        System.out.println("Введите вверхнюю границу");
        int highLimit = in.nextInt();
        range[0] = lowLimit;
        range[1] = highLimit;
        return range;
    }

    public Menu(Bouquet bouquet) throws MenuException {
        this.bouquet = bouquet;
        int variant = 0;
        do {
            showVariants();
            try {
                variant = getVariant();
            } catch (MenuException ex) {
                System.out.println(ex.getMessage());
                break;
            }

            switch(variant) {
                case 1:
                    System.out.println(bouquet.toString());
                    break;
                case 2:
                    showVariantForFlowers();
                    addFlower(getVariant());
                    break;
                case 3:
                    System.out.println(bouquet.getPrice());
                    break;
                case 4:
                    System.out.println(bouquet.sortByHumidity().toString());
                    break;
                case 5:
                    int[] range = getRange();
                    System.out.println(Arrays.toString(bouquet.findByRange(range[0], range[1])));
                    break;
                case 6:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + variant);
            }
        } while (variant != 6);
    }
}
