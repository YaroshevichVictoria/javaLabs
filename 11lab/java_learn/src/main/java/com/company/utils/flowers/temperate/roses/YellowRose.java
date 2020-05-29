package com.company.utils.flowers.temperate.roses;

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
