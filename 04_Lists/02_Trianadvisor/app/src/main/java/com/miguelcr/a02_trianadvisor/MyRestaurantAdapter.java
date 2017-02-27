package com.miguelcr.a02_trianadvisor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by miguelcampos on 27/2/17.
 */

public class MyRestaurantAdapter extends ArrayAdapter<RestaurantItem> {
    Context ctx;
    int layout;
    List<RestaurantItem> values;


    public MyRestaurantAdapter(Context context, int resource, List<RestaurantItem> objects) {
        super(context, resource, objects);
        ctx = context;
        layout = resource;
        values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = LayoutInflater.from(ctx).inflate(layout, parent, false);

        RestaurantItem current = values.get(position);

        // Get all the restaurant information
        String name = current.getName();
        String description = current.getDescription();
        float rating = current.getRating();
        String priceRange = current.getPrice();
        String photo = current.getUrlPhoto();


        // Get the view components references
        TextView tvTitle = (TextView)v.findViewById(R.id.textViewTitle);
        TextView tvDescription = (TextView)v.findViewById(R.id.textViewDescription);
        TextView tvPrice = (TextView)v.findViewById(R.id.textViewPrice);
        ImageView ivRestaurant = (ImageView) v.findViewById(R.id.imageViewRestaurant);
        ImageView ivStar1 = (ImageView) v.findViewById(R.id.imageViewStar1);
        ImageView ivStar2 = (ImageView) v.findViewById(R.id.imageViewStar2);
        ImageView ivStar3 = (ImageView) v.findViewById(R.id.imageViewStar3);
        ImageView ivStar4 = (ImageView) v.findViewById(R.id.imageViewStar4);
        ImageView ivStar5 = (ImageView) v.findViewById(R.id.imageViewStar5);


        // Set the information into the View Components
        tvTitle.setText(name);
        tvDescription.setText(description);
        tvPrice.setText(priceRange);

        Picasso.with(ctx).load(photo).into(ivRestaurant);

        if(rating>=1.0f && rating<2.0f) {
            ivStar1.setImageResource(android.R.drawable.star_on);
        } else if(rating>=2.0f && rating<3.0f) {
            ivStar1.setImageResource(android.R.drawable.star_on);
            ivStar2.setImageResource(android.R.drawable.star_on);
        } else if(rating>=3.0f && rating<4.0f) {
            ivStar1.setImageResource(android.R.drawable.star_on);
            ivStar2.setImageResource(android.R.drawable.star_on);
            ivStar3.setImageResource(android.R.drawable.star_on);
        } else if(rating>=4.0f && rating<5.0f) {
            ivStar1.setImageResource(android.R.drawable.star_on);
            ivStar2.setImageResource(android.R.drawable.star_on);
            ivStar3.setImageResource(android.R.drawable.star_on);
            ivStar4.setImageResource(android.R.drawable.star_on);
        } else if(rating>=5.0f){
            ivStar1.setImageResource(android.R.drawable.star_on);
            ivStar2.setImageResource(android.R.drawable.star_on);
            ivStar3.setImageResource(android.R.drawable.star_on);
            ivStar4.setImageResource(android.R.drawable.star_on);
            ivStar5.setImageResource(android.R.drawable.star_on);
        }

        return v;
    }
}
