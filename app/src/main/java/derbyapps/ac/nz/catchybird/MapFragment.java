package derbyapps.ac.nz.catchybird;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by eugene on 3/08/2017.
 */

public class MapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;

    public MapFragment() {
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
        mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(-36.848461, 174.762183)).title("Sky Tower").snippet("I hope to go there someday"));
        mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(-36.8651428, 174.72435)).title("Pukeko").snippet("Such a nice bird"));
        mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(-36.8809471, 174.702)).title("Pukeko").snippet("Such a nice bird"));
        mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(-36.867218, 174.720322)).title("Pukeko").snippet("Such a nice bird"));
        mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(-36.88101, 174.702)).title("Pukeko").snippet("Such a nice bird"));

        CameraPosition camPosSkyTower = CameraPosition.builder().target(new LatLng(-36.848461, 174.762183)).zoom(16).bearing(0).tilt(45).build();
        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(camPosSkyTower));
    }
}
