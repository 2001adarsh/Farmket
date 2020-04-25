package com.adarsh.farmket.helperClass;

import com.adarsh.farmket.R;

import java.util.ArrayList;

public class PulseItem {
    private int image;
    private String name;

    public PulseItem(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    private static int[] images ={
            R.drawable.urad,
            R.drawable.chanadaal,
            R.drawable.greenmoong,
            R.drawable.kaalachana,
            R.drawable.kidneybeans,
            R.drawable.masoor
            //R.drawable.moongdal,
            //R.drawable.soyabeandaal,
            //R.drawable.whitechana
    };

    private static String[] names = {
            "Urad Daal",
            "Chana Daal",
            "Green Moong",
            "Kaala Chana",
            "Kidney Beans",
            "Masoor"
            //"Moong Daal",
            //"SoyaBean",
            //"White Chana"
    };

    public static ArrayList<PulseItem> getPulses(int n){
        ArrayList<PulseItem> pulseItems = new ArrayList<>();
        for(int i=0; i<n; i++){
            pulseItems.add(new PulseItem(images[i], names[i]));
        }
        return pulseItems;
    }

}
