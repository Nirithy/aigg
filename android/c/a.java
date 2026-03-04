package android.c;

import android.ext.d;

public class a {
    int a;
    private long[] b;
    private int[] c;
    private boolean[] d;

    public a() {
        this(0);
    }

    public a(int v) {
        this.c(b.a(v));
    }

    static IndexOutOfBoundsException a(int v, int v1) {
        throw new IndexOutOfBoundsException("Invalid index " + v + ", size is " + v1);
    }

    public d a(int v, d d0) {
        if(v >= this.a) {
            a.a(v, this.a);
        }
        if(d0 == null) {
            return new d(this.b[v * 2], this.b[v * 2 + 1], this.c[v]);
        }
        d0.b = this.b[v * 2];
        d0.c = this.b[v * 2 + 1];
        d0.d = this.c[v];
        return d0;
    }

    public void a() {
        if(this.a == this.d.length) {
            return;
        }
        this.c(this.a);
    }

    public void a(int v) {
        if(this.c.length < v) {
            this.c(v);
        }
    }

    public void a(int v, boolean z) {
        this.d[v] = z;
    }

    public void a(long v, long v1, int v2, boolean z) {
        int v3 = this.a;
        if(v3 == this.c.length) {
            this.d();
        }
        this.b[v3 * 2] = v;
        this.b[v3 * 2 + 1] = v1;
        this.c[v3] = v2;
        this.d[v3] = z;
        this.a = v3 + 1;
    }

    public int b() {
        return this.a;
    }

    public boolean b(int v) {
        return this.d[v];
    }

    private void c(int v) {
        boolean[] arr_z;
        int[] arr_v1;
        long[] arr_v;
        if(v == 0) {
            arr_v = b.e;
            arr_v1 = b.d;
            arr_z = b.g;
        }
        else {
            arr_v = new long[v * 2];
            arr_v1 = new int[v];
            arr_z = new boolean[v];
        }
        int v1 = this.a;
        if(v1 != 0) {
            System.arraycopy(this.b, 0, arr_v, 0, v1 * 2);
            System.arraycopy(this.c, 0, arr_v1, 0, v1);
            System.arraycopy(this.d, 0, arr_z, 0, v1);
        }
        this.b = arr_v;
        this.c = arr_v1;
        this.d = arr_z;
    }

    public void c() {
        this.a = 0;
    }

    private void d() {
        this.c((this.a >= 6 ? this.a >> 1 : 12) + this.a);
    }
}

