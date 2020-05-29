package main.java.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CarPark {
    static public Logger log = LogManager.getLogger();

    private int parkId;
    private int parkSize;
    private Queue<ParkLot> lots = new ConcurrentLinkedQueue<>();
    private Semaphore semaphore;

    public CarPark(int parkId, int parkSize){
        this.parkId = parkId;
        this.parkSize = parkSize;
        this.semaphore = new Semaphore(parkSize, true);
    }

    public int getParkId() {
        return parkId;
    }

    public void addToParkLots(ParkLot lot){
        if (parkSize >= 0){
            lots.add(lot);
            parkSize--;
        }
    }

    public main.java.entity.ParkLot takeLot(long maxWaitMillis){
        ParkLot toReturn = null;
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                log.info("Car #" + Thread.currentThread().getId() + " tries to poll from park #" + CarPark.this.parkId);
                ParkLot lot = lots.poll();
                log.info("Car #" + Thread.currentThread().getId() +  " poll " + lot);
                toReturn = lot;
            }
        } catch (InterruptedException ignored) {
        }
        return toReturn;
    }

    public void returnLot(ParkLot lot){
        lots.add(lot);
        semaphore.release();
    }
}

