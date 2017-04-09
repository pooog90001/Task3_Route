package by.epam.vladlitvin.action;

import by.epam.vladlitvin.entity.Station;

import java.util.ArrayDeque;

/**
 * Created by vlad_ on 4/3/2017.
 */
public class Rider {

    public static Station rideNextStation(ArrayDeque<Station> route) {
        return route.pollFirst();
    }
}
