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
import com.adarsh.farmket.helperClass.PulseItem;

import java.util.ArrayList;

public class AdapterPulse extends RecyclerView.Adapter<AdapterPulse.PulseVH> {
    ArrayList<PulseItem> pulseItems;
    Context cntx;

    public AdapterPulse(ArrayList<PulseItem> pulseItems, Context cntx) {
        this.pulseItems = pulseItems;
        this.cntx = cntx;
    }

    @NonNull
    @Override
    public PulseVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.fruit_item_individual, parent, false);
        return new PulseVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PulseVH holder, int position) {
        PulseItem pulseItem = pulseItems.get(position);
        holder.img.setImageResource(pulseItem.getImage());
        holder.names.setText(pulseItem.getName());
    }

    @Override
    public int getItemCount() {
        return pulseItems.size();
    }

    public class PulseVH extends RecyclerView.ViewHolder{
        ImageView img;
        TextView names;
        public PulseVH(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.fruit_img);
            names = itemView.findViewById(R.id.fruit_text);
        }
    }
}
