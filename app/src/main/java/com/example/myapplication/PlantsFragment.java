package com.example.myapplication;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class PlantsFragment extends Fragment {

    ImageView btnaloe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plants, container, false);

        btnaloe = view.findViewById(R.id.buttonAloevera);


        btnaloe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment plantcontent = new PlantsContentFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.body_container, plantcontent).commit();
            }
        });
        return view;

    }
}