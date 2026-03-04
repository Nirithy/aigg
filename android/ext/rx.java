package android.ext;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;

public class rx {
    private static final Looper[] a;
    private static final Handler[] b;

    static {
        Looper[] arr_looper = new Looper[4];
        Handler[] arr_handler = new Handler[4];
        arr_looper[0] = Looper.getMainLooper();
        arr_handler[0] = new Handler(arr_looper[0]);
        ry ry0 = new ry("Main");
        ry0.start();
        arr_looper[1] = ry0.getLooper();
        arr_handler[1] = new Handler(arr_looper[1]);
        ry ry1 = new ry("Log");
        ry1.start();
        arr_looper[2] = ry1.getLooper();
        arr_handler[2] = new Handler(arr_looper[2]);
        ry ry2 = new ry("Write");
        ry2.start();
        arr_looper[3] = ry2.getLooper();
        arr_handler[3] = new Handler(arr_looper[3]);
        rx.a = arr_looper;
        rx.b = arr_handler;
    }

    public static Handler a() {
        return rx.a(0);
    }

    private static Handler a(int v) {
        return rx.b[v];
    }

    private static void a(int v, Runnable runnable0, boolean z) {
        if(rx.a == null) {
            lg.c("AndroidService", "Bad implementation", new NullPointerException("loopers"));
            return;
        }
        if(rx.a[v] == null) {
            lg.c("AndroidService", "Bad implementation", new NullPointerException("loopers[" + v + ']'));
            return;
        }
        if(Looper.myLooper() == rx.a[v] && !z) {
            runnable0.run();
            return;
        }
        rx.b[v].post(runnable0);
    }

    public static void a(Runnable runnable0) {
        rx.a(0, runnable0, false);
    }

    public static Handler b() {
        return rx.a(1);
    }

    public static void b(Runnable runnable0) {
        rx.a(1, runnable0, false);
    }

    public static void c(Runnable runnable0) {
        try {
            rx.a(2, runnable0, false);
        }
        catch(Throwable throwable0) {
            lg.c("AndroidService", "Bad implementation", throwable0);
        }
    }

    public static boolean c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @TargetApi(18)
    public static void d() {
        for(int v = 0; v < rx.a.length; ++v) {
            if(v != 0) {
                Looper looper0 = rx.a[v];
                try {
                    looper0.quitSafely();
                }
                catch(NoSuchMethodError unused_ex) {
                    looper0.quit();
                }
            }
        }
    }

    public static void d(Runnable runnable0) {
        rx.a(3, runnable0, false);
    }
}

