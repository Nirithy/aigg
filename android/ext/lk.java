package android.ext;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

class lk implements Runnable {
    @Override
    public void run() {
        try {
            Context context0 = Tools.e();
            ComponentName componentName0 = lh.m();
            lg.a("AndroidService", "Restart: true " + Config.z + ' ' + componentName0);
            if(Config.z == 0 && componentName0 != null && context0.startInstrumentation(componentName0, null, ar.a())) {
                lg.a("AndroidService", "Restart 1");
            }
            lg.a("AndroidService", "Restart 2");
            String s = Tools.g();
            Tools.a(200, new ComponentName(s, "catch_.me_.if_.you_.can_.ActivityMain"), 1);
            Intent intent0 = Tools.a(context0, s, "catch_.me_.if_.you_.can_.ActivityMain");
            la.a(("Restart: " + intent0));
            PendingIntent pendingIntent0 = PendingIntent.getActivity(context0, 0x1E240, intent0, 0x10000000);
            ((AlarmManager)context0.getSystemService("alarm")).set(1, System.currentTimeMillis() + 1000L, pendingIntent0);
            lh.l();
        }
        catch(Throwable throwable0) {
            throw new RuntimeException("Failed restart", throwable0);
        }
    }
}

