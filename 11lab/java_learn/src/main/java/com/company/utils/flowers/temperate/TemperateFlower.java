package com.company.utils.flowers.temperate;

import com.company.utils.flowers.Flower;
import com.company.utils.flowers.Humidity;

public class TemperateFlower extends Flower {
    public TemperateFlower() {
        super();
    }

    public TemperateFlower(String name, int length, float price) {
        super(name, length, price, Humidity.MEDIUM);
    }
}
