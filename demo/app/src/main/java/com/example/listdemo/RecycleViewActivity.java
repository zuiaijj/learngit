package com.example.listdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Item> itemList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        mRecyclerView = findViewById(R.id.recycle_view1);
        initItem();
        Toast.makeText(RecycleViewActivity.this,"inititem",Toast.LENGTH_LONG).show();
        initRecyclerView();
        Toast.makeText(RecycleViewActivity.this,"initRec",Toast.LENGTH_LONG).show();

    }

    private void initItem(){
        for(int i=0;i<20;i=i+1){
            Item item=new Item("第"+i+"个数字",R.mipmap.ic_launcher);
            itemList.add(item);
            //oast.makeText(Main2Activity.this,item.getName()+"",Toast.LENGTH_LONG).show();
        }
    }

    private void initRecyclerView(){
        LinearLayoutManager manager=new LinearLayoutManager(this);
        //manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        RecycleItemAdapter adapter =new RecycleItemAdapter(this,itemList);
        mRecyclerView.setAdapter(adapter);
    }

}
