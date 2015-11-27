package com.adeneche.jokeactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class JokerActivity extends AppCompatActivity implements JokerFragment.OnFragmentInteractionListener {

    public static String EXTRA_JOKE = "extra_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker);

        final Intent intent = getIntent();
        final String joke = intent.getStringExtra(EXTRA_JOKE);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        final JokerFragment fragment = JokerFragment.newInstance(joke);

        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container, fragment);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        // Do we really need this ?
    }
}
