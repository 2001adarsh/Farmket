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
import com.adarsh.farmket.helperClass.AnimalFoodItem;

import java.util.ArrayList;

public class AdapterAnimalFood extends RecyclerView.Adapter<AdapterAnimalFood.AnimalFoodVH> {

    ArrayList<AnimalFoodItem> animalFoodItems;
    AnimalFoodOnClickListener animalFoodOnClickListener;

    public AdapterAnimalFood(ArrayList<AnimalFoodItem> animalFoodItems, AnimalFoodOnClickListener animalFoodOnClickListener) {
        this.animalFoodItems = animalFoodItems;
        this.animalFoodOnClickListener = animalFoodOnClickListener;
    }

    @NonNull
    @Override
    public AnimalFoodVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.fruit_item_individual, parent, false);
        return new AnimalFoodVH(view,animalFoodOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalFoodVH holder, int position) {
        AnimalFoodItem animalFoodItem = animalFoodItems.get(position);
        holder.textView.setText(animalFoodItem.getPname());
        holder.imageView.setImageResource(animalFoodItem.getImg());
    }

    @Override
    public int getItemCount() {
        return animalFoodItems.size();
    }

    public class AnimalFoodVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        AnimalFoodOnClickListener animalFoodOnClickListener;
        ImageView imageView;
        TextView textView;

        public AnimalFoodVH(@NonNull View itemView, AnimalFoodOnClickListener animalFoodOnClickListener) {
            super(itemView);
            this.animalFoodOnClickListener = animalFoodOnClickListener;
            imageView = (ImageView) itemView.findViewById(R.id.fruit_img);
            textView = (TextView) itemView.findViewById(R.id.fruit_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            animalFoodOnClickListener.AnimalFoodOnClick(getAdapterPosition());
        }
    }
    public interface AnimalFoodOnClickListener{
        void AnimalFoodOnClick(int position);
    }
}
