package android.ext;

import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class qh implements Comparable {
    public String a;
    public String b;
    public String c;
    public String d;
    public volatile Drawable e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public long k;
    public boolean l;
    public int m;
    public boolean n;
    public int o;
    public static final int p;
    public static final int q;
    public static final int r;
    private volatile boolean s;
    private static WeakReference t;

    static {
        qh.t = null;
        qh.p = Tools.c(0x7F0A001D, 0xFFAAFFFF);  // color:process_pid
        qh.q = Tools.c(0x7F0A001E, -1);  // color:process_name
        qh.r = Tools.c(0x7F0A001F, 0xFFAAFFAA);  // color:process_size
    }

    public qh(qg qg0, int v, int v1, String s, int v2, boolean z, int v3) {
        this.s = false;
        this.a = s;
        this.b = qg0.d;
        this.c = qg0.c;
        this.d = qg0.e == null ? "" : qg0.e;
        this.e = null;
        this.f = v;
        this.g = v1;
        if(!qg0.h) {
            v1 = qg0.b;
        }
        this.h = v1;
        this.l = s.equals(qg0.c);
        this.i = qg0.f;
        this.j = qg0.g;
        this.m = v2;
        this.n = z;
        this.o = v3;
        if(qg0.h) {
            this.s = true;
        }
    }

    public int a(qh qh0) {
        if(this.m != qh0.m) {
            return this.m <= qh0.m ? 1 : -1;
        }
        if(this.j != qh0.j) {
            return this.j ? -1 : 1;
        }
        if(this.i != qh0.i) {
            return this.i ? 1 : -1;
        }
        if(this.k != qh0.k) {
            return this.k > qh0.k ? -1 : 1;
        }
        if(this.l != qh0.l) {
            return this.l ? -1 : 1;
        }
        if((this.e() <= 0 ? 0 : 1) != (qh0.e() <= 0 ? 0 : 1)) {
            return this.e() <= 0 ? -1 : 1;
        }
        if(this.f != qh0.f) {
            return this.f > qh0.f ? -1 : 1;
        }
        return 0;
    }

    public void a() {
        if(this.g == this.h) {
            return;
        }
        else {
            la.b(("vs app: " + this.h + " != " + this.g));
            try {
                String s = qf.h.a(this.g);
                if(s != null) {
                    ApplicationInfo applicationInfo0 = Tools.j(s);
                    if(applicationInfo0 != null && applicationInfo0.nativeLibraryDir != null) {
                        la.b(("vs: " + this.d + " => " + applicationInfo0.nativeLibraryDir));
                        this.d = applicationInfo0.nativeLibraryDir;
                        return;
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        la.b(("Failed get vs info for " + this.g), throwable0);
    }

    public void a(TextView textView0) {
        if(textView0 != null) {
            boolean z = this.s;
            Drawable drawable0 = this.e;
            if(drawable0 == null) {
                WeakReference weakReference0 = qh.t;
                if(weakReference0 != null) {
                    drawable0 = (Drawable)weakReference0.get();
                }
                if(drawable0 == null) {
                    drawable0 = Tools.b(0x7F02000B);  // drawable:empty
                    qh.t = new WeakReference(drawable0);
                }
            }
            Tools.a(textView0, drawable0, 0x30);
            if(!z) {
                rx.b(new qi(this, textView0));
            }
        }
    }

    public void b() {
        if(!this.s) {
            try {
                this.e = Tools.a(Tools.a(Tools.b(Tools.j(this.c)), Tools.b()));
            }
            catch(Throwable unused_ex) {
                la.b(("Failed load icon for " + this.c));
            }
            this.s = true;
        }
    }

    public CharSequence c() {
        bp bp0 = new bp();
        StringBuilder stringBuilder0 = new StringBuilder();
        if(this.f() > 0) {
            stringBuilder0.append('#');
        }
        if(this.e() > 0) {
            stringBuilder0.append('!');
        }
        if(this.g != this.h) {
            stringBuilder0.append('v');
        }
        if(this.f > 1) {
            stringBuilder0.append('[');
            stringBuilder0.append(Integer.toString(this.f));
            stringBuilder0.append("] ");
        }
        bp0.a(Tools.a(stringBuilder0.toString(), qh.p));
        bp0.a(Tools.a((this.b + this.g()), qh.q));
        StringBuilder stringBuilder1 = new StringBuilder();
        if(this.n) {
            stringBuilder1.append(" [x64]");
        }
        if(this.o != 0) {
            stringBuilder1.append(" [");
            stringBuilder1.append(Tools.a(Tools.e(), 0x400L * ((long)this.o)));
            stringBuilder1.append(']');
        }
        bp0.a(Tools.a(stringBuilder1.toString(), qh.r));
        return bp0.a();
    }

    @Override
    public int compareTo(Object object0) {
        return this.a(((qh)object0));
    }

    public String d() {
        return "ProcessInfo [cmdline=" + this.a + ", name=" + this.b + ", packageName=" + this.c + ", icon=" + this.e + ", pid=" + this.f + ", uid=" + this.g + ", isSystem=" + this.i + ", isGame=" + this.j + ", weight=" + this.k + ", main=" + this.l + ", order=" + this.m + ", x64=" + this.n + ", rss=" + this.o + ", getTracer()=" + this.f() + ", getTrace()=" + this.e() + ']';
    }

    public int e() {
        int v = qf.a.indexOfValue(this.f);
        return v < 0 ? v : qf.a.keyAt(v);
    }

    public int f() {
        return qf.a.get(this.f);
    }

    // 去混淆评级： 低(20)
    private String g() {
        return this.l ? "" : " (" + this.a.replace(String.valueOf(this.c) + ':', "") + ')';
    }

    @Override
    public String toString() {
        return this.c().toString();
    }
}

