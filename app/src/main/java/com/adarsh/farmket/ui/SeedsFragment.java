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
import com.adarsh.farmket.adapters.AdapterSeed;
import com.adarsh.farmket.helperClass.SeedItem;

import java.util.ArrayList;

public class SeedsFragment extends Fragment {

    public SeedsFragment() {
        // Required empty public constructor
    }
    RecyclerView TRV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_seeds, container, false);
        TRV = view.findViewById(R.id.TseedsRV);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<SeedItem> seedItems = SeedItem.getSeed();
        TRV.setLayoutManager(new GridLayoutManager(getContext(),2));
        TRV.setAdapter(new AdapterSeed(seedItems));
    }
}
