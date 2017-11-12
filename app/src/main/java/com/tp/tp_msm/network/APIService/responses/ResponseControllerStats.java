package com.tp.tp_msm.network.APIService.responses;

import com.google.gson.annotations.SerializedName;
import com.tp.tp_msm.network.Response;

/**
 * Created by pacman29 on 12.11.17.
 */

public class ResponseControllerStats {

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
        @SerializedName("controller_id")
        private int controller_id;
        @SerializedName("month")
        private int month;
        @SerializedName("prev_month")
        private int prev_month;
        @SerializedName("prev_year")
        private int prev_year;

        public int getController_id() {
            return controller_id;
        }

        public void setController_id(int controller_id) {
            this.controller_id = controller_id;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getPrev_month() {
            return prev_month;
        }

        public void setPrev_month(int prev_month) {
            this.prev_month = prev_month;
        }

        public int getPrev_year() {
            return prev_year;
        }

        public void setPrev_year(int prev_year) {
            this.prev_year = prev_year;
        }
    }
}
