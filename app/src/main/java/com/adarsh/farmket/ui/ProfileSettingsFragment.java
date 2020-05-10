package com.adarsh.farmket.ui;
//Icons made by <a href="http://www.freepik.com/" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon"> www.flaticon.com</a>
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.adarsh.farmket.ContactUsActivity;
import com.adarsh.farmket.ProfileSettingHolder;
import com.adarsh.farmket.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileSettingsFragment extends Fragment implements View.OnClickListener {
    private FloatingActionButton goToProfileTracking;
    private LinearLayout ContactUsPage, shippingAddress, languageSettings, privacyPolicy;

    public ProfileSettingsFragment() { }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_settings, container, false);
        goToProfileTracking = view.findViewById(R.id.go_to_profile_tacking);
        ContactUsPage = (LinearLayout) view.findViewById(R.id.contact_us);
        languageSettings= (LinearLayout) view.findViewById(R.id.language);
        privacyPolicy = (LinearLayout) view.findViewById(R.id.privacy_policy);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        goToProfileTracking.setOnClickListener(this);
        ContactUsPage.setOnClickListener(this);
        languageSettings.setOnClickListener(this);
        privacyPolicy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.go_to_profile_tacking:
                setFragment(new TrackOrderFragment());
                break;
            case R.id.contact_us:
                setIntent(ContactUsActivity.class);
                break;
            case R.id.language:
                setIntentwithBundle(ProfileSettingHolder.class, "Language");
            case R.id.privacy_policy:
                setIntentwithBundle(ProfileSettingHolder.class, "PrivacyPolicy");
            default: break;
        }
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.profile_frame_layout, fragment);
        ft.commit();
    }

    private void setIntent(Class classobj){
        Intent it = new Intent(getContext(), classobj);
        startActivity(it);
    }

    private void setIntentwithBundle(Class classobj, String value){
        Intent it = new Intent(getContext(), classobj);
        it.putExtra("1", value);
        startActivity(it);
    }
}
