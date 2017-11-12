package com.tp.tp_msm.network.loaders;

import android.content.Context;

import com.tp.tp_msm.network.APIService.APIService;
import com.tp.tp_msm.network.APIService.requests.RequestBodyAutorization;
import com.tp.tp_msm.network.APIService.responses.ResponseBaseReal;
import com.tp.tp_msm.network.APIService.responses.ResponseUserInfo;
import com.tp.tp_msm.network.BaseLoader;
import com.tp.tp_msm.network.Response;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by pacman29 on 13.11.17.
 */

public class LoaderUserInfo extends BaseLoader {
    public LoaderUserInfo(Context context) {
        super(context);
    }

    @Override
    protected Response apiCall() throws IOException {
        APIService service = APIService.getInstance();
        Call<Object> call = service.user().getUserInfo();
        retrofit2.Response<Object> response = call.execute();
        Response ret =  new Response();
        ret.setRequestResult(response.code());
        ResponseBody body;
        if(response.code() < 300) {
            body = (ResponseBody) response.body();
            ret.setAnswer(parser(ResponseUserInfo.class, body.string()));
        } else {
            body = (ResponseBody) response.errorBody();
            ret.setAnswer(parser(ResponseBaseReal.class, body.string()));
        }
        return ret;
    }
}
