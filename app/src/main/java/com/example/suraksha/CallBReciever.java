package com.example.suraksha;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class CallBReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, RecievedCall.class);
        context.startActivity(i);

    }
}