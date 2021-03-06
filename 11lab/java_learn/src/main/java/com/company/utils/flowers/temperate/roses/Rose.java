package com.company.utils.flowers.temperate.roses;

import com.company.utils.flowers.temperate.TemperateFlower;

public class Rose extends TemperateFlower {
    private String color;

    public Rose() {
        super();
        this.color = "";
    }

    public Rose(String name, int length, float price, String color) {
        super(name, length, price);
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
