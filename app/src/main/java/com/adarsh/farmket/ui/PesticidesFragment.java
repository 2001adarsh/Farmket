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
import static com.adarsh.farmket.MainActivity.onFullPesticidePage;

import com.adarsh.farmket.R;
import com.adarsh.farmket.adapters.AdapterPesticides;
import com.adarsh.farmket.helperClass.PesticidesItem;

import java.util.ArrayList;

public class PesticidesFragment extends Fragment {

    public PesticidesFragment() {
        // Required empty public constructor
    }
    RecyclerView TRV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        onFullPesticidePage = true;
    View view = inflater.inflate(R.layout.fragment_pesticides, container, false);
    TRV = view.findViewById(R.id.TpesticidesRV);
    return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<PesticidesItem> pesticidesItems = PesticidesItem.getPesticides();
        TRV.setLayoutManager(new GridLayoutManager(getContext(), 2));
        TRV.setAdapter(new AdapterPesticides(pesticidesItems));

    }
}
