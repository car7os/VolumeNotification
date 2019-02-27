package system.volumenotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showNotification();

        this.finish();


    }

    protected void showNotification(){
        Toast.makeText(this, "Testando ....", Toast.LENGTH_LONG).show();
        AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_SAME, AudioManager.FLAG_SHOW_UI);


        Notification vNotification;

        RemoteViews visualNotification = new RemoteViews(getApplicationContext().getPackageName(),R.layout.activity_notification);

        Intent btnVolUp = new Intent(this, NotificationIntentServices.class);
        Bundle extras = new Bundle();
        extras.putString("send_data", "test");
        btnVolUp.putExtras(extras);
        btnVolUp.setAction("system.volumenotification.activity_notification");
        visualNotification.setOnClickPendingIntent(R.id.btnVolumeUp, PendingIntent.getBroadcast(this, 0, btnVolUp,PendingIntent.FLAG_UPDATE_CURRENT));

        Notification.Builder mNotifyBuilder = new Notification.Builder(this);

        vNotification = mNotifyBuilder.setContentTitle("volume notification")
                .setContentText("Volume Notification")
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_volume_up_black_24dp)
                .setOngoing(true)
                .build();

        vNotification.contentView = visualNotification;



        NotificationManager mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyManager.notify(1, vNotification);
    }



}
