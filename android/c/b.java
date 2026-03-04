package android.c;

import android.view.View;

public class b {
    public static final String[] a;
    public static final View[] b;
    public static final byte[] c;
    public static final int[] d;
    public static final long[] e;
    public static final Object[] f;
    public static final boolean[] g;

    static {
        b.a = new String[0];
        b.c = new byte[0];
        b.d = new int[0];
        b.e = new long[0];
        b.f = new Object[0];
        b.g = new boolean[0];
        b.b = new View[0];
    }

    public static int a(int v) {
        return b.b(v * 8) / 8;
    }

    static int a(long[] arr_v, int v, long v1) {
        int v4;
        int v2 = 0;
        int v3 = v - 1;
        while(true) {
            if(v2 > v3) {
                return ~v2;
            }
            v4 = v2 + v3 >>> 1;
            long v5 = arr_v[v4];
            if(v5 < v1) {
                v2 = v4 + 1;
            }
            else {
                if(v5 <= v1) {
                    break;
                }
                v3 = v4 - 1;
            }
        }
        return v4;
    }

    public static int b(int v) {
        for(int v1 = 4; true; ++v1) {
            if(v1 >= 0x20) {
                return v;
            }
            if(v <= (1 << v1) - 12) {
                return (1 << v1) - 12;
            }
        }
    }
}

