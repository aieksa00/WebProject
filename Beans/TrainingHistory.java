package Beans;

import java.util.Date;
import java.util.Objects;

public class TrainingHistory {
    private Date registrationTime;
    private Training training;
    private Customer customer;
    private Trainer trainer;


    public TrainingHistory() {
    }

    public TrainingHistory(Date registrationTime, Training training, Customer customer, Trainer trainer) {
        this.registrationTime = registrationTime;
        this.training = training;
        this.customer = customer;
        this.trainer = trainer;
    }

    public Date getRegistrationTime() {
        return this.registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Training getTraining() {
        return this.training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Trainer getTrainer() {
        return this.trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public TrainingHistory registrationTime(Date registrationTime) {
        setRegistrationTime(registrationTime);
        return this;
    }

    public TrainingHistory training(Training training) {
        setTraining(training);
        return this;
    }

    public TrainingHistory customer(Customer customer) {
        setCustomer(customer);
        return this;
    }

    public TrainingHistory trainer(Trainer trainer) {
        setTrainer(trainer);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TrainingHistory)) {
            return false;
        }
        TrainingHistory trainingHistory = (TrainingHistory) o;
        return Objects.equals(registrationTime, trainingHistory.registrationTime) && Objects.equals(training, trainingHistory.training) && Objects.equals(customer, trainingHistory.customer) && Objects.equals(trainer, trainingHistory.trainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationTime, training, customer, trainer);
    }

    @Override
    public String toString() {
        return "{" +
            " registrationTime='" + getRegistrationTime() + "'" +
            ", training='" + getTraining() + "'" +
            ", customer='" + getCustomer() + "'" +
            ", trainer='" + getTrainer() + "'" +
            "}";
    }
    

}
