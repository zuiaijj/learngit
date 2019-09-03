package com.example.fragmentdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyFirstView extends View {

    private Paint mPaint = new Paint();
    private Paint mPaintTwo = new Paint();

    private static final int LENGTH = 800;
    private static final int HEIGHT = 20;
    /**
     * 进度条的百分比，最大为100
     */
    private int offset = 0;
    private static final int MAX_OFFSET = 100;
    private double percent;


    RectF rect = new RectF(0, 0, LENGTH, HEIGHT);
    RectF rectTwo = new RectF(0, 0, 0, HEIGHT);

    public MyFirstView(Context context) {
        this(context, null);
    }

    public MyFirstView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyFirstView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        intPaint();
    }

    private void intPaint() {
        mPaint.setColor(Color.argb(255, 192, 192, 192));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(1f);

        mPaintTwo.setColor(Color.rgb(255, 225, 0));
        mPaintTwo.setStyle(Paint.Style.FILL);
        mPaintTwo.setStrokeWidth(1f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(rect, 10, 10, mPaint);

        rectTwo.right = (int) (rect.right * percent);
        canvas.drawRoundRect(rectTwo, 10, 10, mPaintTwo);
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
            width = (int) (rect.right - rect.left);
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = (int) (rect.bottom - rect.top);
        }

        setMeasuredDimension(width, height);
    }

    public void startUp() {
        if (offset < MAX_OFFSET) {
            offset = offset + 5;
            percent = (double)offset/MAX_OFFSET;
            invalidate();
        }
    }

    public int getOffset(){
        return offset;
    }

    public void startDown() {
        if (offset > 0) {
            offset = offset - 5;
            percent = (double)offset/MAX_OFFSET;
            invalidate();
        }
    }
}

