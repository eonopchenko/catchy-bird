package derbyapps.ac.nz.catchybird;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity activity = this;

        /// Create BirdLocationClient
        BirdLocationClient birdLocationClient = new BirdLocationClient(this);

        /// Subscribe on BirdLocationAvailable event
        Fragment frMap = getFragmentManager().findFragmentById(R.id.frMap);
        birdLocationClient.setOnBirdLocationListener((BirdLocationAvailableListener)frMap);
    }
}
