package com.example.listdemo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Item> itemList = new ArrayList<>();
    private List<Integer> isThick = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //RecycleViewActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_recycle_view);
        mRecyclerView = findViewById(R.id.recycle_view1);

        initItem();
        Toast.makeText(RecycleViewActivity.this, "inititem", Toast.LENGTH_LONG).show();
        initRecyclerView();
        Toast.makeText(RecycleViewActivity.this, "initRec", Toast.LENGTH_LONG).show();

    }

    private void initItem() {
//        Item headItem = new Item("head",R.mipmap.ic_launcher,true);
//        itemList.add(headItem);
//        for(int i=1;i<20;i=i+1){
//            Item item=new Item("第"+i+"个数字",R.mipmap.ic_launcher,false);
//            itemList.add(item);
//            //oast.makeText(Main2Activity.this,item.getName()+"",Toast.LENGTH_LONG).show();
//        }
        Item headItem = new Item("head", R.mipmap.ic_launcher, 0, 0, 0, null, null, true);
        itemList.add(headItem);
        isThick.add(1);
        itemList.add(new Item("礼物贡献榜", R.mipmap.liwubang_copy_2x, R.mipmap.head_02x, R.mipmap.head_02x, R.mipmap.head_02x, null, null, false));
        itemList.add(new Item("我的发布", R.mipmap.dontai_2x, "29条动态", null));
        itemList.add(new Item("访客记录", R.mipmap.laiguo_copy2_2x, null, "+10"));
        itemList.add(new Item("观看记录", R.mipmap.watchrecord_copy_2x));
        itemList.add(new Item("邀请好友", R.mipmap.yaoqinghaoyou_2x));
        isThick.add(5);
        itemList.add(new Item("收益", R.mipmap.qianbao_copy_2x, "2映币 · 8.88元红包", null));
        itemList.add(new Item("余额", R.mipmap.zhanghu_2x, "去充值", null));
        itemList.add(new Item("特权", R.mipmap.lv_copy_2x));
        itemList.add(new Item("映任务", R.mipmap.yingrenwu_copy_2x));
        isThick.add(9);
        itemList.add(new Item("实名认证", R.mipmap.shimingrenzhen_copy_2x, null, "已认证"));
        itemList.add(new Item("主播入驻频道", R.mipmap.zhuborenzheng_copy_2x, null, "已认证"));
        isThick.add(11);
        itemList.add(new Item("设置", R.mipmap.shezhi_copy_2x));
        isThick.add(12);

    }

    private void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        //manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(manager);
        MyDividerItemDecoration dividerItemDecoration = new MyDividerItemDecoration(this, manager.getOrientation(), isThick);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.divider_sharp);
        dividerItemDecoration.setDrawable(drawable);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        RecycleItemAdapter adapter = new RecycleItemAdapter(this, itemList);
        mRecyclerView.setAdapter(adapter);
    }

}
