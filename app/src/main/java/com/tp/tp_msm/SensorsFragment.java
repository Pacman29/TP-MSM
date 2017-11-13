package com.tp.tp_msm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SensorsFragment extends Fragment  implements View.OnClickListener, LoaderManager.LoaderCallbacks<Response>{
    private View view;
    private final BundleFabric bundleFabric = BundleFabric.getInstance();
    private static final String TAG = AutorizationFragment.class.getSimpleName();

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.button_get_sensor_data)
    Button buttonGetSensorData;

    @BindView(R.id.button_get_sensor_stats)
    Button buttonGetSensorStats;

    @BindView(R.id.text_request_sensors)
    TextView request;

    @BindView(R.id.date)
    EditText date;

    @BindView(R.id.limit)
    EditText limit;

    @BindView(R.id.sensorId)
    EditText sensorId;

    public SensorsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sensors, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.button_get_sensor_data)
    public void onClickButtonGetControllerSensors(){
        String sensorId = String.valueOf(this.sensorId.getText());
        String date = String.valueOf(this.date.getText());
        String slimit = String.valueOf(this.limit.getText());

        if(sensorId.equals("") || date.equals("") || slimit.equals(""))
            return;

        Integer limit = Integer.valueOf(slimit);
        getLoaderManager().initLoader(R.id.loader_sensor_data,
                bundleFabric.getSensorDataBundle(sensorId,date,limit),
                this);
    }

    @OnClick(R.id.button_get_sensor_stats)
    public void onClickButtonGetControllerStats(){
        String sensorId = String.valueOf(this.sensorId.getText());
        if(sensorId.equals(""))
            return;
        getLoaderManager().initLoader(R.id.loader_sensor_stats,
                bundleFabric.getSensorStatsBundle(sensorId),
                this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public Loader<Response> onCreateLoader(int id, Bundle bundle) {
        switch (id) {
            case R.id.loader_sensor_data: {
                return new LoaderSensorData(this.getContext(),
                        bundle.getString("sensorId"),
                        bundle.getString("date"),
                        bundle.getInt("limit"));
            }
            case R.id.loader_sensor_stats: {
                return new LoaderSensorStats(this.getContext(),bundle.getString("sensorId"));
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
            //Log.d(TAG,error.getMessage().getErrorMessage());
            Gson gson = new Gson();
            request.setText(gson.toJson(error));

        }

        getLoaderManager().destroyLoader(id);
    }

    @Override
    public void onLoaderReset(Loader<Response> loader) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
