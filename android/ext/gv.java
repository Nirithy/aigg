package android.ext;

public class gv {
    private static long[] a;

    static {
        gv.a = new long[12];
        for(int v = 0; v < 3; ++v) {
            long v1 = (1L << (1 << v) * 8) - 1L;
            gv.a[v * 4] = ~(v1 >> 1) & v1;
            gv.a[v * 4 + 1] = v1 >> 1;
            gv.a[v * 4 + 2] = ~(v1 >> 1);
            gv.a[v * 4 + 3] = v1;
        }
    }

    public static long a(long v, int v1, boolean z) {
        if(v1 != 3) {
            if(z) {
                return v & gv.a[v1 * 4 + 3];
            }
            return (gv.a[v1 * 4] & v) == 0L ? v & gv.a[v1 * 4 + 1] : v | gv.a[v1 * 4 + 2];
        }
        return v;
    }

    private static String a(long v) {
        String s = Tools.a("%,d", "%d", null, v);
        if(s == null) {
            s = Long.toString(v);
        }
        if(s == null) {
            return v == null ? "fail" : v;
        }
        return s == null ? "fail" : s;
    }

    public static String a(long v, int v1) {
        return gv.b(v, v1, false);
    }

    public static boolean a(long v, long v1, int v2) {
        int v3 = d.f(v2);
        if(v3 == 3) {
            return v < v1;
        }
        long v4 = gv.a[v3 * 4] & v;
        return v4 == (gv.a[v3 * 4] & v1) ? (gv.a[v3 * 4 + 1] & v) < (gv.a[v3 * 4 + 1] & v1) : v4 != 0L;
    }

    public static String b(long v, int v1, boolean z) {
        int v2 = d.f(v1);
        long v3 = gv.a(v, v2, z);
        return z ? ts.a(1 << v2 + 1, v3) : gv.a(v3);
    }
}

