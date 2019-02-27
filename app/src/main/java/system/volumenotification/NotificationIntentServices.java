package system.volumenotification;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;

public class NotificationIntentServices extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle extras = intent.getExtras();

        if(extras!=null){

System.out.println(extras.getString("send_data"));
        }else{
            System.out.println("ERROR");
       }

    }


}
