package com.example.demoservice.service.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast


class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED") {
            Log.d("XXX", "Call here BOOT_COMPLETED...")
            val serviceIntent = Intent(context, AlarmService::class.java)
            context.startService(serviceIntent)
        } else {
            Log.d("XXX", "Call here ...")
            Toast.makeText(
                context.applicationContext,
                "Alarm Manager just ran",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}