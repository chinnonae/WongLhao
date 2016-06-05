package chinnonae.wonglhao.utils;

import java.util.List;

import chinnonae.wonglhao.models.Rating;

/**
 * Created by chinnonae on 04-Jun-16.
 */
public class PlaceUtil {

    public static float calculateRating(List<Rating> ratings){
        float rated = 0;
        for(Rating r : ratings) {
            rated += r.getRated();
        }
        return rated/ratings.size();
    }
}
