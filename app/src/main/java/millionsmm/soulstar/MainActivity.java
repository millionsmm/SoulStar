package millionsmm.soulstar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SoulStarView soulStarView;
    private TextStarAdapter textStarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soulStarView = (SoulStarView) findViewById(R.id.galaxy_view);
        textStarAdapter = new TextStarAdapter(new String[20]);

        soulStarView.setStarsAdapter(textStarAdapter);
    }
}
