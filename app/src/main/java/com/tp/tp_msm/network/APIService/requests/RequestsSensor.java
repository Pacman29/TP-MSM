package com.tp.tp_msm.network.APIService.requests;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by pacman29 on 12.11.17.
 */

public interface RequestsSensor {
    @GET("/sensor/{sensor_id}/view_stats")
    Call<Object> getSensorStats(@Path("sensor_id") String sensor_id);

    @GET("/sensor/{sensor_id}/get_data")
    Call<Object> getSensorData(@Path("sensor_id") String sensor_id,
                               @Query("date") String date,
                               @Query("limit") Integer limit);
}
