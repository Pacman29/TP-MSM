package com.tp.tp_msm.network.APIService.responses;

import com.google.gson.annotations.SerializedName;
import com.tp.tp_msm.network.Response;

import java.util.List;

/**
 * Created by pacman29 on 12.11.17.
 */

public class ResponseUserControllers {

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
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("user_id")
        private int user_id;
        @SerializedName("adres")
        private String adres;
        @SerializedName("activation_date")
        private String activation_date;
        @SerializedName("status")
        private int status;
        @SerializedName("mac")
        private String mac;
        @SerializedName("deactivation_date")
        private String deactivation_date;
        @SerializedName("controller_type")
        private int controller_type;

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

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getAdres() {
            return adres;
        }

        public void setAdres(String adres) {
            this.adres = adres;
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

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getDeactivation_date() {
            return deactivation_date;
        }

        public void setDeactivation_date(String deactivation_date) {
            this.deactivation_date = deactivation_date;
        }

        public int getController_type() {
            return controller_type;
        }

        public void setController_type(int controller_type) {
            this.controller_type = controller_type;
        }
    }
}
