package com.adarsh.farmket.helperClass;

import com.adarsh.farmket.R;

import java.util.ArrayList;

public class PesticidesItem {
    private int image;
    private String name;

    public PesticidesItem(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    private static int[] images={
            R.drawable.apple
    };

    private static String[] names = {
            "Apple"
    };

    public static ArrayList<PesticidesItem> getPesticides(){
        ArrayList<PesticidesItem> pesticidesItems = new ArrayList<>();
        for(int i=0; i<names.length; i++){
            pesticidesItems.add(new PesticidesItem(images[i], names[i]));
        }
        return pesticidesItems;
    }
}
