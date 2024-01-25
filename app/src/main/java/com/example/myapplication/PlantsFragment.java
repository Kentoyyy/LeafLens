package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class PlantsFragment extends Fragment {

    ImageView btnaloe,btnTulsi,btnWildTea;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plants, container, false);

        btnaloe = view.findViewById(R.id.buttonAloevera);
        btnTulsi = view.findViewById(R.id.btnTulsi);
        btnWildTea = view.findViewById(R.id.btnWildTea);


        btnaloe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment plantcontent = new AloeVeraFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.body_container, plantcontent).commit();
            }
        });

        btnTulsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment plantcontent = new TulsiFragment();
                FragmentTransaction tulsi = getActivity().getSupportFragmentManager().beginTransaction();
                tulsi.replace(R.id.body_container, plantcontent).commit();
            }
        });

        btnTulsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment plantcontent = new WildTeaFragment();
                FragmentTransaction wildtea = getActivity().getSupportFragmentManager().beginTransaction();
                wildtea.replace(R.id.body_container, plantcontent).commit();
            }
        });
        return view;

    }
}