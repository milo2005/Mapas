package com.example.estacionvl_tc_014.mapas.fragments;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.estacionvl_tc_014.mapas.R;
import com.example.estacionvl_tc_014.mapas.models.Lugar;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends TitleFragment {


    Lugar lugar;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v  =inflater.inflate(R.layout.fragment_detail, container, false);
        ImageView img = (ImageView) v.findViewById(R.id.img);
        TextView cell = (TextView) v.findViewById(R.id.cell);
        TextView email = (TextView) v.findViewById(R.id.email);
        TextView des = (TextView) v.findViewById(R.id.description);

        cell.setText(lugar.getCelular());
        email.setText(lugar.getEmail());
        des.setText(lugar.getDescripcion());
        Picasso.with(getContext()).load(Uri.parse(lugar.getImg())).into(img);

        return v;
    }

    @Override
    public String getTitle() {
        return "Informacion";
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
}
