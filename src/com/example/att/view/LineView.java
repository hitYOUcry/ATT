package com.example.att.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.example.att.R;

public class LineView extends View {

    private final static int NUMS = 3;
    private final static int offset = 30;
    private final static float radius = 5.0f;

    private int mWidth;

    private int mTextSize;
    private int mTextColor;

    private float[] xAixs = new float[NUMS];
    private List<Float> yAxisList;
    private TextPaint mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private Paint mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.LineGraph);
        mTextSize =
                attributes.getDimensionPixelSize(R.styleable.LineGraph_text_size, getResources()
                        .getDimensionPixelSize(R.dimen.linegraph_text_size));
        mTextColor =
                attributes.getColor(R.styleable.LineGraph_text_color,
                        getResources().getColor(R.color.linegraph_text_color));
        yAxisList = new ArrayList<Float>();

        attributes.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initData();
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setTextAlign(Align.CENTER);
        int y = getBottom() - offset;
        canvas.drawLine(getLeft() + offset, y, getRight() - offset, y, mLinePaint);
        for (int i = 0; i < yAxisList.size(); i++) {
            canvas.drawLine(xAixs[i], y, xAixs[i], y - yAxisList.get(i), mLinePaint);
            canvas.drawCircle(xAixs[i], y - yAxisList.get(i), radius, mLinePaint);
            canvas.drawText(String.format("%1$.2fdB", yAxisList.get(i)), xAixs[i],
                    y - yAxisList.get(i) - 3 * radius, mTextPaint);
        }

    }

    public void addLine(float height) {
        if (null != yAxisList) {
            if (yAxisList.size() >= NUMS) {
                yAxisList.remove(0); // remove first;
            }
            yAxisList.add(height);
            invalidate();
        }
    }

    private void initData() {
        mWidth = getWidth();
        for (int i = 0; i < xAixs.length; i++) {
            xAixs[i] = 2 * offset + i * (float) mWidth / NUMS;
        }
    }


}
