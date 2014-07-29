package com.example.testapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by gutierrezf on 7/24/2014.
 */
public class fragTwo extends Fragment implements View.OnClickListener {
    TextView tview;
    View rootView;
    private boolean clicked_b1;
    private boolean clicked_b2;
    Button button2, button1;
    Intent update;
    private final String TAG = "updateBroadcast";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragtwo, container, false);
        tview = (TextView)rootView.findViewById(R.id.text1);

        button1 = (Button) rootView.findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = (Button) rootView.findViewById(R.id.button2);
        button2.setOnClickListener(this);
        update = new Intent(getActivity().getApplicationContext(), testService.class);
        return rootView;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button1:
                if( !clicked_b1) {
                    tview.setText("changes");
                  rootView.setBackgroundColor(Color.parseColor("#FFFFC66C"));
                    clicked_b1 = !clicked_b1;
                }
                else{
                    tview.setText("more changes");
                    rootView.setBackgroundColor(Color.parseColor("#ff65ffc1"));
                    clicked_b1 = !clicked_b1;
                }
                break;
            case R.id.button2:
                if( !clicked_b2) {
                    getActivity().startService(update);
                    getActivity().registerReceiver(broadcastReceiver, new IntentFilter(TAG));
//                    Toast.makeText(getActivity().getApplicationContext(), "Clicked button",Toast.LENGTH_LONG);
                    Log.e("BUTTON2", "pressed");
                    button2.setText("Stop Service");
                    clicked_b2 = !clicked_b2;
                }
                else {
                    getActivity().unregisterReceiver(broadcastReceiver);
                    getActivity().stopService(update);
                    button2.setText("Start Service");
                    clicked_b2 = !clicked_b2;
                }
                break;
            default: Toast.makeText(getActivity().getApplicationContext(), "error",Toast.LENGTH_LONG);
                break;
        }
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateViewBackground(intent);
        }
    };

//    @Override
//    public void onResume(){
//        super.onPause();
//    }
//
//    @Override
//    public void onPause(){
//        super.onPause();
//    }

    private void updateViewBackground(Intent intent){
        String color = intent.getStringExtra("newColor");
        rootView.setBackgroundColor(Color.parseColor(color));
    }

}
