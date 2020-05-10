package com.adarsh.farmket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.adarsh.farmket.ui.LanguageFragment;
import com.adarsh.farmket.ui.PrivacyPolicyFragment;

public class ProfileSettingHolder extends AppCompatActivity {
    FrameLayout frameLayout;
    private Toolbar toolbar;
    TextView titleToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting_holder);
        frameLayout = (FrameLayout) findViewById(R.id.profile_holder);

        //Setting up toolbar.
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        titleToolbar = findViewById(R.id.title);

        String value = getIntent().getExtras().getString("1");

        if(value.equals("Language")){
            titleToolbar.setText("Language Settings");
            setFragment(new LanguageFragment());
        }
        else if(value.equals("PrivacyPolicy")){
            titleToolbar.setText("Privacy Policy");
            setFragment(new PrivacyPolicyFragment());
        }
        else{
            Log.d("TAG", "onCreate: Went wrong" + value);
        }
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.profile_holder, fragment);
        ft.commit();
    }

}