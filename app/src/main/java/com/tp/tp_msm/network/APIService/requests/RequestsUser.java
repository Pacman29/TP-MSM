package com.tp.tp_msm.network.APIService.requests;

import com.tp.tp_msm.network.APIService.responses.ResponseBaseSpec;
import com.tp.tp_msm.network.APIService.responses.ResponseUserInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by pacman29 on 12.11.17.
 */

public interface RequestsUser {
        @GET("/user/user_info")
    Call<ResponseUserInfo> getUserInfo();
}
