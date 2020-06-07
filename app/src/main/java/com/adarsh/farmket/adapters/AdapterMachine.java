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
import com.adarsh.farmket.helperClass.MachineItem;

import java.util.ArrayList;

import javax.crypto.Mac;

public class AdapterMachine extends RecyclerView.Adapter<AdapterMachine.MachineVH> {
    ArrayList<MachineItem> machineItems;
    MachineOnClickListener machineOnClickListener;
    public AdapterMachine(ArrayList<MachineItem> machineItems, MachineOnClickListener machineOnClickListener) {
        this.machineItems = machineItems;
        this.machineOnClickListener = machineOnClickListener;
    }

    @NonNull
    @Override
    public MachineVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.fruit_item_individual, parent, false);
        return new MachineVH(view, machineOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MachineVH holder, int position) {
        MachineItem machineItem = machineItems.get(position);
        holder.textView.setText(machineItem.getName());
        holder.imageView.setImageResource(machineItem.getImage());
    }

    @Override
    public int getItemCount() {
        return machineItems.size();
    }

    public class MachineVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        MachineOnClickListener machineOnClickListener;
        public MachineVH(@NonNull View itemView, MachineOnClickListener machineOnClickListener) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.fruit_img);
            textView = (TextView) itemView.findViewById(R.id.fruit_text);
            this.machineOnClickListener = machineOnClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            machineOnClickListener.MachineOnClick(getAdapterPosition());
        }
    }

    public interface MachineOnClickListener{
        void MachineOnClick(int position);
    }
}
