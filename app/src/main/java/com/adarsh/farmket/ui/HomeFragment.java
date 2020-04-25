package com.adarsh.farmket.ui;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.adarsh.farmket.R;
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
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
public class HomeFragment extends Fragment {

    ArrayList<SliderItem> sliderItems = SliderItem.setSliderView(4);
    private SliderView sliderView;

    private RecyclerView vegetableRV, fruitsRV, pulsesRV, seedsRV, machinesRV, pesticidesRV;
    ArrayList<VegetableItem> vegetableItems = VegetableItem.vegetableItems(6);
    ArrayList<FruitItem> fruitItems = FruitItem.fruitItems(6);
    ArrayList<PulseItem> pulseItems = PulseItem.getPulses(6);
    ArrayList<SeedItem> seedItems = SeedItem.getSeed(6);
    ArrayList<MachineItem> machineItems = MachineItem.getMachines(1);
    ArrayList<PesticidesItem> pesticidesItems = PesticidesItem.getPesticides(1);

    TextView machSeeAll, pectSeeAll, vegSeeAll, fruitSeeAll, pulsesSeeAll, seedsSeeAll;
    FrameLayout frameLayout;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_home, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        vegSeeAll = view.findViewById(R.id.vegSeeall);
        fruitSeeAll = view.findViewById(R.id.fruitSeeall);
        pulsesSeeAll = view.findViewById(R.id.pulsesSeeall);
        seedsSeeAll = view.findViewById(R.id.seedSeeAll);
        machSeeAll = view.findViewById(R.id.machSeeall);
        pectSeeAll = view.findViewById(R.id.pestSeeAll);

        frameLayout = getActivity().findViewById(R.id.main_frame);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Image Slider View.
        sliderView = view.findViewById(R.id.imageSlider);
        sliderView.setSliderAdapter(new AdapterSlider(sliderItems));
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);

        //Vegetable Recycler View
        vegetableRV = view.findViewById(R.id.vegetableRV);
        vegetableRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        vegetableRV.setAdapter(new AdapterVegetable(vegetableItems));


        //Fruits Recycler View
        fruitsRV = view.findViewById(R.id.fruitsRV);
        fruitsRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        fruitsRV.setAdapter(new AdapterFruits(fruitItems));

        //Pulses Recycler View
        pulsesRV = view.findViewById(R.id.pulsesRV);
        pulsesRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        pulsesRV.setAdapter(new AdapterPulse(pulseItems, getContext()));

        //Seeds Recycler View
        seedsRV = view.findViewById(R.id.seedsRV);
        seedsRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        seedsRV.setAdapter(new AdapterSeed(seedItems));

        //Machines Recycler View
        machinesRV = view.findViewById(R.id.machinesRV);
        machinesRV.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        machinesRV.setAdapter(new AdapterMachine(machineItems));

        //Pesticides Recycler View
        pesticidesRV = view.findViewById(R.id.pesticidesRV);
        pesticidesRV.setLayoutManager(new LinearLayoutManager(getContext(),
                RecyclerView.HORIZONTAL, false));
        pesticidesRV.setAdapter(new AdapterPesticides(pesticidesItems));


        //See All when clicked
        machSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { setFragment(new MachineFragment());
            }
        });
        pectSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { setFragment(new PesticidesFragment());
            }
        });
        vegSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new VegFragment());
            }
        });
        fruitSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { setFragment(new FruitsFragment());
            }
        });
        pulsesSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {              setFragment(new PulsesFragment());
            }
        });
        seedsSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { setFragment(new SeedsFragment());
            }
        });


    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction ft =getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(frameLayout.getId(), fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
