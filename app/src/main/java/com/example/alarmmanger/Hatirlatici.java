package com.example.alarmmanger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Hatirlatici extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"MyChannel")
                .setSmallIcon(R.drawable.ic_baseline_add_alert_24)
                .setContentTitle("Not Hatırlatıcı")
                .setContentText("Şuan Bu Mesaja Bakmalısınız.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(200,builder.build());

    }
}
