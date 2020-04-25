package com.adarsh.farmket.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adarsh.farmket.R;

import static com.adarsh.farmket.MainActivity.onFullMachinePage;

public class MachineFragment extends Fragment {

    public MachineFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        onFullMachinePage = true;
        return inflater.inflate(R.layout.fragment_machine, container, false);
    }

}
