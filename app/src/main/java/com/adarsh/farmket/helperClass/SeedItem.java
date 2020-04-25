package com.adarsh.farmket.helperClass;

import com.adarsh.farmket.R;

import java.util.ArrayList;

public class SeedItem {
    private int image;
    private String name;

    public SeedItem(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    private static int[] images = {
            R.drawable.cotton,
            R.drawable.corn,
            R.drawable.jowar,
            R.drawable.mustard,
            R.drawable.peanuts,
            R.drawable.rice
            //R.drawable.sugarcane,
            //R.drawable.tea,
            //R.drawable.wheat
    };

    private static String[] names ={
            "Cotton",
            "Corn",
            "Jowar",
            "Mustard",
            "Peanuts",
            "Rice",
            //"Sugarcane",
            //"Tea",
            //"Wheat"
    };

    public static ArrayList<SeedItem> getSeed(int n){
        ArrayList<SeedItem> seedItems = new ArrayList<>();
        for(int i=0; i<n; i++){
            SeedItem seedItem = new SeedItem(images[i], names[i]);
            seedItems.add(seedItem);
        }
        return seedItems;
    }
}

