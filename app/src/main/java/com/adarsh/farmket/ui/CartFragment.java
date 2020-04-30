package com.adarsh.farmket.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adarsh.farmket.R;
import com.adarsh.farmket.adapters.CartAdapter;
import com.adarsh.farmket.helperClass.CartModelClass;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    RecyclerView cartRV;
    ArrayList<CartModelClass> cartlist = new ArrayList<CartModelClass>();
    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_cart, container, false);
        cartRV = view.findViewById(R.id.cartRV);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addList();
        cartRV.setLayoutManager(new LinearLayoutManager(getContext()));
        cartRV.setAdapter(new CartAdapter(cartlist));
    }

    private void addList(){
        cartlist.add(new CartModelClass(0 ,R.drawable.apple, "Apple", 24, 2 ));
        cartlist.add(new CartModelClass(0 ,R.drawable.banana, "Banana", 30, 12 ));
        cartlist.add(new CartModelClass(0 ,R.drawable.oranges, "Oranges", 30, 12 ));
        cartlist.add(new CartModelClass(1,3, 24 , 50, 200));
    }

}
