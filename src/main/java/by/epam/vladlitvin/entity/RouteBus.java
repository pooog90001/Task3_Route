package by.epam.vladlitvin.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;

import static org.apache.logging.log4j.Level.ERROR;

/**
 * Created by vlad_ on 4/3/2017.
 */
public class RouteBus implements Cloneable {
    private final static Logger LOGGER = LogManager.getLogger();
    private ArrayDeque<Station> route;

    public RouteBus(ArrayDeque<Station> route) {
        this.route = route;
    }

    public ArrayDeque<Station> getRoute() {
        return route;
    }

    public String getName() {
        return (route.getFirst().getName()
                + " -- " + route.getLast().getName());
    }


    @Override
    public RouteBus clone() {
        RouteBus routeBus = null;
        try {
            routeBus = (RouteBus) super.clone();
            routeBus.route = route.clone();

        } catch (CloneNotSupportedException e) {
            LOGGER.log(ERROR,"Can't clone RouteBus object " + e);
        }
        return routeBus;
    }
}