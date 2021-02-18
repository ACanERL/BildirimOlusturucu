package com.example.alarmmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button alarm=(Button)findViewById(R.id.alarm);

        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bilidirimOlustur();
                Toast.makeText(getApplicationContext(),"Hatırlatici Gonderimi",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Hatirlatici.class);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,0,intent,0);
                AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
                long timeBtn=System.currentTimeMillis();
                long Onsaniye=1000*10;

                alarmManager.set(AlarmManager.RTC_WAKEUP,timeBtn+Onsaniye,pendingIntent);
            }
        });
    }
    private void  bilidirimOlustur(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name="MesajKanali";
            String aciklama="Mesaj Hatirlatici";
            int importance= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel("MyChannel",name,importance);
            channel.setDescription(aciklama);

            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}