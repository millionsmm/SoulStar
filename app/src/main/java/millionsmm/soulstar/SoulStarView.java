package millionsmm.soulstar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by Wilber
 * on 27/10/2017.
 */

public class SoulStarView extends ViewGroup implements Runnable, StarsAdapter.OnDataSetChangeListener {
    private Galaxy galaxy;
    private int mode;

    private int size;
    private float centerX, centerY;
    private float radius;
    private MarginLayoutParams marginLayoutParams;
    private float radiusPercent = 0.9f;

    private float[] argb = {0.8f, 0.8f, 0.8f, 0.8f};

    private Handler handler = new Handler(Looper.getMainLooper());
    private StarsAdapter starsAdapter;
    private OnStarClickListener onStarClickListener;

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
        setFocusableInTouchMode(true);
        galaxy = new Galaxy();
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SoulStarView);
            String mode = typedArray.getString(R.styleable.SoulStarView_scrollMode);
            this.mode = Integer.parseInt(mode);
            typedArray.recycle();
        }
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        int screenWidth = point.x;
        int screenHeight = point.y;
        size = screenHeight < screenWidth ? screenHeight : screenWidth;

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

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        handler.post(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void run() {

    }

    private void initAdapter() {
        this.post(new Runnable() {
            @Override
            public void run() {
                centerX = (getRight() - getLeft()) / 2;
                centerY = (getBottom() - getTop()) / 2;
                radius = Math.min(centerX * radiusPercent, centerY * radiusPercent);
                galaxy.setRadius((int) radius);
                galaxy.setStarARGB(argb);
                galaxy.clear();

                removeAllViews();

                for (int i = 0; i < starsAdapter.getCount(); i++) {
                    Star star = new Star(starsAdapter.getPriority(i));
                    View view = starsAdapter.getView(getContext(), i, SoulStarView.this);
                    star.setView(view);
                    galaxy.add(star);
                }
                galaxy.produce(true);
                //TODO notify
            }
        });
    }

    public void setStarsAdapter(StarsAdapter starsAdapter) {
        this.starsAdapter = starsAdapter;
        starsAdapter.setOnDataSetChangeListener(this);
    }

    @Override
    public void onChanged() {
        initAdapter();
    }

    public interface OnStarClickListener {
        void onItemClick(ViewGroup parent, View view, int position);
    }
}
