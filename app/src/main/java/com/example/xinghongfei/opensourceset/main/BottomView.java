package com.example.xinghongfei.opensourceset.main;

/**
 * Created by xinghongfei on 16/7/18.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.xinghongfei.opensourceset.R;


/**
 * Created by xinghongfei on 15/12/22.
 */
public class BottomView extends View {
    public static final String BUNDLE = "a";
    public static final String MYBUNDLE = "b";
    Rect textRect = new Rect();
    Paint textPaint = new Paint();
    float myalpha;
    Paint paintcava;
    Rect iconRect;
    int iconWitch;
    private int textSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics());
    private String string;
    private int color = 0x12121212;
    private Bitmap icon = null;
    private Bitmap myBitmap;
    private Canvas myCanvas;


    public BottomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BottomView);

        int n = typedArray.getIndexCount();
        for (int i = 0; i < n; i++) {
            int a = typedArray.getIndex(i);
            switch (a) {
                case R.styleable.BottomView_text:
                    string = typedArray.getString(a);
                    break;
                case R.styleable.BottomView_textSize:

                    textSize = (int) typedArray.getDimension(a, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.BottomView_icon:
                    BitmapDrawable drawable = (BitmapDrawable) typedArray.getDrawable(a);
                    icon = drawable.getBitmap();
                    break;

                case R.styleable.BottomView_textColor:
                    color = typedArray.getColor(a, 0x111111);
                    break;


            }


        }
        typedArray.recycle();
        textPaint.setTextSize(textSize);
        textPaint.setColor(color);
        textPaint.getTextBounds(string, 0, string.length(), textRect);


    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            bundle.get(BUNDLE);
            myalpha = bundle.getFloat(MYBUNDLE);
            super.onRestoreInstanceState((Parcelable) bundle.get(BUNDLE));
        }


    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE, super.onSaveInstanceState());
        bundle.putFloat(MYBUNDLE, myalpha);


        return bundle;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int height = getMeasuredHeight();
        int textHeight = textRect.height();
        int wight = getMeasuredWidth();
        int a = height - getPaddingTop() - getPaddingBottom() - textHeight;
        int b = wight - getPaddingLeft() - getPaddingRight();

        iconWitch = Math.min(a, b);
        int left = getMeasuredWidth() / 2 - iconWitch / 2;
        int top = (getMeasuredHeight() - iconWitch - textRect.height()) / 2;

        iconRect = new Rect(left, top, left + iconWitch, top + iconWitch);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(icon, null, iconRect, null);


        int alpha = (int) Math.ceil(255 * myalpha);


        drawTextSource(canvas, alpha);
        drawTextTarge(canvas, alpha);

        drawMybitmap(alpha);

        canvas.drawBitmap(myBitmap, 0, 0, null);

    }

    private void drawTextTarge(Canvas canvas, int alpha) {
        textPaint.setColor(color);
        textPaint.setAlpha(alpha);
        canvas.drawText(string, getMeasuredWidth() / 2 - textRect.width() / 2, iconRect.bottom + textRect.height() - 5, textPaint);

    }

    private void drawTextSource(Canvas canvas, int alpha) {

        textPaint.setColor(0xff333333);

        textPaint.setAlpha(255 - alpha);

        canvas.drawText(string, getMeasuredWidth() / 2 - textRect.width() / 2, iconRect.bottom + textRect.height() - 5, textPaint);

    }

    private void drawMybitmap(int alpha) {
        myBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        myCanvas = new Canvas(myBitmap);
        paintcava = new Paint();
        paintcava.setColor(color);
        paintcava.setAntiAlias(true);
        paintcava.setDither(true);
        paintcava.setAlpha(alpha);
        myCanvas.drawRect(iconRect, paintcava);
        paintcava.setAlpha(255);
        paintcava.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        myCanvas.drawBitmap(icon, null, iconRect, paintcava);


    }

    public void setSomethingAlpha(float alpha) {
        this.myalpha = alpha;
        invalidateVeiw();
    }

    private void invalidateVeiw() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }


}
