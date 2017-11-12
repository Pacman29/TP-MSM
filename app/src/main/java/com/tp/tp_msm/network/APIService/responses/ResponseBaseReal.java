package com.tp.tp_msm.network.APIService.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pacman29 on 12.11.17.
 */

public class ResponseBaseReal {
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private ResponseBaseReal.Msg msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResponseBaseReal.Msg getMessage() {
        return msg;
    }

    public void setMessage(ResponseBaseReal.Msg msg) {
        this.msg = msg;
    }

    public static class Msg {
        @SerializedName("error message")
        private String message;

        public String getErrorMessage() {
            return message;
        }

        public void setErrorMessage(String message) {
            this.message = message;
        }
    }
}
