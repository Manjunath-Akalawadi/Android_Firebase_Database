package com.manju7.firebasedata;

import android.app.Application;

import com.firebase.client.Firebase;

public class FirebaseData extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }


}

