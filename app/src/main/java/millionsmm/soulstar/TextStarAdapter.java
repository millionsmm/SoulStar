package millionsmm.soulstar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Wilber
 * on 31/10/2017.
 */

public class TextStarAdapter extends StarsAdapter {

    private List<String> dataSet = new ArrayList<>();

    public TextStarAdapter(@NonNull String... data) {
        dataSet.clear();
        Collections.addAll(dataSet, data);

    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public View getView(final Context context, int position, ViewGroup parent) {
        TextView textView = new TextView(context);
        textView.setText("No." + position);
        textView.setGravity(Gravity.CENTER);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
            }
        });
        return null;
    }

    @Override
    public Object getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public int getPriority(int position) {
        return position % 7;
    }
}
