package com.example.q_thjen.networklistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

/**
 * Created by q-thjen on 12/17/17.
 */

public class NetworkStateChangeReceiver extends BroadcastReceiver {

    public static final String NETWORK_AVAILABLE_ACTION = "com.ajit.singh.NetworkAvailable";
    public static final String IS_NETWORK_AVAILABLE = "isNetworkAvailable";

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent networkState = new Intent(NETWORK_AVAILABLE_ACTION);
        networkState.putExtra(IS_NETWORK_AVAILABLE, isConnectedToInternet(context));
        LocalBroadcastManager.getInstance(context).sendBroadcast(networkState);

    }

    private boolean isConnectedToInternet(Context context) {

        try {
            if ( context != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                return networkInfo != null && networkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

}
