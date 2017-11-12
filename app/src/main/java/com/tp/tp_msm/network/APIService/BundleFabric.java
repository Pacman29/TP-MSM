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
}
