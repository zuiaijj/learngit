package com.example.fragmentdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTablayout;
    private ViewPager fragmentviewPager;
    private MyFragmentViewAdapter myFragmentViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        FragmentManager pvFragmentManager = getSupportFragmentManager();
        fragmentviewPager = findViewById(R.id.fragment_vp);
        myFragmentViewAdapter = new MyFragmentViewAdapter(pvFragmentManager, DataGenerator.tabName.length);
        fragmentviewPager.setAdapter(myFragmentViewAdapter);
        fragmentviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTablayout));
        mTablayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(fragmentviewPager));
    }

    private void init() {
        mTablayout = findViewById(R.id.bottom_tab_layout);

        mTablayout.addTab(mTablayout.newTab().setIcon(R.mipmap.ic_launcher).setText(DataGenerator.tabName[0]));
        mTablayout.addTab(mTablayout.newTab().setIcon(R.mipmap.ic_launcher).setText(DataGenerator.tabName[1]));
        mTablayout.addTab(mTablayout.newTab().setIcon(R.mipmap.ic_launcher).setText(DataGenerator.tabName[2]));
        mTablayout.addTab(mTablayout.newTab().setIcon(R.mipmap.ic_launcher).setText(DataGenerator.tabName[3]));

    }

}
