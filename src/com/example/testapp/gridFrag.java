package com.example.testapp;

import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.content.Context;

import java.util.Random;

/**
 * Created by gutierrezf on 8/6/2014.
 */
public class gridFrag extends Fragment {
    View rootview;
    String[] colors = {"#FFfa6a6a", "#FF8C8C88", "#FFFFC66C", "#ff65ffc1", "#ffeb7d51","#FF59EEFF"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        rootview = inflater.inflate(R.layout.gridsample, container, false);
//        getActivity().registerReceiver(broadcastReceiver, new IntentFilter(TAG));
//        change_fl = true;
        GridView gridview = (GridView) rootview.findViewById(R.id.gridview);

        gridview.setAdapter(new ImageAdapter(rootview.getContext()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show();
                v.setBackgroundColor(Color.parseColor(getRandColor()));
            }
        });

        return rootview;
    }

    private String getRandColor(){
        Random rand = new Random();
        int randomNum = rand.nextInt(colors.length);
        return colors[randomNum];
    }
}
