package id.sch.smktelkom_mlg.privateassignment.xiirpl216.googlemaps_showhockeyapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition JTG = CameraPosition.builder()
            .target(new LatLng(-6.858623, 111.642224))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions house;
    MarkerOptions quba;
    MarkerOptions pasar;
    MarkerOptions kec;
    MarkerOptions koramil;
    MarkerOptions smp;

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        house = new MarkerOptions()
                .position(new LatLng(-6.886892, 111.654675))
                .title("My House")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_black_24dp));

        quba = new MarkerOptions()
                .position(new LatLng(-6.887492, 111.656472))
                .title("Masjid Ar-rahmah")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_black_24dp));

        pasar = new MarkerOptions()
                .position(new LatLng(-6.879152, 111.658757))
                .title("Pasar Jatirogo")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_black_24dp));

        kec = new MarkerOptions()
                .position(new LatLng(-6.885809, 111.658339))
                .title("Kantor Kec. Jatirogo")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_black_24dp));

        koramil = new MarkerOptions()
                .position(new LatLng(-6.888232, 111.662722))
                .title("Koramil Jatirogo")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_black_24dp));

        smp = new MarkerOptions()
                .position(new LatLng(-6.884760, 111.657529))
                .title("SMPN 1 Jatirogo")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_black_24dp));

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map) {
        Toast toast = Toast.makeText(getApplicationContext(), "Map Ready!", Toast.LENGTH_SHORT);
        toast.show();
        mapReady = true;
        m_map = map;
        m_map.addMarker(house);
        m_map.addMarker(quba);
        m_map.addMarker(pasar);
        m_map.addMarker(kec);
        m_map.addMarker(koramil);
        m_map.addMarker(smp);
        flyTo(JTG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }
}
