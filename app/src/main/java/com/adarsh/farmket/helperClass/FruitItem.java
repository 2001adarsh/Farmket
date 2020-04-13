package com.adarsh.farmket.helperClass;

import com.adarsh.farmket.R;

import java.util.ArrayList;

public class FruitItem {
    private int img;
    private String Pname;

    public FruitItem(int img, String pname) {
        this.img = img;
        Pname = pname;
    }

    public int getImg() {
        return img;
    }

    public String getPname() {
        return Pname;
    }

    private static int[] images = {
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.cherry,
            R.drawable.guava,
            R.drawable.mango,
            R.drawable.oranges,
            R.drawable.pineapple,
            R.drawable.fruits
    };

    private static String[] names = {
            "Apple",
            "Banana",
            "Cherry",
            "Guava",
            "Mango",
            "Oranges",
            "Pineapple",
            "See all ->"
    };

    public static ArrayList<FruitItem> fruitItems(int n){
        ArrayList<FruitItem> fi = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            FruitItem fruitItem = new FruitItem(images[i], names[i]);
            fi.add(fruitItem);
        }
        return fi;
    }
}
