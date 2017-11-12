package com.tp.tp_msm.network.APIService.responses;

import com.google.gson.annotations.SerializedName;
import com.tp.tp_msm.network.Response;

/**
 * Created by pacman29 on 12.11.17.
 */

public class ResponseUserInfo {

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
        @SerializedName("family_name")
        private String family_name;
        @SerializedName("name")
        private String name;
        @SerializedName("second_name")
        private String second_name;
        @SerializedName("date_receiving")
        private String date_receiving;
        @SerializedName("issued_by")
        private String issued_by;
        @SerializedName("division_number")
        private String division_number;
        @SerializedName("registration_addres")
        private String registration_addres;
        @SerializedName("mailing_addres")
        private String mailing_addres;
        @SerializedName("birth_day")
        private String birth_day;
        @SerializedName("sex")
        private boolean sex;
        @SerializedName("home_phone")
        private String home_phone;
        @SerializedName("mobile_phone")
        private String mobile_phone;
        @SerializedName("citizenship")
        private String citizenship;
        @SerializedName("e_mail")
        private String e_mail;

        public String getFamily_name() {
            return family_name;
        }

        public void setFamily_name(String family_name) {
            this.family_name = family_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSecond_name() {
            return second_name;
        }

        public void setSecond_name(String second_name) {
            this.second_name = second_name;
        }

        public String getDate_receiving() {
            return date_receiving;
        }

        public void setDate_receiving(String date_receiving) {
            this.date_receiving = date_receiving;
        }

        public String getIssued_by() {
            return issued_by;
        }

        public void setIssued_by(String issued_by) {
            this.issued_by = issued_by;
        }

        public String getDivision_number() {
            return division_number;
        }

        public void setDivision_number(String division_number) {
            this.division_number = division_number;
        }

        public String getRegistration_addres() {
            return registration_addres;
        }

        public void setRegistration_addres(String registration_addres) {
            this.registration_addres = registration_addres;
        }

        public String getMailing_addres() {
            return mailing_addres;
        }

        public void setMailing_addres(String mailing_addres) {
            this.mailing_addres = mailing_addres;
        }

        public String getBirth_day() {
            return birth_day;
        }

        public void setBirth_day(String birth_day) {
            this.birth_day = birth_day;
        }

        public boolean getSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }

        public String getHome_phone() {
            return home_phone;
        }

        public void setHome_phone(String home_phone) {
            this.home_phone = home_phone;
        }

        public String getMobile_phone() {
            return mobile_phone;
        }

        public void setMobile_phone(String mobile_phone) {
            this.mobile_phone = mobile_phone;
        }

        public String getCitizenship() {
            return citizenship;
        }

        public void setCitizenship(String citizenship) {
            this.citizenship = citizenship;
        }

        public String getE_mail() {
            return e_mail;
        }

        public void setE_mail(String e_mail) {
            this.e_mail = e_mail;
        }
    }
}
