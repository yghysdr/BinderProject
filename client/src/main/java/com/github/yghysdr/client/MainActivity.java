package com.github.yghysdr.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.github.yghysdr.server.aidl.IStoreAidl;


public class MainActivity extends AppCompatActivity {


    private static final String ACTION_BIND_SERVICE = "com.github.yghysdr.server.StoreService";
    private static final String PACKAGE = "com.github.yghysdr.server";
    private static final String TAG = "BinderApplication";
    IStoreAidl iStoreAidl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(TAG, "onCreate: ");
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Snackbar.make(view, iStoreAidl.getApplePrice() + "...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        bindService();

    }

    //需要先运行server
    private void bindService() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(PACKAGE, ACTION_BIND_SERVICE));
//        intent.setPackage(PACKAGE);

//        Intent intent = new Intent(ACTION_BIND_SERVICE);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d(TAG, "onServiceConnected: ");
                iStoreAidl = IStoreAidl.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d(TAG, "onServiceDisconnected: ");
                iStoreAidl = null;
            }
        }, Context.BIND_AUTO_CREATE);
    }


}
