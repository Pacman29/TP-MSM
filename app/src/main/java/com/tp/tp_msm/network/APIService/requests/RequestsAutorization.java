package com.tp.tp_msm.network.APIService.requests;

import com.tp.tp_msm.network.APIService.responses.ResponseBaseReal;
import com.tp.tp_msm.network.APIService.responses.ResponseBaseSpec;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by pacman29 on 12.11.17.
 */

public interface RequestsAutorization {
    @POST("/user/sign_in")
    Call<ResponseBaseReal> postAutorization(@Body RequestBodyAutorization body);
}
