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
import com.adarsh.farmket.helperClass.FruitItem;

import java.util.ArrayList;

public class AdapterFruits extends RecyclerView.Adapter<AdapterFruits.FruitsVH> {

    ArrayList<FruitItem> fruitItems;

    public AdapterFruits(ArrayList<FruitItem> fruitItems) {
        this.fruitItems = fruitItems;
    }

    @NonNull
    @Override
    public FruitsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.fruit_item_individual, parent, false);
        return new FruitsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitsVH holder, int position) {
        FruitItem fruitItem = fruitItems.get(position);
        holder.fruitText.setText(fruitItem.getPname());
        holder.fruitimg.setImageResource(fruitItem.getImg());
    }

    @Override
    public int getItemCount() {
        return fruitItems.size();
    }

    public class FruitsVH extends RecyclerView.ViewHolder{

        ImageView fruitimg;
        TextView fruitText;

        public FruitsVH(@NonNull View itemView) {
            super(itemView);
            fruitimg = itemView.findViewById(R.id.fruit_img);
            fruitText = itemView.findViewById(R.id.fruit_text);
        }
    }
}
