package com.example.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by gutierrezf on 8/6/2014.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {

        return mThumbIds.length;
    }

    public Object getItem(int position) {

        return null;
    }

    public long getItemId(int position) {

        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.custom_grid, null);
//            TextView text1 (TextView) grid.findViewById(R.id.firstLine);
            TextView textView = (TextView) grid.findViewById(R.id.firstLine2);
            ImageView imageView = (ImageView) grid.findViewById(R.id.icon2);
            textView.setText("This img is: "+position);

            TextView textView2 = (TextView) grid.findViewById(R.id.secondLine2);
            textView2.setText("more information");

//            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(96, 96));
//            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setAdjustViewBounds(true);
//            imageView.setPadding(8, 8, 8, 8);
            imageView.setImageResource(mThumbIds[position]);

        } else {
//            imageView = (ImageView) convertView;
            grid =(View) convertView;
        }

//        imageView.setImageResource(mThumbIds[position]);
        return grid;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.ic_dino, R.drawable.ic_girl,
            R.drawable.ic_dude, R.drawable.ic_mario,
            R.drawable.ic_eva01
    };

}
