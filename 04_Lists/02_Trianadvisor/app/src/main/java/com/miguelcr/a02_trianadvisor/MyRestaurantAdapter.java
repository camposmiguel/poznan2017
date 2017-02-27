package com.miguelcr.a02_trianadvisor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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


        return v;
    }
}
