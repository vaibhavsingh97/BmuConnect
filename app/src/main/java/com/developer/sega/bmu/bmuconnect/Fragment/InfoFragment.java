package com.developer.sega.bmu.bmuconnect.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.developer.sega.bmu.bmuconnect.Departments;
import com.developer.sega.bmu.bmuconnect.Login;
import com.developer.sega.bmu.bmuconnect.R;
import com.developer.sega.bmu.bmuconnect.clubs;
import com.developer.sega.bmu.bmuconnect.contacts;
import com.developer.sega.bmu.bmuconnect.emergency;
import com.developer.sega.bmu.bmuconnect.maps;
import com.developer.sega.bmu.bmuconnect.weather;


public class InfoFragment extends Fragment{

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.info_fragment, container, false);
       // return inflater.inflate(R.layout.info_fragment, container, false);

        //Departments
        ImageButton image_department = (ImageButton) mLinearLayout.findViewById(R.id.imageButton2);
        image_department.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                startActivity(new Intent(getActivity(),Departments.class));
            }
        });

        //Clubs
        ImageButton image_club = (ImageButton) mLinearLayout.findViewById(R.id.imageButton5);
        image_club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                startActivity(new Intent(getActivity(),clubs.class));
            }
        });

        //Contacts
        ImageButton image_contact  = (ImageButton) mLinearLayout.findViewById(R.id.imageButton8);
        image_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                startActivity(new Intent(getActivity(),contacts.class));
            }
        });

        //Emergency
        ImageButton image_emergency  = (ImageButton) mLinearLayout.findViewById(R.id.imageButton3);
        image_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                startActivity(new Intent(getActivity(),emergency.class));
            }
        });

        //Weather
        ImageButton image_weather  = (ImageButton) mLinearLayout.findViewById(R.id.imageButton6);
        image_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                startActivity(new Intent(getActivity(),weather.class));
            }
        });

        //BMU Map
        ImageButton image_Map  = (ImageButton) mLinearLayout.findViewById(R.id.imageButton9);
        image_Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                startActivity(new Intent(getActivity(),maps.class));
            }
        });

        // after you've done all your manipulation, return your layout to be shown
        return mLinearLayout;
    }

}