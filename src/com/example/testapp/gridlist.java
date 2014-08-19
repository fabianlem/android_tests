package com.example.testapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
//import android.app.Fragment;
import android.util.Log;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by gutierrezf on 8/6/2014.
 */
public class gridlist extends Fragment {
    View rootview;
    private final String TAG = "updateBroadcast";
//    private String passengers = "";
//    SharedPreferences prefs ;
//    private String name = "";
//    boolean canPay = false;
    GridView gridview ;
    ImageGridAdapter arrAdapter;
    String[] colors = {"#FFfa6a6a", "#FF8C8C88", "#FFFFC66C", "#ff65ffc1", "#FF59EEFF"};
    String[] names = {"dino", "girl", "dude", "mario", "eva01"};
    private int[] mThumbIds = {
            R.drawable.ic_dino, R.drawable.ic_girl,
            R.drawable.ic_dude, R.drawable.ic_mario,
            R.drawable.ic_eva01
    };
    OnItemSelectedListener mCallback;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        rootview = inflater.inflate(R.layout.gridsample, container, false);
      // gridview.setAdapter(new ImageAdapter(rootview.getContext(), mDataSourceList, nameList, statusList));

//        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(getActivity().getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show();
//                v.setBackgroundColor(Color.parseColor(getRandColor()));
//            }
//        });

        return rootview;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        arrAdapter = new ImageGridAdapter(getActivity(), mThumbIds, names, colors ); //, timeStamp
        gridview = (GridView) rootview.findViewById(R.id.gridview);
        gridview.setAdapter(arrAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            ////
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
    //                Toast.makeText(getActivity().getApplicationContext(), "" + nameList.get(position), Toast.LENGTH_SHORT).show();
    //                view.setBackgroundColor(Color.parseColor(getRandColor()));
                Log.e("gridList","clicked "+ names[position]);
                mCallback.onFragItemSelected(position, names[position], colors[position]);

            }
        });
    }

    public interface OnItemSelectedListener {
        public void onFragItemSelected(int position, String name, String color);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnItemSelectedListener");
        }
    }

    private String getRandColor(){
        Random rand = new Random();
        int randomNum = rand.nextInt(colors.length);
        return colors[randomNum];
    }
}
