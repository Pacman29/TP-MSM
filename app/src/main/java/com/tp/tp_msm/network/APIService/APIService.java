package com.tp.tp_msm.network.APIService;

import com.tp.tp_msm.network.APIService.requests.RequestsAutorization;
import com.tp.tp_msm.network.APIService.requests.RequestsController;
import com.tp.tp_msm.network.APIService.requests.RequestsSensor;
import com.tp.tp_msm.network.APIService.requests.RequestsUser;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pacman29 on 12.11.17.
 */

public class APIService {
    private RequestsAutorization requestsAutorization;
    private RequestsController requestsController;
    private RequestsSensor requestsSensor;
    private RequestsUser requestsUser;

    private static volatile APIService instance;

    public static APIService getInstance() {
        APIService localInstance = instance;
        if (localInstance == null) {
            synchronized (APIService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new APIService();
                }
            }
        }
        return localInstance;
    }

    // TODO : надо вынести хост в конфиг?
    private final String host = "http://194.58.120.31:8081";
    private APIService() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        requestsAutorization = retrofit.create(RequestsAutorization.class);
        requestsController = retrofit.create(RequestsController.class);
        requestsSensor = retrofit.create(RequestsSensor.class);
        requestsUser = retrofit.create(RequestsUser.class);
    }

    public RequestsAutorization autorization() {
        return requestsAutorization;
    }

    public RequestsController controllers() {
        return requestsController;
    }

    public RequestsSensor sensors() {
        return requestsSensor;
    }

    public RequestsUser user() {
        return requestsUser;
    }
}
