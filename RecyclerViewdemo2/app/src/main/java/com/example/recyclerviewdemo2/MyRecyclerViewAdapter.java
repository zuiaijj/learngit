package com.example.recyclerviewdemo2;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Item> mItemData;
    public static final int ITEM_TYPE_IMAGE = 1;
    public static final int ITEM_TYPE_BUTTON = 0;
    public static final int ITEM_TYPE_BIGIMAGE = 2;
    private OnItemClickListener mOnItemClickListener = null;
    private OnButtonItemClickListener mOnButtonItemClickListener = null;

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    public static interface OnButtonItemClickListener {
        void onButtonItemClick(View view, String buttonName);
    }

    public void setOnButtonItemClickListener(OnButtonItemClickListener listener) {
        this.mOnButtonItemClickListener = listener;
    }

    public MyRecyclerViewAdapter(List<Item> ItemData) {
        this.mItemData = ItemData;
    }


    public static class myViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemIV;

        myViewHolder(View imageView) {
            super(imageView);
            itemIV = imageView.findViewById(R.id.item_image_iv);
        }
    }

    public static class myBigViewHolder extends RecyclerView.ViewHolder {
        private ImageView bigItemIV;

        myBigViewHolder(View imageView) {
            super(imageView);
            bigItemIV = imageView.findViewById(R.id.big_item_image_iv);
        }
    }

    public static class myButtonViewHolder extends RecyclerView.ViewHolder {
        private Button buttonItemBT;

        myButtonViewHolder(View itemButtonView) {
            super(itemButtonView);
            buttonItemBT = itemButtonView.findViewById(R.id.item_button_bt);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Item item = mItemData.get(position);
        return item.getImgType();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_IMAGE) {
            View imageView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
            myViewHolder holder = new myViewHolder(imageView);
            return holder;
        } else if (viewType == ITEM_TYPE_BUTTON) {
            View itemButtonView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_single_buttton, parent, false);
            myButtonViewHolder holder = new myButtonViewHolder(itemButtonView);
            return holder;
        } else {
            View imageView = LayoutInflater.from(parent.getContext()).inflate(R.layout.big_item_image, parent, false);
            myBigViewHolder holder = new myBigViewHolder(imageView);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof myViewHolder) {
            Item item = mItemData.get(position);
            ((myViewHolder) holder).itemIV.setImageResource(item.getImgId());
            if (mOnItemClickListener != null) {
                ((myViewHolder) holder).itemIV.setOnClickListener(new View.OnClickListener() {
                    final int tag = position;

                    @Override
                    public void onClick(View view) {
                        mOnItemClickListener.onItemClick(((myViewHolder) holder).itemIV, tag + 1);
                    }
                });
            }
        } else if (holder instanceof myBigViewHolder) {
            Item item = mItemData.get(position);
            ((myBigViewHolder) holder).bigItemIV.setImageResource(item.getImgId());
            if (mOnItemClickListener != null) {
                ((myBigViewHolder) holder).bigItemIV.setOnClickListener(new View.OnClickListener() {
                    final int tag = position;

                    @Override
                    public void onClick(View view) {
                        mOnItemClickListener.onItemClick(((myBigViewHolder) holder).bigItemIV, tag + 1);
                    }
                });
            }
        } else {
            Item item = mItemData.get(position);
            final String buttonName = item.getButtonName();
            ((myButtonViewHolder) holder).buttonItemBT.setText(item.getButtonName());
            if (mOnButtonItemClickListener != null) {
                ((myButtonViewHolder) holder).buttonItemBT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnButtonItemClickListener.onButtonItemClick(((myButtonViewHolder) holder).buttonItemBT, buttonName);
                    }
                });
            }
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
                            return gridLayoutManager.getSpanCount();
                        case ITEM_TYPE_BUTTON:
                            return gridLayoutManager.getSpanCount() / 5;
                        default:
                            return gridLayoutManager.getSpanCount() / 2;
                    }
                }
            });

        }
    }
}
