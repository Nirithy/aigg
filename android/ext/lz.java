package android.ext;

import android.app.AlertDialog;
import android.content.Context;

class lz implements Runnable {
    private final Context a;
    private final String b;
    private final long c;

    lz(Context context0, String s, long v) {
        this.a = context0;
        this.b = s;
        this.c = v;
        super();
    }

    @Override
    public void run() {
        try {
            AlertDialog alertDialog0 = i.a((this.a == null ? Tools.e() : this.a)).setMessage(this.b).setPositiveButton(qk.a(0x7F07009D), null).setNeutralButton(qk.a(0x7F0700B9), lh.a(this.c)).create();  // string:ok "OK"
            i.c(alertDialog0);
            Tools.a(alertDialog0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }
}

