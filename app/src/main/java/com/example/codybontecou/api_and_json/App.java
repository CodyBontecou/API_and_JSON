package com.example.codybontecou.api_and_json;

import android.app.Application;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by codybontecou on 2/22/18.
 */

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        //Realm initialization
        Realm.init(this);

        /*
        //default realm init for dev environment
        RealmConfiguration config =
                new RealmConfiguration.Builder().name("myContact.realm").build();

        */

        //release version realm init with version# and migration when structure changed
        RealmConfiguration config =
                new RealmConfiguration.Builder().name("myContact.realm").build();


        Realm.setDefaultConfiguration(config);

        Log.d("ddd","app class initializaion...");
    }
}
