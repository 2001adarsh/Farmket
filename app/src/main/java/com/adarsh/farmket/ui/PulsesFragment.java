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
import com.adarsh.farmket.adapters.AdapterPulse;
import com.adarsh.farmket.helperClass.PulseItem;

import java.util.ArrayList;

public class PulsesFragment extends Fragment {

    public PulsesFragment() {
        // Required empty public constructor
    }
    RecyclerView TpulseRV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pulses, container, false);
        TpulseRV = view.findViewById(R.id.TpulsesRV);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<PulseItem> pulseItems = PulseItem.getPulses();
        TpulseRV.setLayoutManager(new GridLayoutManager(getContext(), 2));
        TpulseRV.setAdapter(new AdapterPulse(pulseItems,getContext()));
    }
}
