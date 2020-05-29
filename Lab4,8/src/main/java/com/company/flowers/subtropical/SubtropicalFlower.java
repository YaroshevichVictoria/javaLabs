package com.company.flowers.subtropical;

import com.company.flowers.Flower;
import com.company.flowers.Humidity;

public class SubtropicalFlower extends Flower {
    public SubtropicalFlower() {
        super();
    }

    public SubtropicalFlower(String name, int length, float price) {
        super(name, length, price, Humidity.HIGH);
    }
}
