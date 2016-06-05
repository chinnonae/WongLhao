package chinnonae.wonglhao.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import chinnonae.wonglhao.R;
import chinnonae.wonglhao.models.Review;

/**
 * Created by chinnonae on 04-Jun-16.
 */
public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private List<Review> reviews;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView username;
        private TextView review;

        public ViewHolder(View v) {
            super(v);
            username = (TextView) v.findViewById(R.id.username_text);
            review = (TextView) v.findViewById(R.id.review_text);
        }
    }

    public ReviewAdapter(Context context, List<Review> reviews) {
        this.reviews = reviews;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    @Override
    public ReviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_cardview, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ReviewAdapter.ViewHolder holder, int position) {
        holder.username.setText(reviews.get(position).getReviewer().getUsername());
        holder.review.setText(reviews.get(position).getReviewContent().toString());
    }
}
