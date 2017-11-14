package com.tp.tp_msm.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by pacman29 on 12.11.17.
 */

public class Response {
    private Object mAnswer;

    private Integer mRequestResult;

    public Response(@NonNull Object mAnswer) {
        mRequestResult = 500;
        this.mAnswer = mAnswer;
    }

    @NonNull
    public int getRequestResult() {
        return mRequestResult;
    }

    public Response setRequestResult(@NonNull Integer requestResult) {
        mRequestResult = requestResult;
        return this;
    }

    public <T> T getTypedAnswer() {
        return (T) mAnswer;
    }

    public void save(@NonNull Context context) {
    }
}
