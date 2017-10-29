package millionsmm.soulstar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Wilber
 * on 28/10/2017.
 */

public class StarsAdapter {
    private OnDataSetChangeListener onDataSetChangeListener;

    public int getCount() {
        return 0;
    }

    public View getView(Context context, int position, ViewGroup parent) {
        return null;
    }

    public Object getItem(int position) {
        return null;
    }


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
