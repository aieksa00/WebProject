package Beans;

import java.util.Objects;

public class SportsObject {
    private String name;
    private String objectType;
    private String description;
    private boolean status;
    private Location location;
    private Double rating;
    private String workingHours;
    private String image;


    public SportsObject() {
    }

    public SportsObject(String name, String objectType, String description, boolean status, Location location, Double rating, String workingHours, String image) {
        this.name = name;
        this.objectType = objectType;
        this.description = description;
        this.status = status;
        this.location = location;
        this.rating = rating;
        this.workingHours = workingHours;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectType() {
        return this.objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getWorkingHours() {
        return this.workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public SportsObject name(String name) {
        setName(name);
        return this;
    }

    public SportsObject objectType(String objectType) {
        setObjectType(objectType);
        return this;
    }

    public SportsObject description(String description) {
        setDescription(description);
        return this;
    }

    public SportsObject status(boolean status) {
        setStatus(status);
        return this;
    }

    public SportsObject location(Location location) {
        setLocation(location);
        return this;
    }

    public SportsObject rating(Double rating) {
        setRating(rating);
        return this;
    }

    public SportsObject workingHours(String workingHours) {
        setWorkingHours(workingHours);
        return this;
    }

    public SportsObject image(String image) {
        setImage(image);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SportsObject)) {
            return false;
        }
        SportsObject sportsObject = (SportsObject) o;
        return Objects.equals(name, sportsObject.name) && Objects.equals(objectType, sportsObject.objectType) && Objects.equals(description, sportsObject.description) && status == sportsObject.status && Objects.equals(location, sportsObject.location) && Objects.equals(rating, sportsObject.rating) && Objects.equals(workingHours, sportsObject.workingHours) && Objects.equals(image, sportsObject.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, objectType, description, status, location, rating, workingHours, image);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", objectType='" + getObjectType() + "'" +
            ", description='" + getDescription() + "'" +
            ", status='" + isStatus() + "'" +
            ", location='" + getLocation() + "'" +
            ", rating='" + getRating() + "'" +
            ", workingHours='" + getWorkingHours() + "'" +
            ", image='" + getImage() + "'" +
            "}";
    }
    

    public String[] toCSV()
    {
        String[] csvValues =
        {
            name,
            objectType,
            description,
            String.valueOf(status),
            location.toString(),
            rating.toString(),
            workingHours,
            image
        };
        return csvValues;
    }
}
