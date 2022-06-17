package Beans;
import java.util.Date;
import java.util.Objects;

public class User{
    private String username;
    private String password;
    private String name;
    private String surname;
    private String gender;
    private Date birthDate;
    private UserType userType;
    

    public User() {
    }

    public User(String username, String password, String name, String surname, String gender, Date birthDate, UserType userType) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.userType = userType;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public UserType getUserType() {
        return this.userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(gender, user.gender) && Objects.equals(birthDate, user.birthDate) && Objects.equals(userType, user.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, name, surname, gender, birthDate, userType);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", gender='" + getGender() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", userType='" + getUserType() + "'" +
            "}";
    }
}