package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class PlantTropicalFragment extends Fragment {

    ImageView btnaloe,btntulsi,btnwildtea,btnbittergroud,btnyerbabuena,btnLagundi, btntanglakd;

    Button btnbacktropical;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planttropical, container, false);


        btntanglakd = view.findViewById(R.id.btntanglad);

        btnLagundi = view.findViewById(R.id.btnLaagundi);

        btnbittergroud = view.findViewById(R.id.btnAmpalaya);

        btnyerbabuena = view.findViewById(R.id.btnYerba);

        btnaloe = view.findViewById(R.id.buttonAloevera);

        btntulsi = view.findViewById(R.id.btnTulsi);

        btnwildtea = view.findViewById(R.id.btnWildTea);


        btnbacktropical = view.findViewById(R.id.btnBackTl);


        btntanglakd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment Tanglad = new TangladFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.body_container, Tanglad).commit();
            }
        });
        btnLagundi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment Lagundi = new LagundiFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.body_container, Lagundi).commit();
            }
        });

        btnbacktropical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment backTropical = new HomeFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.body_container, backTropical).commit();
            }
        });


        btnwildtea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment plantcontent = new WildTeaFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.body_container, plantcontent).commit();
            }
        });

        btnbittergroud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment plantcontent = new BittergourdFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.body_container, plantcontent).commit();
            }
        });

        btnyerbabuena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment plantcontent = new YerbaBuenaFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.body_container, plantcontent).commit();
            }
        });

        btntulsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment plantcontent = new TulsiFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.body_container, plantcontent).commit();
            }
        });


        btnaloe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment plantcontent = new AloeVeraFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.body_container, plantcontent).commit();
            }
        });


        return view;

    }
}