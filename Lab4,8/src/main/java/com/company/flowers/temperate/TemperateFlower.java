package com.company.flowers.temperate;

import com.company.flowers.Flower;
import com.company.flowers.Humidity;

public class TemperateFlower extends Flower {
    public TemperateFlower() {
        super();
    }

    public TemperateFlower(String name, int length, float price) {
        super(name, length, price, Humidity.MEDIUM);
    }
}
