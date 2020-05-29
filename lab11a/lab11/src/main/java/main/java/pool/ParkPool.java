package main.java.pool;

import main.java.entity.CarPark;
import main.java.entity.ParkLot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ParkPool {
    public static Logger log = LogManager.getLogger();

    private ReentrantLock lock = new ReentrantLock();
    private ArrayList<CarPark> parkPool = new ArrayList<>();

    public ParkPool(){
    }

    public void addToPool(CarPark park){
        parkPool.add(park);
    }

    public ParkLot getLot(long maxWaitMillis) {
        log.info("Car #" + Thread.currentThread().getId() + " tried to getLot");
        ParkLot toReturn = null;
        for (CarPark park : parkPool) {
            ParkLot lot = park.takeLot(maxWaitMillis);
            if (lot != null){
                toReturn = lot;
                break;
            }
            else {
                log.info("Car #" + Thread.currentThread().getId() + " -> timeout. Going to another parking.");
            }
        }
        return toReturn;
    }

    public boolean returnLot(ParkLot lot){
        boolean toReturn = false;
        if (lock.tryLock()) {
            for (CarPark park : parkPool) {
                if (park.getParkId() == lot.getParkId()) {
                    park.returnLot(lot);
                }
            }
            toReturn = true;
            lock.unlock();
        }
        return toReturn;
    }
}

