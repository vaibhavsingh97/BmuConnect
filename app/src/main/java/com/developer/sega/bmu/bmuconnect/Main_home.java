package com.developer.sega.bmu.bmuconnect;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;


import com.developer.sega.bmu.bmuconnect.Fragment.HomeFragment;
import com.developer.sega.bmu.bmuconnect.Fragment.InfoFragment;
import com.developer.sega.bmu.bmuconnect.Fragment.MenuFragment;
import com.developer.sega.bmu.bmuconnect.helper.SQLiteHandler;
import com.developer.sega.bmu.bmuconnect.helper.SessionManager;
import java.util.ArrayList;
import java.util.List;


import com.developer.sega.bmu.bmuconnect.R;

import org.w3c.dom.Text;

public class Main_home extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView textview;
    private TextView logout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_tab_menu,
            R.drawable.ic_tab_home,
            R.drawable.ic_tab_info
    };
    private SQLiteHandler db;
    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        logout =(TextView)findViewById(R.id.logout_text);
        logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });


       /*//toolbar = (Toolbar) findViewById(R.id.toolbar);
        textview =(TextView)findViewById(R.id.textView);
         //setSupportActionBar(toolbar);
        textview.setText("BMU APP");
        textview.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        viewPager.setCurrentItem(1, false);


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new MenuFragment(), "MENU");
        adapter.addFrag(new HomeFragment(), "HOME");
        adapter.addFrag(new InfoFragment(), "INFO");


        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    //Change The Backgournd Color of Tabs

    public void setTabColor(TabHost tabhost) {

        for(int i=0;i<tabhost.getTabWidget().getChildCount();i++)
            tabhost.getTabWidget().getChildAt(i).setBackgroundColor(Color.RED); //unselected

        if(tabhost.getCurrentTab()==0)
            tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab()).setBackgroundColor(Color.GREEN); //1st tab selected
        else
            tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab()).setBackgroundColor(Color.YELLOW); //2nd tab selected
    }

    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(Main_home.this, Login.class);
        startActivity(intent);
        finish();
    }
}