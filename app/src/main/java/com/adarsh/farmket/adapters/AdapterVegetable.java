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
    VegetableOnClickListener vegetableOnClickListener;

    public AdapterVegetable(ArrayList<VegetableItem> vegetableItems, VegetableOnClickListener vegetableOnClickListener) {
        this.vegetableItems = vegetableItems;
        this.vegetableOnClickListener = vegetableOnClickListener;
    }

    @NonNull
    @Override
    public vegetableVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= li.inflate(R.layout.fruit_item_individual, parent,false);
        return new vegetableVH(view, vegetableOnClickListener);
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

    public class vegetableVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView vegImg;
        TextView textView;
        VegetableOnClickListener vegOnClickListener;
        public vegetableVH(@NonNull View itemView, VegetableOnClickListener vegOnClickListener) {
            super(itemView);
            vegImg = itemView.findViewById(R.id.fruit_img);
            textView = itemView.findViewById(R.id.fruit_text);
            this.vegOnClickListener = vegOnClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            vegOnClickListener.onVegClick(getAdapterPosition());
        }
    }

    public interface VegetableOnClickListener {
        void onVegClick(int position);
    }
}
