package android.ext;

import android.app.AlertDialog;

class gd implements Runnable {
    final gc a;

    gd(gc gc0) {
        this.a = gc0;
        super();
    }

    @Override
    public void run() {
        try {
            String s = qk.a(0x7F0700A8) + "\n\n" + qk.a(0x7F07015C);  // string:is_device_rooted "Unable to obtain root access."
            AlertDialog alertDialog0 = i.c().setCustomTitle(Tools.d(0x7F0700A7)).setMessage(s).setPositiveButton(qk.a(0x7F070164), new ge(this)).setNegativeButton(qk.a(0x7F07009D), null).create();  // string:failed_load_daemon "Failed to load daemon"
            i.c(alertDialog0);
            Tools.a(alertDialog0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }
}

