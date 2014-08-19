package com.example.testapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;
import android.widget.FrameLayout;
import android.app.Activity;
import android.app.FragmentManager;

/**
 * Created by gutierrezf on 8/18/2014.
 */
public class panelTest extends Activity implements gridlist.OnItemSelectedListener {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel_layout);
        loadPaneLayout();
    }

    private void loadPaneLayout() {
        FrameLayout fragmentItemDetail = (FrameLayout) findViewById(R.id.placement_holder1);
        // If there is a second pane for details
        if (fragmentItemDetail != null) {
//            isTwoPane = true;
            FragmentTransaction ft;
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.placement_holder1, new gridlist());
            ft.commit();
        }

        FrameLayout fragmentMoreInfo = (FrameLayout) findViewById(R.id.placement_holder2);
        // If there is a second pane for details
        if (fragmentMoreInfo != null) {
//            isTwoPane = true;
            FragmentTransaction ft;
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.placement_holder2, new moreInfo_frag(), "moreInfo");
            ft.commit();
        }
    }

    public void onFragItemSelected(int position, String name, String color){
        moreInfo_frag moreInfo = (moreInfo_frag) getFragmentManager().findFragmentByTag("moreInfo");// getSupportFragmentManager()
        if(moreInfo != null){
            moreInfo.setNam(name);
            moreInfo.setDesc(""+position);
            moreInfo.setPic(position);
            moreInfo.setBackground(color);
        }
    }
}
