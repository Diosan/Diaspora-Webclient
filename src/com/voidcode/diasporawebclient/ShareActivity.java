package com.voidcode.diasporawebclient;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

public class ShareActivity extends MainActivity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo m3G = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mWifi.isConnected() || m3G.isConnected()) 
        {
        	// load: open a new messages
        	mWeb.loadUrl(main_domain+"/status_messages/new");
        }
        else
        {
        	// if user don�t have internet/ Wifi or 3G
        	setContentView(R.layout.setupinternet);
        }        	
    }
}