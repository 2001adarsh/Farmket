package com.adarsh.farmket.helperClass;

import com.adarsh.farmket.R;

import java.util.ArrayList;

public class VegetableItem {
    private int img;
    private String Pname;

    public VegetableItem(int img, String pname) {
        this.img = img;
        Pname = pname;
    }

    public int getImg() {
        return img;
    }

    public String getPname() {
        return Pname;
    }

    private static int[] images={
            R.drawable.tomato,
            R.drawable.cabbage,
            R.drawable.carrot,
            R.drawable.caulifower,
            R.drawable.eggplant,
            R.drawable.onion,
            R.drawable.vegetables
    };
    private static String[] names={
            "Tomato",
            "Cabbage",
            "Carrot",
            "Cauliflower",
            "Eggplant",
            "Onion",
            "See all ->"
    };
    public static ArrayList<VegetableItem> vegetableItems(int n){
        ArrayList<VegetableItem> vg = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            VegetableItem vegetableItem = new VegetableItem(images[i], names[i]);
            vg.add(vegetableItem);
        }
        return vg;
    }
}