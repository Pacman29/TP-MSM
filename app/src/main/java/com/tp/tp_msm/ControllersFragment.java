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
import com.tp.tp_msm.network.APIService.responses.ResponseControllerSensors;
import com.tp.tp_msm.network.APIService.responses.ResponseControllerStats;
import com.tp.tp_msm.network.APIService.responses.ResponseUserControllers;
import com.tp.tp_msm.network.Response;
import com.tp.tp_msm.network.loaders.LoaderAutorization;
import com.tp.tp_msm.network.loaders.LoaderControllerSensors;
import com.tp.tp_msm.network.loaders.LoaderControllerStats;
import com.tp.tp_msm.network.loaders.LoaderUserControllers;
import com.tp.tp_msm.network.loaders.LoaderUserInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ControllersFragment extends Fragment  implements View.OnClickListener, LoaderManager.LoaderCallbacks<Response>{
    private View view;
    private final BundleFabric bundleFabric = BundleFabric.getInstance();
    private static final String TAG = AutorizationFragment.class.getSimpleName();

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.button_get_controller_sensors)
    Button buttonGetControllerSensors;

    @BindView(R.id.button_get_controller_stats)
    Button buttonGetControllerStats;

    @BindView(R.id.text_request_controllers)
    TextView request;

    @BindView(R.id.text_controllers)
    TextView controllers;

    @BindView(R.id.controllerId)
    EditText controllerId;

    public ControllersFragment() {
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
        view = inflater.inflate(R.layout.fragment_controllers, container, false);
        ButterKnife.bind(this,view);
        getLoaderManager().initLoader(R.id.loader_user_controllers,
                bundleFabric.getEmpty(),
                this);
        return view;
    }

    @OnClick(R.id.button_get_controller_sensors)
    public void onClickButtonGetControllerSensors(){
        String controllerId = String.valueOf(this.controllerId.getText());
        if(controllerId.equals(""))
            return;
        getLoaderManager().initLoader(R.id.loader_controller_sensors,
                bundleFabric.getControllerIdBundle(controllerId),
                this);
    }

    @OnClick(R.id.button_get_controller_stats)
    public void onClickButtonGetControllerStats(){
        String controllerId = String.valueOf(this.controllerId.getText());
        if(controllerId.equals(""))
            return;
        getLoaderManager().initLoader(R.id.loader_controller_stats,
                bundleFabric.getControllerIdBundle(controllerId),
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
            case R.id.loader_controller_sensors: {
                return new LoaderControllerSensors(this.getContext(),bundle.getString("controllerId"));
            }
            case R.id.loader_controller_stats: {
                return new LoaderControllerStats(this.getContext(),bundle.getString("controllerId"));
            }
            case R.id.loader_user_controllers: {
                return new LoaderUserControllers(this.getContext());
            }
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Response> loader, Response response) {
        int id = loader.getId();
        // нет соединения
        if(response.getRequestResult() == 500)
            return;
        if(response.getRequestResult() < 300){
            switch (id) {
                case R.id.loader_user_controllers:{
                    ResponseUserControllers responseUserControllers = response.getTypedAnswer();
                    Gson gson = new Gson();
                    controllers.setText(gson.toJson(responseUserControllers));
                    break;
                }
                case R.id.loader_controller_sensors:{
                    ResponseControllerSensors responseControllerSensors = response.getTypedAnswer();
                    Gson gson = new Gson();
                    request.setText(gson.toJson(responseControllerSensors));
                    break;
                }
                case R.id.loader_controller_stats:{
                    ResponseControllerStats responseControllerStats = response.getTypedAnswer();
                    Gson gson = new Gson();
                    request.setText(gson.toJson(responseControllerStats));
                    break;
                }
            }
        } else {
            ResponseBaseReal error = response.getTypedAnswer();
            //Log.d(TAG,error.getMessage().getErrorMessage());
            Gson gson = new Gson();
            if(id == R.id.loader_user_controllers)
                controllers.setText(gson.toJson(error));
            else
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
