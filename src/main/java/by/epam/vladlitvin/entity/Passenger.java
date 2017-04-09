package by.epam.vladlitvin.entity;

/**
 * Created by vlad_ on 4/2/2017.
 */
public class Passenger {
    private String name;

    public Passenger(int number) {
        this.name = ("passanger " + number);
    }

    @Override
    public String toString() {
        return name ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Passenger)) {
            return false;
        }

        Passenger passenger = (Passenger) o;

        return name.equals(passenger.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
