package com.adarsh.farmket.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adarsh.farmket.R;
import com.adarsh.farmket.adapters.AdapterVegetable;
import com.adarsh.farmket.helperClass.VegetableItem;

import java.util.ArrayList;

public class VegFragment extends Fragment {

    public VegFragment() { }

    RecyclerView vegRV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_veg, container, false);
        vegRV = view.findViewById(R.id.TvegRV);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<VegetableItem> vegetableItems = VegetableItem.vegetableItems();

        vegRV.setLayoutManager(new GridLayoutManager(getContext(), 2));
        vegRV.setAdapter(new AdapterVegetable(vegetableItems));
    }
}
