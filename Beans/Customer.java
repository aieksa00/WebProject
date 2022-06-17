package Beans;

import java.util.ArrayList;
import java.util.Objects;

public class Customer extends User {
    private double membershipFee;
    private ArrayList<SportsObject> visitedObjects;
    private int earnedPoints;
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(double membershipFee, ArrayList<SportsObject> visitedObjects, int earnedPoints, CustomerType customerType) {
        this.membershipFee = membershipFee;
        this.visitedObjects = visitedObjects;
        this.earnedPoints = earnedPoints;
        this.customerType = customerType;
    }

    public double getMembershipFee() {
        return this.membershipFee;
    }

    public void setMembershipFee(double membershipFee) {
        this.membershipFee = membershipFee;
    }

    public ArrayList<SportsObject> getVisitedObjects() {
        return this.visitedObjects;
    }

    public void setVisitedObjects(ArrayList<SportsObject> visitedObjects) {
        this.visitedObjects = visitedObjects;
    }

    public int getEarnedPoints() {
        return this.earnedPoints;
    }

    public void setEarnedPoints(int earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public CustomerType getCustomerType() {
        return this.customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return membershipFee == customer.membershipFee && Objects.equals(visitedObjects, customer.visitedObjects) && earnedPoints == customer.earnedPoints && Objects.equals(customerType, customer.customerType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(membershipFee, visitedObjects, earnedPoints, customerType);
    }

    @Override
    public String toString() {
        return "{" +
            " membershipFee='" + getMembershipFee() + "'" +
            ", visitedObjects='" + getVisitedObjects() + "'" +
            ", earnedPoints='" + getEarnedPoints() + "'" +
            ", customerType='" + getCustomerType() + "'" +
            "}";
    }
    
}
