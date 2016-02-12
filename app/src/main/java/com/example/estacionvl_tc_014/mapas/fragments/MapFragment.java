package com.example.estacionvl_tc_014.mapas.fragments;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.estacionvl_tc_014.mapas.R;
import com.example.estacionvl_tc_014.mapas.models.Lugar;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends TitleFragment implements OnMapReadyCallback {


    Lugar lugar;
    GoogleMap map;


    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_map, container, false);

        TextView address = (TextView) v.findViewById(R.id.address);
        address.setText(lugar.getDireccion());


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public String getTitle() {
        return "Mapa";
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng pasto = new LatLng(lugar.getLatitud(), lugar.getLongitud());
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pasto, 10));

        MarkerOptions parqueI = new MarkerOptions().title(lugar.getNombre())
                .position(pasto);
        map.addMarker(parqueI);

    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
}
