package millionsmm.soulstar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Wilber
 * on 28/10/2017.
 */

public abstract class StarsAdapter {
    private OnDataSetChangeListener onDataSetChangeListener;

    public abstract int getCount();

    public abstract View getView(Context context, int position, ViewGroup parent);

    public abstract Object getItem(int position);

    public abstract int getPriority(int position);

    public void setOnDataSetChangeListener(OnDataSetChangeListener onDataSetChangeListener) {
        this.onDataSetChangeListener = onDataSetChangeListener;
    }

    public final void notifyDataSetChanged() {
        onDataSetChangeListener.onChanged();
    }

    public interface OnDataSetChangeListener {
        void onChanged();
    }
}
