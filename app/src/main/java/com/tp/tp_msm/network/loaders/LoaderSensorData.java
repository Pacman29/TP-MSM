package com.tp.tp_msm.network.loaders;

import android.content.Context;
import android.content.Intent;

import com.tp.tp_msm.network.APIService.APIService;
import com.tp.tp_msm.network.APIService.responses.ResponseBaseReal;
import com.tp.tp_msm.network.APIService.responses.ResponseControllerStats;
import com.tp.tp_msm.network.APIService.responses.ResponseSensorData;
import com.tp.tp_msm.network.BaseLoader;
import com.tp.tp_msm.network.Response;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by pacman29 on 13.11.17.
 */

public class LoaderSensorData extends BaseLoader{
    private String sensorId;
    private String date;
    private Integer limit;

    public LoaderSensorData(Context context, String sensorId, String date, Integer limit) {
        super(context);
        this.sensorId = sensorId;
        this.date = date;
        this.limit = limit;
    }

    @Override
    protected Response apiCall() throws IOException {
        APIService service = APIService.getInstance();
        Call<ResponseSensorData> call = service.sensors().getSensorData(this.sensorId,this.date,this.limit);
        retrofit2.Response<ResponseSensorData> response = call.execute();
        Response ret =  new Response();
        ret.setRequestResult(response.code());
        ResponseBody body;
        if(response.code() < 300 && response.code() >= 200) {
            ret.setAnswer(response.body());
        } else {
            body = (ResponseBody) response.errorBody();
            ret.setAnswer(parser(ResponseBaseReal.class, body.string()));
        }
        return ret;
    }
}
