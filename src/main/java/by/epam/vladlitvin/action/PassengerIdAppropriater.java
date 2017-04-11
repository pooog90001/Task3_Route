package by.epam.vladlitvin.action;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vlad_ on 3/22/2017.
 */
public class PassengerIdAppropriater {
    private static AtomicInteger id = new AtomicInteger(0);

    public static int appropriateID() {
        return id.incrementAndGet();
    }


}
