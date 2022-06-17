package Beans;

import java.util.Objects;

public class Comment {
    private Customer customer;
    private SportsObject object;
    private String text;
    private int rating;


    public Comment() {
    }

    public Comment(Customer customer, SportsObject object, String text, int rating) {
        this.customer = customer;
        this.object = object;
        this.text = text;
        this.rating = rating;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SportsObject getObject() {
        return this.object;
    }

    public void setObject(SportsObject object) {
        this.object = object;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Comment customer(Customer customer) {
        setCustomer(customer);
        return this;
    }

    public Comment object(SportsObject object) {
        setObject(object);
        return this;
    }

    public Comment text(String text) {
        setText(text);
        return this;
    }

    public Comment rating(int rating) {
        setRating(rating);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Comment)) {
            return false;
        }
        Comment comment = (Comment) o;
        return Objects.equals(customer, comment.customer) && Objects.equals(object, comment.object) && Objects.equals(text, comment.text) && rating == comment.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, object, text, rating);
    }

    @Override
    public String toString() {
        return "{" +
            " customer='" + getCustomer() + "'" +
            ", object='" + getObject() + "'" +
            ", text='" + getText() + "'" +
            ", rating='" + getRating() + "'" +
            "}";
    }
    

}
