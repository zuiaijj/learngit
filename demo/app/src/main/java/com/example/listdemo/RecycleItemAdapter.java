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
    private List<Item> mItemList;

    public RecycleItemAdapter(Context context,List<Item> itemList){
        this.mContext=context;
        this.mItemList=itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_item,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item =mItemList.get(position);
        holder.mtext.setText(item.getName());
        holder.imageView.setImageResource(item.getImageId());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

      static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mtext;
        private ImageView imageView;

         ViewHolder(View itemView) {
            super(itemView);
            mtext = (TextView) itemView.findViewById(R.id.item_item);
            imageView=(ImageView)itemView.findViewById(R.id.icon_item);
        }
    }


}
