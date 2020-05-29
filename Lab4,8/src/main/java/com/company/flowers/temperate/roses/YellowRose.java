package com.company.flowers.temperate.roses;

import com.company.flowers.Humidity;
import com.company.flowers.temperate.TemperateFlower;

public class YellowRose extends Rose {
    private String color;

    public YellowRose() {
        super();
        this.color = "yellow";
    }

    public YellowRose(String name, int length, float price) {
        super(name, length, price, "yellow");
    }

    public String getColor() {
        return this.color;
    }
}
