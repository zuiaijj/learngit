package com.example.recyclerviewdemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

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
        for (int i = 0; i < 10; i++) {
            itemList.add(new Item(R.mipmap.ic_launcher));
        }
    }

    private void initRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(itemList);
        myRecyclerView.setLayoutManager(gridLayoutManager);
        myRecyclerView.setAdapter(myRecyclerViewAdapter);
    }

}
