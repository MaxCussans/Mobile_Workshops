package com.max_cussans2hotmail.max_mobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.content.Intent;

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
