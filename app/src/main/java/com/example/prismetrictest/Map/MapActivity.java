package com.example.prismetrictest.Map;

import static com.example.prismetrictest.Util.Constance.LATITUDE;
import static com.example.prismetrictest.Util.Constance.LONGITUDE;
import static com.example.prismetrictest.Util.Constance.ZERO;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.prismetrictest.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

  private GoogleMap mMap;
  String lat, lan;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_map);

    if (getIntent() != null){
      lat = getIntent().getStringExtra(LATITUDE);
      lan = getIntent().getStringExtra(LONGITUDE);
    }

    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
        .findFragmentById(R.id.frag_home_google_map);
    mapFragment.getMapAsync(this);
  }

  @Override
  public void onMapReady(@NonNull GoogleMap googleMap) {
    mMap = googleMap;
    LatLng TutorialsPoint = new LatLng(lat != null && !lat.equals("") ? Double.parseDouble(lat):ZERO,
        lan != null && !lan.equals("") ? Double.parseDouble(lan):ZERO);
    mMap.addMarker(new MarkerOptions().position(TutorialsPoint));
    mMap.moveCamera(CameraUpdateFactory.newLatLng(TutorialsPoint));
  }
}