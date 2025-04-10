package com.example.daltonrose_cs360;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WeightRecyclerView extends RecyclerView.Adapter<WeightRecyclerView.RecyclerViewHolder>{

    Context context;
    ArrayList<WeightModel> weightModels;

    public WeightRecyclerView(Context context, ArrayList<WeightModel> weightModels) {
        this.context = context;
        this.weightModels = weightModels;
    }

    @NonNull
    @Override
    public WeightRecyclerView.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new WeightRecyclerView.RecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull WeightRecyclerView.RecyclerViewHolder holder, int position) {
        holder.textViewWeight.setText(weightModels.get(position).getWeight());
    }

    @Override
    public int getItemCount() {
        return weightModels.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewWeight;
        TextView textViewDate;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView2);
            textViewWeight = itemView.findViewById(R.id.textView4);
            textViewDate = itemView.findViewById(R.id.textView5);


        }
    }

}
