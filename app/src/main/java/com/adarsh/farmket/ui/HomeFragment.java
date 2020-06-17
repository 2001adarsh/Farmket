package com.adarsh.farmket.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.adarsh.farmket.ContactUsActivity;
import com.adarsh.farmket.R;
import com.adarsh.farmket.ServicesItemHolderPage;
import com.adarsh.farmket.adapters.AdapterSlider;
import com.adarsh.farmket.helperClass.SliderItem;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private ArrayList<SliderItem> sliderItems = SliderItem.setSliderView(4);

    private FrameLayout frameLayout;

    //QuickLinks
    private CircleImageView vegy, fruity, cropy, seedy, machy, pesty, conty , weather;
    private TextView tvegy, tfruity, tcropy, tseedy, tmachy, tpesty, tconty , tweather;

    //Products
    private CardView vegetableItem, fruitItem, pulsesItem, seedItem, cropsItems, pesticidesItem,animalFoodItem,
                    fertilizersItem;
    //Services
    private CardView workersItem, machineItem, consultancyItem, chainPulleyItem, combineItem,
            electricianItem;

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
        fertilizersItem = view.findViewById(R.id.fertilizer_view);
        animalFoodItem = view.findViewById(R.id.animal_food_view);

        //services
        workersItem = view.findViewById(R.id.worker_view);
        machineItem = view.findViewById(R.id.machines_view);
        consultancyItem = view.findViewById(R.id.consultancy_view);
        chainPulleyItem = view.findViewById(R.id.chainPulley_view);
        combineItem = view.findViewById(R.id.combine_view);
        electricianItem = view.findViewById(R.id.electrician_view);
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

        weather = (CircleImageView) view.findViewById(R.id.quick_weather);
        tweather = (TextView) view.findViewById(R.id.quick_weather_txt);

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
        animalFoodItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new AnimalFoodFragment());
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
        weather.setOnClickListener(this);
        tweather.setOnClickListener(this);
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
        } else if (view.getId() == R.id.quick_weather || (view.getId() == R.id.quick_weather_txt)) {
            setFragment(new WeatherFragment());  //Weather Fragment

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