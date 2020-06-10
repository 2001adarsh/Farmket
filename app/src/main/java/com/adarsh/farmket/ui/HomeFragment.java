package com.adarsh.farmket.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.adarsh.farmket.ContactUsActivity;
import com.adarsh.farmket.ItemHolderActivity;
import com.adarsh.farmket.R;
import com.adarsh.farmket.ServicesItemHolderPage;
import com.adarsh.farmket.adapters.AdapterFruits;
import com.adarsh.farmket.adapters.AdapterMachine;
import com.adarsh.farmket.adapters.AdapterPesticides;
import com.adarsh.farmket.adapters.AdapterPulse;
import com.adarsh.farmket.adapters.AdapterSeed;
import com.adarsh.farmket.adapters.AdapterSlider;
import com.adarsh.farmket.adapters.AdapterVegetable;
import com.adarsh.farmket.helperClass.FruitItem;
import com.adarsh.farmket.helperClass.MachineItem;
import com.adarsh.farmket.helperClass.PesticidesItem;
import com.adarsh.farmket.helperClass.PulseItem;
import com.adarsh.farmket.helperClass.SeedItem;
import com.adarsh.farmket.helperClass.SliderItem;
import com.adarsh.farmket.helperClass.VegetableItem;
import com.adarsh.farmket.helperClass.WorkerItem;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private ArrayList<SliderItem> sliderItems = SliderItem.setSliderView(4);

    private FrameLayout frameLayout;

    //QuickLinks
    private CircleImageView vegy, fruity, cropy, pulsy, seedy, machy, pesty, conty;
    private TextView tvegy, tfruity, tcropy, tpulsy, tseedy, tmachy, tpesty, tconty;

    //Products
    private CardView vegetableItem, fruitItem, pulsesItem, seedItem, cropsItems, pesticidesItem;
    //Services
    private CardView workersItem, machineItem, consultancyItem, chainPulleyItem;

    public HomeFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        //products
        vegetableItem = view.findViewById(R.id.vegetable_view);
        fruitItem = view.findViewById(R.id.fruits_view);
        pulsesItem = view.findViewById(R.id.pulses_view);
        seedItem = view.findViewById(R.id.seeds_view);
        cropsItems = view.findViewById(R.id.crops_view);
        pesticidesItem = view.findViewById(R.id.pesticides_view);

        //services
        workersItem = view.findViewById(R.id.worker_view);
        machineItem = view.findViewById(R.id.machines_view);
        consultancyItem = view.findViewById(R.id.consultancy_view);
        chainPulleyItem = view.findViewById(R.id.chainPulley_view);
        quickLinksSetUp(view);

        frameLayout = getActivity().findViewById(R.id.main_frame);
        return view;
    }

    private void quickLinksSetUp(View view) {
        vegy = (CircleImageView) view.findViewById(R.id.quick_veg);
        tvegy = (TextView) view.findViewById(R.id.quick_veg_txt);

        fruity = (CircleImageView) view.findViewById(R.id.quick_fruit);
        tfruity = (TextView) view.findViewById(R.id.quick_fruit_txt);

        cropy = (CircleImageView) view.findViewById(R.id.quick_crops);
        tcropy = (TextView) view.findViewById(R.id.quick_crops_txt);

        seedy = (CircleImageView) view.findViewById(R.id.quick_seeds);
        tseedy = (TextView) view.findViewById(R.id.quick_seeds_txt);

        pulsy = (CircleImageView) view.findViewById(R.id.quick_pulses);
        tpulsy = (TextView) view.findViewById(R.id.quick_pulses_txt);

        machy = (CircleImageView) view.findViewById(R.id.quick_machines);
        tmachy = (TextView) view.findViewById(R.id.quick_machines_txt);

        pesty = (CircleImageView) view.findViewById(R.id.quick_pesticides);
        tpesty = (TextView) view.findViewById(R.id.quick_pesticides_txt);

        conty = (CircleImageView) view.findViewById(R.id.quick_contact);
        tconty = (TextView) view.findViewById(R.id.quick_contact_txt);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //initialisation of quick links
        ClickListenerforQuickLinks();

        //Image Slider View.
        SliderView sliderView = view.findViewById(R.id.imageSlider);
        sliderView.setSliderAdapter(new AdapterSlider(sliderItems));
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);

        //Products
        vegetableItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new VegFragment());
            }
        });
        fruitItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new FruitsFragment());
            }
        });
        pulsesItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new PulsesFragment());
            }
        });
        seedItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new SeedsFragment());
            }
        });
        /*
        crops to be made.
        -----*/
        pesticidesItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new PesticidesFragment());
            }
        });

        // Image Slider for Service.
        SliderView serviceBanner = view.findViewById(R.id.serviceBanner);
        serviceBanner.setSliderAdapter(new AdapterSlider(sliderItems));
        serviceBanner.setIndicatorAnimation(IndicatorAnimations.WORM);
        serviceBanner.setIndicatorSelectedColor(Color.WHITE);
        serviceBanner.setIndicatorUnselectedColor(Color.GRAY);


        //Services
        workersItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new workersFragment());
            }
        });

        machineItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new MachineFragment());
            }
        });

        consultancyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new ConsultancyFragment());
            }
        });

        chainPulleyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startServiceItemPage();
            }
        });
    }

    private void ClickListenerforQuickLinks() {
        vegy.setOnClickListener(this);
        tvegy.setOnClickListener(this);
        fruity.setOnClickListener(this);
        tfruity.setOnClickListener(this);
        seedy.setOnClickListener(this);
        tseedy.setOnClickListener(this);
        cropy.setOnClickListener(this);
        tcropy.setOnClickListener(this);
        pulsy.setOnClickListener(this);
        tpulsy.setOnClickListener(this);
        machy.setOnClickListener(this);
        tmachy.setOnClickListener(this);
        pesty.setOnClickListener(this);
        tpesty.setOnClickListener(this);
        conty.setOnClickListener(this);
        tconty.setOnClickListener(this);
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(frameLayout.getId(), fragment);
        ft.addToBackStack(null);
        ft.commit();
    }



    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.quick_veg || (view.getId() == R.id.quick_veg_txt)) {
            setFragment(new VegFragment());
        } else if (view.getId() == R.id.quick_fruit || (view.getId() == R.id.quick_fruit_txt)) {
            setFragment(new FruitsFragment());
        } else if (view.getId() == R.id.quick_crops || (view.getId() == R.id.quick_crops_txt)) {

        } else if (view.getId() == R.id.quick_seeds || (view.getId() == R.id.quick_seeds_txt)) {
            setFragment(new SeedsFragment());
        } else if (view.getId() == R.id.quick_pulses || (view.getId() == R.id.quick_pulses_txt)) {
            setFragment(new PulsesFragment());
        } else if (view.getId() == R.id.quick_machines || (view.getId() == R.id.quick_machines_txt)) {
            setFragment(new MachineFragment());
        } else if (view.getId() == R.id.quick_pesticides || (view.getId() == R.id.quick_pesticides_txt)) {
            setFragment(new PesticidesFragment());
        } else if (view.getId() == R.id.quick_contact || (view.getId() == R.id.quick_contact_txt)) {
            Intent it = new Intent(getContext(), ContactUsActivity.class);
            startActivity(it);
        }
    }

    private void startServiceItemPage() {
        startActivity(new Intent(getContext(), ServicesItemHolderPage.class));
    }
}