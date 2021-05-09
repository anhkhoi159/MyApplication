package com.example.myapplication

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class MyService : Service() {
    override fun onCreate() {
        super.onCreate()
        Log.e("Khoitqa","MyService create")
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        var strData: String? = intent?.getStringExtra("key_data")

        if (strData != null) {
            sendNotification(strData)
        }
        return START_NOT_STICKY
    }

    private fun sendNotification(strData: String) {
        var intent = Intent(this,MainActivity::class.java)
        var pendingIntent= PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
        var notification = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
            .setContentTitle("Title Service")
            .setContentText(strData)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1,notification)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Khoitqa","MyService destroy")
    }
}