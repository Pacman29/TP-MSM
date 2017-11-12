package com.tp.tp_msm;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tp.tp_msm.network.APIService.BundleFabric;
import com.tp.tp_msm.network.APIService.responses.ResponseBaseReal;
import com.tp.tp_msm.network.Response;
import com.tp.tp_msm.network.loaders.LoaderAutorization;
import com.tp.tp_msm.network.loaders.LoaderControllerSensors;
import com.tp.tp_msm.network.loaders.LoaderControllerStats;
import com.tp.tp_msm.network.loaders.LoaderSensorData;
import com.tp.tp_msm.network.loaders.LoaderSensorStats;
import com.tp.tp_msm.network.loaders.LoaderUserControllers;
import com.tp.tp_msm.network.loaders.LoaderUserInfo;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Response>{

    private static final String TAG = MainActivity.class.getSimpleName();
    private final BundleFabric bundleFabric = BundleFabric.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLoaderManager().initLoader(R.id.loader_sensor_stats,
                bundleFabric.getSensorStatsBundle("1"),
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
            case R.id.loader_user_info: {
                return new LoaderUserInfo(this);
            }
            case R.id.loader_user_controllers: {
                return new LoaderUserControllers(this);
            }
            case R.id.loader_controller_sensors: {
                return new LoaderControllerSensors(this,
                        bundle.getString("controllerId"));
            }
            case R.id.loader_controller_stats: {
                return new LoaderControllerStats(this,
                        bundle.getString("controllerId"));
            }
            case R.id.loader_sensor_data: {
                return new LoaderSensorData(this,
                        bundle.getString("sensorId"),
                        bundle.getString("date"),
                        bundle.getInt("limit"));
            }
            case R.id.loader_sensor_stats: {
                return new LoaderSensorStats(this,
                        bundle.getString("sensorId"));
            }
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Response> loader, Response response) {
        int id = loader.getId();
        if(response.getRequestResult() < 300){
            switch (id) {
                case R.id.loader_autorization:{
                    break;
                }
                case R.id.loader_user_info:{
                    break;
                }
                case R.id.loader_user_controllers:{
                    break;
                }
                case R.id.loader_controller_sensors:{
                    break;
                }
                case R.id.loader_controller_stats:{
                    break;
                }
                case R.id.loader_sensor_data:{
                    break;
                }
                case R.id.loader_sensor_stats:{
                    break;
                }
            }
        } else {
            ResponseBaseReal error = response.getTypedAnswer();
            Log.d(TAG,error.getMessage().getErrorMessage());
        }

        getLoaderManager().destroyLoader(id);
    }

    @Override
    public void onLoaderReset(Loader<Response> loader) {

    }
}
