package com.example.recyclerviewdemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.recyclerviewdemo2.MyRecyclerViewAdapter.ITEM_TYPE_BIGIMAGE;
import static com.example.recyclerviewdemo2.MyRecyclerViewAdapter.ITEM_TYPE_BUTTON;
import static com.example.recyclerviewdemo2.MyRecyclerViewAdapter.ITEM_TYPE_IMAGE;

public class MainActivity extends AppCompatActivity {
    private List<Item> itemList = new ArrayList<>();
    private RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecyclerView = findViewById(R.id.recycle_view);
        initItem();
        initRecyclerView();
    }

    private void initItem() {
        itemList.add(new Item(R.mipmap.drawable_land_xhdpi_screen, ITEM_TYPE_IMAGE));
        itemList.add(new Item(R.mipmap.drawable_land_xhdpi_screen_1, ITEM_TYPE_IMAGE));
        itemList.add(new Item(R.mipmap.drawable_land_xhdpi_screen, ITEM_TYPE_IMAGE));
        itemList.add(new Item(R.mipmap.drawable_land_xhdpi_screen_1, ITEM_TYPE_IMAGE));
        itemList.add(new Item("音乐", ITEM_TYPE_BUTTON));
        itemList.add(new Item("舞蹈", ITEM_TYPE_BUTTON));
        itemList.add(new Item("电台", ITEM_TYPE_BUTTON));
        itemList.add(new Item("脱口秀", ITEM_TYPE_BUTTON));
        itemList.add(new Item("交友", ITEM_TYPE_BUTTON));
        itemList.add(new Item("nans", ITEM_TYPE_BUTTON));
        itemList.add(new Item("校园", ITEM_TYPE_BUTTON));
        itemList.add(new Item("户外", ITEM_TYPE_BUTTON));
        itemList.add(new Item("换装", ITEM_TYPE_BUTTON));
        itemList.add(new Item("更多", ITEM_TYPE_BUTTON));
        itemList.add(new Item(R.mipmap.bilibili, ITEM_TYPE_BIGIMAGE));
        itemList.add(new Item(R.mipmap.drawable_land_xhdpi_screen, ITEM_TYPE_IMAGE));
        itemList.add(new Item(R.mipmap.drawable_land_xhdpi_screen_1, ITEM_TYPE_IMAGE));
        itemList.add(new Item(R.mipmap.drawable_land_xhdpi_screen, ITEM_TYPE_IMAGE));
        itemList.add(new Item(R.mipmap.drawable_land_xhdpi_screen_1, ITEM_TYPE_IMAGE));
        itemList.add(new Item(R.mipmap.drawable_land_xhdpi_screen, ITEM_TYPE_IMAGE));
        itemList.add(new Item(R.mipmap.drawable_land_xhdpi_screen_1, ITEM_TYPE_IMAGE));
        itemList.add(new Item(R.mipmap.drawable_land_xhdpi_screen, ITEM_TYPE_IMAGE));
        itemList.add(new Item(R.mipmap.drawable_land_xhdpi_screen_1, ITEM_TYPE_IMAGE));
    }

    private void initRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 10);
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(itemList);
        myRecyclerView.addItemDecoration(new SpaceItemDecoration(10));
        myRecyclerView.setLayoutManager(gridLayoutManager);
        myRecyclerView.setAdapter(myRecyclerViewAdapter);
        myRecyclerViewAdapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "刚刚点击了第" + position + "个Item", Toast.LENGTH_SHORT).show();
            }
        });
        myRecyclerViewAdapter.setOnButtonItemClickListener(new MyRecyclerViewAdapter.OnButtonItemClickListener() {
            @Override
            public void onButtonItemClick(View view, String buttonName) {
                Toast.makeText(MainActivity.this, "刚刚点击了button" + buttonName, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
