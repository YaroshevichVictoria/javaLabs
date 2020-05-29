package com.company.utils.flowers.subtropical;

import com.company.utils.flowers.Flower;
import com.company.utils.flowers.Humidity;

public class SubtropicalFlower extends Flower {
    public SubtropicalFlower() {
        super();
    }

    public SubtropicalFlower(String name, int length, float price) {
        super(name, length, price, Humidity.HIGH);
    }
}
