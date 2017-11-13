package com.tp.tp_msm;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Response>,
        NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private final BundleFabric bundleFabric = BundleFabric.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLoaderManager().initLoader(R.id.loader_sensor_stats,
                bundleFabric.getSensorStatsBundle("1"),
                this);

        //nav bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    //NAV BAR
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //TODO : item switch

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
