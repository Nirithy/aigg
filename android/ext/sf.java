package android.ext;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class sf {
    private static volatile Toast a;
    private static final Object b;
    private static volatile WeakReference c;
    private static final Object d;
    private static volatile WeakReference e;
    private static Context f;
    private static Context g;

    static {
        sf.a = null;
        sf.b = new Object();
        sf.c = null;
        sf.d = new Object();
        sf.e = null;
        new gr(new sg(), "toastThread").start();
        sf.f = null;
        sf.g = null;
    }

    public static void a() {
    }

    public static void a(Toast toast0) {
        Toast toast2;
        Runnable runnable0;
        Toast toast1;
        synchronized(sf.d) {
            toast1 = sf.c == null ? null : ((Toast)sf.c.get());
            sf.c = null;
            runnable0 = sf.e == null ? null : ((Runnable)sf.e.get());
            sf.e = null;
        }
        sf.f(toast0).show();
        si si0 = new si(toast0);
        synchronized(sf.d) {
            sf.c = new WeakReference(toast0);
            sf.e = new WeakReference(si0);
        }
        synchronized(sf.b) {
            toast2 = sf.a;
            sf.a = null;
        }
        sf.e(toast2);
        sf.e(toast1);
        Handler handler0 = rx.a();
        if(runnable0 != null) {
            handler0.removeCallbacks(runnable0);
        }
        handler0.postDelayed(si0, 3000L);
    }

    public static Context b() {
        return Tools.e();
    }

    private static void e(Toast toast0) {
        if(toast0 != null) {
            rx.a(new sj(toast0));
        }
    }

    private static Toast f(Toast toast0) {
        try {
            Field field0 = Toast.class.getDeclaredField("mTN");
            field0.setAccessible(true);
            Object object0 = field0.get(toast0);
            Field[] arr_field = object0.getClass().getDeclaredFields();
            for(int v = 0; true; ++v) {
                if(v >= arr_field.length) {
                    return toast0;
                }
                Field field1 = arr_field[v];
                String s = field1.getName();
                if(s.equals("mShow") || s.equals("mHide")) {
                    field1.setAccessible(true);
                    Object object1 = field1.get(object0);
                    if(object1 instanceof Runnable) {
                        field1.set(object0, to.a(((Runnable)object1)));
                    }
                }
                else if(s.equals("mHandler")) {
                    field1.setAccessible(true);
                    Object object2 = field1.get(object0);
                    if(object2 instanceof Handler) {
                        field1.set(object0, tm.a(((Handler)object2)));
                    }
                }
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return toast0;
        }
    }
}

