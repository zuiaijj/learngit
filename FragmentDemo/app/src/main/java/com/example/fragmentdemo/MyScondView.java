package com.example.fragmentdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyScondView extends View {


    private boolean isColored = false;
    Paint mPain = new Paint();
    RectF rectF = new RectF(0, 0, 20, 40);
    private Paint mPaintTwo = new Paint();

    public MyScondView(Context context) {
        this(context, null);
    }

    public MyScondView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyScondView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        intPain();
    }

    private void intPain() {
        mPain.setColor(Color.argb(255, 192, 192, 192));
        mPain.setStyle(Paint.Style.FILL);
        mPain.setStrokeWidth(1f);

        mPaintTwo.setColor(Color.rgb(225, 215, 0));
        mPaintTwo.setStyle(Paint.Style.FILL);
        mPaintTwo.setStrokeWidth(1f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(rectF, mPain);

        if (isColored) {
            canvas.drawOval(rectF, mPaintTwo);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = (int) (rectF.right - rectF.left);
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = (int) (rectF.bottom - rectF.top);
        }

        setMeasuredDimension(width, height);
    }

    public void setColored() {
        isColored = true;
        invalidate();
    }

    public void unSetColored() {
        isColored = false;
        invalidate();
    }
}
