package chinnonae.wonglhao.models;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chinnonae on 02-Jun-16.
 */
public final class DataSimulator {
    private static ArrayList<HangoutPlace> places;
    private static ArrayList<User> users;
    private static User thisUser;
    private static HashMap<String, HangoutPlace> places_map;



    public static List<HangoutPlace> getPlaces() {
        return places;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static HangoutPlace getPlace(String name) {
        return places_map.get(name);
    }

    public static User getThisUser() {
        return thisUser;
    }

    public static void populateData() {
        places = new ArrayList<HangoutPlace>();
        users = new ArrayList<User>();
        places_map = new HashMap<String, HangoutPlace>();
        User Mr_a = new User("Mr.A", "A jing jing", "CopyA");
        User Mr_b = new User("Mr.Be", "Cool", "Bcool");
        User Mr_c = new User("Mr.C-you", "Again", "SeeYa");
        users.add(Mr_a);
        users.add(Mr_b);
        users.add(Mr_c);

        User thisuser = new User("Mr.you", "this-is-you", "ThisIsU");
        thisUser = thisuser;


        HangoutPlace kikbar = new HangoutPlace("Kikbar");
        kikbar.setPricing("3 bottles of beer -> 270 Baht");
        kikbar.setPromotion("Free mixer");

        Review kikRevA = new Review(Mr_a, "Kikbar is awesome");
        Review kikRevC = new Review(Mr_c, "You should try this place");
        kikbar.addReview(kikRevA, kikRevC);

        Rating kikRatA = new Rating(Mr_a, 5);
        Rating kikRatB = new Rating(Mr_b, 4);
        Rating kikRatC = new Rating(Mr_c, 4);
        kikbar.addRating(kikRatA, kikRatB, kikRatC);


        HangoutPlace deep = new HangoutPlace("Deep");
        deep.setPricing("1 beer tower: 900 Baht");

        Review[] deepReviews = {
            new Review(Mr_b, "Goog EDM music, but may be little expensive"),
            new Review(Mr_c, "This place is OK, not that good")
        };

        Rating[] deepRatings = {
            new Rating(Mr_a, 3),
            new Rating(Mr_b, 4)
        };

        deep.addRating(deepRatings);
        deep.addReview(deepReviews);


        places.add(kikbar);
        places.add(deep);
        places_map.put(kikbar.getName(), kikbar);
        places_map.put(deep.getName(), deep);

    }
}
