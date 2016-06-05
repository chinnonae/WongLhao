package chinnonae.wonglhao.activities;


import android.app.DialogFragment;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import chinnonae.wonglhao.R;
import chinnonae.wonglhao.models.DataSimulator;
import chinnonae.wonglhao.models.Review;
import chinnonae.wonglhao.views.adapters.ReviewAdapter;

/**
 * Created by chinnonae on 04-Jun-16.
 */
public class ReviewsDialog extends DialogFragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Review> reviews;
    private EditText editText;
    private Button submitButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.reviews_dialog, container, false);

        this.reviews = DataSimulator.getPlace(getArguments().getString("Place")).getReviews();

        recyclerView = (RecyclerView) v.findViewById(R.id.review_list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ReviewAdapter(v.getContext(), reviews);
        recyclerView.setAdapter(adapter);

        editText = (EditText)v.findViewById(R.id.review_editText);

        submitButton = (Button)v.findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                Review review = new Review(DataSimulator.getThisUser(), s);
                reviews.add(review);
                editText.setText("");
            }
        });

        return v;
    }
}
