package com.tp.tp_msm.network;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tp.tp_msm.network.APIService.responses.ResponseBaseReal;

import java.io.IOException;

/**
 * Created by pacman29 on 12.11.17.
 */

public abstract class BaseLoader extends AsyncTaskLoader<Response> {
    public BaseLoader(Context context) {
        super(context);
    }
    private static final Gson GSON = new GsonBuilder().create();
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public Response loadInBackground() {
        try {
            Response response = apiCall();
            if(response.getRequestResult() < 300){
                response.save(getContext());
                onSuccess();
            } else {
                onError();
            }
            return response;
        } catch (IOException e) {
            onError();
            return new Response();
        }
    }

    protected void onSuccess(){}

    protected void onError(){}

    protected abstract Response apiCall() throws IOException;

    public  <T> T parser(Class<T> type,final String body){
        return GSON.fromJson(body,type);
    }

}
