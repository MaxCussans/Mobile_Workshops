package com.max_cussans2hotmail.max_mobile;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
// add below for helloworld
import android.view.View;
import android.widget.*;
import android.content.Intent;

import java.util.Calendar;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user touches the button */
    public void textChangeButton(View view)
    {
        // create an intent to start the activity called TestActivity
        Intent intent = new Intent(this, TestActivity.class);

        // find the textView control to change first
        TextView tv1 = (TextView)findViewById(R.id.changeText);

        // set visibility to visible
        tv1.setVisibility(View.VISIBLE);

        // edit textView control value
        tv1.setText("Hello TestActivity!");

        // get the new string value of the textView control
        String message = tv1.getText().toString();

        // pass string value of textView to new TestActivity
        intent.putExtra("testParameter", message);

        // start TestActivity!
        startActivity(intent);
    }

    public void cameraIntent(View view)
    {

        int REQUEST_IMAGE_CAPTURE = 1;
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }

    public void browserIntent(View view)
    {
        String url = "http://www.imdb.com/title/";
        String movieID = "tt0816692";
        Uri webpage = Uri.parse(url + movieID);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void eventIntent(View view)
    {
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2015, 12, 25, 00, 00);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2015, 12, 25, 00, 01);
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Xmas!");
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "North Pole");
        startActivity(calendarIntent);
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
