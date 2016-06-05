package chinnonae.wonglhao.views.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;

import java.util.List;

import chinnonae.wonglhao.R;
import chinnonae.wonglhao.activities.MainActivity;
import chinnonae.wonglhao.activities.PlaceActivity;
import chinnonae.wonglhao.models.HangoutPlace;

/**
 * Created by chinnonae on 03-Jun-16.
 */
public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private List<HangoutPlace> data;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        private CardView cardView;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.place_name_text);
            cardView = (CardView) itemView.findViewById(R.id.place_cardview);
        }

    }


    public PlaceAdapter(Context context, List<HangoutPlace> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.place_cardview, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(data.get(position).getName());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(((MainActivity)context), PlaceActivity.class);
                intent.putExtra("Place", data.get(position).getName());
                Log.d("click place name", "onClick: " + data + "\n" + "Position: " + position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
