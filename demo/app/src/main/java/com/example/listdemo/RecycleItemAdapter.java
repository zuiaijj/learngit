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

public class RecycleItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    private int mHeaderCount = 1;
    private Context mContext;
    private List<Item> itemList;

    public RecycleItemAdapter(Context context, List<Item> itemList) {
        this.mContext = context;
        this.itemList = itemList;
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderCount != 0 && position < mHeaderCount) {
            return ITEM_TYPE_HEADER;
        } else {
            return ITEM_TYPE_CONTENT;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_HEADER) {
            View headView = LayoutInflater.from(mContext).inflate(R.layout.user_item, parent, false);
            headViewHolder holder = new headViewHolder(headView);
            return holder;
        } else if (viewType == ITEM_TYPE_CONTENT) {
            View contentView = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
            contentViewHolder holder = new contentViewHolder(contentView);
            return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = itemList.get(position);
        if (holder instanceof headViewHolder) {

        } else if (holder instanceof contentViewHolder) {
            ((contentViewHolder) holder).itemNameText.setText(item.getName());
            ((contentViewHolder) holder).goldenText.setText(item.getgolden_item_text());
            ((contentViewHolder) holder).sliverText.setText(item.getsliver_item_text());
            ((contentViewHolder) holder).itemImageView.setImageResource(item.getImageId());
            ((contentViewHolder) holder).liWuBangItemImageView1.setImageResource(item.getliwubang_imageId1());
            ((contentViewHolder) holder).liWuBangItemImageView2.setImageResource(item.getliwubang_imageId2());
            ((contentViewHolder) holder).liWuBangItemImageView3.setImageResource(item.getliwubang_imageId3());
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class contentViewHolder extends RecyclerView.ViewHolder {
        private TextView itemNameText;
        private TextView goldenText;
        private TextView sliverText;
        private ImageView itemImageView;
        private ImageView liWuBangItemImageView1;
        private ImageView liWuBangItemImageView2;
        private ImageView liWuBangItemImageView3;

        contentViewHolder(View contentView) {
            super(contentView);
            itemNameText = (TextView) itemView.findViewById(R.id.list_textview);
            goldenText = (TextView) itemView.findViewById(R.id.golden_item_text_tv);
            sliverText = (TextView) itemView.findViewById(R.id.sliver_item_text_tv);
            itemImageView = (ImageView) itemView.findViewById(R.id.list_icon);
            liWuBangItemImageView1 = (ImageView) itemView.findViewById(R.id.liwubang_iv1);
            liWuBangItemImageView2 = (ImageView) itemView.findViewById(R.id.liwubang_iv2);
            liWuBangItemImageView3 = (ImageView) itemView.findViewById(R.id.liwubang_iv3);
        }
    }

    static class headViewHolder extends RecyclerView.ViewHolder {
        headViewHolder(View contentView) {
            super(contentView);
        }
    }


}
