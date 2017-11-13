package com.tp.tp_msm.network.APIService.responses;

import com.google.gson.annotations.SerializedName;
import com.tp.tp_msm.network.Response;

import java.util.List;

/**
 * Created by pacman29 on 12.11.17.
 */

public class ResponseControllerSensors {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
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
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("controller_id")
        private int controller_id;
        @SerializedName("activation_date")
        private String activation_date;
        @SerializedName("status")
        private int status;
        @SerializedName("deactivation_date")
        private String deactivation_date;
        @SerializedName("sensor_type")
        private int sensor_type;
        @SerializedName("company")
        private String company;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getController_id() {
            return controller_id;
        }

        public void setController_id(int controller_id) {
            this.controller_id = controller_id;
        }

        public String getActivation_date() {
            return activation_date;
        }

        public void setActivation_date(String activation_date) {
            this.activation_date = activation_date;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getDeactivation_date() {
            return deactivation_date;
        }

        public void setDeactivation_date(String deactivation_date) {
            this.deactivation_date = deactivation_date;
        }

        public int getSensor_type() {
            return sensor_type;
        }

        public void setSensor_type(int sensor_type) {
            this.sensor_type = sensor_type;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }
    }
}
