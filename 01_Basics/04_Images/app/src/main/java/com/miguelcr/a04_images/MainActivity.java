package com.miguelcr.a04_images;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    ImageView avatar;
    CircleImageView cImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the toolbar
        getSupportActionBar().hide();

        avatar = (ImageView) findViewById(R.id.imageViewAvatar);
        cImage = (CircleImageView) findViewById(R.id.profile_image);

        Picasso.with(this).load("http://www.lagalerna.com/wp-content/uploads/2016/11/cristiano-ronaldoI.jpg").into(avatar);
        Picasso.with(this).load("http://www.lagalerna.com/wp-content/uploads/2016/11/cristiano-ronaldoI.jpg").into(cImage);
    }
}
