package com.example.fragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.example.fragmentdemo.MyRecyclerViewAdapter.ITEM_TYPE_BIGIMAGE;
import static com.example.fragmentdemo.MyRecyclerViewAdapter.ITEM_TYPE_BUTTON;
import static com.example.fragmentdemo.MyRecyclerViewAdapter.ITEM_TYPE_IMAGE;

public class RoundFragment extends Fragment {
    private List<ImageItem> itemList = new ArrayList<>();
    private RecyclerView myImageRecyclerView;
    private Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.round_fragment, container, false);
        myImageRecyclerView = view.findViewById(R.id.recycle_view);
        context=view.getContext();
        initItem();
        initRecyclerView();
        return view;
    }

    private void initItem() {
        itemList.add(new ImageItem(R.mipmap.drawable_land_xhdpi_screen, ITEM_TYPE_IMAGE));
        itemList.add(new ImageItem(R.mipmap.drawable_land_xhdpi_screen_1, ITEM_TYPE_IMAGE));
        itemList.add(new ImageItem(R.mipmap.drawable_land_xhdpi_screen, ITEM_TYPE_IMAGE));
        itemList.add(new ImageItem(R.mipmap.drawable_land_xhdpi_screen_1, ITEM_TYPE_IMAGE));
        itemList.add(new ImageItem("音乐", ITEM_TYPE_BUTTON));
        itemList.add(new ImageItem("舞蹈", ITEM_TYPE_BUTTON));
        itemList.add(new ImageItem("电台", ITEM_TYPE_BUTTON));
        itemList.add(new ImageItem("脱口秀", ITEM_TYPE_BUTTON));
        itemList.add(new ImageItem("交友", ITEM_TYPE_BUTTON));
        itemList.add(new ImageItem("nans", ITEM_TYPE_BUTTON));
        itemList.add(new ImageItem("校园", ITEM_TYPE_BUTTON));
        itemList.add(new ImageItem("户外", ITEM_TYPE_BUTTON));
        itemList.add(new ImageItem("换装", ITEM_TYPE_BUTTON));
        itemList.add(new ImageItem("更多", ITEM_TYPE_BUTTON));
        itemList.add(new ImageItem(R.mipmap.bilibili, ITEM_TYPE_BIGIMAGE));
        itemList.add(new ImageItem(R.mipmap.drawable_land_xhdpi_screen, ITEM_TYPE_IMAGE));
        itemList.add(new ImageItem(R.mipmap.drawable_land_xhdpi_screen_1, ITEM_TYPE_IMAGE));
        itemList.add(new ImageItem(R.mipmap.drawable_land_xhdpi_screen, ITEM_TYPE_IMAGE));
        itemList.add(new ImageItem(R.mipmap.drawable_land_xhdpi_screen_1, ITEM_TYPE_IMAGE));
        itemList.add(new ImageItem(R.mipmap.drawable_land_xhdpi_screen, ITEM_TYPE_IMAGE));
        itemList.add(new ImageItem(R.mipmap.drawable_land_xhdpi_screen_1, ITEM_TYPE_IMAGE));
        itemList.add(new ImageItem(R.mipmap.drawable_land_xhdpi_screen, ITEM_TYPE_IMAGE));
        itemList.add(new ImageItem(R.mipmap.drawable_land_xhdpi_screen_1, ITEM_TYPE_IMAGE));
    }

    private void initRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 10);
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(itemList);
        myImageRecyclerView.addItemDecoration(new SpaceItemDecoration(10));
        myImageRecyclerView.setLayoutManager(gridLayoutManager);
        myImageRecyclerView.setAdapter(myRecyclerViewAdapter);
        myRecyclerViewAdapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context, "刚刚点击了第" + position + "个Item", Toast.LENGTH_SHORT).show();
            }
        });
        myRecyclerViewAdapter.setOnButtonItemClickListener(new MyRecyclerViewAdapter.OnButtonItemClickListener() {
            @Override
            public void onButtonItemClick(View view, String buttonName) {
                Toast.makeText(context, "刚刚点击了button" + buttonName, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
