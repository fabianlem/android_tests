package com.example.testapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;

/**
 * Created by gutierrezf on 8/18/2014.
 */
public class panelTest extends FragmentActivity {
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
            ft.replace(R.id.placement_holder1, new listFrag());
            ft.commit();
        }

        FrameLayout fragmentMoreInfo = (FrameLayout) findViewById(R.id.placement_holder2);
        // If there is a second pane for details
        if (fragmentMoreInfo != null) {
//            isTwoPane = true;
            FragmentTransaction ft;
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.placement_holder2, new moreInfo_frag());
            ft.commit();
        }
    }
}
