package android.ext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.fix.d;
import android.os.Bundle;

public class ri extends d {
    public ri(Context context0) {
        super(context0);
    }

    public static Context a(Context context0) {
        return context0 != null && !(context0 instanceof ri) ? new ri(context0) : context0;
    }

    @Override  // android.content.ContextWrapper
    public Context getApplicationContext() {
        Context context0 = super.getApplicationContext();
        return context0 == null ? ar.e : context0;
    }

    @Override  // android.fix.d
    public Object getSystemService(String s) {
        try {
            return super.getSystemService(s);
        }
        catch(Throwable throwable0) {
            la.c(("getSystemService fail: " + s), throwable0);
            return null;
        }
    }

    @Override  // android.content.ContextWrapper
    public void startActivities(Intent[] arr_intent) {
        if(arr_intent != null) {
            for(int v = 0; v < arr_intent.length; ++v) {
                Intent intent0 = arr_intent[v];
                if(intent0 != null) {
                    intent0.setFlags(0x10000000);
                }
            }
        }
        super.startActivities(arr_intent);
    }

    @Override  // android.content.ContextWrapper
    public void startActivities(Intent[] arr_intent, Bundle bundle0) {
        if(arr_intent != null) {
            for(int v = 0; v < arr_intent.length; ++v) {
                Intent intent0 = arr_intent[v];
                if(intent0 != null) {
                    intent0.setFlags(0x10000000);
                }
            }
        }
        super.startActivities(arr_intent, bundle0);
    }

    @Override  // android.fix.d
    public void startActivity(Intent intent0) {
        if(intent0 != null) {
            intent0.setFlags(0x10000000);
        }
        super.startActivity(intent0);
    }

    @Override  // android.content.ContextWrapper
    public void startActivity(Intent intent0, Bundle bundle0) {
        if(intent0 != null) {
            intent0.setFlags(0x10000000);
        }
        super.startActivity(intent0, bundle0);
    }

    @Override  // android.fix.d
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver0) {
        try {
            super.unregisterReceiver(broadcastReceiver0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            la.a(illegalArgumentException0);
        }
    }
}

