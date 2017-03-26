package com.developer.sega.bmu.bmuconnect.Fragment;


import android.content.Intent;
import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.developer.sega.bmu.bmuconnect.About_us;
import com.developer.sega.bmu.bmuconnect.CMS;
import com.developer.sega.bmu.bmuconnect.R;
import com.developer.sega.bmu.bmuconnect.events;
import com.developer.sega.bmu.bmuconnect.lms;
import com.developer.sega.bmu.bmuconnect.mess_menu;
import com.developer.sega.bmu.bmuconnect.timetable;


public class MenuFragment extends Fragment{

    public MenuFragment() {
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
        final LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.menu_fragment, container, false);
        // return inflater.inflate(R.layout.info_fragment, container, false);

        //LMS
        ImageButton image_lms = (ImageButton) mLinearLayout.findViewById(R.id.imageButton11);
        image_lms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                startActivity(new Intent(getActivity(), lms.class));
            }
        });
        //Events
        ImageButton image_events = (ImageButton) mLinearLayout.findViewById(R.id.imageButton14);
        image_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                startActivity(new Intent(getActivity(), events.class));
            }
        });
        //CMS
        ImageButton image_cms = (ImageButton) mLinearLayout.findViewById(R.id.imageButton17);
        image_cms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                startActivity(new Intent(getActivity(), CMS.class));
            }
        });
        //Today's Menu
        ImageButton image_mess = (ImageButton) mLinearLayout.findViewById(R.id.imageButton12);
        image_mess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                startActivity(new Intent(getActivity(), mess_menu.class));
            }
        });
        //Timetable
        ImageButton image_timetable = (ImageButton) mLinearLayout.findViewById(R.id.imageButton15);
        image_timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                startActivity(new Intent(getActivity(), timetable.class));
            }
        });

        //About Us
        ImageButton image_about_us = (ImageButton) mLinearLayout.findViewById(R.id.imageButton18);
        image_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                startActivity(new Intent(getActivity(), About_us.class));
            }
        });

        // after you've done all your manipulation, return your layout to be shown
        return mLinearLayout;
    }
}