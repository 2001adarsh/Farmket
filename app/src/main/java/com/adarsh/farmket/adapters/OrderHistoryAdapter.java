package com.adarsh.farmket.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.farmket.R;
import com.adarsh.farmket.helperClass.OrderHistoryModelClass;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.OrderRV>{
    private ArrayList<OrderHistoryModelClass> orderList;

    public OrderHistoryAdapter(ArrayList<OrderHistoryModelClass> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderRV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.order_history_item, parent, false);
        return new OrderRV(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderRV holder, int position) {
        OrderHistoryModelClass orderItem = orderList.get(position);

        holder.img.setImageResource(orderItem.getImage());
        holder.date.setText(orderItem.getDate());
        holder.name.setText(orderItem.getName());
        holder.price.setText(orderItem.getProductPrice());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class OrderRV extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView price, name, date;
        OrderRV(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.product_img);
            price = (TextView) itemView.findViewById(R.id.product_price);
            name = (TextView) itemView.findViewById(R.id.product_name);
            date = (TextView) itemView.findViewById(R.id.order_date);
        }
    }
}
