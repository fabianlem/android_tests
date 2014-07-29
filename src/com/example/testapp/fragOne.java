package com.example.testapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.BufferedInputStream;

import java.util.ArrayList;

/**
 * Created by gutierrezf on 7/24/2014.
 */
public class fragOne extends Fragment{
    ArrayList<String> mDataSourceList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        View rootview = inflater.inflate(R.layout.fragmrnt_one, container, false);



        return rootview;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDataSourceList = new ArrayList<String>();
        for(int i=0; i < 10; i++)
            mDataSourceList.add("列表数据 " + i);

        ListView listView = (ListView) getActivity().findViewById(R.id.listview);
//        listView.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, mDataSourceList));
////
        String[] values = mDataSourceList.toArray(new String[mDataSourceList.size()]);
        CustomArrayAdapter arrAdapter = new CustomArrayAdapter(getActivity(), values );
        listView.setAdapter(arrAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            ////
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
            }
        });
    }
    }
