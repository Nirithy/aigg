package android.ext;

import android.c.b;
import android.content.res.Resources;
import android.fix.j;
import catch_.me_.if_.you_.can_.R.string;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class qk {
    static volatile j a;
    static int[] b;
    static volatile long c;
    private static volatile WeakReference d;
    private static final Runnable e;
    private static Pattern f;

    static {
        qk.d = new WeakReference(null);
        qk.a = new j();
        qk.b = b.d;
        qk.c = 0L;
        qk.e = new ql();
        qk.f = Pattern.compile("__([a-z0-9_]+?)__");
    }

    public static int a(String s, Class class0) {
        try {
            Object object0 = class0.getDeclaredField(s).get(null);
            if(object0 instanceof Integer) {
                return (int)(((Integer)object0));
            }
        }
        catch(Throwable throwable0) {
            la.b(("Resource id for name \'" + s + "\' not found"), throwable0);
        }
        return 0;
    }

    public static String a(int v) {
        return qk.c(v);
    }

    public static String a(String s) {
        return qk.b(s);
    }

    public static void a() {
        j j0 = qk.a;
        if(j0.size() <= qk.b.length) {
            return;
        }
        j j1 = new j();
        int[] arr_v = qk.b;
        for(int v = 0; v < arr_v.length; ++v) {
            int v1 = arr_v[v];
            String s = (String)j0.a(v1);
            if(s != null) {
                j1.put(v1, s);
            }
        }
        qk.a = j1;
        qk.c = 0L;
    }

    private static Resources b() {
        Resources resources0 = (Resources)qk.d.get();
        if(resources0 == null) {
            Resources resources1 = Tools.e().getResources();
            qk.d = new WeakReference(resources1);
            qk.e.run();
            j j0 = new j();
            ArrayList arrayList0 = qk.b.length == 0 ? new ArrayList() : null;
            int v = qk.a("app_name", R.string.class);
            if(arrayList0 != null) {
                arrayList0.add(v);
            }
            j0.put(v, "GameGuardian");
            try {
                ad.a();
                qk.c(0x7F070006);  // string:d "%,d"
            }
            catch(Exception exception0) {
                la.c("Check format", exception0);
                if(arrayList0 != null) {
                    arrayList0.add(0x7F070006);  // string:d "%,d"
                }
                j0.put(0x7F070006, "%d");  // string:d "%,d"
            }
            if(arrayList0 != null) {
                arrayList0.add(0x7F07003C);  // string:forum "http://gameguardian.net/forum"
            }
            j0.put(0x7F07003C, "http://gameguardian.net/forum");  // string:forum "http://gameguardian.net/forum"
            if(arrayList0 != null) {
                arrayList0.add(0x7F07004E);  // string:decimal "."
            }
            j0.put(0x7F07004E, ".");  // string:decimal "."
            if(arrayList0 != null) {
                arrayList0.add(0x7F07004F);  // string:thousands ","
            }
            j0.put(0x7F07004F, ps.a);  // string:thousands ","
            if(arrayList0 != null) {
                qk.b = Tools.b(arrayList0);
            }
            qk.a = j0;
            return resources1;
        }
        return resources0;
    }

    public static String b(int v) {
        try {
            return qk.b().getResourceEntryName(v);
        }
        catch(Throwable throwable0) {
            String s = "Resource name for id 0x" + ts.a(8, ((long)v)) + " not found";
            la.c(s, throwable0);
            return s;
        }
    }

    private static String b(String s) {
        String s1;
        if(s == null) {
            s = "null";
        }
        if(s.indexOf(0x5F) >= 0) {
            try {
                Class class0 = R.string.class;
                s1 = s;
                Matcher matcher0 = qk.f.matcher(s);
                s1 = s;
                while(true) {
                    if(!matcher0.find()) {
                        return s1;
                    }
                    try {
                        int v = qk.a(matcher0.group(1), class0);
                        if(v == 0) {
                            continue;
                        }
                        s1 = s1.replace(matcher0.group(0), qk.c(v));
                    }
                    catch(Throwable throwable1) {
                        la.c(("Exception for: " + s), throwable1);
                    }
                }
            }
            catch(Throwable throwable0) {
                la.c(("Exception on: " + s), throwable0);
                return s1;
            }
        }
        return s;
    }

    private static String c(int v) {
        String s1;
        if(v == -1 || v == 0) {
            return "(Invalid resource id " + v + ")";
        }
        j j0 = qk.a;
        Object object0 = j0.a(v);
        String s = object0 == null ? null : object0.toString();
        if(s == null) {
            try {
                s1 = qk.b().getString(v);
            }
            catch(Throwable throwable0) {
                s1 = "Resource for id 0x" + ts.a(8, ((long)v)) + " not found";
                la.c(s1, throwable0);
            }
            s = qk.b(s1);
            try {
                j0.a(v, s);
            }
            catch(Throwable throwable1) {
                la.a(throwable1);
            }
            qk.c = System.currentTimeMillis();
            return s;
        }
        return s;
    }
}

