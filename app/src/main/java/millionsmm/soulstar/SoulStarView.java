package millionsmm.soulstar;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by Wilber
 * on 27/10/2017.
 */

public class SoulStarView extends ViewGroup{
    public SoulStarView(Context context) {
        super(context);
    }

    public SoulStarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SoulStarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SoulStarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
