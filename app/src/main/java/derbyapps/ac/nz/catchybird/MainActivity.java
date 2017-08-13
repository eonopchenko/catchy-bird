package derbyapps.ac.nz.catchybird;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<BirdLocationItem> birdLocationItems = new ArrayList<BirdLocationItem>();
    BirdLocationAdapter birdLocationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity activity = this;
        BirdLocationClient birdLocationClient = new BirdLocationClient(this);
        birdLocationClient.setOnBirdLocationListener(
                (BirdLocationListener)getFragmentManager().findFragmentById(R.id.first_fragment));


    }
}
