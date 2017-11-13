package com.tp.tp_msm.network.APIService;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;

import com.tp.tp_msm.network.APIService.requests.RequestsAutorization;
import com.tp.tp_msm.network.APIService.requests.RequestsController;
import com.tp.tp_msm.network.APIService.requests.RequestsSensor;
import com.tp.tp_msm.network.APIService.requests.RequestsUser;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
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
        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60 * 5, TimeUnit.SECONDS)
                .readTimeout(60 * 5, TimeUnit.SECONDS)
                .writeTimeout(60 * 5, TimeUnit.SECONDS);
        okHttpClient.interceptors().add(new AddCookiesInterceptor());
        okHttpClient.interceptors().add(new ReceivedCookiesInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .client(okHttpClient.build())
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

    public static HashSet<String> getCookies(Context context) {
        SharedPreferences mcpPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return (HashSet<String>) mcpPreferences.getStringSet("cookies", new HashSet<String>());
    }

    public static boolean setCookies(Context context, HashSet<String> cookies) {
        SharedPreferences mcpPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = mcpPreferences.edit();
        return editor.putStringSet("cookies", cookies).commit();
    }
}
