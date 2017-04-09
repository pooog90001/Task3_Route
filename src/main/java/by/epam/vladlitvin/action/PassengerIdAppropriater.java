package by.epam.vladlitvin.action;

/**
 * Created by vlad_ on 3/22/2017.
 */
public class PassengerIdAppropriater {
    private static int id;

    public static int appropriateID() {
        return id++;
    }


}
