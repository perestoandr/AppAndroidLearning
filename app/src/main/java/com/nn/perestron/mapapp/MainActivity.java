package com.nn.perestron.mapapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {

    GoogleMap gMap;
    private boolean isMarkerDraggable;

    private void createMapView() {
        try {
            if (gMap == null) {
                gMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapView)).getMap();
                if (gMap == null) {
                    Toast.makeText(getApplicationContext(), "Fucking Map didn't load", Toast.LENGTH_SHORT).show();
                }
            }

        }catch (NullPointerException exception){
            Log.e("mapApp", exception.toString());
        }
    }

    public void addMarker(){
        if(gMap != null){
            gMap.addMarker(new MarkerOptions()
                                .position(new LatLng(0,0))
                                .title("It is you, Idiot!")
                                .draggable(true)
            );
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Wow bitch! It isn't working!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        isMarkerDraggable = true;
        createMapView();
        addMarker();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


}
