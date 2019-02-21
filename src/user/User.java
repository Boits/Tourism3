package user;

import storage.Storage;

public class User {
    private String firstName;
    private String lastName;
    private Integer passport;

    public User(String firstName, String lastName, Integer passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
