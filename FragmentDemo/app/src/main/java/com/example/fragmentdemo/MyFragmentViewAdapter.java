package com.example.fragmentdemo;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class MyFragmentViewAdapter extends FragmentPagerAdapter {
    private String[] tabName = DataGenerator.tabName;
    private int tabNum;

    public MyFragmentViewAdapter(FragmentManager fm, int tabNum) {
        super(fm);
        this.tabNum = tabNum;
    }

    @Override
    public Fragment getItem(int position) {
        return getFragment(position);
    }

    @Override
    public int getCount() {
        return tabNum;
    }

    public Fragment getFragment(int position) {
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
        return fragment;
    }
}
