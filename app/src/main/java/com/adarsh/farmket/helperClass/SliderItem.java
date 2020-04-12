package com.adarsh.farmket.helperClass;

import com.adarsh.farmket.R;

import java.util.ArrayList;

public class SliderItem {
    private int img;
    private String desc;

    public SliderItem(int img, String desc) {
        this.img = img;
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public String getDesc() {
        return desc;
    }

    public static int[] images = {
            R.drawable.bannerimg,
            R.drawable.bannerflower,
            R.drawable.bannerservices,
            R.drawable.bannerlife
    };
    public static String[] description = {
            "Farmket, Taking agriculture to new Experience",
            "You will get all kinds of Products",
            "All kinds of Services are there!",
            "Now Life is easy for our farmers"
    };

    public static ArrayList<SliderItem> setSliderView(int n){
        ArrayList<SliderItem> sliderItems = new ArrayList<>();
        for(int i=0; i<n; i++){
            SliderItem sliderItem = new SliderItem(images[i], description[i]);
            sliderItems.add(sliderItem);
        }
        return sliderItems;
    }
}
