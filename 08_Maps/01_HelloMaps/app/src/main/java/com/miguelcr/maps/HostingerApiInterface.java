package com.miguelcr.maps;

import com.miguelcr.maps.pojos.ResponseRestaurants;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by miguelcampos on 3/3/17.
 */

public interface HostingerApiInterface {

    @GET("get_restaurants.php")
    Call<ResponseRestaurants> getRestaurants();
}
