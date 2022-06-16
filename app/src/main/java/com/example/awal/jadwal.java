package com.example.awal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class jadwal extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);

        mTabLayout.addTab(mTabLayout.newTab().setText("MINGGU"));
        mTabLayout.addTab(mTabLayout.newTab().setText("SENIN"));
        mTabLayout.addTab(mTabLayout.newTab().setText("SELASA"));
        mTabLayout.addTab(mTabLayout.newTab().setText("RABU"));
        mTabLayout.addTab(mTabLayout.newTab().setText("KAMIS"));
        mTabLayout.addTab(mTabLayout.newTab().setText("JUMAT"));
        mTabLayout.addTab(mTabLayout.newTab().setText("SABTU"));

       mPager=findViewById(R.id.viewpager);
       PageAdapter adapter=new PageAdapter(getSupportFragmentManager(),mTabLayout.getTabCount());
       mPager.setAdapter(adapter);
       mTabLayout.setOnTabSelectedListener(this);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
    mPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}