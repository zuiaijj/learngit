package com.example.recyclerviewdemo2;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Item> mItemData;
    public static final int ITEM_TYPE_IMAGE = 1;
    public static final int ITEM_TYPE_BUTTON = 0;
    public static final int ITEM_TYPE_BIGIMAGE = 2;

    public MyRecyclerViewAdapter(List<Item> ItemData) {
        this.mItemData = ItemData;
    }


    public static class myViewHolder extends RecyclerView.ViewHolder {
        private ImageView item_iv;

        myViewHolder(View imageView) {
            super(imageView);
            item_iv = imageView.findViewById(R.id.item_image_iv);
        }
    }

    public static class myButtonViewHolder extends RecyclerView.ViewHolder {
        //private View itemButtonView;
        myButtonViewHolder(View itemButtonView) {
            super(itemButtonView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 4) {
            return ITEM_TYPE_BUTTON;
        } else if (position == getItemCount() - 1) {
            return ITEM_TYPE_BIGIMAGE;
        } else {
            return ITEM_TYPE_IMAGE;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_IMAGE) {
            View imageView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
            myViewHolder holder = new myViewHolder(imageView);
            return holder;
        } else if (viewType == ITEM_TYPE_BUTTON) {
            View itemButtonView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_button, parent, false);
            myButtonViewHolder holder = new myButtonViewHolder(itemButtonView);
            return holder;
        } else {
            View imageView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
            myViewHolder holder = new myViewHolder(imageView);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof myViewHolder) {
            Item item = mItemData.get(position);
            ((myViewHolder) holder).item_iv.setImageResource(item.getImgId());
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return mItemData.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = ((GridLayoutManager) manager);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int viewType = getItemViewType(position);
                    switch (viewType) {
                        case ITEM_TYPE_IMAGE:
                            return gridLayoutManager.getSpanCount() / 2;
                        case ITEM_TYPE_BIGIMAGE:
                        case ITEM_TYPE_BUTTON:
                            return gridLayoutManager.getSpanCount();
                        default:
                            return gridLayoutManager.getSpanCount() / 2;
                    }
                }
            });

        }
    }
}
