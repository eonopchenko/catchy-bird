package derbyapps.ac.nz.catchybird;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 3/08/2017.
 */

public class MapFragment extends Fragment implements OnMapReadyCallback, BirdLocationListener {

    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;

    ArrayList<BirdLocationItem> birdLocationItems = new ArrayList<BirdLocationItem>();
    BirdLocationAdapter birdLocationAdapter;

    public void onBirdLocationAvailable(List<BirdLocationItem> locations) {

        birdLocationItems.clear();
        for(BirdLocationItem location: locations) {
            float lat = location.getLatitude();
            float lng = location.getLongitude();
            String bird = location.getBird();
            mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title(location.getBird()).snippet("Such a nice bird!"));
            CameraPosition camPos = CameraPosition.builder().target(new LatLng(lat, lng)).zoom(16).bearing(0).tilt(45).build();
            mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(camPos));
            Boolean found = false;
            for(BirdLocationItem item : birdLocationItems) {
                if(item.getBird().equals(bird)) {
                    found = true;
                    break;
                }
            }
            if(found == false) {
                birdLocationItems.add(new BirdLocationItem(bird, lat, lng, location.getId()));
            }
        }

        birdLocationAdapter = new BirdLocationAdapter(getActivity(), birdLocationItems);
        ListView lvMain = (ListView) mView.findViewById(R.id.lvMain);
        lvMain.setAdapter(birdLocationAdapter);
    }

    public MapFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.map_fragment, container, false);
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
}
