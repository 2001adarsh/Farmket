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
import com.adarsh.farmket.helperClass.ConsultancyItem;

import java.util.ArrayList;

public class AdapterConsultancy  extends RecyclerView.Adapter<AdapterConsultancy.ConsultancyVH>{

    ArrayList<ConsultancyItem> consultancyItems;
    ConsultancyOnClickListener consultancyOnClickListener;

    public AdapterConsultancy(ArrayList<ConsultancyItem> consultancyItems, ConsultancyOnClickListener consultancyOnClickListener) {
        this.consultancyItems = consultancyItems;
        this.consultancyOnClickListener = consultancyOnClickListener;
    }

    @NonNull
    @Override
    public ConsultancyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li =
                (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.fruit_item_individual, parent, false);
        return new ConsultancyVH(view, consultancyOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsultancyVH holder, int position) {
        ConsultancyItem consultancyItem = consultancyItems.get(position);
        holder.textView.setText(consultancyItem.getPname());
        holder.imageView.setImageResource(consultancyItem.getImg());
    }

    @Override
    public int getItemCount() {
        return consultancyItems.size();
    }

    public class ConsultancyVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        ConsultancyOnClickListener consultancyOnClickListener;
        public ConsultancyVH(@NonNull View itemView, ConsultancyOnClickListener consultancyOnClickListener) {
            super(itemView);
            this.consultancyOnClickListener = consultancyOnClickListener;
            imageView = (ImageView) itemView.findViewById(R.id.fruit_img);
            textView = (TextView) itemView.findViewById(R.id.fruit_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            consultancyOnClickListener.ConsultancyOnClick(getAdapterPosition());
        }
    }
    public interface ConsultancyOnClickListener{
        void ConsultancyOnClick(int position);
    }
}
