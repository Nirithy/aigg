package android.ext;

import android.app.AlertDialog;
import android.content.Intent;

class kc implements Runnable {
    private final int a;
    private final String b;
    private final int c;
    private final Intent[] d;

    kc(int v, String s, int v1, Intent[] arr_intent) {
        this.a = v;
        this.b = s;
        this.c = v1;
        this.d = arr_intent;
        super();
    }

    @Override
    public void run() {
        kd kd0 = new kd(this, this.c, this.d);
        jp.e.f();
        AlertDialog alertDialog0 = i.a(ar.f).setMessage("0: [" + this.a + "] " + this.b).setPositiveButton(0x7F07009B, kd0).setNegativeButton(0x7F07009C, kd0).setCancelable(false).create();  // string:yes "Yes"
        i.c(alertDialog0);
        jp.e.f = alertDialog0;
    }
}

