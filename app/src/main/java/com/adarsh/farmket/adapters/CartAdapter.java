package com.adarsh.farmket.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.farmket.helperClass.CartModelClass;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter {

    private ArrayList<CartModelClass> cartlist;

    public CartAdapter(ArrayList<CartModelClass> cartlist) {
        this.cartlist = cartlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        switch (cartlist.get(position).getType()){
            case 0:
                return CartModelClass.item;
            case 1:
                return CartModelClass.TotalAmount;
            default:
                return -1;
        }
        //return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class CartItemViewHolder extends RecyclerView.ViewHolder{

        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class CartTotalAmountVH extends RecyclerView.ViewHolder{

        public CartTotalAmountVH(@NonNull View itemView) {
            super(itemView);
        }
    }


}
