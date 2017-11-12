package com.tp.tp_msm.network.APIService.responses;

import com.google.gson.annotations.SerializedName;
import com.tp.tp_msm.network.Response;

/**
 * Created by pacman29 on 12.11.17.
 */

public class ResponseBaseSpec {

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private Msg msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Msg getMsg() {
        return msg;
    }

    public void setMsg(Msg msg) {
        this.msg = msg;
    }

    public static class Msg {
        @SerializedName("message")
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
