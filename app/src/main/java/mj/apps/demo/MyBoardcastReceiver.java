package mj.apps.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBoardcastReceiver extends BroadcastReceiver {
    public static final String TAG = MyBoardcastReceiver.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
    }
}
