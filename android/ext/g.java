package android.ext;

import android.c.f;
import java.util.ArrayList;
import java.util.List;

public class g {
    private final f[] a;

    public g() {
        this(10);
    }

    public g(int v) {
        f[] arr_f = new f[7];
        for(int v1 = 0; v1 < 7; ++v1) {
            arr_f[v1] = new f(v);
        }
        this.a = arr_f;
    }

    public void a() {
        f[] arr_f = this.a;
        for(int v = 0; v < 7; ++v) {
            arr_f[v].c();
        }
    }

    public void a(long v, int v1, h h0) {
        int v2 = Integer.numberOfTrailingZeros(v1);
        if(v2 < 7) {
            f f0 = this.a[v2];
            int v3 = f0.a(v);
            if(v3 >= 0) {
                h0.a = f0.b(v3);
                h0.b = true;
                return;
            }
        }
        h0.b = false;
    }

    public boolean a(long v, int v1, long v2) {
        int v3 = Integer.numberOfTrailingZeros(v1);
        return v3 >= 7 ? false : this.a[v3].a(v, v2);
    }

    public int b() {
        f[] arr_f = this.a;
        int v = 0;
        int v1 = 0;
        while(v1 < 7) {
            int v2 = arr_f[v1].b();
            ++v1;
            v = v2 + v;
        }
        return v;
    }

    public void c() {
        f[] arr_f = this.a;
        boolean z = false;
        for(int v = 0; v < 7; ++v) {
            f f0 = arr_f[v];
            int v1 = f0.b();
            if(v1 > 0) {
                if(!z) {
                    z = true;
                }
                int v2 = 0x1000000 | 1 << v;
                for(int v3 = 0; v3 < v1; ++v3) {
                    try {
                        d d0 = new d();
                        d0.d = v2;
                        d0.b = f0.a(v3);
                        d0.c = f0.b(v3);
                        d0.p();
                    }
                    catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                        la.b(("Concurent modification for " + v), arrayIndexOutOfBoundsException0);
                        if(true) {
                            break;
                        }
                    }
                }
            }
        }
        if(z) {
            MainService.instance.L();
        }
    }

    public List d() {
        List list0 = new ArrayList();
        f[] arr_f = this.a;
        for(int v = 0; v < 7; ++v) {
            f f0 = arr_f[v];
            int v1 = f0.b();
            if(v1 > 0) {
                int v2 = 1 << v;
                for(int v3 = 0; v3 < v1; ++v3) {
                    try {
                        d d0 = new d();
                        d0.d = v2;
                        d0.b = f0.a(v3);
                        d0.c = f0.b(v3);
                        list0.add(d0);
                    }
                    catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                        la.b(("Concurent modification for " + v), arrayIndexOutOfBoundsException0);
                        if(true) {
                            break;
                        }
                    }
                }
            }
        }
        return list0;
    }
}

