package com.adarsh.farmket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity implements  ChipNavigationBar.OnItemSelectedListener{

    private ChipNavigationBar bottomNav;
    private FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setui();

        if(savedInstanceState==null) //Placing default fragments
        {
            bottomNav.setItemSelected(R.id.nav_home, true);

        }

        bottomNav.setOnItemSelectedListener(this);

    }
    private void setui(){

        frameLayout = (FrameLayout) findViewById(R.id.main_frame);
        bottomNav = (ChipNavigationBar) findViewById(R.id.main_nav);
    }


    @Override
    public void onItemSelected(int i) {
        switch (i){

            case R.id.nav_home:
                Toast.makeText(this, "Home Fragment!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_cart:
                Toast.makeText(this, "Cart Fragment", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_help:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_profile:
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
