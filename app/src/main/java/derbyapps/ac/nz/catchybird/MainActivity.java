package derbyapps.ac.nz.catchybird;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BirdLocationClient birdLocationClient = new BirdLocationClient(this);
        birdLocationClient.setOnBirdLocationListener(
                (BirdLocationListener)getFragmentManager().findFragmentById(R.id.first_fragment));
        SlidingUpPanelLayout slider = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
    }
}
