package by.epam.vladlitvin.entity;

import org.apache.logging.log4j.Logger;
import static by.epam.vladlitvin.action.Rider.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.apache.logging.log4j.Level.ERROR;
import static org.apache.logging.log4j.Level.INFO;
import static org.apache.logging.log4j.LogManager.*;

/**
 * Created by vlad_ on 4/2/2017.
 */
public class Bus extends Thread{
    private final static Logger LOGGER = getLogger();
    public static final int PASSANGER_CAPACITY = 60;
    private static final int INT_FOUR = 4;
    private int routeNumber;
    private int busNumber;
    private final Passenger[] passengers = new Passenger[PASSANGER_CAPACITY];
    private Route route;

    private boolean onStation;

    public Bus(int routeNumber, int busNumber, Route route) {
        this.routeNumber = routeNumber;
        this.busNumber = busNumber;
        this.route = route;

    }

    public Passenger getPassanger(int index) {
        if (passengers.length > index) {
            return passengers[index];

        } else {
            return null;
        }
    }

    public void setPassanger(Passenger passenger, int index) {
        if (passengers.length > index) {
            this.passengers[index] = passenger;
        }
    }

    public boolean isOnStation() {
        return onStation;
    }

    public void setOnStation(boolean onStation) {
        this.onStation = onStation;

    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public int getBusNumber() {
        return busNumber;
    }

    @Override
    public void run() {
        LOGGER.log(INFO, "Bus № " + routeNumber + " Started move on rout: " + route.getName());
        while (!route.getRoute().isEmpty()) {
            try {
                Station station = rideNextStation(route.getRoute());
                station.arrive(this);
                SECONDS.sleep(INT_FOUR);
                station.depart(this);
                SECONDS.sleep(1);
            } catch (InterruptedException e) {
                LOGGER.log(ERROR, "Bus № " + routeNumber + " took interupted exception " + e);

            }
        }
        LOGGER.log(INFO, "Bus № " + routeNumber + " finished route");
    }
}
