package com.company.flowers;

public class Flower {
    protected String name;
    protected int length;
    protected float price;
    protected Humidity humidityDegree;

    public Flower() {
        this.name = "";
        this.length = 0;
        this.price = 0;
        humidityDegree = Humidity.MEDIUM;
    }

    public Flower(String name, int length, float price, Humidity humidityDegree) {
        this.name = name;
        this.length = length;
        this.price = price;
        this.humidityDegree = humidityDegree;
    }

    @Override
    public String toString() {
        return "name:'" + name + '\n' +
                "length: " + length + '\n' +
                "price:" + price + '\n' +
                "humidityDegree: " + humidityDegree + '\n';
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
