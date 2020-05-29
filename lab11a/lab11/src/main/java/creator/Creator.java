package main.java.creator;

import main.java.entity.CarPark;
import main.java.entity.ParkLot;

public class Creator {
    public static CarPark createPark0(){
        CarPark park = new CarPark(0,2);
        park.addToParkLots(new ParkLot(1, park.getParkId()));
        park.addToParkLots(new ParkLot(2, park.getParkId()));
        return park;
    }

    public static CarPark createPark1(){
        CarPark park = new CarPark(1,3);

        park.addToParkLots(new ParkLot(1, park.getParkId()));
        park.addToParkLots(new ParkLot(2, park.getParkId()));
        park.addToParkLots(new ParkLot(3, park.getParkId()));

        return park;
    }

    public static CarPark createPark2(){
        CarPark park = new CarPark(2,4);

        park.addToParkLots(new ParkLot(1, park.getParkId()));
        park.addToParkLots(new ParkLot(2, park.getParkId()));
        park.addToParkLots(new ParkLot(3, park.getParkId()));
        park.addToParkLots(new ParkLot(4, park.getParkId()));

        return park;
    }
}

