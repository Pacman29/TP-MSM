package com.tp.tp_msm.network;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.io.IOException;

/**
 * Created by pacman29 on 12.11.17.
 */

public abstract class BaseLoader extends AsyncTaskLoader<Response> {
    public BaseLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public Response loadInBackground() {
        try {
            Response response = apiCall();
            if(response.getRequestResult() == 200){
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
}
