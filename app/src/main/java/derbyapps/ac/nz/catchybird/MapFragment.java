package derbyapps.ac.nz.catchybird;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

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

    @Override
    public void onBirdLocationAvailable(List<BirdLocationItem> birds) {

        mBirdList = new ArrayList<>(birds);

        List<BirdListItem> filter = new ArrayList<BirdListItem>();

        for(BirdLocationItem birdLocation: mBirdList) {

            float lat = birdLocation.getLatitude();
            float lng = birdLocation.getLongitude();
            String bird = birdLocation.getBird();

            int markerIcon = R.mipmap.ic_map_pin_white;
            int img = R.mipmap.ic_launcher_round;
            switch (bird) {
                case "pukeko":
                    markerIcon = R.mipmap.ic_map_pin_dark_red;
                    img = R.mipmap.ic_bird_pukeko;
                    break;
                case "sparrow":
                    markerIcon = R.mipmap.ic_map_pin_dark_pastel_green;
                    img = R.mipmap.ic_bird_sparrow;
                    break;
                case "black swan":
                    markerIcon = R.mipmap.ic_map_pin_azure;
                    img = R.mipmap.ic_bird_black_swan;
                    break;
                case "grey duck":
                    markerIcon = R.mipmap.ic_map_pin_dark_lavender;
                    img = R.mipmap.ic_bird_grey_duck;
                    break;
            }

            birdLocation.setMarker(mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title(bird).snippet(lat + ", " + lng).icon(BitmapDescriptorFactory.fromResource(markerIcon))));

            CameraPosition camPos = CameraPosition.builder().target(new LatLng(lat, lng)).zoom(16).bearing(0).tilt(45).build();
            mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(camPos));

            boolean exists = false;
            for (BirdListItem item : filter) {
                if(item.getBird().equals(bird)) {
                    exists = true;
                    item.incCount();
                    break;
                }
            }
            if(!exists) {
                filter.add(new BirdListItem(bird, 1, img));
            }
        }

        BirdListAdapter adapter = new BirdListAdapter(getActivity(), (ArrayList<BirdListItem>) filter);
        adapter.setOnBirdFilterListener(this);
        ListView lvBirdList = (ListView) mView.findViewById(R.id.lvBirdList);
        lvBirdList.setAdapter(adapter);

        ((ProgressBar)mView.findViewById(R.id.progressBar)).setVisibility(View.INVISIBLE);
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
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mGoogleMap.setPadding(0, 0, 0, 140);
    }

    @Override
    public void onBirdFilter(List<BirdListItem> birds) {
        for(BirdListItem birdFilter: birds) {
            for(BirdLocationItem birdLocation: mBirdList) {
                if(birdLocation.getBird().equals(birdFilter.getBird())) {
                    birdLocation.getMarker().setVisible(birdFilter.isBox());
                }
            }
        }
    }
}
