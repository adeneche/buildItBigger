package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.adeneche.jokeactivity.JokerActivity;
import com.udacity.gradle.builditbigger.service.EndpointAsyncTask;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void tellJoke(View view){
        new EndpointAsyncTask(new EndpointAsyncTask.ResultListener() {
            @Override
            public void onResults(String s) {
                final Context context = MainActivity.this;
                final Intent jokeIntent = new Intent(context, JokerActivity.class);
                jokeIntent.putExtra(JokerActivity.EXTRA_JOKE, s);
                context.startActivity(jokeIntent);
            }
        }).execute(this);
    }


}
