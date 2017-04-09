package by.epam.vladlitvin.entity;


import by.epam.vladlitvin.entity.Bus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;

import static by.epam.vladlitvin.action.PassengerTransporter.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.apache.logging.log4j.Level.*;

/**
 * Created by vlad_ on 4/2/2017.
 */
public class Station implements Cloneable {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int INT_ONE = 1;
    private final static int STATION_CAPACITY = 3;
    private final Semaphore semaphore = new Semaphore(STATION_CAPACITY, true);
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void arrive(Bus bus) {
        try {
            semaphore.acquire();
            LOGGER.log(INFO,"Bus № " + bus.getRouteNumber() +
                    " arrived at the station " + name);
            bus.setOnStation(true);
            passangersGetOff(bus);
            SECONDS.sleep(INT_ONE);
            passangersGetOn(bus);
        } catch (InterruptedException e) {
            LOGGER.log(ERROR,"Interrupt Error in arrive method" + e);
        }
    }

    public void depart(Bus bus) {

        LOGGER.log(INFO,"Bus № " + bus.getRouteNumber() +
                " left with the station " + name);
        bus.setOnStation(false);
        semaphore.release();

    }


}
