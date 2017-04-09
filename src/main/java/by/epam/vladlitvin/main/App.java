package by.epam.vladlitvin.main;

import by.epam.vladlitvin.entity.Bus;
import by.epam.vladlitvin.entity.RouteBus;
import by.epam.vladlitvin.entity.Station;

import java.util.ArrayDeque;

/**
 * Created by vlad_ on 4/8/2017.
 */
public class App {
    public static void main(String... args) {
        ArrayDeque<Station> stations = new ArrayDeque<Station>(){{
            addLast(new Station("Зелёный луг-7"));
            addLast(new Station("Мирошниченко"));
            addLast(new Station("Цнянское водохранилище"));
            addLast(new Station("Гамарника"));
            addLast(new Station("Кольцова"));
            addLast(new Station("Никитино"));
        }};
        RouteBus routeBus = new RouteBus(stations);
        new Bus(53, 8525, routeBus.clone()).start();
        new Bus(46, 8545, routeBus.clone()).start();
        new Bus(24, 7525, routeBus.clone()).start();
        new Bus(34, 8565, routeBus.clone()).start();
        new Bus(33, 8225, routeBus.clone()).start();


    }
}
