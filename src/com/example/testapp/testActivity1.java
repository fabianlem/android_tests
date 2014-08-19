package com.example.testapp;

import android.app.ActionBar;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
//import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

public class testActivity1 extends FragmentActivity  implements ActionBar.TabListener{
    /**
     * Called when the activity is first created.
     */
    private ViewPager mViewPager;
    private TabsPagerAdapter mTabsAdapter;
    private ActionBar actionBar;
    private String[] tabs = {"one", "two", "three"};
    private boolean isTwoPane = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // Initialization
//        determinePaneLayout();
        mViewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mTabsAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mTabsAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        mViewPager.setOffscreenPageLimit(3);
        // Adding Tabs
        for (String tab_name : tabs)
            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));

        /**
         * on swiping the viewpager make respective tab selected
         * */
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dropdownmenu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
//code here
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.submenu1:
                Toast.makeText(getApplicationContext(), "submenu1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.submenu2:
                Toast.makeText(getApplicationContext(), "submenu2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
