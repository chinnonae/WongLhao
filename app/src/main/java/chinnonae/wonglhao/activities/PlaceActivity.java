package chinnonae.wonglhao.activities;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import chinnonae.wonglhao.R;
import chinnonae.wonglhao.models.DataSimulator;
import chinnonae.wonglhao.models.HangoutPlace;
import chinnonae.wonglhao.models.Rating;
import chinnonae.wonglhao.models.Review;
import chinnonae.wonglhao.utils.PlaceUtil;

public class PlaceActivity extends AppCompatActivity {

    private HangoutPlace place;
    private PlaceActivity self = this;
    private Button reviewButton;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        Toolbar toolbar = (Toolbar) findViewById(R.id.place_name_toolbar);
        setSupportActionBar(toolbar);

        initComponent();
    }


    private void initComponent() {
        place = DataSimulator.getPlace(getIntent().getStringExtra("Place"));

        getSupportActionBar().setTitle(place.getName());

        final TextView ratingText = (TextView) findViewById(R.id.rating_text);
        ratingText.setText(String.format("Rating: %.2f", PlaceUtil.calculateRating(place.getRatings())));

        TextView promotionText = (TextView) findViewById(R.id.promotion_text);
        if (!place.getPromotion().equals("")) {
            promotionText.setText(place.getPromotion());
        }

        TextView pricingText = (TextView) findViewById(R.id.pricing_text);
        if (!place.getPricing().equals("")) {
            pricingText.setText(place.getPricing());
        }

        reviewButton = (Button) findViewById(R.id.review_button);
        reviewButton.setText(String.format("%d people review this place", place.getReviews().size()));
        reviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // DialogFragment.show() will take care of adding the fragment
                // in a transaction.  We also want to remove any currently showing
                // dialog, so make our own transaction and take care of that here.
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                // Create and show the dialog.
                DialogFragment newFragment = new ReviewsDialog();
                Bundle bundle = new Bundle();
                bundle.putString("Place", place.getName());
                newFragment.setArguments(bundle);

                newFragment.show(ft, "dialog");
            }
        });


        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        Rating thisUserRating = null;
        for (Rating r : place.getRatings()) {
            if (r.getUser() == DataSimulator.getThisUser()) {
                thisUserRating = r;
            }
        }
        if (thisUserRating != null) {
            ratingBar.setIsIndicator(true);
            ratingBar.setRating(thisUserRating.getRated());
        } else {
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    if (fromUser) {
                        ratingBar.setIsIndicator(true);
                        place.addRating(new Rating(DataSimulator.getThisUser(), rating));
                        Log.d("OnRatePlace", place.getRatings().toString());
                        ratingText.setText(String.format("Rating: %.2f", PlaceUtil.calculateRating(place.getRatings())));
                    }
                }
            });
        }
    }


}
