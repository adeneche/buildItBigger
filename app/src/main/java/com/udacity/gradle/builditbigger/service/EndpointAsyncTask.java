package com.udacity.gradle.builditbigger.service;

import android.content.Context;
import android.os.AsyncTask;

import com.adeneche.joker.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.common.base.Preconditions;

import java.io.IOException;

public class EndpointAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private final ResultListener resultListener;

    public interface ResultListener {
        void onResults(String s);
    }

    public EndpointAsyncTask(final ResultListener resultListener) {
        Preconditions.checkArgument(resultListener != null);
        this.resultListener = resultListener;
    }
    @Override
    protected String doInBackground(Context ...params) {
        if (myApiService == null) { // Only do this once
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    // options for running against local devappserver
//                    // - 10.0.2.2 is localhost's IP address in Android emulator
//                    // - turn off compression when running against local devappserver
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });
                    // end options for devappserver
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://joke-teller-1139.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return "Problem connecting to the Joke Server";
        }
    }

    @Override
    protected void onPostExecute(String s) {
//        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
        if (resultListener != null) {
            resultListener.onResults(s);
        }
    }
}
