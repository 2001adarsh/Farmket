package com.adarsh.farmket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.farmket.R;
import com.adarsh.farmket.helperClass.VegetableItem;
import java.util.ArrayList;

public class AdapterVegetable extends RecyclerView.Adapter<AdapterVegetable.vegetableVH> {

    ArrayList<VegetableItem> vegetableItems;

    public AdapterVegetable(ArrayList<VegetableItem> vegetableItems) {
        this.vegetableItems = vegetableItems;
    }

    @NonNull
    @Override
    public vegetableVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= li.inflate(R.layout.fruit_item_individual, parent,false);
        return new vegetableVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull vegetableVH holder, int position) {
        VegetableItem vegetableItem = vegetableItems.get(position);
        holder.textView.setText(vegetableItem.getPname());
        holder.vegImg.setImageResource(vegetableItem.getImg());
    }

    @Override
    public int getItemCount() {
        return vegetableItems.size();
    }

    public class vegetableVH extends RecyclerView.ViewHolder {
        ImageView vegImg;
        TextView textView;
        public vegetableVH(@NonNull View itemView) {
            super(itemView);
            vegImg = itemView.findViewById(R.id.fruit_img);
            textView = itemView.findViewById(R.id.fruit_text);
        }
    }
}
