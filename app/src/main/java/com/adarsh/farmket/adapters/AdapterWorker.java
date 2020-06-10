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
import com.adarsh.farmket.helperClass.WorkerItem;

import java.util.ArrayList;

public class AdapterWorker extends RecyclerView.Adapter<AdapterWorker.WorkerVH> {
    ArrayList<WorkerItem> workerItems;
    WorkerOnClickListener workerOnClickListener;

    public AdapterWorker(ArrayList<WorkerItem> workerItems, WorkerOnClickListener workerOnClickListener) {
        this.workerItems = workerItems;
        this.workerOnClickListener = workerOnClickListener;
    }

    @NonNull
    @Override
    public WorkerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li =
                (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.fruit_item_individual, parent, false);
        return new WorkerVH(view, workerOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkerVH holder, int position) {
        WorkerItem workerItem = workerItems.get(position);
        holder.textView.setText(workerItem.getPname());
        holder.imageView.setImageResource(workerItem.getImg());
    }

    @Override
    public int getItemCount() {
        return workerItems.size();
    }


    public class WorkerVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        WorkerOnClickListener workerOnClickListener;

        public WorkerVH(@NonNull View itemView, WorkerOnClickListener workerOnClickListener) {
            super(itemView);
            this.workerOnClickListener = workerOnClickListener;
            imageView = itemView.findViewById(R.id.fruit_img);
            textView = itemView.findViewById(R.id.fruit_text);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            workerOnClickListener.WorkerOnClick(getAdapterPosition());
        }
    }

    public interface WorkerOnClickListener{
        void WorkerOnClick(int position);
    }
}
