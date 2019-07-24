package com.example.fragmentdemo;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyDividerItemDecoration extends DividerItemDecoration {
    private List<Integer> isThick = new ArrayList<>();
    private Context context;

    public MyDividerItemDecoration(Context context, int orientation, List<Integer> isThick) {
        super(context, orientation);
        this.context = context;
        for (int i = 0; i < isThick.size(); i++) {
            this.isThick.add(isThick.get(i));
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if (isThick.contains(position)) {

        } else {
            //outRect.set(0,0,0,80);
        }
    }
}
