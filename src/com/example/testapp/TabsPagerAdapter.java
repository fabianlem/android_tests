package com.example.testapp;
/**
 * Created by gutierrezf on 7/24/2014.
 */
//import android.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
//import android.support.v13.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private FragmentManager mFragmentManager;
    public TabsPagerAdapter(FragmentManager fm){
        super(fm);
        mFragmentManager = fm;
    }
    @Override
    public Fragment getItem(int index){
        switch (index){
            case 0: //if(mFragment == null) {
//                        mFragment = fragOne.newInstance(new FragListener() {
//
//                            public void onSwitchToNextFragment() {
//                                mFragmentManager.beginTransaction().remove(mFragment).commit();
//                                mFragment = new fragTwo();
//                                notifyDataSetChanged();
//                            }
//                        });
//                        return mFragment;
//                    }else
                        return new fragOne();
            case 1:     return new fragTwo();
            case 2:     return new gridFrag();
        }
        return null;
    }
    @Override
    public int getCount() {
        return 3;
    }
}
