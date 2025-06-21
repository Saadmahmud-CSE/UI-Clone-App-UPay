package com.saad.cse.upay;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

public class BalloonIndicatorView extends View {
    private int dotCount;
    private int selectedPosition = 0;
    private int dotColor;
    private int selectedDotColor;
    private float dotRadius;
    private float dotSpacing;
    private float balloonSizeFactor = 1.5f; // How much larger the selected dot should be

    private Paint dotPaint;
    private Paint selectedDotPaint;
    private ViewPager2 viewPager;

    public BalloonIndicatorView(Context context) {
        this(context, null);
    }

    public BalloonIndicatorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BalloonIndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        // Default values
        dotColor = 0x80CCCCCC; // Semi-transparent gray
        selectedDotColor = 0xFF6200EE; // Material Purple 500
        dotRadius = dpToPx(4); // 4dp
        dotSpacing = dpToPx(8); // 8dp

        // Get attributes from XML if available
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BalloonIndicatorView);
            try {
                dotColor = a.getColor(R.styleable.BalloonIndicatorView_dotColor, dotColor);
                selectedDotColor = a.getColor(R.styleable.BalloonIndicatorView_selectedDotColor, selectedDotColor);
                dotRadius = a.getDimension(R.styleable.BalloonIndicatorView_dotRadius, dotRadius);
                dotSpacing = a.getDimension(R.styleable.BalloonIndicatorView_dotSpacing, dotSpacing);
                balloonSizeFactor = a.getFloat(R.styleable.BalloonIndicatorView_balloonSizeFactor, balloonSizeFactor);
            } finally {
                a.recycle();
            }
        }

        // Setup paints
        dotPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        dotPaint.setColor(dotColor);
        dotPaint.setStyle(Paint.Style.FILL);

        selectedDotPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        selectedDotPaint.setColor(selectedDotColor);
        selectedDotPaint.setStyle(Paint.Style.FILL);
    }

    public void setViewPager(ViewPager2 viewPager) {
        this.viewPager = viewPager;
        if (viewPager != null && viewPager.getAdapter() != null) {
            dotCount = viewPager.getAdapter().getItemCount();
            viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageSelected(int position) {
                    selectedPosition = position;
                    invalidate();
                }
            });
            invalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Calculate desired width and height
        float desiredWidth = (dotCount * (dotRadius * 2)) + ((dotCount - 1) * dotSpacing);
        float desiredHeight = dotRadius * 2 * balloonSizeFactor; // Height for the balloon dot

        setMeasuredDimension(
                resolveSize((int) desiredWidth, widthMeasureSpec),
                resolveSize((int) desiredHeight, heightMeasureSpec)
        );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (dotCount <= 0) return;

        float totalWidth = (dotCount * (dotRadius * 2)) + ((dotCount - 1) * dotSpacing);
        float startX = (getWidth() - totalWidth) / 2f;
        float centerY = getHeight() / 2f;

        for (int i = 0; i < dotCount; i++) {
            float centerX = startX + (i * (dotRadius * 2 + dotSpacing)) + dotRadius;

            if (i == selectedPosition) {
                // Draw balloon dot (larger)
                canvas.drawCircle(centerX, centerY, dotRadius * balloonSizeFactor, selectedDotPaint);
            } else {
                // Draw normal dot
                canvas.drawCircle(centerX, centerY, dotRadius, dotPaint);
            }
        }
    }

    // Helper method to convert dp to pixels
    private float dpToPx(float dp) {
        return dp * getResources().getDisplayMetrics().density;
    }

    // Setters for customization
    public void setDotColor(int color) {
        dotPaint.setColor(color);
        invalidate();
    }

    public void setSelectedDotColor(int color) {
        selectedDotPaint.setColor(color);
        invalidate();
    }

    public void setDotRadius(float radius) {
        this.dotRadius = radius;
        invalidate();
    }

    public void setDotSpacing(float spacing) {
        this.dotSpacing = spacing;
        invalidate();
    }

    public void setBalloonSizeFactor(float factor) {
        this.balloonSizeFactor = factor;
        invalidate();
    }
}