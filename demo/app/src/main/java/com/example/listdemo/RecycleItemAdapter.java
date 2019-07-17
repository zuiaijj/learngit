package com.example.listdemo;

//import androidx.appcompat.app.AlertController;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public  class RecycleItemAdapter extends RecyclerView.Adapter<RecycleItemAdapter.ViewHolder> {
    private Context mContext;
    private List<Item> itemList;

    public RecycleItemAdapter(Context context,List<Item> itemList){
        this.mContext=context;
        this.itemList=itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(mContext).inflate(R.layout.item,parent,false);
        ViewHolder holder= new ViewHolder(itemView);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item =itemList.get(position);
        holder.itemText.setText(item.getName());
        holder.itemImageView.setImageResource(item.getImageId());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

      static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView itemText;
        private ImageView itemImageView;

         ViewHolder(View itemView) {
            super(itemView);
            itemText = (TextView) itemView.findViewById(R.id.list_textview);
            itemImageView=(ImageView)itemView.findViewById(R.id.list_icon);
        }
    }


}
