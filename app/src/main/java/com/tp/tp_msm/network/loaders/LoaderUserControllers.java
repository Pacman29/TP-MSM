package com.tp.tp_msm.network.loaders;

import android.content.Context;

import com.tp.tp_msm.network.APIService.APIService;
import com.tp.tp_msm.network.APIService.responses.ResponseBaseReal;
import com.tp.tp_msm.network.APIService.responses.ResponseUserControllers;
import com.tp.tp_msm.network.APIService.responses.ResponseUserInfo;
import com.tp.tp_msm.network.BaseLoader;
import com.tp.tp_msm.network.Response;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by pacman29 on 13.11.17.
 */

public class LoaderUserControllers extends BaseLoader{
    public LoaderUserControllers(Context context) {
        super(context);
    }

    @Override
    protected Response apiCall() throws IOException {
        APIService service = APIService.getInstance();
        Call<ResponseUserControllers> call = service.controllers().getUserControllers();
        retrofit2.Response<ResponseUserControllers> response = call.execute();
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
