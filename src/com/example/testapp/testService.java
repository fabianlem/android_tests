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
    public String IN_RANGE = "IN_RANGE";
    public Boolean inrange;
    public LocationManager locationManager;
    public String provider;
    public Criteria criteria;
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
        //v.vibrate(300);
//        inrange = (Boolean) intent.getSerializableExtra(IN_RANGE);
        update = new Intent(TAG);
        performOnBackgroundThread();
//		Toast.makeText(getApplicationContext(), "Hello from VibratingService", Toast.LENGTH_LONG).show();

        // Get the location manager
//        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Define the criteria how to select the location provider -> use
        // default
//        gps = new GPSTracker(testService.this);
//    	LocationListener locationListener = new LocationListener() {
//	    public void onLocationChanged(Location location) {
//	      // Called when a new location is found by the network location provider.
//	    //  makeUseOfNewLocation(location);
//	    	//Log.e("Location",location.getLatitude() + "   "+ location.getLongitude() );
////	    	Toast.makeText(getApplicationContext(), location.getLatitude() + "   "+ location.getLongitude(), Toast.LENGTH_LONG).show();
//	    }
//
//	    public void onStatusChanged(String provider, int status, Bundle extras) {
//
//	    }
//
//	    public void onProviderEnabled(String provider) {
//	    }
//
//	    public void onProviderDisabled(String provider) {
//	    }
//	  };


//        criteria = new Criteria();
//        //provider = locationManager.getBestProvider(criteria, false);
//        String locationProvider = LocationManager.GPS_PROVIDER;
//        location = locationManager.getLastKnownLocation(locationProvider);

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
                {
//	            	LocationListener locationListener = new LocationListener() {
//	            	    public void onLocationChanged(Location location) {
//	            	      // Called when a new location is found by the network location provider.
//	            	    //  makeUseOfNewLocation(location);
//	            	    	Log.e("Location",location.getLatitude() + "   "+ location.getLongitude() );
//	            	    }
//
//	            	    public void onStatusChanged(String provider, int status, Bundle extras) {}
//
//	            	    public void onProviderEnabled(String provider) {}
//
//	            	    public void onProviderDisabled(String provider) {}
//	            	  };



//                    Log.e(this.getClass().toString(),"in thread");

                    Log.e("inRange","in thread");

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
//                                Location a = gps.getLocation();

                                switcher = !switcher;
//                                Log.e("inRange", MonitoringActivity.inrange.toString());
                                //gps = new GPSTracker(VibrateService.this);
                                i = 0;
                            }
                            i+= 0.5;
//                        }

//                        else
//                        {
//                            Log.i("inRange", "nothing");
//                        }

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
