package android.ext;

import android.view.View;

public class uf extends pj {
    static volatile boolean a;
    static volatile long b;
    static volatile boolean c;
    static volatile long d;
    static volatile boolean g;
    static volatile double h;
    static volatile boolean i;
    static volatile double j;
    static volatile uf k;

    static {
        uf.a = false;
        uf.b = 0L;
        uf.c = false;
        uf.d = 1L;
        uf.g = false;
        uf.h = 0.0;
        uf.i = false;
        uf.j = 0.01;
        uf.k = null;
    }

    public uf() {
        super(0x7F07027B, 0x7F02001C);  // string:unrandomizer "Unrandomizer"
        uf.k = this;
    }

    public static void a() {
        uf.a = false;
        uf.c = false;
        uf.g = false;
        uf.i = false;
    }

    public static void a(int v, long v1, long v2, double f, double f1) {
        MainService.instance.k.a(v, v1, v2, f, f1);
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        new ug(this, null).onClick(view0);
    }
}

