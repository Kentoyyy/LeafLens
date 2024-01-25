package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class PlantsFragment extends Fragment {

    ImageView btnaloe,btntulsi,btnwildtea;

    SearchView searchView;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plants, container, false);

        recyclerView = view.findViewById(R.id.recycleView);
        searchView = view.findViewById(R.id.recycleView);

        btnaloe = view.findViewById(R.id.buttonAloevera);

        btntulsi = view.findViewById(R.id.btnTulsi);

        btnwildtea = view.findViewById(R.id.btnWildTea);

        btnwildtea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment plantcontent = new WildTeaFragment();
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