package com.example.testapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by gutierrezf on 8/18/2014.
 */
public class moreInfo_frag extends Fragment {
    private OnItemSelectedListener listener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        View rootview = inflater.inflate(R.layout.more_info, container, false);

        return rootview;
    }

    public void setDesc(String item) {
        TextView view = (TextView) getView().findViewById(R.id.descLine);
        view.setText(item);
    }
    public void setNam(String item) {
        TextView view = (TextView) getView().findViewById(R.id.namLine);
        view.setText(item);
    }

    public void setPic(ImageView item) {
        ImageView view = (ImageView) getView().findViewById(R.id.pic);
//        view.setImageBitmap(item);
    }
    public interface OnItemSelectedListener {
        public void onRssItemSelected(String link);
    }
}
