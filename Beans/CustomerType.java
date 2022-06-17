package Beans;

import java.util.Objects;

public class CustomerType {
    private CustomerTypeName typeName;
    private Double discount;
    private int reqiredPointsToRankUp;  

    public CustomerType() {
    }

    public CustomerType(CustomerTypeName typeName, Double discount, int reqiredPointsToRankUp) {
        this.typeName = typeName;
        this.discount = discount;
        this.reqiredPointsToRankUp = reqiredPointsToRankUp;
    }

    public CustomerTypeName getTypeName() {
        return this.typeName;
    }

    public void setTypeName(CustomerTypeName typeName) {
        this.typeName = typeName;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public int getReqiredPointsToRankUp() {
        return this.reqiredPointsToRankUp;
    }

    public void setReqiredPointsToRankUp(int reqiredPointsToRankUp) {
        this.reqiredPointsToRankUp = reqiredPointsToRankUp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerType)) {
            return false;
        }
        CustomerType customerType = (CustomerType) o;
        return Objects.equals(typeName, customerType.typeName) && Objects.equals(discount, customerType.discount) && reqiredPointsToRankUp == customerType.reqiredPointsToRankUp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName, discount, reqiredPointsToRankUp);
    }

    @Override
    public String toString() {
        return "{" +
            " typeName='" + getTypeName() + "'" +
            ", discount='" + getDiscount() + "'" +
            ", reqiredPointsToRankUp='" + getReqiredPointsToRankUp() + "'" +
            "}";
    }

}
