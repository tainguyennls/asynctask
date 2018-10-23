package com.example.nguyenhuutai.androidasynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebServiceAsyncTask extends AsyncTask<String,Void,User> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected User doInBackground(String... strings) {
        try {
            URL url  = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String streamRead="";
            String output="";
            while((streamRead = bufferedReader.readLine()) != null){
                output+= streamRead;
            }
            Gson gson = new Gson();
            User user = gson.fromJson(output,User.class);
            return user;
        }
        catch (Exception e){
            Log.e("ERROR",e.toString());
            return null;
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(User user) {
        super.onPostExecute(user);
    }
}
