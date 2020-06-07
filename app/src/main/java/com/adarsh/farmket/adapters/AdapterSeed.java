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
import com.adarsh.farmket.helperClass.SeedItem;

import java.util.ArrayList;

public class AdapterSeed extends RecyclerView.Adapter<AdapterSeed.SeedRV> {
    ArrayList<SeedItem> seedItems;
    SeedOnClickListener seedOnClickListener;
    public AdapterSeed(ArrayList<SeedItem> seedItems, SeedOnClickListener seedOnClickListener) {
        this.seedItems = seedItems;
        this.seedOnClickListener = seedOnClickListener;
    }

    @NonNull
    @Override
    public SeedRV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.fruit_item_individual, parent, false);
        return new SeedRV(view, seedOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SeedRV holder, int position) {
        SeedItem seedItem = seedItems.get(position);
        holder.image.setImageResource(seedItem.getImage());
        holder.text.setText(seedItem.getName());
    }

    @Override
    public int getItemCount() {
        return seedItems.size();
    }

    public class SeedRV extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView text;
        SeedOnClickListener seedOnClickListener;
        public SeedRV(@NonNull View itemView , SeedOnClickListener seedOnClickListener) {
            super(itemView);
            image = itemView.findViewById(R.id.fruit_img);
            text = itemView.findViewById(R.id.fruit_text);
            this.seedOnClickListener = seedOnClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            seedOnClickListener.onSeedClick(getAdapterPosition());
        }
    }

    public interface SeedOnClickListener{
        void onSeedClick(int position);
    }
}
