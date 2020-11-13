package com.example.demoservice.service.alarm

import android.app.AlarmManager
import android.app.IntentService
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi


class AlarmService : IntentService("IntentService") {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onHandleIntent(intent: Intent?) {
        val alarmManager =
            getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val alarmIntent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0)
        alarmManager.setInexactRepeating(AlarmManager.RTC, 0, 1000, pendingIntent)
    }

}