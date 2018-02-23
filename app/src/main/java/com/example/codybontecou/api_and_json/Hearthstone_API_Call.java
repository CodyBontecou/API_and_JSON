package com.example.codybontecou.api_and_json;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import io.realm.Realm;

import static java.lang.System.in;

/**
 * Created by codybontecou on 2/22/18.
 */

public class Hearthstone_API_Call extends AsyncTask<Void,Integer,String> {

    private Context mContext;
    private String server_response;
    private JSONArray mJsonArrayContacts= new JSONArray();


    public Hearthstone_API_Call(Context context){
        mContext = context;
    }


    @Override
    protected String doInBackground(Void... voids) {

        //realm instance
        Realm mRealm = Realm.getDefaultInstance();
        //http call to URL and add it to Contact
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(ConstUrl.GETCONTACTURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("X-Mashape-Key", "YlOQYWZqPrmshxrpYu8jVY0eGx6Kp1N44KfjsndvsJTYWMStrO");

            int responseCode = urlConnection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                server_response = readStream(urlConnection.getInputStream());
                //Log.d("ddd", server_response);
                try {
                    mJsonArrayContacts = new JSONArray(server_response);
                    for(int i=0; i<mJsonArrayContacts.length(); i++){
                        JSONObject jsonObject = mJsonArrayContacts.getJSONObject(i);
                        //Log.d("ddd",jsonObject.getString("id"));

                        mRealm.beginTransaction();
                        Card card = mRealm.createObject(Card.class);
                        card.setCardId(jsonObject.getString("cardId"));
                        card.setName(jsonObject.getString("name"));
                        card.setAttack(jsonObject.getString("attack"));
                        card.setHealth(jsonObject.getString("health"));
                        mRealm.commitTransaction();

                        //display progress
//                        publishProgress(i+1);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //always close realm when done
        mRealm.close();



        return null;
    }

    private String readStream(InputStream inputStream) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }
}
