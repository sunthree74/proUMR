package tk.sunthree.upahku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsHome extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    private static final LatLng BANDUNG = new LatLng(-6.90389, 107.61861);
    private static final LatLng DEPOK = new LatLng(-6.4, 106.81861);
    private static final LatLng MALANG = new LatLng(-7.9797, 112.6304);

    private Marker mBandung;
    private Marker mDepok;
    private Marker mMalang;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_maps);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.splash_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(MapsHome.this, MainActivity.class);
            startActivity(i);

            // close this activity
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        List<Marker> markerList = new ArrayList<>();


        //mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        mBandung = mMap.addMarker(new MarkerOptions()
                .position(BANDUNG)
                .title("Bandung"));
        mBandung.setTag(0);
        markerList.add(mBandung);

        mDepok = mMap.addMarker(new MarkerOptions()
                .position(DEPOK)
                .title("Depok")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mDepok.setTag(0);
        markerList.add(mDepok);

        mMalang = mMap.addMarker(new MarkerOptions()
                .position(MALANG)
                .title("Malang")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mMalang.setTag(0);
        markerList.add(mMalang);

        mMap.setOnMarkerClickListener(this); // register our click listener!

        for (Marker m : markerList){
            LatLng latLng = new LatLng(m.getPosition().latitude, m.getPosition().longitude);
            mMap.addMarker(new MarkerOptions().position(latLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,12));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,2));
        }


        // Add a marker in Sydney and move the camera
//        LatLng jakarta = new LatLng(-6.21462, 106.84513);
//        mMap.addMarker(new MarkerOptions().position(jakarta).title("Marker in Jakarta")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jakarta,13));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Integer clickCount = (Integer) marker.getTag();
        if(clickCount != null){
            clickCount = clickCount+1;
            marker.setTag(clickCount);
            Toast.makeText(this,marker.getTitle()+" has been clicked "+clickCount+" times",Toast.LENGTH_LONG).show();
        }
        return false;
    }
}
