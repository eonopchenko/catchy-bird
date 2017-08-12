package derbyapps.ac.nz.catchybird;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BirdLocationClient birdLocationClient = new BirdLocationClient(this);
        birdLocationClient.setOnBirdLocationListener(
                (BirdLocationListener)getFragmentManager().findFragmentById(R.id.first_fragment));
    }
}
