package com.example.fragmentdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;


public class MyFirstCombineView extends FrameLayout {
    MyFirstView firstView;
    MyScondView scondViewOne;
    MyScondView scondViewTwo;
    private boolean isFirstLight = false;
    private boolean isSecondLight = false;

    public MyFirstCombineView(Context context) {
        this(context, null);
    }

    public MyFirstCombineView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyFirstCombineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_first_combine_view, this);
        firstView = view.findViewById(R.id.first_view);
        scondViewOne = view.findViewById(R.id.second_view_1);
        scondViewTwo = view.findViewById(R.id.second_view_2);
    }

    public void setUP() {
        firstView.startUp();
        setisLight();
        setLight();
    }

    public void setDown() {
        firstView.startDown();
        setisLight();
        setLight();
    }

    private void setLight() {
        if (isFirstLight) {
            scondViewOne.setColored();
        } else {
            scondViewOne.unSetColored();
        }
        if (isSecondLight) {
            scondViewTwo.setColored();
        } else {
            scondViewTwo.unSetColored();
        }
    }

    private void setisLight() {
        int offset = firstView.getOffset();
        if (offset > 24) {
            isFirstLight = true;
            if (offset > 70) {
                isSecondLight = true;
            } else {
                isSecondLight = false;
            }
        } else {
            isFirstLight = false;
        }
    }
}
