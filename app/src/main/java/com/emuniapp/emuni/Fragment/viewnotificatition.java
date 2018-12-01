package com.emuniapp.emuni.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.emuniapp.emuni.Activity.NotificationActivity;
import com.emuniapp.emuni.R;


public class viewnotificatition extends Fragment {
    // TODO: Rename parameter arguments, choose names that match


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        Intent resultIntent = new Intent(getActivity(), NotificationActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getContext());
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(NotificationActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        // Add to your action, enabling Direct Reply for it
        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(R.mipmap.ic_launcher_round, "reply", resultPendingIntent)
                      //  .addRemoteInput(remoteInput)
                        .setAllowGeneratedReplies(true)
                        .build();

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getContext())
                        .addAction(action)
                        .setAutoCancel(true)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("the data is ")
                        .setContentText("id :  name:");

        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);

        //Show it
        mNotificationManager.notify(1000, mBuilder.build());
        return inflater.inflate(R.layout.fragment_add_item, container, false);

    }
}





