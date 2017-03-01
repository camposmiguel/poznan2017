package com.miguelcr.a01_localdatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.miguelcr.a01_localdatabase.localdb.Students;

import java.util.List;

/**
 * Created by miguelcampos on 1/3/17.
 */

public class StudentsAdapter extends ArrayAdapter<Students> {
    Context ctx;
    int layout;
    List<Students> values;


    public StudentsAdapter(Context context, int resource, List<Students> objects) {
        super(context, resource, objects);
        ctx = context;
        layout = resource;
        values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = LayoutInflater.from(ctx).inflate(layout, parent, false);

        Students current = values.get(position);

        // Get all the restaurant information
        String name = current.getName();
        int age = current.getAge();
        boolean repeat = current.getRepeat();


        // Get the view components references
        TextView tvName = (TextView)v.findViewById(R.id.textViewName);
        TextView tvAge = (TextView)v.findViewById(R.id.textViewAge);
        TextView tvRepeat = (TextView)v.findViewById(R.id.textViewRepeat);


        // Set the information into the View Components
        tvName.setText(name);
        tvAge.setText(String.valueOf(age));

        if(!repeat) {
            // If we write INVISIBLE means that the space where we have
            // the TextView repeat appear in transparent
            //tvRepeat.setVisibility(View.INVISIBLE);

            // If we write GONE it means that the view component disappear
            // completely
            tvRepeat.setVisibility(View.GONE);
        }


        return v;
    }
}
