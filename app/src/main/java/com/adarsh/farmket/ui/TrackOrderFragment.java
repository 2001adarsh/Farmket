package com.adarsh.farmket.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adarsh.farmket.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TrackOrderFragment extends Fragment implements View.OnClickListener {
    private FloatingActionButton goToProfileSettings;
    public TrackOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_track_order, container, false);
        goToProfileSettings = (FloatingActionButton) view.findViewById(R.id.go_to_profileSettings);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        goToProfileSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.go_to_profileSettings:
                setFragment(new ProfileSettingsFragment());
            default:
                return;
        }
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.profile_frame_layout, fragment);
        ft.commit();
    }

}
