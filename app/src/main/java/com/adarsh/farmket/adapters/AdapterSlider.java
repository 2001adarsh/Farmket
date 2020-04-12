package com.adarsh.farmket.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adarsh.farmket.R;
import com.adarsh.farmket.helperClass.SliderItem;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class AdapterSlider extends SliderViewAdapter<AdapterSlider.SliderVH> {

    private ArrayList<SliderItem> sliderItems;

    public AdapterSlider(ArrayList<SliderItem> sliderItems) {
        this.sliderItems = sliderItems;
    }

    @Override
    public SliderVH onCreateViewHolder(ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.slider_image,parent,false);
        return new SliderVH(view);
    }

    @Override
    public void onBindViewHolder(SliderVH viewHolder, int position) {
        SliderItem sliderItem = sliderItems.get(position);
        viewHolder.img.setImageResource(sliderItem.getImg());
        viewHolder.textView.setText(sliderItem.getDesc());
        if(position == 3){
            viewHolder.textView.setTextColor(Color.WHITE);
        }
    }

    @Override
    public int getCount() {
        return sliderItems.size();
    }

    class SliderVH extends SliderViewAdapter.ViewHolder{

        ImageView img;
        TextView textView;

        public SliderVH(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.imgbanner);
            textView = (TextView) itemView.findViewById(R.id.txtbanner);
        }
    }
}
