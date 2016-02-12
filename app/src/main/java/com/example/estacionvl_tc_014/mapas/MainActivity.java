package com.example.estacionvl_tc_014.mapas;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.estacionvl_tc_014.mapas.adapters.PagerAdapter;
import com.example.estacionvl_tc_014.mapas.fragments.DetailFragment;
import com.example.estacionvl_tc_014.mapas.fragments.MapFragment;
import com.example.estacionvl_tc_014.mapas.fragments.TitleFragment;
import com.example.estacionvl_tc_014.mapas.models.Lugar;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    ViewPager pager;
    DetailFragment detail;
    MapFragment map;
    PagerAdapter adapter;

    List<TitleFragment> data;

    Toolbar toolbar;
    TabLayout tabLayout;

    Lugar lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pager = (ViewPager) findViewById(R.id.pager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        setSupportActionBar(toolbar);



        detail = new DetailFragment();
        map = new MapFragment();

        initLugar();
        detail.setLugar(lugar);
        map.setLugar(lugar);
        toolbar.setTitle(lugar.getNombre());

        data =  new ArrayList<>();

        data.add(detail);
        data.add(map);

        adapter = new PagerAdapter(getSupportFragmentManager(), data);

        pager.setAdapter(adapter);

        tabLayout.setupWithViewPager(pager);
        tabLayout.setTabsFromPagerAdapter(adapter);






    }


    public void initLugar(){
        lugar = new Lugar();
        lugar.setNombre("Parque Infantil");
        lugar.setDireccion("Carrera 30A #17-00");
        lugar.setImg("http://photos.wikimapia.org/p/00/00/23/82/70_big.jpg");
        lugar.setLatitud(1.2193775530053121);
        lugar.setLongitud(-77.28168858462527);
        lugar.setDescripcion("Lo que guarda la escultura del Parque Infantil de Pasto.  La escultura que se  encuentra ubicada dentro del parque infantil, es un monumento en piedra, en el cual se encuentra tallado el escudo de la ciudad de Pasto, históricamente no se conoce la fecha de su creación ni el autor.");
        lugar.setEmail("parqueinfantil@gmail.com");
        lugar.setCelular("3001234564");

    }


}
