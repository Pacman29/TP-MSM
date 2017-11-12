package com.tp.tp_msm.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by pacman29 on 12.11.17.
 */

public class Response {
    @Nullable private Object mAnswer;

    private Integer mRequestResult;

    public Response() {
        mRequestResult = 500;
    }

    @NonNull
    public int getRequestResult() {
        return mRequestResult;
    }

    public Response setRequestResult(@NonNull Integer requestResult) {
        mRequestResult = requestResult;
        return this;
    }

    @Nullable
    public <T> T getTypedAnswer() {
        if (mAnswer == null) {
            return null;
        }
        //noinspection unchecked
        return (T) mAnswer;
    }

    @NonNull
    public Response setAnswer(@Nullable Object answer) {
        mAnswer = answer;
        return this;
    }

    public void save(@NonNull Context context) {
    }
}
