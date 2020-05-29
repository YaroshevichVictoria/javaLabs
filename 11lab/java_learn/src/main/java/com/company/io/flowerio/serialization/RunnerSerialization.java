package com.company.io.flowerio.serialization;

import com.company.utils.flowers.Flower;
import com.company.utils.flowers.Humidity;

import java.io.InvalidObjectException;

public class RunnerSerialization {
    private final static String FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/serial.txt";

    public static void main(String[] args) throws InvalidObjectException {
        Flower flower = new Flower("Fern", 10, 5, Humidity.LOW);
        flower.setDaysOfAlive(15);
        flower.pick();
        System.out.println("Before serialization:");
        System.out.println(flower.toString());
        System.out.println("========================================");
        Serializator serializator = new Serializator();
        new Thread() {
            public void run() {
                synchronized (FILE_PATH) {
                    boolean isSerialized = serializator.serialization(flower, FILE_PATH);
                }
            }
        }.start();

        final Flower[] resultingFlower = {null};
        new Thread() {
            public void run() {
                synchronized (FILE_PATH) {
                    try {
                        resultingFlower[0] = serializator.deserialization(FILE_PATH);
                    } catch (InvalidObjectException e) {
                        e.printStackTrace();
                    }
                    flower.setDaysOfAlive(15);
                    System.out.println("After serialization:");
                    assert resultingFlower[0] != null;
                    System.out.println(resultingFlower[0].toString());
                }
            }
        }.start();
    }
}
