package com.example.testapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by gutierrezf on 8/6/2014.
 */
public class ImageGridAdapter extends BaseAdapter {
    private Context context;
    private int[] pix;
    private String[] names;
    private String[] colors;
    private ArrayList<String> status;
//    private int count = 0;
  //  private final String[] base64Code;
 //   private String[] names;
    private Integer[] userPix;
//    private Bitmap userBit;

    public ImageGridAdapter(Context context, int[] pics, String[] names, String[] colors) {
      //  mContext = c;
        this.context = context;
        this.colors = colors;
        this.names = names;
        this.pix = pics;
    }

    public int getCount() {

        return pix.length;
    }

    public Object getItem(int position) {

        return position;
    }

    public long getItemId(int position) {

        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            grid = new View(context);
            grid = inflater.inflate(R.layout.custom_grid2, null);
            grid.setBackgroundColor(Color.parseColor("#FFE5E5E5"));
            Drawable stat = grid.getResources().getDrawable(R.drawable.rounded_rectangle);

            ImageView imageView = (ImageView) grid.findViewById(R.id.g_user);

//            Log.e("DATALEN", "name " + names[position] + " " + names.size() + " " + names.toString());

            LinearLayout li = (LinearLayout) grid.findViewById(R.id.stat_bar);

//            Bitmap userBit = convertToImage(pix[position]);

            imageView.setImageResource(pix[position]);
            imageView.getLayoutParams().height = 250;
            imageView.getLayoutParams().width = 260;

            imageView.setAdjustViewBounds(true);
//            imageView.setPadding(8, 8, 8, 8);

            stat.setColorFilter(Color.parseColor(colors[position]), PorterDuff.Mode.SRC_ATOP);
            li.setBackground(stat);

        } else {
//            imageView = (ImageView) convertView;
            grid =(View) convertView;
        }

//        imageView.setImageResource(mThumbIds[position]);
        return grid;
    }


	private Bitmap convertToImage(String userPicBase64) {
		// TODO Auto-generated method stub			 
			  InputStream stream = new ByteArrayInputStream(Base64.decode(userPicBase64.getBytes(), Base64.DEFAULT)); ////////////////////////////////////!!!!!!!!!!!!
			  Bitmap b = BitmapFactory.decodeStream(stream);
			  b.setDensity(Bitmap.DENSITY_NONE);
			  return b;
			}

    // references to our images
//    private Integer[] mThumbIds = {
//            R.drawable.ic_dino, R.drawable.ic_girl,
//            R.drawable.ic_dude, R.drawable.ic_mario,
//            R.drawable.ic_eva01
//    };

}
