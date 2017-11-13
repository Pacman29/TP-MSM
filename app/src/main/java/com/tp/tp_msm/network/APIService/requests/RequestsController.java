package com.tp.tp_msm.network.APIService.requests;

import com.tp.tp_msm.network.APIService.responses.ResponseControllerSensors;
import com.tp.tp_msm.network.APIService.responses.ResponseControllerStats;
import com.tp.tp_msm.network.APIService.responses.ResponseUserControllers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by pacman29 on 12.11.17.
 */

public interface RequestsController {
    @GET("/controller/get_user_controllers")
    Call<ResponseUserControllers> getUserControllers();

    @GET("/controller/{controller_id}/get_sensors")
    Call<ResponseControllerSensors> getSensors(@Path("controller_id") String controller_id);

    @GET("/controller/{controller_id}/get_controller_stats")
    Call<ResponseControllerStats> getControllerStats(@Path("controller_id") String controller_id);
}
