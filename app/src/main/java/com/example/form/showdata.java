package com.example.form;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class showdata extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;
    Button btn2;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdata);
        t1=(TextView) findViewById(R.id.t1);
        t2=(TextView) findViewById(R.id.t2);
        t3=(TextView) findViewById(R.id.t3);
        t4=(TextView) findViewById(R.id.t4);
        t5=(TextView) findViewById(R.id.t5);
        btn2=(Button)findViewById(R.id.btn2);
        db=new DBHandler(getApplicationContext());
        final Intent i=getIntent();
        final String name=i.getStringExtra("name");
        final String email=i.getStringExtra("email");
        final String pwd=i.getStringExtra("pwd");
        final String gender=i.getStringExtra("gender");
        final String education=i.getStringExtra("education");
        t1.setText(name);
        t2.setText(email);
        t3.setText(pwd);
        t4.setText(gender);
        t5.setText(education);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(showdata.this);
                builder.setMessage("are you want to save?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                db.insertRecord(name,email,pwd,gender,education);
                                Toast.makeText(getApplicationContext(),"record inserted",
                                        Toast.LENGTH_LONG).show();
                                final long [] vibe = {0,500};
                                final Uri notificationsound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    NotificationChannel channel = new NotificationChannel("notification","notification",NotificationManager.IMPORTANCE_DEFAULT);
                                    NotificationManager notificationManager = getSystemService(NotificationManager.class);
                                    notificationManager.createNotificationChannel(channel);
                                }
                                NotificationCompat.Builder noti=(NotificationCompat.Builder)new NotificationCompat.Builder(getApplicationContext(),"notification")
                                        .setSmallIcon(R.drawable.student,10)
                                        .setSound(notificationsound)
                                        .setVibrate(vibe)
                                .setContentTitle("new notification")
                                        .setContentText("the details are save")
                                        .setAutoCancel(true);
                                NotificationManagerCompat notificationManager=NotificationManagerCompat.from(showdata.this);
                                notificationManager.notify(999,noti.build());
                            }
                        })
                        .setNegativeButton("no",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(showdata.this, "not save", Toast.LENGTH_SHORT).show();
                                final long [] vibe = {0,500};
                                final Uri notificationsound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    NotificationChannel channel = new NotificationChannel("notification","notification",NotificationManager.IMPORTANCE_DEFAULT);
                                    NotificationManager notificationManager = getSystemService(NotificationManager.class);
                                    notificationManager.createNotificationChannel(channel);
                                }
                                NotificationCompat.Builder noti=(NotificationCompat.Builder)new NotificationCompat.Builder(getApplicationContext(),"notification")
                                        .setSmallIcon(R.drawable.student,10)
                                        .setSound(notificationsound)
                                        .setVibrate(vibe)
                                        .setContentTitle("new notification")
                                        .setContentText("the details are not save")
                                        .setAutoCancel(true);
                                NotificationManagerCompat notificationManager=NotificationManagerCompat.from(showdata.this);
                                notificationManager.notify(999,noti.build());
                            }
                        });
                AlertDialog alert=builder.create();
                alert.show();
            }
        });
    }
}
