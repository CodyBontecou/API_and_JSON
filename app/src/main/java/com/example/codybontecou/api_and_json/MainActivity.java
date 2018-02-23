package com.example.codybontecou.api_and_json;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Realm mRealm;
    private RealmResults<Card> mResults;
    private ArrayList<Card> mContactList;

//    private CustomRealmAdapter mCustomRealmAdapter;
    private static boolean sortBoolean = true;
    private static final String TAG = "MainActivity";

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get realm instance
        mRealm = Realm.getDefaultInstance();
        //first query on contact table
        mResults = mRealm.where(Card.class).findAll().sort("name", Sort.ASCENDING);


        ArrayList<Card> list = new ArrayList<>(mResults);

        //if contact is empty, build data
        if(mResults.isEmpty()){
            //build data
            /*
            ContactData contactData = new ContactData();
            mResults = contactData.buildData();
            */

            //webservice to get asynctask
            Hearthstone_API_Call getContactAsyncTask = new Hearthstone_API_Call(this);
            getContactAsyncTask.execute();


        }

        //add toolbar as actionbar
        //set title after contact table is built, display total contacts in title
//        mToolbar.setTitle(getResources().getString(R.string.app_name)+" ("+mResults.size()+")");
//        setSupportActionBar(mToolbar);
//
//
//        //set listview with the custom adapter
//        ListView listView = findViewById(R.id.contactlist);
//        mCustomRealmAdapter = new CustomRealmAdapter(mResults);
//        listView.setAdapter(mCustomRealmAdapter);

        //set listener when a row of listview clicked
        //Passes the index of item selected
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(MainActivity.this, ContactCardActivity.class);
//
//                //************************************************
//                //!!!!make sure we get the contact from mResults!!!
//                //!!!!no more contactList!!!!!
//                //************************************************
//                Contact contact = mResults.get(i);
//
//                intent.putExtra(ContactCardActivity.EXTRA_ID,contact.getId());
//                startActivity(intent);
//            }
//        });


//        new AsyncTask<Void, Void, String>() {
//            @Override
//            protected String doInBackground(Void... voids) {
//                String url = "https://omgvamp-hearthstone-v1.p.mashape.com/cards";
//                OkHttpClient client = new OkHttpClient();
//                Request request = new Request.Builder().url(url).header("X-Mashape-Key", "YlOQYWZqPrmshxrpYu8jVY0eGx6Kp1N44KfjsndvsJTYWMStrO").build();
//
//                try {
//                    Response response = client.newCall(request).execute();
//                    Log.d(TAG, "doInBackground() called with: params = [" + response.body() + "]");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//        }.execute();

//         These code snippets use an open-source library. http://unirest.io/java
//        try {
//            HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards")
//                    .header("X-Mashape-Key", "YlOQYWZqPrmshxrpYu8jVY0eGx6Kp1N44KfjsndvsJTYWMStrO")
//                    .asJson();
//            System.out.println(response.getBody().toString());
////            JSONArray array = response.getJSONArray("interests");
//        } catch (UnirestException e) {
//            e.printStackTrace();
//        }

    }

    public void onClickSave(View view) {
//        Log.d("ddd", "ddd");
//        Toast.makeText(this, R.string.favorite_message, Toast.LENGTH_SHORT).show();
    }

}
