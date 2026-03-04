package android.ext;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.fix.d;
import android.os.Build.VERSION;
import android.os.IBinder;

public class bj extends Service {
    public static volatile bj a;
    public static volatile boolean b;
    public static volatile Runnable c;
    public static volatile boolean d;
    public static volatile boolean e;

    static {
        bj.b = false;
        bj.c = null;
        bj.d = false;
        bj.e = false;
    }

    public bj() {
        bj.a = this;
    }

    void a() {
        try {
            this.stopForeground(true);
            la.a("BootstrapService stopForeground");
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
        try {
            String s = Tools.g();
            la.a(("BootstrapService stop: " + this.stopService(new Intent().setClassName(s, "catch_.me_.if_.you_.can_.AnalyticsService"))));
        }
        catch(Throwable throwable1) {
            la.c("Failed stop Service", throwable1);
        }
    }

    private void b() {
        Tools.e(this);
        if(bj.d) {
            if(MainService.context == null) {
                MainService.context = ri.a(this);
            }
            ho.b();
        }
    }

    private void c() {
        if(!bj.e && bj.d) {
            String[] arr_s = ho.a();
            for(int v = 2; v < arr_s.length; v += 2) {
                String s = arr_s[v];
                if(Tools.e(arr_s[v + 1])) {
                    RuntimeException runtimeException0 = new RuntimeException("BootstrapService stop: " + s);
                    la.b(("Found: " + s), runtimeException0);
                    ho.a(Thread.currentThread(), runtimeException0);
                }
            }
        }
    }

    @Override  // android.content.ContextWrapper
    public SharedPreferences getSharedPreferences(String s, int v) {
        return qv.a(super.getSharedPreferences(s, v));
    }

    @Override  // android.app.Service
    public IBinder onBind(Intent intent0) {
        la.a(("BootstrapService onBind: " + intent0));
        return null;
    }

    @Override  // android.app.Service
    public void onConfigurationChanged(Configuration configuration0) {
        la.a(("BootstrapService onConfigurationChanged: " + configuration0));
        if(!bj.b) {
            return;
        }
        Configuration configuration1 = d.a(configuration0);
        super.onConfigurationChanged(configuration1);
        MainService.a(configuration1);
    }

    @Override  // android.app.Service
    public void onCreate() {
        la.a(("BootstrapService onCreate: " + bj.b + '-' + bj.d + "; " + bj.a + "; " + this));
        if(!bj.b) {
            this.a();
            return;
        }
        bj.a = this;
        super.onCreate();
        this.b();
    }

    @Override  // android.app.Service
    public void onDestroy() {
        if(bj.c != null) {
            lg.a("AndroidService", "wait 3");
            bj.c.run();
            return;
        }
        if(!bj.b) {
            la.a(("BootstrapService onDestroy 1: " + bj.b + '-' + bj.e));
            return;
        }
        la.a(("BootstrapService onDestroy 2: " + bj.b + '-' + bj.e), new RuntimeException());
        this.c();
        this.stopForeground(true);
        if(!bi.a()) {
            bf.b();
        }
        super.onDestroy();
    }

    @Override  // android.app.Service
    public void onLowMemory() {
        la.a("BootstrapService onLowMemory");
        if(!bj.b) {
            return;
        }
        super.onLowMemory();
        MainService.b(-1);
    }

    @Override  // android.app.Service
    public void onRebind(Intent intent0) {
        la.a(("BootstrapService onRebind: " + intent0));
        super.onRebind(intent0);
    }

    @Override  // android.app.Service
    public void onStart(Intent intent0, int v) {
        la.a(("BootstrapService onStart: " + v + "; " + intent0));
        super.onStart(intent0, v);
    }

    @Override  // android.app.Service
    public int onStartCommand(Intent intent0, int v, int v1) {
        la.a(("BootstrapService onStartCommand: " + bj.b + '-' + bj.d + "; " + bj.a + "; " + this + "; " + MainService.context));
        la.a(("BootstrapService onStartCommand: " + v1 + ' ' + v + ' ' + intent0));
        if(!bj.b) {
            this.a();
            return 2;
        }
        this.b();
        if(bj.d) {
            lh.i();
            Throwable throwable0 = null;
            int v2 = 0;
            while(true) {
                MainService mainService0 = MainService.instance;
                if(v2 % 2 == 0) {
                    try {
                        boolean z = true;
                        goto label_15;
                    label_14:
                        z = false;
                    label_15:
                        this.startForeground(1, mainService0.a(z, false));
                        la.a(("startForeground 1." + v2));
                        return super.onStartCommand(intent0, v, v1);
                    }
                    catch(Throwable throwable1) {
                        goto label_19;
                    }
                }
                else {
                    goto label_14;
                }
                goto label_15;
            label_19:
                if(throwable0 != null && Build.VERSION.SDK_INT >= 19) {
                    throwable1.addSuppressed(throwable0);
                }
                if(v2 == 1) {
                    la.b("Failed startForeground", throwable1);
                    ho.a(Thread.currentThread(), throwable1, false);
                }
                ++v2;
                throwable0 = throwable1;
            }
        }
        return super.onStartCommand(intent0, v, v1);
    }

    @Override  // android.app.Service
    public void onTaskRemoved(Intent intent0) {
        la.a(("BootstrapService onTaskRemoved: " + bj.b + '-' + bj.e + '-' + bj.d + "; " + intent0), new RuntimeException());
        if(!bj.b) {
            return;
        }
        this.c();
        super.onTaskRemoved(intent0);
    }

    @Override  // android.app.Service
    public void onTrimMemory(int v) {
        la.a(("BootstrapService onTrimMemory: " + v));
        if(!bj.b) {
            return;
        }
        super.onTrimMemory(v);
        MainService.b(v);
    }

    @Override  // android.app.Service
    public boolean onUnbind(Intent intent0) {
        la.a(("BootstrapService onUnbind: " + intent0));
        return super.onUnbind(intent0);
    }
}

