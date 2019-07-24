package com.example.fragmentdemo;

import androidx.fragment.app.Fragment;

public class DataGenerator {
    public static final String[] tabName = new String[]{"首页","附近","关注","我"};
    public static final int[] tabImgRes = new int[]{R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    public static final int[] pressedImgRes = new int[]{R.mipmap.pressed_copy_3x,R.mipmap.pressed_copy_3x,R.mipmap.pressed_copy_3x,R.mipmap.pressed_copy_3x};

    public static Fragment[] getFragment(){
        Fragment[] fragments = new Fragment[4];
        fragments[0] = new MainFragment();
        fragments[1] = new RoundFragment();
        fragments[2] = new FollowFragment();
        fragments[3] = new MineFragment();
        return fragments;
    }
}
