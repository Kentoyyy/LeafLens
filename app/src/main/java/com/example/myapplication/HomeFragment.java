package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class HomeFragment extends Fragment {


    ImageButton btntropical;

    Button btntips;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        btntropical = view.findViewById(R.id.btnTropical);

        btntips = view.findViewById(R.id.btnTIps);

        btntips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment tips = new PlantTipsFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.body_container, tips).commit();
            }
        });

        btntropical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment plantcontent = new PlantTropicalFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.body_container, plantcontent).commit();
            }
        });




        return view;
    }
}