package com.example.statusbarnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_SIMPLE = 1234;
    private static final int REQ_NOTIFICATION = 4567;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.btnOkay).setOnClickListener(this::clicked);
    }

    private void clicked(View view) {
        
        if(view.getId() == R.id.btnOkay) showNotification();
    }

    private void showNotification() {

        Intent intent = new Intent(this,NotificationActivity.class);

        PendingIntent pendingintent =
                PendingIntent.getActivity(this,REQ_NOTIFICATION,intent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Action action = new NotificationCompat.Action
                .Builder(R.mipmap.ic_launcher,"Action",pendingintent).build();



       NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentInfo(getResources().getString(R.string.info));
        builder.setContentTitle(getResources().getString(R.string.title))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(getResources().getString(R.string.text))
                .setDefaults(Notification.DEFAULT_ALL)
                .addAction(action)
                .setContentIntent(pendingintent)
                .setAutoCancel(true);

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_SIMPLE,notification);
    }
}
