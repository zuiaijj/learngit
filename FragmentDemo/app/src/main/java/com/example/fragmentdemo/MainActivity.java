package com.example.fragmentdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTablayout;

    //private Fragment[] mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // mFragments = DataGenerator.getFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new MainFragment()).commit();
        init();
    }

    private void init() {
        mTablayout = findViewById(R.id.bottom_tab_layout);

        mTablayout.addTab(mTablayout.newTab().setIcon(R.mipmap.ic_launcher).setText(DataGenerator.tabName[0]));
        mTablayout.addTab(mTablayout.newTab().setIcon(R.mipmap.ic_launcher).setText(DataGenerator.tabName[1]));
        mTablayout.addTab(mTablayout.newTab().setIcon(R.mipmap.ic_launcher).setText(DataGenerator.tabName[2]));
        mTablayout.addTab(mTablayout.newTab().setIcon(R.mipmap.ic_launcher).setText(DataGenerator.tabName[3]));

        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onItemTabSelected(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void onItemTabSelected(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new MainFragment();
                break;
            case 1:
                fragment = new RoundFragment();
                break;
            case 2:
                fragment = new MineFragment();
                break;
            case 3:
                fragment = new FollowFragment();
                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        }
    }
}
