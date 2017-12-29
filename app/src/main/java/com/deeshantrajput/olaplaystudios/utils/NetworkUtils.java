package com.deeshantrajput.olaplaystudios.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.deeshantrajput.olaplaystudios.activities.Application;


public class NetworkUtils {

    public static boolean isNetworkAvailable(){
        Context context = Application.getContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo!=null && networkInfo.isConnected();
    }
}
