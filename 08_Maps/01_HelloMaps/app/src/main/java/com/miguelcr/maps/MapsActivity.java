package com.miguelcr.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.miguelcr.maps.pojos.ResponseRestaurants;
import com.miguelcr.maps.pojos.Restaurant;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng seville = new LatLng(37.380279,-6.006947);


        mMap.animateCamera(CameraUpdateFactory.newLatLng(seville));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(seville));


        mMap.setOnMapClickListener(this);
        mMap.setOnMarkerClickListener(this);

        getRestaurantsList();

    }

    @Override
    public void onMapClick(LatLng latLng) {
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("New marker")
                .snippet("You clicked here!")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker))
        );

        // We change the center of the map
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        //marker.remove();
        return false;
    }

    private void getRestaurantsList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://miguelftp.esy.es")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HostingerApiInterface apiService =
                retrofit.create(HostingerApiInterface.class);

        Call<ResponseRestaurants> call = apiService.getRestaurants();

        call.enqueue(new Callback<ResponseRestaurants>() {

            @Override
            public void onResponse(Call<ResponseRestaurants> call, Response<ResponseRestaurants> response) {

                Log.i("ErroronResponse",call.request().url().toString());

                int statusCode = response.code();

                // 200 ok
                if(statusCode== HttpURLConnection.HTTP_OK && response.body()!=null) {

                    ResponseRestaurants restaurantsResponse = response.body();
                    List<Restaurant> restaurantList = restaurantsResponse.getRestaurants();



                    for(int i=0; i<restaurantList.size(); i++) {
                        String latlon = restaurantList.get(i).getLatlng();

                        String[] splitString = latlon.split(",");
                        LatLng position = new LatLng(Double.parseDouble(splitString[0]),Double.parseDouble(splitString[1]));

                        mMap.addMarker(new MarkerOptions()
                            .title(restaurantList.get(i).getName())
                            .position(position)
                        );

                        mMap.animateCamera(CameraUpdateFactory.newLatLng(position));

                    }

                } else {
                    // 404
                    // 500
                    Toast.makeText(MapsActivity.this,"Error",Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<ResponseRestaurants> call, Throwable t) {

                Log.i("ErroronFailure",call.request().url().toString());

            }

        });
    }
}
