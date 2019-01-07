package com.alexander.multithreading;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> data;

    public Adapter(List<String> data){
        this.data = data;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.textT.setText(data.get(position));
    }

    public void setData(List<String> data){
        this.data = data;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textT;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textT = itemView.findViewById(R.id.textT);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
