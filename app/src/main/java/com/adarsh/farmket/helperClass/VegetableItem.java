package com.adarsh.farmket.helperClass;

import com.adarsh.farmket.R;

import java.util.ArrayList;

public class VegetableItem {
    private int img;
    private String Pname;

    public VegetableItem(int img, String Pname) {
        this.img = img;
        this.Pname = Pname;
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
            R.drawable.onion
    };
    private static String[] names={
            "Tomato",
            "Cabbage",
            "Carrot",
            "Cauliflower",
            "Eggplant",
            "Onion",
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
