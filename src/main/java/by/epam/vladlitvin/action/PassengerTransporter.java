package by.epam.vladlitvin.action;

import by.epam.vladlitvin.entity.Bus;
import by.epam.vladlitvin.entity.Passenger;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static by.epam.vladlitvin.action.PassengerIdAppropriater.*;
import static org.apache.logging.log4j.Level.*;
import static org.apache.logging.log4j.LogManager.*;

/**
 * Created by vlad_ on 4/8/2017.
 */
public class PassengerTransporter {
    private final static Logger LOGGER = getLogger();
    private final static int RANDOM_BORDER = 5;

    public static void passangersGetOn(Bus bus) {
        Random random = new Random();

        int countGetOn = random.nextInt(RANDOM_BORDER);

        for (int i = 0; i < countGetOn; i++) {
            int index = random.nextInt(Bus.PASSANGER_CAPACITY - 1);

            if (bus.getPassanger(index) == null) {
                bus.setPassanger(new Passenger(appropriateID()), index);
                LOGGER.log(INFO,bus.getPassanger(index) + " get on the  bus № "
                        + bus.getRouteNumber() + ", on plase № " + index );
            }
        }
    }

    public static void passangersGetOff(Bus bus) {
        Random random = new Random();
        int countGetOff = random.nextInt(RANDOM_BORDER);

        for (int i = 0; i < countGetOff; i++) {
            int index = random.nextInt(Bus.PASSANGER_CAPACITY - 1);

            if (bus.getPassanger(index) != null) {
                LOGGER.log(INFO, bus.getPassanger(index) + " get off the bus № " + bus.getRouteNumber());
                bus.setPassanger(null, index);
            }
        }
    }
}

