package com.tp.tp_msm.network.APIService.requests;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pacman29 on 12.11.17.
 */

public class RequestBodyAutorization {

    @SerializedName("e_mail")
    private String e_mail;
    @SerializedName("password")
    private String password;

    public RequestBodyAutorization(String e_mail, String password) {
        this.e_mail = e_mail;
        this.password = password;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
