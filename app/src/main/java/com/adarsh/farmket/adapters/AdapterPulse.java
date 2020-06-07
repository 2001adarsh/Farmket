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
    PulsesOnClickListener pulsesOnClickListener;
    public AdapterPulse(ArrayList<PulseItem> pulseItems, PulsesOnClickListener pulsesOnClickListener) {
        this.pulseItems = pulseItems;
        this.pulsesOnClickListener = pulsesOnClickListener;
    }

    @NonNull
    @Override
    public PulseVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.fruit_item_individual, parent, false);
        return new PulseVH(view, pulsesOnClickListener);
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

    public class PulseVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView names;
        PulsesOnClickListener pulsesOnClickListener;
        public PulseVH(@NonNull View itemView , PulsesOnClickListener pulsesOnClickListener) {
            super(itemView);
            img = itemView.findViewById(R.id.fruit_img);
            names = itemView.findViewById(R.id.fruit_text);
            this.pulsesOnClickListener = pulsesOnClickListener ;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            pulsesOnClickListener.PulsesOnClick(getAdapterPosition());
        }
    }

    public interface PulsesOnClickListener{
        void PulsesOnClick(int position);
    }
}
