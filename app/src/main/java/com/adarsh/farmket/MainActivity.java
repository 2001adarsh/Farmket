package com.adarsh.farmket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.adarsh.farmket.ui.CartFragment;
import com.adarsh.farmket.ui.HomeFragment;
import com.adarsh.farmket.ui.ProfileFragment;
import com.adarsh.farmket.ui.UpdateFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity implements  ChipNavigationBar.OnItemSelectedListener{
    public static boolean onFullMachinePage=false;
    public static boolean onFullPesticidePage=false;

    private ChipNavigationBar bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setui();

        if(savedInstanceState==null) //Placing default fragments
        {
            bottomNav.setItemSelected(R.id.nav_home, true);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_frame, new HomeFragment());
            ft.commit();
        }

        bottomNav.setOnItemSelectedListener(this);

    }
    private void setui(){
        bottomNav = (ChipNavigationBar) findViewById(R.id.main_nav);
    }


    @Override
    public void onItemSelected(int i) {
        Fragment fragment = null;
        switch (i){

            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
            case R.id.nav_cart:
                fragment = new CartFragment();
                break;
            case R.id.nav_update:
                fragment = new UpdateFragment();
                break;
            case R.id.nav_profile:
                fragment = new ProfileFragment();
                break;
        }
        if(fragment != null)
        {
            FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_frame, fragment).commit();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(onFullMachinePage){
                onFullMachinePage = false;
                setFragment(new HomeFragment());
                return false;
            }
            if(onFullPesticidePage){
                onFullPesticidePage = false;
                setFragment(new HomeFragment());
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame, fragment).commit();
    }


}
