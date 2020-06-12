package com.adarsh.farmket.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adarsh.farmket.ItemHolderActivity;
import com.adarsh.farmket.R;
import com.adarsh.farmket.ServicesItemHolderPage;
import com.adarsh.farmket.adapters.AdapterAnimalFood;
import com.adarsh.farmket.helperClass.AnimalFoodItem;

import java.util.ArrayList;

public class AnimalFoodFragment extends Fragment implements AdapterAnimalFood.AnimalFoodOnClickListener {


    public AnimalFoodFragment() {
        // Required empty public constructor
    }
    RecyclerView TRV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animal_food, container, false);
        TRV = view.findViewById(R.id.TanimalFoodRV);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<AnimalFoodItem> animalFoodItems = AnimalFoodItem.getAnimalFood();
        TRV.setLayoutManager(new GridLayoutManager(getContext(), 2));
        TRV.setAdapter(new AdapterAnimalFood(animalFoodItems, this));
    }

    @Override
    public void AnimalFoodOnClick(int position) {
        startActivity(new Intent(getContext(), ItemHolderActivity.class));
    }
}