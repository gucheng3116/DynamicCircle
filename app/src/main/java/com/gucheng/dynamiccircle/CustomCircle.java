package com.gucheng.dynamiccircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by suolong on 2018/4/1.
 */

public class CustomCircle extends View {
    private int mWidth;
    private int mHeight;
    private RectF mRectF;
    private int mCurrentProgress = 0;
    private int mMaxProgress = 100;

    public CustomCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(Color.rgb(0x3a, 0x58, 0x5f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);

        mWidth = getWidth();
        mHeight = getHeight();
        mRectF = new RectF();
        setRectFPosition(mRectF);
        canvas.drawArc(mRectF, -90, ((float) mCurrentProgress % mMaxProgress) / mMaxProgress * 360, false, paint);

    }

    private void setRectFPosition(RectF mRectF) {
        mRectF.left = 10; // 左上角x
        mRectF.top = 10; // 左上角y
        mRectF.right = mWidth - 10; // 左下角x
        mRectF.bottom = mWidth - 10; // 右下角y
    }

    public void setProgress(int currentProgress) {
        mCurrentProgress = currentProgress;
        invalidate();
    }


}
