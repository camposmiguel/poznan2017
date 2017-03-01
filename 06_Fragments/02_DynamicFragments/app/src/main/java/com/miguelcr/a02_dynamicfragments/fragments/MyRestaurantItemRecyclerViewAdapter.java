package com.miguelcr.a02_dynamicfragments.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.miguelcr.a02_dynamicfragments.R;
import com.squareup.picasso.Picasso;


import java.util.List;

public class MyRestaurantItemRecyclerViewAdapter extends RecyclerView.Adapter<MyRestaurantItemRecyclerViewAdapter.ViewHolder> {

    private final List<RestaurantItem> mValues;
    private Context ctx;
    private int layout;

    public MyRestaurantItemRecyclerViewAdapter(Context context, int resource, List<RestaurantItem> items) {
        mValues = items;
        ctx = context;
        layout = resource;
    }

    // WE LOAD THE LAYOUT TEMPLATE
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);
        return new ViewHolder(view);
    }

    // SETTERS
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.textViewName.setText(holder.mItem.getName());
        holder.textViewPrice.setText(holder.mItem.getPrice());
        holder.textViewDescription.setText(holder.mItem.getDescription());

        float rating = holder.mItem.getRating();

        if(rating>=1.0f && rating<2.0f) {
            holder.imageViewRating1.setImageResource(android.R.drawable.star_on);
        } else if(rating>=2.0f && rating<3.0f) {
            holder.imageViewRating1.setImageResource(android.R.drawable.star_on);
            holder.imageViewRating2.setImageResource(android.R.drawable.star_on);
        } else if(rating>=3.0f && rating<4.0f) {
            holder.imageViewRating1.setImageResource(android.R.drawable.star_on);
            holder.imageViewRating2.setImageResource(android.R.drawable.star_on);
            holder.imageViewRating3.setImageResource(android.R.drawable.star_on);
        } else if(rating>=4.0f && rating<5.0f) {
            holder.imageViewRating1.setImageResource(android.R.drawable.star_on);
            holder.imageViewRating2.setImageResource(android.R.drawable.star_on);
            holder.imageViewRating3.setImageResource(android.R.drawable.star_on);
            holder.imageViewRating4.setImageResource(android.R.drawable.star_on);
        } else if(rating>=5.0f) {
            holder.imageViewRating1.setImageResource(android.R.drawable.star_on);
            holder.imageViewRating2.setImageResource(android.R.drawable.star_on);
            holder.imageViewRating3.setImageResource(android.R.drawable.star_on);
            holder.imageViewRating4.setImageResource(android.R.drawable.star_on);
            holder.imageViewRating5.setImageResource(android.R.drawable.star_on);
        }

        Picasso.with(ctx).load(holder.mItem.getUrlPhoto()).into(holder.imageViewPhoto);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    // VIEW COMPONENTS findViewById methods
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewName;
        public final TextView textViewDescription;
        public final TextView textViewPrice;
        public final ImageView imageViewRating1;
        public final ImageView imageViewRating2;
        public final ImageView imageViewRating3;
        public final ImageView imageViewRating4;
        public final ImageView imageViewRating5;
        public final ImageView imageViewPhoto;
        public RestaurantItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            // findViewId
            textViewName = (TextView) view.findViewById(R.id.textViewTitle);
            textViewDescription = (TextView) view.findViewById(R.id.textViewDescription);
            textViewPrice = (TextView) view.findViewById(R.id.textViewPrice);
            imageViewRating1 = (ImageView) view.findViewById(R.id.imageViewStar1);
            imageViewRating2 = (ImageView) view.findViewById(R.id.imageViewStar2);
            imageViewRating3 = (ImageView) view.findViewById(R.id.imageViewStar3);
            imageViewRating4 = (ImageView) view.findViewById(R.id.imageViewStar4);
            imageViewRating5 = (ImageView) view.findViewById(R.id.imageViewStar5);
            imageViewPhoto = (ImageView) view.findViewById(R.id.imageViewRestaurant);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewName.getText() + "'";
        }
    }
}
