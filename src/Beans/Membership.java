package Beans;

import java.util.Date;
import java.util.Objects;

public class Membership {
    private String id;
    private String type;
    private Date paymentTime;
    private Date validityTime;
    private int price;
    private Customer customer;
    private boolean active;
    private int numberOfTrainings;


    public Membership() {
    }

    public Membership(String id, String type, Date paymentTime, Date validityTime, int price, Customer customer, boolean active, int numberOfTrainings) {
        this.id = id;
        this.type = type;
        this.paymentTime = paymentTime;
        this.validityTime = validityTime;
        this.price = price;
        this.customer = customer;
        this.active = active;
        this.numberOfTrainings = numberOfTrainings;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getPaymentTime() {
        return this.paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getValidityTime() {
        return this.validityTime;
    }

    public void setValidityTime(Date validityTime) {
        this.validityTime = validityTime;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getNumberOfTrainings() {
        return this.numberOfTrainings;
    }

    public void setNumberOfTrainings(int numberOfTrainings) {
        this.numberOfTrainings = numberOfTrainings;
    }

    public Membership id(String id) {
        setId(id);
        return this;
    }

    public Membership type(String type) {
        setType(type);
        return this;
    }

    public Membership paymentTime(Date paymentTime) {
        setPaymentTime(paymentTime);
        return this;
    }

    public Membership validityTime(Date validityTime) {
        setValidityTime(validityTime);
        return this;
    }

    public Membership price(int price) {
        setPrice(price);
        return this;
    }

    public Membership customer(Customer customer) {
        setCustomer(customer);
        return this;
    }

    public Membership active(boolean active) {
        setActive(active);
        return this;
    }

    public Membership numberOfTrainings(int numberOfTrainings) {
        setNumberOfTrainings(numberOfTrainings);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Membership)) {
            return false;
        }
        Membership membership = (Membership) o;
        return Objects.equals(id, membership.id) && Objects.equals(type, membership.type) && Objects.equals(paymentTime, membership.paymentTime) && Objects.equals(validityTime, membership.validityTime) && price == membership.price && Objects.equals(customer, membership.customer) && active == membership.active && numberOfTrainings == membership.numberOfTrainings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, paymentTime, validityTime, price, customer, active, numberOfTrainings);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", type='" + getType() + "'" +
            ", paymentTime='" + getPaymentTime() + "'" +
            ", validityTime='" + getValidityTime() + "'" +
            ", price='" + getPrice() + "'" +
            ", customer='" + getCustomer() + "'" +
            ", active='" + isActive() + "'" +
            ", numberOfTrainings='" + getNumberOfTrainings() + "'" +
            "}";
    }
    

}
