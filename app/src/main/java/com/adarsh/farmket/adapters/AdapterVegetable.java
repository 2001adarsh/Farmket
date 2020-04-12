package com.adarsh.farmket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.farmket.R;
import com.adarsh.farmket.helperClass.VegetableItem;
import java.util.ArrayList;

public class AdapterVegetable extends RecyclerView.Adapter<AdapterVegetable.vegetableVH> {

    ArrayList<VegetableItem> vegetableItems = new ArrayList<>();

    public AdapterVegetable(ArrayList<VegetableItem> vegetableItems) {
        this.vegetableItems = vegetableItems;
    }

    @NonNull
    @Override
    public vegetableVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull vegetableVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return vegetableItems.size();
    }

    public class vegetableVH extends RecyclerView.ViewHolder {
        public vegetableVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
