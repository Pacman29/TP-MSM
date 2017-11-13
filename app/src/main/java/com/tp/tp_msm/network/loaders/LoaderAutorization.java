package com.tp.tp_msm.network.loaders;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tp.tp_msm.network.APIService.APIService;
import com.tp.tp_msm.network.APIService.requests.RequestBodyAutorization;
import com.tp.tp_msm.network.APIService.responses.ResponseBaseReal;
import com.tp.tp_msm.network.APIService.responses.ResponseBaseSpec;
import com.tp.tp_msm.network.BaseLoader;
import com.tp.tp_msm.network.Response;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by pacman29 on 12.11.17.
 */

public class LoaderAutorization extends BaseLoader{
    private final String email;
    private final String password;
    public LoaderAutorization(Context context, String email, String password) {
        super(context);
        this.email = email;
        this.password = password;
    }

    @Override
    protected Response apiCall() throws IOException {
        APIService service = APIService.getInstance();
        Call<ResponseBaseReal> call = service.
                autorization().
                postAutorization(new RequestBodyAutorization(this.email,this.password));
        retrofit2.Response<ResponseBaseReal> response = call.execute();


        Response ret =  new Response();
        ret.setRequestResult(response.code());
        if(response.code() < 300 && response.code() >= 200)
            ret.setAnswer(response.body());
        else
            ret.setAnswer(parser(ResponseBaseReal.class,response.errorBody().string()));
        return ret;
    }
}
