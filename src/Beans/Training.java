package Beans;

import java.util.Objects;

public class Training{

    private String name;
    private String type;
    private SportsObject sportsObject;
    private int duration;
    private Trainer trainer;
    private String description;


    public Training() {
    }

    public Training(String name, String type, SportsObject sportsObject, int duration, Trainer trainer, String description) {
        this.name = name;
        this.type = type;
        this.sportsObject = sportsObject;
        this.duration = duration;
        this.trainer = trainer;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SportsObject getSportsObject() {
        return this.sportsObject;
    }

    public void setSportsObject(SportsObject sportsObject) {
        this.sportsObject = sportsObject;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Trainer getTrainer() {
        return this.trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Training name(String name) {
        setName(name);
        return this;
    }

    public Training type(String type) {
        setType(type);
        return this;
    }

    public Training sportsObject(SportsObject sportsObject) {
        setSportsObject(sportsObject);
        return this;
    }

    public Training duration(int duration) {
        setDuration(duration);
        return this;
    }

    public Training trainer(Trainer trainer) {
        setTrainer(trainer);
        return this;
    }

    public Training description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Training)) {
            return false;
        }
        Training training = (Training) o;
        return Objects.equals(name, training.name) && Objects.equals(type, training.type) && Objects.equals(sportsObject, training.sportsObject) && duration == training.duration && Objects.equals(trainer, training.trainer) && Objects.equals(description, training.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, sportsObject, duration, trainer, description);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", sportsObject='" + getSportsObject() + "'" +
            ", duration='" + getDuration() + "'" +
            ", trainer='" + getTrainer() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
   

}