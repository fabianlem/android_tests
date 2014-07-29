package com.example.testapp;
/**
 * Created by gutierrezf on 7/24/2014.
 */
//import android.app.Fragment;
//import android.app.FragmentPageAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int index){
        switch (index){
            case 0: return new fragOne();
            case 1: return new fragTwo();
        }
        return null;
    }
    @Override
    public int getCount() {
        return 2;
    }
}
