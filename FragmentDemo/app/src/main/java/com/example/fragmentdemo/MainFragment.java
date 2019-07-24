package com.example.fragmentdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<ListItem> itemList = new ArrayList<>();
    private List<Integer> isThick = new ArrayList<>();
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        mRecyclerView = view.findViewById(R.id.recycle_view1);
        context = view.getContext();
        initItem();
        initRecyclerView();
        return view;
    }

    private void initItem() {

        ListItem headItem = new ListItem("head", R.mipmap.ic_launcher, 0, 0, 0, null, null, true);
        itemList.add(headItem);
        isThick.add(1);
        itemList.add(new ListItem("礼物贡献榜", R.mipmap.liwubang_copy_2x, R.mipmap.head_02x, R.mipmap.head_02x, R.mipmap.head_02x, null, null, false));
        itemList.add(new ListItem("我的发布", R.mipmap.dontai_2x, "29条动态", null));
        itemList.add(new ListItem("访客记录", R.mipmap.laiguo_copy2_2x, null, "+10"));
        itemList.add(new ListItem("观看记录", R.mipmap.watchrecord_copy_2x));
        itemList.add(new ListItem("邀请好友", R.mipmap.yaoqinghaoyou_2x));
        isThick.add(5);
        itemList.add(new ListItem("收益", R.mipmap.qianbao_copy_2x, "2映币 · 8.88元红包", null));
        itemList.add(new ListItem("余额", R.mipmap.zhanghu_2x, "去充值", null));
        itemList.add(new ListItem("特权", R.mipmap.lv_copy_2x));
        itemList.add(new ListItem("映任务", R.mipmap.yingrenwu_copy_2x));
        isThick.add(9);
        itemList.add(new ListItem("实名认证", R.mipmap.shimingrenzhen_copy_2x, null, "已认证"));
        itemList.add(new ListItem("主播入驻频道", R.mipmap.zhuborenzheng_copy_2x, null, "已认证"));
        isThick.add(11);
        itemList.add(new ListItem("设置", R.mipmap.shezhi_copy_2x));
        isThick.add(12);

    }

    private void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        //manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(manager);
        MyDividerItemDecoration dividerItemDecoration = new MyDividerItemDecoration(context, manager.getOrientation(), isThick);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.divider_sharp);
        dividerItemDecoration.setDrawable(drawable);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        RecycleItemAdapter adapter = new RecycleItemAdapter(context, itemList);
        mRecyclerView.setAdapter(adapter);
    }

}
