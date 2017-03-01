package com.miguelcr.a02_trianadvisor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    LottieAnimationView animationView;
    ListView lista;
    List<RestaurantItem> restaurantItemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        /*
        animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        animationView.setAnimation("heart.json");
        animationView.loop(false);

        animationView.setOnClickListener(this);
        */

        // 1. get a reference to the listView component
        lista = (ListView)findViewById(R.id.list_view);

        // 2. Create the list of elements
        restaurantItemList = new ArrayList<>();
        restaurantItemList.add(new RestaurantItem(
                        "Spanish Food Restaurant",
                        "The best spanish restaurant in Seville",
                        4.0f,"http://www.que.es/archivos/201505/salmorejo_n-672xXx80.jpg",
                        "10-30€"
                )
        );

        restaurantItemList.add(new RestaurantItem(
                        "Burguer house",
                        "American style burguers",
                        3.0f,"https://s-media-cache-ak0.pinimg.com/originals/af/c2/44/afc244ae80c5118f05cffbfefe4f7f42.jpg",
                        "15-20€"
                )
        );

        // 3. The adapter
        MyRestaurantAdapter adapter = new MyRestaurantAdapter(
                this,
                R.layout.restaurant_item,
                restaurantItemList
        );

        // 4. connect the adapter with the listView
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        // play the heart animation when we click on heart icon
        animationView.playAnimation();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(this, ScrollingDetailRestaurantActivity.class);
        intent.putExtra("name",restaurantItemList.get(position).getName());
        intent.putExtra("description",restaurantItemList.get(position).getDescription());
        intent.putExtra("photo",restaurantItemList.get(position).getUrlPhoto());
        startActivity(intent);
    }
}
