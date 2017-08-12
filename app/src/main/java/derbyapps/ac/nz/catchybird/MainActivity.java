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

        List<String> your_array_list = Arrays.asList(
                "Bird 1",
                "Bird 2",
                "Bird 3",
                "Bird 4",
                "Bird 5",
                "Bird 6",
                "Bird 7",
                "Bird 8",
                "Bird 9",
                "Bird 10"
        );

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        ListView lv = (ListView) findViewById(R.id.bird_list);
        lv.setAdapter(arrayAdapter);
    }
}
