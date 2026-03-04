package android.ext;

import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.fix.d;
import android.os.Bundle;

public class bi extends Instrumentation {
    public static volatile boolean a;
    public static volatile bi b;

    static {
        bi.a = false;
        la.a("Instrumentation clinit");
        ho.b();
    }

    public bi() {
        bi.b = this;
        la.a("Instrumentation init");
        ho.b();
    }

    public static boolean a() {
        return bi.a;
    }

    public Context a(boolean z) {
        Context context0 = z ? this.getTargetContext() : this.getContext();
        if(!z) {
            return context0 == null ? d.c(this.getTargetContext()) : d.c(context0);
        }
        return context0 == null ? d.c(this.getContext()) : d.c(context0);
    }

    public static void b() {
        bi bi0 = bi.b;
        if(bi0 != null) {
            bi0.finish(0, new Bundle());
        }
    }

    @Override  // android.app.Instrumentation
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        ar.a(bundle0);
        Tools.e(this.getTargetContext());
        Tools.e(this.getContext());
        if(MainService.context == null) {
            MainService.context = ri.a(this.a(false));
        }
        la.a(("Instrumentation onCreate " + bundle0));
        ho.b();
        bi.b = this;
        bi.a = true;
        this.start();
    }

    @Override  // android.app.Instrumentation
    public void onDestroy() {
        bf.b();
        super.onDestroy();
    }

    @Override  // android.app.Instrumentation
    public boolean onException(Object object0, Throwable throwable0) {
        la.b(("Instrumentation onException: " + object0), throwable0);
        return super.onException(object0, throwable0);
    }

    @Override  // android.app.Instrumentation
    public void onStart() {
        super.onStart();
        la.a("Instrumentation onStart catch_.me_.if_.you_.can_.ActivityMain");
        Context context0 = this.a(true);
        Tools.a(100, new ComponentName("catch_.me_.if_.you_.can_", "catch_.me_.if_.you_.can_.ActivityMain"), 1);
        context0.startActivity(Tools.a(context0, "catch_.me_.if_.you_.can_", "catch_.me_.if_.you_.can_.ActivityMain"));
    }
}

