package com.company.flowers;

import java.util.*;

public class Bouquet {
    private Flower[] flowersArray;

    public Bouquet(Flower[] flowersArray) {
        this.flowersArray = flowersArray;
    }

    public Flower[] getFlowersArray() {
        return this.flowersArray;
    }

    public void setFlowersArray(Flower[] flowersArray) {
        this.flowersArray = flowersArray;
    }

    public float getPrice() {
        float totalPrice = 0;
        for (Flower flower : this.flowersArray) {
            totalPrice += flower.getPrice();
        }
        return totalPrice;
    }

    private void swap(int ind1, int ind2) {
        Flower tmp = this.flowersArray[ind1];
        this.flowersArray[ind1] = this.flowersArray[ind2];
        this.flowersArray[ind2] = tmp;
    }

    public Bouquet sortByHumidity() {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < this.flowersArray.length - 1; i += 1) {
                if (this.flowersArray[i].humidityDegree.compareTo(this.flowersArray[i + 1].humidityDegree) > 0) {
                    isSorted = false;
                    this.swap(i, i + 1);
                }
            }
        }
        return this;
    }

    public Flower[] findByRange(int lowLimit, int highLimit) {
        List<Flower> resultFlowersList = new ArrayList<Flower>();
        for (Flower flower : this.flowersArray) {
            if (flower.getLength() >= lowLimit && flower.getLength() <= highLimit) {
                resultFlowersList.add(flower);
            }
        }
        Flower[] resultFlowersArray = new Flower[resultFlowersList.size()];
        resultFlowersList.toArray(resultFlowersArray);
        return resultFlowersArray;
    }

    public void add(Flower flowerToAdd) {
        List<Flower> resultFlowersList = new ArrayList<Flower>();
        Collections.addAll(resultFlowersList, this.flowersArray);
        resultFlowersList.add(flowerToAdd);
        this.flowersArray = resultFlowersList.toArray(this.flowersArray);
        System.out.println("before " + this.flowersArray.length);
        System.out.println("after " + this.flowersArray.length);
    }

    @Override
    public String toString() {
        return "Flowers:\n" + Arrays.toString(flowersArray);
    }
}
