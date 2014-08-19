package com.example.testapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.app.Activity;
import android.app.FragmentManager;

/**
 * Created by gutierrezf on 8/18/2014.
 */
public class panelTest extends Fragment {
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.panel_layout);
//        loadPaneLayout();
//    }
    View rootview;
    moreInfo_frag moreInfo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        rootview = inflater.inflate(R.layout.panel_layout, container, false);
        loadPaneLayout();
        // gridview.setAdapter(new ImageAdapter(rootview.getContext(), mDataSourceList, nameList, statusList));

//        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(getActivity().getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show();
//                v.setBackgroundColor(Color.parseColor(getRandColor()));
//            }
//        });

        return rootview;
    }
    private void loadPaneLayout() {
        FrameLayout fragmentItemDetail = (FrameLayout) rootview.findViewById(R.id.placement_holder1);
        Log.e("PANELTEST", "inside loadLayout" + (fragmentItemDetail==null));
        // If there is a second pane for details
        if (fragmentItemDetail != null) {
//            isTwoPane = true;
            FragmentTransaction ft;
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.placement_holder1, new gridlist());
            ft.commit();
        }

        FrameLayout fragmentMoreInfo = (FrameLayout) rootview.findViewById(R.id.placement_holder2);
        // If there is a second pane for details
        if (fragmentMoreInfo != null) {
//            isTwoPane = true;
            FragmentTransaction ft;
            ft = getFragmentManager().beginTransaction();
//            moreInfo = new moreInfo_frag();
            ft.replace(R.id.placement_holder2, new moreInfo_frag(), "moreInfo");
            ft.commit();
        }
    }

    public void updateInfo(int position, String name, String color){
        Log.e("paneltest", "updateinfo " + position+name+color );
        moreInfo_frag moreInfo = (moreInfo_frag) getFragmentManager().findFragmentByTag("moreInfo");// getSupportFragmentManager()
//        if(moreInfo != null){
//            moreInfo.setNam(name);
//            moreInfo.setDesc(""+position);
//            moreInfo.setPic(position);
//            moreInfo.setBackground(color);
//            }
    }
}
