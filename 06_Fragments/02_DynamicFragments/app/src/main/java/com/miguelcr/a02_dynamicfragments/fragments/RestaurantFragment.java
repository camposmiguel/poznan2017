package com.miguelcr.a02_dynamicfragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelcr.a02_dynamicfragments.R;

import java.util.ArrayList;
import java.util.List;


public class RestaurantFragment extends Fragment {

    List<RestaurantItem> restaurantItemList;

    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestaurantFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurantitem_list, container, false);

        // List of elements to show in the RecyclerView
        restaurantItemList = new ArrayList<>();
        restaurantItemList.add(new RestaurantItem("Spanish food","dsjhgfdsjfgsdjhf",4.0f,"http://spanishsabores.com/wp-content/uploads/2015/04/IMG_6028.jpg","10-20€"));
        restaurantItemList.add(new RestaurantItem("Burguer house","hdgsfgsdgfjhsdh",3.0f,"https://s-media-cache-ak0.pinimg.com/originals/41/1d/e1/411de18af3f771b4d8b5bd646c93b431.jpg","5-10€"));

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            MyRestaurantItemRecyclerViewAdapter adapter = new MyRestaurantItemRecyclerViewAdapter(
                    getActivity(),
                    R.layout.restaurant_item,
                    restaurantItemList
            );
            recyclerView.setAdapter(adapter);
        }
        return view;
    }


    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    */
}
