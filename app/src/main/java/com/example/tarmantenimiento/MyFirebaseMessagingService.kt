package com.example.tarmantenimiento

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.media.session.MediaSession
import android.os.Build
import android.util.JsonToken
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.actions.NoteIntents
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
private val TAG = "MyActivity"


class MyFirebaseMessagingService : FirebaseMessagingService(){
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG,"From: ${remoteMessage.from}")

        val notificationManager = getSystemService((Context.NOTIFICATION_SERVICE)) as NotificationManager
        val Notification_Channel_ID = "Channel"

        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel(Notification_Channel_ID, "Your Notifications", NotificationManager.IMPORTANCE_HIGH)

            notificationChannel.description = "Description"
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.vibrationPattern = longArrayOf(0,1000,500,1000)
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)

        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = notificationManager.getNotificationChannel(Notification_Channel_ID)
            channel.canBypassDnd()
        }
        val notificationBuilder = NotificationCompat.Builder(this, Notification_Channel_ID)

        notificationBuilder.setAutoCancel(true)
            .setColor(ContextCompat.getColor(this,R.color.colorAccent))
            .setContentTitle(getString(R.string.app_name))
            .setContentText(remoteMessage!!.notification!!.body)
            .setDefaults(Notification.DEFAULT_ALL)
            .setWhen(System.currentTimeMillis())
            .setSmallIcon(R.drawable.noti)
            .setAutoCancel(true)

        notificationManager.notify(1000,notificationBuilder.build())

        }
    private fun sendRegistrationToServer (token: String){
        Log.d(TAG,"sendRegistrationToServer($token")


    }
}