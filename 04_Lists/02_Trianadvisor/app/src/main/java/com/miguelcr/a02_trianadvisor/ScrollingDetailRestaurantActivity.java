package com.miguelcr.a02_trianadvisor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ScrollingDetailRestaurantActivity extends AppCompatActivity {
    TextView tvDescription;
    ImageView ivHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_detail_restaurant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tvDescription = (TextView) findViewById(R.id.text_view_description);
        ivHeader = (ImageView) findViewById(R.id.header_image);

        // We're going to get the intent extras values
        Bundle extras = getIntent().getExtras();

        String name = extras.getString("name");
        String description = extras.getString("description");
        String photo = extras.getString("photo");

        // and now we can set the values into the view components
        setTitle(name);
        tvDescription.setText(description);
        Picasso.with(this).load(photo).into(ivHeader);
    }
}
