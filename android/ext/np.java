package android.ext;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;

class np implements Runnable {
    final no a;
    private final String b;
    private final boolean c;

    np(no no0, String s, boolean z) {
        this.a = no0;
        this.b = s;
        this.c = z;
        super();
    }

    @Override
    public void run() {
        boolean z1;
        boolean z;
        Intent intent2;
        int v = 0;
        la.a(("Restart stub: " + this.b));
        String s = "exec setprop wrap." + (this.b == null || this.b.length() <= 26 ? this.b : this.b.substring(0, 26));
        try {
            qt.a((s + " LD_PRELOAD=" + (eu.d() + eu.a(this.c))), 5);
        }
        catch(Throwable throwable0) {
            la.c(("Failed stub app: " + this.b), throwable0);
        }
        try {
            if(!qt.a(("exec monkey -p " + this.b + " 1"), 10).contains("Events injected")) {
                Intent intent0 = Tools.m().getLaunchIntentForPackage(this.b);
                if(intent0 == null) {
                    Intent intent1 = new Intent("android.intent.action.MAIN");
                    intent1.setPackage(this.b);
                    intent2 = intent1;
                }
                else {
                    intent2 = intent0;
                }
                if(intent2 == null) {
                    z = false;
                }
                else {
                    ComponentName componentName0 = intent2.getComponent();
                    z = componentName0 == null ? false : qt.a(("exec am start -n " + componentName0.flattenToString()), 10).contains("Starting: Intent");
                }
                if(!z) {
                    intent2.setFlags(0x10000000);
                    rx.a(new nq(this, intent2, this.b));
                }
            }
            z1 = true;
        }
        catch(Throwable throwable1) {
            la.c(("Failed restart app: " + this.b), throwable1);
            z1 = false;
        }
        rx.b().postDelayed(new nr(this, s, this.b), ((long)(z1 ? 10000 : 0)));
        Handler handler0 = rx.a();
        ns ns0 = new ns(this, this.b);
        if(z1) {
            v = 4000;
        }
        handler0.postDelayed(ns0, ((long)v));
    }
}

