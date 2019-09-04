package com.example.fragmentdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class MyFirstCombineView extends FrameLayout {

    /**
     * 默认会有一个进度条
     */
    MyFirstView firstView;
    private int firstViewLength;
    private boolean isForward = true;//是否正向

    private Map<MyScondView,Double> secondViewMap = new LinkedHashMap<>();

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
        firstViewLength = firstView.getLength();
    }

    public void setFirstViewConfig(int length, int height) {
        firstView.initRecF(length, height);
        invalidate();
        firstViewLength = firstView.getLength();
    }

    public void addSecondView(List<Double> percentList) {
        for(int i = 0 ; i<percentList.size(); i++) {
            FrameLayout.LayoutParams secondParams = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            secondParams.gravity = Gravity.START;
            secondParams.leftMargin = (int) ((firstViewLength - MyScondView.LENGTH / 2) * percentList.get(i));
            MyScondView myScondView = new MyScondView(getContext());
            this.addView(myScondView, secondParams);
            secondViewMap.put(myScondView, percentList.get(i));
        }
        invalidate();
    }


    public void setUP() {
        firstView.startUp();
        setIsLight();
    }

    public void setDown() {
        firstView.startDown();
        setIsLight();
    }

    public void changeDirection(){
        isForward = !isForward;
        firstView.changeDirection();
        setIsLight();
    }

    private void setIsLight() {
        double offset = (double) firstView.getOffset() / MyFirstView.MAX_OFFSET;
        for (Map.Entry<MyScondView, Double> entry : secondViewMap.entrySet()) {
            double percent = entry.getValue();
            if(!isForward) {
                percent = 1 - percent;
            }
            MyScondView eMySecond = entry.getKey();
            if (percent <= offset) {
                eMySecond.setColored();
            } else {
                eMySecond.unSetColored();
            }
        }
    }
}
