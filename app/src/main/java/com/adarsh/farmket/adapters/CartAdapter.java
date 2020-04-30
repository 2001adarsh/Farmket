package com.adarsh.farmket.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adarsh.farmket.R;
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
        switch (viewType){
            case 0:
                LayoutInflater li =
                        (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewItem = li.inflate(R.layout.cart_item_individual, parent, false);
                return new CartItemViewHolder(viewItem);
            case 1:
                LayoutInflater li2 =
                        (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewTotal = li2.inflate(R.layout.cart_total_amount, parent, false);
                return new CartTotalAmountVH(viewTotal);

                default:
                return null;
        }
}
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (cartlist.get(position).getType()){
            case CartModelClass.item:
                int price = cartlist.get(position).getProductPrice();
                String name = cartlist.get(position).getProductName();
                int qnty = cartlist.get(position).getQuantity();
                int imgresource = cartlist.get(position).getProductImage();
                ((CartItemViewHolder)holder).setItemDetails(imgresource,name, price, qnty);
                break;

            case CartModelClass.TotalAmount:
                int itemPrice = cartlist.get(position).getTotal_item_price();
                int TotalQnty = cartlist.get(position).getNo_of_items();
                int TotalAmount = cartlist.get(position).getTotal_amount();
                int totalDelivery = cartlist.get(position).getDelivery_price();
                ((CartTotalAmountVH)holder).setTotalDetails(itemPrice, TotalAmount, TotalQnty, totalDelivery);
                 break;
            default: return;

        }
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
        return cartlist.size();
    }

    public class CartItemViewHolder extends RecyclerView.ViewHolder{
        ImageView productImage;
        TextView productTitle, productPrice, productQuantity;
        //LinearLayout productRemove;
        private CartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productTitle = itemView.findViewById(R.id.productName_cart);
            productPrice = itemView.findViewById(R.id.item_price_cart);
            productQuantity =  itemView.findViewById(R.id.qty_cart);
           // productRemove = itemView.findViewById(R.id.remove_cart);
        }
        private void setItemDetails(int resource,String title, int price, int qnty ){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            String Itemprice ="Rs. "+ price + "/-";
            productPrice.setText(Itemprice);
            //productQuantity.setText(qnty);
        }
    }

    public class CartTotalAmountVH extends RecyclerView.ViewHolder{
        TextView totalItemPrice, totalqty, totaldelivery, totalAmount;
        private CartTotalAmountVH(@NonNull View itemView) {
            super(itemView);
            totalqty = itemView.findViewById(R.id.Total_qty);
            totalAmount =itemView.findViewById(R.id.total_Budg);
            totaldelivery = itemView.findViewById(R.id.delivery_cart);
            totalItemPrice = itemView. findViewById(R.id.total_item_price);
        }
        private void setTotalDetails(int price, int total, int delivery,int qty){
            String itemprice = "Rs."+ price+ "/-";
            totalItemPrice.setText(itemprice);
            String amount = "Rs." + total + "/-";
            totalAmount.setText(amount);
            String del = "Rs. "+ delivery+"/-";
            totaldelivery.setText(del);
            String qnty = "(Qty:"+qty+ ")";
            totalqty.setText(qnty);
        }
    }


}
