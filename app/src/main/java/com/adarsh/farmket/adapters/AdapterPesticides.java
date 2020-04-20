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
import com.adarsh.farmket.helperClass.PesticidesItem;

import java.util.ArrayList;

public class AdapterPesticides extends RecyclerView.Adapter<AdapterPesticides.PesticidesVH> {

    ArrayList<PesticidesItem> pesticidesItems;

    public  AdapterPesticides(ArrayList<PesticidesItem> pesticidesItems){
        this.pesticidesItems = pesticidesItems;
    }

    @NonNull
    @Override
    public PesticidesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.fruit_item_individual, parent, false);
        return new PesticidesVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PesticidesVH holder, int position) {
        PesticidesItem pesticidesItem = pesticidesItems.get(position);
        holder.textView.setText(pesticidesItem.getName());
        holder.imageView.setImageResource(pesticidesItem.getImage());
    }

    @Override
    public int getItemCount() {
        return pesticidesItems.size();
    }

    public class PesticidesVH extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public PesticidesVH(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.fruit_img);
            textView = (TextView) itemView.findViewById(R.id.fruit_text);
        }
    }
}
