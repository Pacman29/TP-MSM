package com.tp.tp_msm;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tp.tp_msm.network.APIService.BundleFabric;
import com.tp.tp_msm.network.APIService.responses.ResponseBaseReal;
import com.tp.tp_msm.network.APIService.responses.ResponseBaseSpec;
import com.tp.tp_msm.network.Response;
import com.tp.tp_msm.network.loaders.LoaderAutorization;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Response>{

    private static final String TAG = MainActivity.class.getSimpleName();
    private final BundleFabric bundleFabric = BundleFabric.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLoaderManager().initLoader(R.id.loader_autorization,
                bundleFabric.getAutorizationBundle("test123@test.ru","password"),
                this);
    }

    @Override
    public Loader<Response> onCreateLoader(int id, Bundle bundle) {
        switch (id){
            case R.id.loader_autorization: {
                return new LoaderAutorization(this,
                        bundle.getString("email"),
                        bundle.getString("password"));
            }
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Response> loader, Response response) {
        int id = loader.getId();
        switch (id) {
            case R.id.loader_autorization:{
                ResponseBaseReal autorization = response.getTypedAnswer();
                Log.d(TAG,autorization.getMessage().getErrorMessage());
            }
        }
        getLoaderManager().destroyLoader(id);
    }

    @Override
    public void onLoaderReset(Loader<Response> loader) {

    }
}
