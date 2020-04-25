package com.adarsh.farmket.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import static com.adarsh.farmket.MainActivity.onFullPesticidePage;

import com.adarsh.farmket.R;

public class PesticidesFragment extends Fragment {

    public PesticidesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        onFullPesticidePage = true;

        return inflater.inflate(R.layout.fragment_pesticides, container, false);
    }
}
