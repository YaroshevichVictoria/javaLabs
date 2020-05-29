package main.java.entity;

import main.java.pool.ParkPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Car extends Thread {
    static public Logger log = LogManager.getLogger();

    private boolean standing;
    private ParkPool pool;

    public Car(ParkPool pool){
        this.pool = pool;
        log.info("Car #" + this.getId() + " is created");
    }

    public void run(){
        this.setName("Car-" + this.getId());
        ParkLot lot = null;

        while (lot == null){
            log.debug("Try of getting lot (while). Car #" + this.getId());
            lot = pool.getLot(500);
        }
        log.info("Car №" + this.getId() + " took park lot №" + lot.getLotId() + ". Parking №" + lot.getParkId());
        standing = true;

        lot.using();

        standing = false;
        log.info("Car №" + this.getId() + " : " + lot.getLotId() + " lot released. Parking №" + lot.getParkId());
        while (true){
            if (pool.returnLot(lot)){
                break;
            }
        }
        log.info("Car #" + this.getId() + " is terminated");
    }

    public boolean isStanding(){
        return standing;
    }

}
