package com.andro_curiosity.againstroadaccident;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MyBroadCastReceive extends BroadcastReceiver {  
    MediaPlayer mp;  
    @Override  
    public void onReceive(Context context, Intent intent) {  
        mp=MediaPlayer.create(context, R.raw.policewhistle   );  
        mp.start();  
        Toast.makeText(context,R.string.AlarmAwarness, Toast.LENGTH_LONG).show();
        
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent notificationIntent = new Intent(context, MyBroadCastReceive.class);
        //Intent notificationIntent = new Intent(context, MainPage.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        CharSequence NotificationTicket = "Road accident awareness";
        CharSequence NotificationTitle = "Awareness";
        CharSequence NotificationContent = "Be aware about road accident";
        Notification notification = new Notification(R.drawable.ic_launcher,NotificationTicket,System.currentTimeMillis());
        notification.setLatestEventInfo(context, NotificationTitle, NotificationContent, contentIntent);
        //notification.flags |= Notification.FLAG_ONGOING_EVENT;
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, notification);
    }
}
    
    
    