package com.company.utils.flowers;

import java.io.Serializable;

public class Flower implements Serializable {
    protected String name;
    protected int length;
    protected float price;
    protected Humidity humidityDegree;
    protected transient boolean isPicked;
    protected static int daysOfAlive;

    public Flower() {
        name = "";
        length = 0;
        price = 0;
        humidityDegree = Humidity.MEDIUM;
        isPicked = false;
        daysOfAlive = 0;
    }

    public Flower(String name, int length, float price, Humidity humidityDegree) {
        this.name = name;
        this.length = length;
        this.price = price;
        this.humidityDegree = humidityDegree;
        isPicked = false;
    }

    @Override
    public String toString() {
        return "name: " + name + '\n' +
                "length: " + length + '\n' +
                "price: " + price + '\n' +
                "humidityDegree: " + humidityDegree + '\n' +
                "is picked: " + isPicked + '\n' +
                "days of alive: " + daysOfAlive + '\n';
    }

    public void pick() {
        isPicked = !isPicked;
    }

    public void setDaysOfAlive(int daysOfAlive) {
        Flower.daysOfAlive = daysOfAlive;
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.length;
    }

    public float getPrice() {
        return this.price;
    }

    public Humidity getHumidityDegree() {
        return this.humidityDegree;
    }
}
