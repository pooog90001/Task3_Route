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
    private static ReentrantLock locker = new ReentrantLock(true);

    public static void passangersGetOn(Bus bus) {
        Random random = new Random();

        int countGetOn = random.nextInt(RANDOM_BORDER);
        for (int i = 0; i < countGetOn; i++) {
            int index = random.nextInt(RANDOM_BORDER );
            if (bus.getPassanger(index) == null) {
                locker.lock();
                bus.setPassanger(new Passenger(appropriateID()), index);
                LOGGER.log(INFO,bus.getPassanger(index) + " get on the  bus № " + bus.getRouteNumber() );
                locker.unlock();
            }
        }
    }

    public static void passangersGetOff(Bus bus) {
        Random random = new Random();
        int countGetOff = random.nextInt(RANDOM_BORDER);

        for (int i = 0; i < countGetOff; i++) {
            int index = random.nextInt(RANDOM_BORDER);

            if (bus.getPassanger(index) != null) {
                LOGGER.log(INFO, bus.getPassanger(index) + " get off the bus № " + bus.getRouteNumber());
                bus.setPassanger(null, index);
            }
        }
    }
}

