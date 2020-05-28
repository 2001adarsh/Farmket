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
import com.adarsh.farmket.ui.NotificationSettingsFragment;
import com.adarsh.farmket.ui.OrderHistoryFragment;
import com.adarsh.farmket.ui.PrivacyPolicyFragment;

public class ProfileSettingHolder extends AppCompatActivity {
    FrameLayout frameLayout;
    TextView titleToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting_holder);
        frameLayout = (FrameLayout) findViewById(R.id.profile_holder);

        //Setting up toolbar.
        Toolbar toolbar = findViewById(R.id.toolbar);
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

        switch (value){
            case "Language": titleToolbar.setText("Language Settings");
                setFragment(new LanguageFragment());
                break;
            case "PrivacyPolicy":
                titleToolbar.setText("Privacy Policy");
                setFragment(new PrivacyPolicyFragment());
                break;
            case "OrderHistory":
                titleToolbar.setText("Order History");
                setFragment(new OrderHistoryFragment());
                break;
            case "NotificationSettings":
                titleToolbar.setText("NotificationSettings");
                setFragment(new NotificationSettingsFragment());
                break;
            default:
                Log.d("TAG", "onCreate: Went wrong" + value);
                finish();
        }
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.profile_holder, fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
