package derbyapps.ac.nz.catchybird;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 3/08/2017.
 */

public class MapFragment extends Fragment implements OnMapReadyCallback, BirdLocationAvailableListener, BirdFilterListener {

    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;
    List<BirdLocationItem> mBirdList;

    public MapFragment() {
        mBirdList = new ArrayList<>();
    }

    @Override
    public void onBirdLocationAvailable(List<BirdLocationItem> birds) {

        mBirdList = new ArrayList<>(birds);

        List<BirdLocationItem> filter = new ArrayList<BirdLocationItem>();

        for(BirdLocationItem birdLocation: mBirdList) {

            float lat = birdLocation.getLatitude();
            float lng = birdLocation.getLongitude();
            String bird = birdLocation.getBird();

            int icon = R.mipmap.ic_map_pin_white;
            int img = R.mipmap.ic_launcher_round;
            switch (bird) {
                case "pukeko":
                    icon = R.mipmap.ic_map_pin_dark_red;
                    img = R.mipmap.ic_bird_pukeko;
                    break;
                case "sparrow":
                    icon = R.mipmap.ic_map_pin_dark_pastel_green;
                    img = R.mipmap.ic_bird_sparrow;
                    break;
                case "black swan":
                    icon = R.mipmap.ic_map_pin_azure;
                    img = R.mipmap.ic_bird_black_swan;
                    break;
                case "grey duck":
                    icon = R.mipmap.ic_map_pin_dark_lavender;
                    img = R.mipmap.ic_bird_grey_duck;
                    break;
            }

            birdLocation.setMarker(mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title(bird).snippet(lat + ", " + lng).icon(BitmapDescriptorFactory.fromResource(icon))));

            CameraPosition camPos = CameraPosition.builder().target(new LatLng(lat, lng)).zoom(16).bearing(0).tilt(45).build();
            mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(camPos));

            boolean exists = false;
            for (BirdLocationItem item : filter) {
                if(item.getBird().equals(bird)) {
                    exists = true;
                    item.incCount();
                    break;
                }
            }
            if(!exists) {
                filter.add(new BirdLocationItem(1, img, bird));
            }
        }

        BirdLocationAdapter adapter = new BirdLocationAdapter(getActivity(), (ArrayList<BirdLocationItem>) filter);
        adapter.setOnBirdFilterListener(this);
        ListView lvBirdLocation = (ListView) mView.findViewById(R.id.lvBirdLocation);
        lvBirdLocation.setAdapter(adapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_map, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMapView = (MapView)view.findViewById(R.id.map);
        if(mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());

        mGoogleMap = googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mGoogleMap.setPadding(0, 0, 0, 140);
    }

    @Override
    public void onBirdFilter(List<BirdLocationItem> birds) {
        for(BirdLocationItem birdFilter: birds) {
            for(BirdLocationItem birdLocation: mBirdList) {
                if(birdLocation.getBird().equals(birdFilter.getBird())) {
                    birdLocation.getMarker().setVisible(birdFilter.isBox());
                }
            }
        }
    }
}
