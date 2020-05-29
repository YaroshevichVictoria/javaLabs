package main.java;

import main.java.creator.Creator;
import main.java.entity.Car;
import main.java.pool.ParkPool;


public class Main {
    public static void main(String[] args) {
        ParkPool pool = new ParkPool();
        pool.addToPool(Creator.createPark0());
        pool.addToPool(Creator.createPark1());
        pool.addToPool(Creator.createPark2());

        for (int i = 0; i < 10; i++) {
            new Car(pool).start();
        }

    }
}
