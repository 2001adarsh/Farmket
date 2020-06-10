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
import com.adarsh.farmket.adapters.AdapterWorker;
import com.adarsh.farmket.helperClass.WorkerItem;

import java.util.ArrayList;

public class workersFragment extends Fragment implements AdapterWorker.WorkerOnClickListener {

    public workersFragment() { }
    RecyclerView TRV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_workers, container, false);
        TRV = view.findViewById(R.id.TworkerRV);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<WorkerItem> workerItems = WorkerItem.getworkers();
        TRV.setLayoutManager(new GridLayoutManager(getContext(), 2));
        TRV.setAdapter(new AdapterWorker(workerItems,this));
    }

    @Override
    public void WorkerOnClick(int position) {
        startActivity(new Intent(getContext(), ServicesItemHolderPage.class));
    }
}