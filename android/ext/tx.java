package android.ext;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class tx extends BroadcastReceiver {
    private static final int a;

    static {
        tx.a = Tools.a.nextInt();
    }

    public static PendingIntent a(int v) {
        try {
            return PendingIntent.getBroadcast(Tools.e(), Tools.a.nextInt(), tx.a().putExtra("action", v), 0x8000000);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return null;
        }
    }

    private static Intent a() {
        String s = Tools.g();
        Intent intent0 = new Intent();
        intent0.setClassName(s, s + ".Receiver");
        intent0.setAction(s);
        intent0.setFlags((intent0.getFlags() | 0x1000020) & 0xFF7FFFEF);
        intent0.putExtra("check-hash", tx.a);
        return intent0;
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context0, Intent intent0) {
        try {
            int v = 0;
            la.b(("onReceive broadcast: " + intent0 + "; " + context0 + "; " + MainService.instance));
            if(MainService.instance == null) {
                v = 1;
            }
            else if(intent0 == null) {
                v = 2;
            }
            else if(intent0.getIntExtra("check-hash", 0) != tx.a) {
                v = 3;
            }
            la.b(("Broadcast: " + v));
            if(v != 0) {
                return;
            }
            try {
                context0.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            }
            catch(Throwable throwable1) {
                la.b("Failed hide status bar", throwable1);
            }
            if(intent0.getIntExtra("action", 0) != 1) {
                MainService.instance.z();
                return;
            }
            ConfigListAdapter.e();
        }
        catch(Throwable throwable0) {
            la.b(("onReceive broadcast fail: " + intent0), throwable0);
        }
    }
}

