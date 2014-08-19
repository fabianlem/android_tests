package com.example.testapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by gutierrezf on 7/24/2014.
 */
public class listFrag extends Fragment{
    ArrayList<String> mDataSourceList;
    View rootview;
    CustomArrayAdapter arrAdapter;
    Boolean change_fl;
    private final String TAG = "updateBroadcast";

    public static listFrag newInstance(){
        listFrag f =  new listFrag();
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        rootview = inflater.inflate(R.layout.fragmrnt_one, container, false);
        mDataSourceList = new ArrayList<String>();
        if(savedInstancesState != null)
            mDataSourceList = savedInstancesState.getStringArrayList("list");
        else
            for(int i=0; i < 2; i++)
                mDataSourceList.add("列表数据 " + i);
//        getActivity().registerReceiver(broadcastReceiver, new IntentFilter(TAG));
//        change_fl = true;

        return rootview;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mDataSourceList = new ArrayList<String>();
//        if(savedInstanceState != null)
//            mDataSourceList = savedInstanceState.getStringArrayList("list");
//        else
//            for(int i=0; i < 2; i++)
//                mDataSourceList.add("列表数据 " + i);

        ListView listView = (ListView) getActivity().findViewById(R.id.listview);
//        listView.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, mDataSourceList));
////
//        String[] values = mDataSourceList.toArray(new String[mDataSourceList.size()]);
        arrAdapter = new CustomArrayAdapter(getActivity(), mDataSourceList);
        listView.setAdapter(arrAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            ////
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                mDataSourceList.remove(position);

                arrAdapter.notifyDataSetChanged();
            }

//            @Override
//            public void onConfigurationChanged(Configuration newConfig) {
//                super.onConfigurationChanged(newConfig);
//                setContentView(R.layout.mylayout);
//
//            }

        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("list", mDataSourceList);
    }
//    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            updateViewBackground(intent);
//        }
//    };

//    private void updateViewBackground(Intent intent){
//        if(change_fl) {
//            mDataSourceList.add("элемент списка " + mDataSourceList.size());
//            arrAdapter.notifyDataSetChanged();
//        }
//        String color = intent.getStringExtra("newColor");
//        rootview.setBackgroundColor(Color.parseColor(color));
//        change_fl = !change_fl;
////        String[] values = mDataSourceList.toArray(new String[mDataSourceList.size()]);
////        ArrayAdapter ar = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1, values);
//
//    }
    }
