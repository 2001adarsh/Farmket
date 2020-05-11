package com.adarsh.farmket.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adarsh.farmket.R;
import com.adarsh.farmket.adapters.OrderHistoryAdapter;
import com.adarsh.farmket.helperClass.OrderHistoryModelClass;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class OrderHistoryFragment extends Fragment {

    public OrderHistoryFragment() { }

    private ArrayList<OrderHistoryModelClass> orderList = new ArrayList<>();
    private RecyclerView orderHistoryRV;
    private TextView orderCount;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_order_history, container, false);
        addValues();
        orderHistoryRV = (RecyclerView) view.findViewById(R.id.order_history_rv);
        orderCount = (TextView) view.findViewById(R.id.orders_count);
        return view;
    }
    private void addValues(){
        orderList.add(new OrderHistoryModelClass(R.drawable.fruits, "Apples, Stawberry and more",
                "Rs. 263", "• Delivered on: 2nd May 2020"));
        orderList.add(new OrderHistoryModelClass(R.drawable.vegetables, "Tomato, onion and more",
                "Rs. 135", "• Delivered on: 11th May 2020"));
        orderList.add(new OrderHistoryModelClass(R.drawable.vegetables, "Tomato, onion and more",
                "Rs. 135", "• Delivered on: 11th May 2020"));
        orderList.add(new OrderHistoryModelClass(R.drawable.vegetables, "Tomato, onion and more",
                "Rs. 135", "• Delivered on: 11th May 2020"));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        orderHistoryRV.setLayoutManager(new LinearLayoutManager(getContext()));
        orderHistoryRV.setAdapter(new OrderHistoryAdapter(orderList));

        String orderSize = orderList.size() + " orders.";
        orderCount.setText(orderSize);
    }
}
