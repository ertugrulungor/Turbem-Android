package com.ertugrulungor.konumbelirle;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

/**
 * Created by macintosh on 9.04.2017.
 */

public class GPSBul implements LocationListener {
    private final Context mContext;

    private Location location = null;
    private boolean isGpsOn = false;
    private boolean isNetworkOn = false;

    LocationManager locationManager;

    private double latitute;
    private double longitude;
    private long time;
    private float speed;

    public GPSBul(Context context) {
        this.mContext = context;
        this.GetLocation();
    }

    public Location GetLocation() {
        locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);

        isGpsOn = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        Log.d("GpsAcildi", String.valueOf(isGpsOn));

        isNetworkOn = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        Log.d("NetworkAcildi", String.valueOf(isNetworkOn));

        if (isGpsOn == true || isNetworkOn == true) {
            if (isNetworkOn) {
                location = null;

                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return null;
                }
                locationManager.requestLocationUpdates(locationManager.NETWORK_PROVIDER, 1, 1, this);
                if(locationManager != null){
                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                    if(location != null){
                        latitute = location.getLatitude();
                        longitude = location.getLongitude();
                        time = location.getTime();
                    }
                }
            }

            if(isGpsOn){
                if(location == null){
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1,1,this);
                    if(locationManager != null){
                        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                        if(location != null){
                            latitute = location.getLatitude();
                            longitude = location.getLongitude();
                            time = location.getTime();
                            speed = location.getSpeed();
                        }
                    }
                }
            }
        }


        return location;
    }

    public double GetLatitute(){
        if (location != null){
            latitute = location.getLatitude();
        }

        return  latitute;
    }

    public double GetLongitude(){
        if(location != null) {
            longitude = location.getLongitude();
        }

        return longitude;
    }

    public long GetTime(){
        if(location != null) {
            time = location.getTime();
        }

        return time;
    }

    public float GetSpeed(){
        if(location != null) {
            speed = location.getSpeed();
        }
        return speed;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
