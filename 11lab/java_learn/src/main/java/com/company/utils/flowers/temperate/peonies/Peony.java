package com.company.utils.flowers.temperate.peonies;

import com.company.utils.flowers.temperate.TemperateFlower;

public class Peony extends TemperateFlower {
    private String color;

    public Peony() {
        super();
        this.color = "";
    }

    public Peony(String name, int length, float price, String color) {
        super(name, length, price);
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
