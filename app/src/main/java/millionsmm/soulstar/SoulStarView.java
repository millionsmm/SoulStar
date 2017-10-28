package millionsmm.soulstar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by Wilber
 * on 27/10/2017.
 */

public class SoulStarView extends ViewGroup {
    private Galaxy galaxy;
    private int mode;

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
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
