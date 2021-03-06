package com.max_cussans2hotmail.max_mobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.content.Intent;
// add below imports for location purposes
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
//intents imports
import java.util.Locale;
import android.net.Uri;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //create the TestActivity activity
        super.onCreate(savedInstanceState);

        // Get the message from the intent started in the helloWorld activity
        Intent intent = getIntent();
        String message = intent.getStringExtra("testParameter");

        // Create a new TextView widget programmatically
        TextView textView = new TextView(this);
        textView.setTextSize(40);

        // Set the TextView to the string message -
        // which was passed as a parameter from the HelloWorld activity
        textView.setText(message);
        // Set the TextView widget as the activity UI layout
        setContentView(textView);

        // get location code
        // Acquire a reference to the system Location Manager
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        // Use network provider to get last known location
        String locationProvider = LocationManager.GPS_PROVIDER;
        Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
        double lat;
        double longi;
        if(lastKnownLocation != null)
        {
            lat = lastKnownLocation.getLatitude();
            longi = lastKnownLocation.getLongitude();
        }
        else
        {
            //store the lat/long coordinates of last known location
            lat = 0;
            longi = 0;
        }


        // bind the lat long coordinates to the programmatically created TextView for displaying
        textView.setText("Location:\n" + lat +"\n" + longi);

        // Set the text view as the activity layout
        // note we could create a new layout file to do this too
        //setContentView(textView);

        // Intent for Google Maps, if another map app handles the geo tag it may show more than one app option
        String uri = String.format(Locale.ENGLISH, "geo:%f,%f", lat, longi);
        Intent intent_map = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent_map);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
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
