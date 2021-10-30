package com.example.prismetrictest.HomeScreen.Adapter;


import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.prismetrictest.HomeScreen.fragment.HomeFragment;

import butterknife.Unbinder;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;
    private Unbinder unbinder;

    public PagerAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        this.tabCount = tabCount;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new HomeFragment();
            case 2:
                return new HomeFragment();

            case 3:
                return new HomeFragment();
            case 4:
                return new HomeFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
