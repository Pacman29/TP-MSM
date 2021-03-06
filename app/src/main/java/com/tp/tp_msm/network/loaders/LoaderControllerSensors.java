package com.tp.tp_msm.network.loaders;

import android.content.Context;

import com.tp.tp_msm.network.APIService.APIService;
import com.tp.tp_msm.network.APIService.responses.ResponseBaseReal;
import com.tp.tp_msm.network.APIService.responses.ResponseControllerSensors;
import com.tp.tp_msm.network.APIService.responses.ResponseUserInfo;
import com.tp.tp_msm.network.BaseLoader;
import com.tp.tp_msm.network.Response;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by pacman29 on 13.11.17.
 */

public class LoaderControllerSensors extends BaseLoader{
    private String controllerId;

    public LoaderControllerSensors(Context context, String controllerId) {
        super(context);
        this.controllerId = controllerId;
    }

    @Override
    protected Response apiCall() throws IOException {
        APIService service = APIService.getInstance();
        Call<ResponseControllerSensors> call = service.controllers().getSensors(this.controllerId);
        retrofit2.Response<ResponseControllerSensors> response = call.execute();
        Response ret;

        ResponseBody body;
        if(response.code() < 300 && response.code() >= 200) {
            ret =  new Response(response.body());
        } else {
            body = response.errorBody();
            ret =  new Response(parser(ResponseBaseReal.class, body.string()));
        }
        ret.setRequestResult(response.code());
        return ret;
    }
}
