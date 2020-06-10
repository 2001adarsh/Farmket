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

import com.adarsh.farmket.R;
import com.adarsh.farmket.ServicesItemHolderPage;
import com.adarsh.farmket.adapters.AdapterConsultancy;
import com.adarsh.farmket.helperClass.ConsultancyItem;

import java.util.ArrayList;


public class ConsultancyFragment extends Fragment implements AdapterConsultancy.ConsultancyOnClickListener {

    public ConsultancyFragment() {  }
    RecyclerView TRV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consultancy, container, false);
        TRV = view.findViewById(R.id.TconsultancyRV);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<ConsultancyItem> consultancyItems = ConsultancyItem.getConcultant();
        TRV.setLayoutManager(new GridLayoutManager(getContext(), 2));
        TRV.setAdapter(new AdapterConsultancy(consultancyItems, this));
    }

    @Override
    public void ConsultancyOnClick(int position) {
        startActivity(new Intent(getContext(), ServicesItemHolderPage.class));
    }
}