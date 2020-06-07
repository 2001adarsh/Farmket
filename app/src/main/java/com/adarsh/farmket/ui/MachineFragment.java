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
import com.adarsh.farmket.adapters.AdapterMachine;
import com.adarsh.farmket.helperClass.MachineItem;

import java.util.ArrayList;

import static com.adarsh.farmket.MainActivity.onFullMachinePage;

public class MachineFragment extends Fragment implements AdapterMachine.MachineOnClickListener {

    public MachineFragment() {
    }
RecyclerView TRV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        onFullMachinePage = true;
        View view = inflater.inflate(R.layout.fragment_machine, container, false);
        TRV = view.findViewById(R.id.TmachinesRV);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<MachineItem> machineItems = MachineItem.getMachines();
        TRV.setLayoutManager(new GridLayoutManager(getContext(), 2));
        TRV.setAdapter(new AdapterMachine(machineItems, this));
    }

    @Override
    public void MachineOnClick(int position) {
        startActivity(new Intent(getContext(), ServicesItemHolderPage.class));
    }
}
