package chinnonae.wonglhao.models;

import java.io.Serializable;

/**
 * Created by chinnonae on 02-Jun-16.
 */
public class User implements Serializable{

    private String firstname, lastname, username;

    public User(String firstname, String lastname, String username) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return username;
    }
}
