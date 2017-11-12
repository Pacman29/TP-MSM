package com.tp.tp_msm.network.APIService.responses;

import com.google.gson.annotations.SerializedName;
import com.tp.tp_msm.network.Response;

/**
 * Created by pacman29 on 12.11.17.
 */

public class ResponseSensorStats {

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

    public static class Stats {
        @SerializedName("current_month")
        private int current_month;
        @SerializedName("prev_year_month")
        private int prev_year_month;
        @SerializedName("prev_year_average")
        private int prev_year_average;

        public int getCurrent_month() {
            return current_month;
        }

        public void setCurrent_month(int current_month) {
            this.current_month = current_month;
        }

        public int getPrev_year_month() {
            return prev_year_month;
        }

        public void setPrev_year_month(int prev_year_month) {
            this.prev_year_month = prev_year_month;
        }

        public int getPrev_year_average() {
            return prev_year_average;
        }

        public void setPrev_year_average(int prev_year_average) {
            this.prev_year_average = prev_year_average;
        }
    }

    public static class Msg {
        @SerializedName("type")
        private int type;
        @SerializedName("name")
        private String name;
        @SerializedName("status")
        private int status;
        @SerializedName("accural")
        private int accural;
        @SerializedName("over")
        private int over;
        @SerializedName("result")
        private int result;
        @SerializedName("stats")
        private Stats stats;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getAccural() {
            return accural;
        }

        public void setAccural(int accural) {
            this.accural = accural;
        }

        public int getOver() {
            return over;
        }

        public void setOver(int over) {
            this.over = over;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public Stats getStats() {
            return stats;
        }

        public void setStats(Stats stats) {
            this.stats = stats;
        }
    }
}
