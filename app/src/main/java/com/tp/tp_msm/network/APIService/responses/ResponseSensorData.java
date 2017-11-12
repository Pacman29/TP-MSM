package com.tp.tp_msm.network.APIService.responses;

import com.google.gson.annotations.SerializedName;
import com.tp.tp_msm.network.Response;

import java.util.List;

/**
 * Created by pacman29 on 12.11.17.
 */

public class ResponseSensorData {

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private List<Msg> msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Msg> getMsg() {
        return msg;
    }

    public void setMsg(List<Msg> msg) {
        this.msg = msg;
    }

    public static class Msg {
        @SerializedName("sensor_id")
        private int sensor_id;
        @SerializedName("date")
        private String date;
        @SerializedName("value")
        private int value;
        @SerializedName("hash")
        private String hash;

        public int getSensor_id() {
            return sensor_id;
        }

        public void setSensor_id(int sensor_id) {
            this.sensor_id = sensor_id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }
    }
}
