package com.example.testapp;

/**
 * Created by gutierrezf on 7/29/2014.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public CustomArrayAdapter(Context context, String[] values) {
        super(context, R.layout.informative_list, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.informative_list, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.firstLine);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);

        TextView textView2 = (TextView) rowView.findViewById(R.id.secondLine);
        textView2.setText("more information");
        // change the icon for Windows and iPhone
        String s = values[position];
        if (s.startsWith("iPhone")) {
            imageView.setImageResource(R.drawable.bus);
        } else {
            imageView.setImageResource(R.drawable.bus);
        }

        return rowView;
    }
}
