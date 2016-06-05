package chinnonae.wonglhao.models;

import java.io.Serializable;

/**
 * Created by chinnonae on 02-Jun-16.
 */
public class Review implements Serializable{

    private User reviewer;
    private String reviewContent;

    public Review(User reviewer, String reviewContent) {
        this.reviewer = reviewer;
        this.reviewContent = reviewContent;
    }

    public User getReviewer() {
        return reviewer;
    }

    public String getReviewContent() {
        return reviewContent;
    }
}
