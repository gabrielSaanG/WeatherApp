package com.example.weatherapp;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.transform.Result;

public class JsonConverter  extends AsyncTask<String, Void, JSONObject> {


    public JsonConverter() throws MalformedURLException {
    }

    @Override
    protected JSONObject doInBackground(String... urls) {

        try{
            URL jsonURL = new URL(urls[0]);
            InputStream inputStreamObject = jsonURL.openStream();
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStreamObject, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());

            return jsonObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected JSONObject onPostExecute(Result result) throws JSONException {
        return new JSONObject(result.toString());
    }

}

