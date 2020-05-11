package com.adarsh.farmket.ui;

import android.content.Intent;
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

import com.adarsh.farmket.ContactUsActivity;
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

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private ArrayList<SliderItem> sliderItems = SliderItem.setSliderView(4);
    private SliderView sliderView;

    private RecyclerView vegetableRV, fruitsRV, pulsesRV, seedsRV, machinesRV, pesticidesRV;

    private ArrayList<VegetableItem> vegetableItems = VegetableItem.vegetableItems();
    private ArrayList<FruitItem> fruitItems = FruitItem.fruitItems();
    private ArrayList<PulseItem> pulseItems = PulseItem.getPulses();
    private ArrayList<SeedItem> seedItems = SeedItem.getSeed();
    private ArrayList<MachineItem> machineItems = MachineItem.getMachines();
    private ArrayList<PesticidesItem> pesticidesItems = PesticidesItem.getPesticides();

    private TextView machSeeAll, pectSeeAll, vegSeeAll, fruitSeeAll, pulsesSeeAll, seedsSeeAll;
    private FrameLayout frameLayout;

    //QuickLinks
    private CircleImageView vegy, fruity, cropy, pulsy, seedy, machy, pesty, conty;
    private TextView tvegy, tfruity, tcropy, tpulsy, tseedy, tmachy, tpesty, tconty;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        vegSeeAll = view.findViewById(R.id.vegSeeall);
        fruitSeeAll = view.findViewById(R.id.fruitSeeall);
        pulsesSeeAll = view.findViewById(R.id.pulsesSeeall);
        seedsSeeAll = view.findViewById(R.id.seedSeeAll);
        machSeeAll = view.findViewById(R.id.machSeeall);
        pectSeeAll = view.findViewById(R.id.pestSeeAll);

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
        sliderView = view.findViewById(R.id.imageSlider);
        sliderView.setSliderAdapter(new AdapterSlider(sliderItems));
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);

        //Vegetable Recycler View
        vegetableRV = view.findViewById(R.id.vegetableRV);
        vegetableRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
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
        machinesRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        machinesRV.setAdapter(new AdapterMachine(machineItems));

        //Pesticides Recycler View
        pesticidesRV = view.findViewById(R.id.pesticidesRV);
        pesticidesRV.setLayoutManager(new LinearLayoutManager(getContext(),
                RecyclerView.HORIZONTAL, false));
        pesticidesRV.setAdapter(new AdapterPesticides(pesticidesItems));


        //See All when clicked
        machSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new MachineFragment());
            }
        });
        pectSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new PesticidesFragment());
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
            public void onClick(View view) {
                setFragment(new FruitsFragment());
            }
        });
        pulsesSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new PulsesFragment());
            }
        });
        seedsSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new SeedsFragment());
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
}