package Beans;

import java.util.Objects;

public class Manager extends User {
    private SportsObject sportsObject;

    public Manager() {
    }

    public Manager(SportsObject sportsObject) {
        this.sportsObject = sportsObject;
    }

    public SportsObject getSportsObject() {
        return this.sportsObject;
    }

    public void setSportsObject(SportsObject sportsObject) {
        this.sportsObject = sportsObject;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Manager)) {
            return false;
        }
        Manager manager = (Manager) o;
        return Objects.equals(sportsObject, manager.sportsObject);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sportsObject);
    }

    @Override
    public String toString() {
        return "{" +
            " sportsObject='" + getSportsObject() + "'" +
            "}";
    }

}
