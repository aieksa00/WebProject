package Beans;

import java.util.Objects;

public class Location {
    private Double geoLength;
    private Double geoWidth;
    private Address address;
    
    public Location() {
    }

    public Location(Double geoLength, Double geoWidth, Address address) {
        this.geoLength = geoLength;
        this.geoWidth = geoWidth;
        this.address = address;
    }

    public Double getGeoLength() {
        return this.geoLength;
    }

    public void setGeoLength(Double geoLength) {
        this.geoLength = geoLength;
    }

    public Double getGeoWidth() {
        return this.geoWidth;
    }

    public void setGeoWidth(Double geoWidth) {
        this.geoWidth = geoWidth;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Location)) {
            return false;
        }
        Location location = (Location) o;
        return Objects.equals(geoLength, location.geoLength) && Objects.equals(geoWidth, location.geoWidth) && Objects.equals(address, location.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geoLength, geoWidth, address);
    }

    @Override
    public String toString() {
        return "{" +
            " geoLength='" + getGeoLength() + "'" +
            ", geoWidth='" + getGeoWidth() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }   
}
