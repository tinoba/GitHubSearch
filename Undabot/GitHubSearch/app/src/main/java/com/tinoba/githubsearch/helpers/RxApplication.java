package com.tinoba.githubsearch.helpers;

import android.app.Application;

import com.tinoba.githubsearch.Network.NetworkService;

/**
 * Created by tinoba on 30.6.2016..
 */
public class RxApplication extends Application {
    private NetworkService networkService;
    @Override
    public void onCreate() {
        super.onCreate();
        networkService = new NetworkService();

    }
    public NetworkService getNetworkService(){
        return networkService;
    }
}
