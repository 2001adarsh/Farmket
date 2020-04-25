package com.adarsh.farmket.helperClass;

import com.adarsh.farmket.R;

import java.util.ArrayList;

public class MachineItem {
    private int image;
    private String name;

    public MachineItem(int image, String name) {
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

    public static ArrayList<MachineItem> getMachines(){
        ArrayList<MachineItem> machineItems = new ArrayList<>();
        for(int i=0; i<names.length; i++){
            machineItems.add(new MachineItem(images[i], names[i]));
        }
        return machineItems;
    }
}
