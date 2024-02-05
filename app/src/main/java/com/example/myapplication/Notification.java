package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.ActivityNotificationBinding;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;

public class Notification extends AppCompatActivity {


    private ActivityNotificationBinding binding;
    private MaterialTimePicker timePicker;
    private Calendar calendar;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createNotificationChannel();
        binding.setReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker = new MaterialTimePicker.Builder()
                        .setTimeFormat(TimeFormat.CLOCK_12H)
                        .setHour(12)
                        .setMinute(0)
                        .setTitleText("Select Alarm Time")
                        .build();
                timePicker.show(getSupportFragmentManager(), "Reminder");
                timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (timePicker.getHour() > 12){
                            binding.setReminder.setText(
                                    String.format("%02d",(timePicker.getHour()-12)) +":"+ String.format("%02d", timePicker.getMinute())+"PM"
                            );
                        } else  {
                            binding.setReminder.setText(timePicker.getHour()+":" + timePicker.getMinute()+ "AM");
                        }
                        calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                        calendar.set(Calendar.MINUTE, timePicker.getMinute());
                        calendar.set(Calendar.SECOND, 0);
                        calendar.set(Calendar.MILLISECOND, 0);
                    }
                });
            }
        });
        binding.btnsetReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(Notification.this, BroadcastReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(Notification.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                Toast.makeText(Notification.this, "Alarm Set", Toast.LENGTH_SHORT).show();
            }
        });
        binding.cancelReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Notification.this, BroadcastReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(Notification.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                if (alarmManager == null){
                    alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                }
                alarmManager.cancel(pendingIntent);
                Toast.makeText(Notification.this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "leaflens";
            String desc = "Channel for Alarm Manager";
            int imp = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("leaflens", name, imp);
            channel.setDescription(desc);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }







    }
}