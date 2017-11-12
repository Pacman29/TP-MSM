package com.tp.tp_msm.network.APIService.requests;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by pacman29 on 12.11.17.
 */

public interface RequestsController {
    @GET("/controller/get_user_controllers")
    Call<Object> getUserControllers();

    @GET("/controller/{controller_id}/get_sensors")
    Call<Object> getSensors(@Path("controller_id") String controller_id);

    @GET("/controller/{controller_id}/get_controller_stats")
    Call<Object> getControllerStats(@Path("controller_id") String controller_id);
}
