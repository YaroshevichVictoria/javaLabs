package main.java.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class ParkLot {
    static public Logger log = LogManager.getLogger();

    private int lotId;
    private int parkId;

    public ParkLot(int lotId, int parkId){
        super();
        this.lotId = lotId;
        this.parkId = parkId;
    }

    public int getLotId() {
        return lotId;
    }

    public int getParkId() {
        return parkId;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    public void using(){
        log.info("LOT #" + lotId + " using by Car #" + Thread.currentThread().getId());
        try{
            TimeUnit.MILLISECONDS.sleep(new java.util.Random().nextInt(200));
        } catch (InterruptedException ignored){
        }
    }

    @Override
    public String toString(){
        return "LOT #" + lotId + " PARK_ID #" + parkId;
    }
}

