package com.tp.tp_msm.network.APIService;

import android.os.Bundle;

import com.tp.tp_msm.network.APIService.APIService;

/**
 * Created by pacman29 on 12.11.17.
 */

public class BundleFabric {
    private static volatile BundleFabric instance;

    public static BundleFabric getInstance() {
        BundleFabric localInstance = instance;
        if (localInstance == null) {
            synchronized (BundleFabric.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new BundleFabric();
                }
            }
        }
        return localInstance;
    }

    private BundleFabric(){}

    public Bundle getAutorizationBundle(String email,String password){
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("password",password);
        return bundle;
    }

    public Bundle getEmpty(){
        return Bundle.EMPTY;
    }

    public Bundle getControllerIdBundle(String controllerId){
        Bundle bundle = new Bundle();
        bundle.putString("controllerId",controllerId);
        return bundle;
    }

    public Bundle getSensorDataBundle(String sensorId, String date, Integer limit){
        Bundle bundle = new Bundle();
        bundle.putString("sensorId",sensorId);
        bundle.putString("date",date);
        bundle.putInt("limit",limit);
        return bundle;
    }

    public Bundle getSensorStatsBundle(String sensorId){
        Bundle bundle = new Bundle();
        bundle.putString("sensorId",sensorId);
        return bundle;
    }
}
