package com.adarsh.farmket.helperClass;

import com.adarsh.farmket.R;

import java.util.ArrayList;

public class AnimalFoodItem {
    private int img;
    private String Pname;

    public AnimalFoodItem(int img, String pname) {
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
            R.drawable.oranges
    };

    private static String[] names = {
            "Apple",
            "Banana",
            "Cherry",
            "Guava",
            "Mango",
            "Oranges"
    };
    public static ArrayList<AnimalFoodItem> getAnimalFood(){
        ArrayList<AnimalFoodItem> wo = new ArrayList<>();
        for(int i=0; i<names.length; i++)
        {
            AnimalFoodItem animalFoodItem = new AnimalFoodItem(images[i], names[i]);
            wo.add(animalFoodItem);
        }
        return wo;
    }

}
