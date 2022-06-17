package Beans;

import java.util.Objects;

public class Trainer extends User {
    private TrainingHistory trainingHistory;


    public Trainer() {
    }

    public Trainer(TrainingHistory trainingHistory) {
        this.trainingHistory = trainingHistory;
    }

    public TrainingHistory getTrainingHistory() {
        return this.trainingHistory;
    }

    public void setTrainingHistory(TrainingHistory trainingHistory) {
        this.trainingHistory = trainingHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Trainer)) {
            return false;
        }
        Trainer trainer = (Trainer) o;
        return Objects.equals(trainingHistory, trainer.trainingHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(trainingHistory);
    }

    @Override
    public String toString() {
        return "{" +
            " trainingHistory='" + getTrainingHistory() + "'" +
            "}";
    }   
}
