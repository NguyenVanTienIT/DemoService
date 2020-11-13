package com.example.demoservice.fragment

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.demoservice.R
import com.example.demoservice.service.alarm.AlarmReceiver
import com.example.demoservice.service.alarm.AlarmService
import kotlinx.android.synthetic.main.fragment_alarm.*


class AlarmFragment : Fragment() {

    var alarmManager: AlarmManager? = null
    var pendingIntent: PendingIntent? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager?
        val alarmIntent = Intent(context, AlarmReceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0)
        return inflater.inflate(R.layout.fragment_alarm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_start_alarm_service.setOnClickListener {
            handleCreateAlarmService()
        }
    }

    private fun handleCreateAlarmService() {
       startAlarm()
    }

    private fun startAlarm() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager!!.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, 0, pendingIntent)
        } else
            alarmManager!!.setExact(AlarmManager.RTC_WAKEUP, 0, pendingIntent)
    }

    private fun cancelAlarm() {
        alarmManager!!.cancel(pendingIntent)
        Toast.makeText(
            context,
            "Alarm Cancelled",
            Toast.LENGTH_LONG
        ).show()
    }

}