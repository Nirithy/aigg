package android.ext;

import android.content.Context;
import android.fix.d;

public class bf {
    public static void a() {
        Context context0;
        la.a("Bootstrap startService");
        if(MainService.instance != null) {
            la.a("Bootstrap startService: already");
            return;
        }
        if(bi.a()) {
            context0 = bi.b.a(false);
        }
        else if(bj.a == null) {
            context0 = MainService.context;
        }
        else {
            context0 = bj.a;
        }
        if(context0 != null) {
            bf.a(context0);
            return;
        }
        la.b("Bootstrap startService: null");
    }

    public static void a(Context context0) {
        if(MainService.instance != null) {
            la.a("Bootstrap start: already");
        }
        new MainService(d.c(context0));
        rx.a(new bg());
    }

    public static void b() {
        la.a("Bootstrap onDestroy");
        rx.a(new bh());
    }
}

