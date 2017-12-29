package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;


import java.io.IOException;

/**
 * Created by songoku on 28/12/17.
 */

public class CheckAsyncTask extends AsyncTask<MainActivityFragment, Void, String> {
    private MainActivityFragment mainActivityFragment;
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(MainActivityFragment... params) {
        if(myApiService == null) {  // Only do this once
//            MyApi.Builder builder = new
//                    MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    // options for running against local devappserver
//                    // ­ 10.0.2.2 is localhost's IP address in Android emulator
//                    // ­ turn off compression when running against local devappserver
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override                         public void initialize(AbstractGoogleClientRequest<?>
//                                                                                         abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new
                    AndroidJsonFactory(), null)
                    .setRootUrl("https://joketellingapp-189821.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

//        context = params[0];
        mainActivityFragment = params[0];
        context = mainActivityFragment.getActivity();


        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }



    @Override
    protected void onPostExecute(String result) {
        /*// Create Intent to launch JokeFactory Activity
        Intent intent = new Intent(context, DisplayJokeActivity.class);
        // Put the string in the envelope
        intent.putExtra(DisplayJokeActivity.JOKE_KEY,result);
        context.startActivity(intent);
*/
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        mainActivityFragment.loaded_Joke = result;
        mainActivityFragment.launchKilling_joke();
    }

}
