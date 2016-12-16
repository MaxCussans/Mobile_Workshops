package com.max_cussans2hotmail.max_mobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
// add below for helloworld
import android.view.View;
import android.widget.*;
import android.content.Intent;

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
