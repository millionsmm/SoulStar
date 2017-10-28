package millionsmm.soulstar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Wilber
 * on 27/10/2017.
 */

public class SoulStarView extends ViewGroup {
    private Galaxy galaxy;
    private int mode;

    private int size;

    private MarginLayoutParams marginLayoutParams;

    public SoulStarView(Context context) {
        super(context);
        init(context, null);
    }

    public SoulStarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SoulStarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SoulStarView);
            String mode = typedArray.getString(R.styleable.SoulStarView_scrollMode);
            this.mode = Integer.parseInt(mode);
            typedArray.recycle();
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (marginLayoutParams == null) {
            marginLayoutParams = (MarginLayoutParams) getLayoutParams();
        }

        int dimensionX = measureWidthMode == MeasureSpec.EXACTLY ? width : size - marginLayoutParams.leftMargin - marginLayoutParams.rightMargin;
        int dimensionY = measureHeightMode == MeasureSpec.EXACTLY ? height : size - marginLayoutParams.leftMargin - marginLayoutParams.rightMargin;

        setMeasuredDimension(dimensionX, dimensionY);
        measureChildren(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            Star star = galaxy.getStar(i);
            if (child != null && child.getVisibility() != GONE) {

            }
        }
    }
}
