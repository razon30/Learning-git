package com.selise.razonhossain.eventbus;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;

    final int notiID1 = 1, notiID2 = 2, notiID3 = 3;
    int notiID1Count = 0, notiID2count = 0, notiID3count = 0;
    ArrayList<String> notiGroup1 = new ArrayList<>();
    ArrayList<String> notiGroup2 = new ArrayList<>();
    ArrayList<String> notiGroup3 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notiID1Count++;
                notiGroup1.add("new Noti " + notiID1Count);
                String noti = "Noti type 1 and number is " + notiID1Count;
                 setNotification(noti, notiID1, notiID1Count, notiGroup1);
               // setNotificationFor8();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notiID2count++;
                notiGroup2.add("new Noti " + notiID2count);
                String noti = "Noti type 2 and number is " + notiID2count;
                setNotification(noti, notiID2, notiID2count, notiGroup2);
                // setNotificationFor8();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notiID3count++;
                notiGroup3.add("new Noti " + notiID3count);
                String noti = "Noti type 3 and number is " + notiID3count;
                setNotification(noti, notiID3, notiID3count, notiGroup3);
            }
        });


    }

    private void setNotificationFor8() {

//        NotificationManager mNotificationManager =
//                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//// The id of the channel.
        String channel_id = "my_channel_01";
//// The user-visible name of the channel.
//        CharSequence name = "Test channel";
//// The user-visible description of the channel.
//        String description = "This is description";
//
//        NotificationCompat.Builder mBuilder =
//                new NotificationCompat.Builder(this, String.valueOf(notiID1))
//                        .setSmallIcon(R.mipmap.ic_launcher)
//                        .setContentTitle("Noti Test")
//                        .setContentText("Allah malum hobe na mone hoy")
//                        .setNumber(notiID1Count);
//
//        NotificationChannel mChannel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // Sets an ID for the notification, so it can be updated.
            int notifyID = 1;
            String CHANNEL_ID = "my_channel_01";// The id of the channel.
            CharSequence name = "Test channel";// The user-visible name of the channel.
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
// Create a notification and set the notification channel.
            Notification notification = new Notification.Builder(MainActivity.this, CHANNEL_ID)
                    .setContentTitle("New Message")
                    .setContentText("You've received new messages.")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setChannelId(CHANNEL_ID)
                    .build();

            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (mNotificationManager != null) {
                mNotificationManager.createNotificationChannel(mChannel);
                mNotificationManager.notify(notifyID, notification);
            }

        }
//        if (mNotificationManager != null) {
//            mNotificationManager.notify(notiID1, mBuilder.build());
//        }
// Configure the notification channel.

// Sets the notification light color for notifications posted to this
// channel, if the device supports this feature.
        //  mChannel.setLightColor(Color.RED);
        // mChannel.enableVibration(true);
        // mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});


    }

    private void setNotification(String noti, int notiID1, int notiID1Count, ArrayList<String> notiGroup) {

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Moves the expanded layout object into the notification object.


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // Sets an ID for the notification, so it can be updated.
            int notifyID = notiID1;
            String CHANNEL_ID = "my_channel_01";// The id of the channel.
            CharSequence name = "Test channel";// The user-visible name of the channel.
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
// Create a notification and set the notification channel.


            Notification.InboxStyle inboxStyle1 = new Notification.InboxStyle();
            inboxStyle1.setBigContentTitle("Notifications from type " + notiID1)
                    .setSummaryText(notiGroup.size() + " notifications");

            for (String event : notiGroup) {
                inboxStyle1.addLine(event);
            }


            Notification notification = new Notification.Builder(MainActivity.this, CHANNEL_ID)
                    .setContentTitle(notiID1Count + " Notifications from type " + notiID1)
                    .setContentText(noti)
                    .setNumber(notiID1Count)
                    .setColor(Color.BLUE)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setChannelId(CHANNEL_ID)
                    .setStyle(inboxStyle1)
                    .build();




            if (mNotificationManager != null) {
                mNotificationManager.createNotificationChannel(mChannel);
                mNotificationManager.notify(notifyID, notification);
            }

        }else {

            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            inboxStyle.setBigContentTitle("Notifications from Noti Test type " + notiID1)
                    .setSummaryText(notiGroup.size() + " notifications");

            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this, String.valueOf(notiID1))
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle(notiID1Count + " Notifications from type " + notiID1)
                            .setContentText(noti)
                            .setNumber(notiID1Count)
                            .setColor(Color.BLUE);

            mBuilder.setStyle(inboxStyle);

            // Moves events into the expanded layout
            for (String event : notiGroup) {
                inboxStyle.addLine(event);
            }

            if (mNotificationManager != null) {
                mNotificationManager.notify(notiID1, mBuilder.build());
            }

        }


        // String CHANNEL_ID = "my_channel_01";



        // Sets a title for the Inbox in expanded layout



// Creates an explicit intent for an Activity in your app
        //  Intent resultIntent = new Intent(this, SecondActivity.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your app to the Home screen.
     //   TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        // stackBuilder.addParentStack(ResultActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
        //  stackBuilder.addNextIntent(resultIntent);
//        PendingIntent resultPendingIntent =
//                stackBuilder.getPendingIntent(
//                        0,
//                        PendingIntent.FLAG_UPDATE_CURRENT
//                );
        // mBuilder.setContentIntent(resultPendingIntent);
        //  NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

// mNotificationId is a unique integer your app uses to identify the
// notification. For example, to cancel the notification, you can pass its ID
// number to NotificationManager.cancel().



    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent) {

        Toast.makeText(this, messageEvent.getMessageEvent() + " from 1st", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
