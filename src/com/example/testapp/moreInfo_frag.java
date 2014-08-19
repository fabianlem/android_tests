package com.example.testapp;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by gutierrezf on 8/18/2014.
 */
public class moreInfo_frag extends Fragment {
//    private OnItemSelectedListener listener;
    View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        rootview = inflater.inflate(R.layout.more_info, container, false);

        return rootview;
    }

    public void setDesc(String item) {
        TextView view = (TextView) rootview.findViewById(R.id.descLine);
        view.setText(item);
    }
    public void setNam(String item) {
        TextView view = (TextView) rootview.findViewById(R.id.namLine);
        view.setText(item);
    }

    public void setPic(int pos) {
        ImageView view = (ImageView) rootview.findViewById(R.id.pic);
        view.setImageResource(mThumbIds[pos]);
    }

    public void setBackground(String color){
        LinearLayout li = (LinearLayout) rootview.findViewById(R.id.gridlayout);
        li.setBackgroundColor(Color.parseColor(color));
    }
    private int[] mThumbIds = {
            R.drawable.ic_dino, R.drawable.ic_girl,
            R.drawable.ic_dude, R.drawable.ic_mario,
            R.drawable.ic_eva01
    };
//    public interface OnItemSelectedListener {
//        public void onRssItemSelected(String link);
//    }
}
