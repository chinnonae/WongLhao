package chinnonae.wonglhao.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chinnonae on 02-Jun-16.
 */
public class HangoutPlace implements Serializable {

    private String name;
    private List<Rating> ratings;
    private List<Review> reviews;
    private String promotion;
    private String pricing;

    public HangoutPlace(String name) {
        this.name = name;
        ratings = new ArrayList<Rating>();
        reviews = new ArrayList<Review>();
        promotion = "";
        pricing = "";
    }

    public String getName() {
        return name;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public String getPromotion() {
        return promotion;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public void addRating(Rating... ratings) {
        for(Rating r : ratings){
            this.ratings.add(r);
        }
    }

    public void addReview(Review... reviews) {
        for(Review r : reviews){
            this.reviews.add(r);
        }
    }

    public String toString(){
        return this.name;
    }

}
