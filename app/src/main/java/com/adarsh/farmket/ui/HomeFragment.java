package com.adarsh.farmket.ui;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adarsh.farmket.R;
import com.adarsh.farmket.adapters.AdapterFruits;
import com.adarsh.farmket.adapters.AdapterSlider;
import com.adarsh.farmket.adapters.AdapterVegetable;
import com.adarsh.farmket.helperClass.FruitItem;
import com.adarsh.farmket.helperClass.SliderItem;
import com.adarsh.farmket.helperClass.VegetableItem;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
public class HomeFragment extends Fragment {

    ArrayList<SliderItem> sliderItems = SliderItem.setSliderView(4);
    private SliderView sliderView;

    private RecyclerView vegetableRV, fruitsRV;
    ArrayList<VegetableItem> vegetableItems = VegetableItem.vegetableItems(7);
    ArrayList<FruitItem> fruitItems = FruitItem.fruitItems(8);


    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_home, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
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

    }
}
