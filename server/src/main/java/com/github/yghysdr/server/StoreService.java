package com.github.yghysdr.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.github.yghysdr.server.aidl.IStoreAidl;

public class StoreService extends Service {

    private static final String TAG = "BinderApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: 远程连接");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    class MyBinder extends IStoreAidl.Stub {

        @Override
        public int getApplePrice() throws RemoteException {
            Log.d(TAG, "getApplePrice: 有人在看数据");
            return 100;
        }
    }
}
