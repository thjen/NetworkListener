package com.example.q_thjen.networklistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter(NetworkStateChangeReceiver.NETWORK_AVAILABLE_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                boolean isNetworkAvailable = intent.getBooleanExtra(NetworkStateChangeReceiver.IS_NETWORK_AVAILABLE, false);
                String networkState = isNetworkAvailable ? "Connected" : "Disconnect";

                Toast.makeText(context, "Network status" + networkState, Toast.LENGTH_SHORT).show();

            }
        }, intentFilter);


    }
}
