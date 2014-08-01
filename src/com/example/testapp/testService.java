package com.example.testapp;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.Log;
/**
 * Created by gutierrezf on 7/29/2014.
 */
public class testService extends Service {
    Vibrator v;

    public Location location;
    private boolean RUNNING;
    private Intent update;
    private final String TAG = "updateBroadcast";
//    public GPSTracker gps;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.e("Service","started");
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        update = new Intent(TAG);
        performOnBackgroundThread();
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy(){
       RUNNING = true;
        super.onDestroy();
    }
    public void performOnBackgroundThread()
    {
        Log.e(this.getClass().toString(),"in thread 1st time");
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                try
                { Log.e("inRange","in thread");

                    double i = 0;
                    String color = "#FFFFC66C";
                    boolean switcher = true;
                    while(!RUNNING){
                         if(i > 59000500)
                            {
                                if(switcher)
                                    color = "#FFFFC66C";
                                else
                                    color = "#ff65ffc1";

                                Log.e("vibrate","in thread");
                                v.vibrate(300);

                                update.putExtra("newColor", color);
                                sendBroadcast(update);
                                switcher = !switcher;
                                i = 0;
                            }
                            i+= 0.5;
                    }
                }

                finally
                {

                }
            }
        };
        new Thread(runnable).start();

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

}
