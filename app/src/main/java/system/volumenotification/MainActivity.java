package system.volumenotification;

import android.app.Notification;
import android.app.NotificationManager;
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

        RemoteViews visualNotification = new RemoteViews(getApplicationContext().getPackageName(),
                R.layout.activity_notification);

        Notification.Builder mNotifyBuilder = new Notification.Builder(this);
        vNotification = mNotifyBuilder.setContentTitle("volume string")

                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setTicker("VolNotification")
                .setContentTitle("Volume Notification")
                .setContentText("control volume.")
                .setContentInfo("Info")
                .setOngoing(true)
                .build();

        vNotification.bigContentView = visualNotification;

        NotificationManager mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyManager.notify(1, vNotification);
    }

}
