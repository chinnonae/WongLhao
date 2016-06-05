package chinnonae.wonglhao.models;

import java.io.Serializable;

/**
 * Created by chinnonae on 02-Jun-16.
 */
public class Rating implements Serializable{

    private User user;
    private float rated;

    public Rating(User user, float rated) {
        this.user = user;
        this.rated = rated;
    }

    public User getUser() {
        return user;
    }

    public float getRated() {
        return rated;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", user, rated);
    }
}
