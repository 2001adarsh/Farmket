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

    public AdapterMachine(ArrayList<MachineItem> machineItems) {
        this.machineItems = machineItems;
    }

    @NonNull
    @Override
    public MachineVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.fruit_item_individual, parent, false);
        return new MachineVH(view);
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

    public class MachineVH extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MachineVH(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.fruit_img);
            textView = (TextView) itemView.findViewById(R.id.fruit_text);
        }
    }
}
