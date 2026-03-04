package luaj.a;

import luaj.LuaValue;
import luaj.al;
import luaj.ao;
import luaj.l;
import luaj.m;
import luaj.o;

public class a extends m {
    public static int a(int v, int v1) {
        return v & 0x3F | v1 << 6 & 0xFFFFFFC0;
    }

    public static int a(int v, int v1, int v2) {
        return v & 0x3F | v1 << 6 & 0x3FC0 | v2 << 14 & 0xFFFFC000;
    }

    public static int a(int v, int v1, int v2, int v3) [...] // Inlined contents

    public static void a(e e0, int v) {
        e0.a(e0.a() & 0xFFFFFFC0 | v & 0x3F);
    }

    protected static void a(boolean z) {
        if(!z) {
            throw new o("compiler assert failed");
        }
    }

    public static void a(int[] arr_v, int v, int v1) {
        arr_v[v] = arr_v[v] & 0xFFFFC03F | v1 << 6 & 0x3FC0;
    }

    static char[] a(char[] arr_c, int v) {
        char[] arr_c1 = new char[v];
        if(arr_c != null) {
            System.arraycopy(arr_c, 0, arr_c1, 0, Math.min(arr_c.length, v));
        }
        return arr_c1;
    }

    static int[] a(int[] arr_v, int v) {
        int[] arr_v1 = new int[v];
        if(arr_v != null) {
            System.arraycopy(arr_v, 0, arr_v1, 0, Math.min(arr_v.length, v));
        }
        return arr_v1;
    }

    static LuaValue[] a(LuaValue[] arr_luaValue, int v) {
        LuaValue[] arr_luaValue1 = new LuaValue[v];
        if(arr_luaValue != null) {
            System.arraycopy(arr_luaValue, 0, arr_luaValue1, 0, Math.min(arr_luaValue.length, v));
        }
        return arr_luaValue1;
    }

    static luaj.a.m[] a(luaj.a.m[] arr_m, int v) {
        if(arr_m == null) {
            return new luaj.a.m[2];
        }
        return arr_m.length >= v ? arr_m : a.b(arr_m, arr_m.length * 2);
    }

    static q[] a(q[] arr_q, int v) {
        q[] arr_q1 = new q[v];
        if(arr_q != null) {
            System.arraycopy(arr_q, 0, arr_q1, 0, Math.min(arr_q.length, v));
        }
        return arr_q1;
    }

    static al[] a(al[] arr_al, int v) {
        al[] arr_al1 = new al[v];
        if(arr_al != null) {
            System.arraycopy(arr_al, 0, arr_al1, 0, Math.min(arr_al.length, v));
        }
        return arr_al1;
    }

    static ao[] a(ao[] arr_ao, int v) {
        ao[] arr_ao1 = new ao[v];
        if(arr_ao != null) {
            System.arraycopy(arr_ao, 0, arr_ao1, 0, Math.min(arr_ao.length, v));
        }
        return arr_ao1;
    }

    static l[] a(l[] arr_l, int v) {
        l[] arr_l1 = new l[v];
        if(arr_l != null) {
            System.arraycopy(arr_l, 0, arr_l1, 0, Math.min(arr_l.length, v));
        }
        return arr_l1;
    }

    public static void b(e e0, int v) {
        e0.a(e0.a() & 0xFFFFC03F | v << 6 & 0x3FC0);
    }

    static luaj.a.m[] b(luaj.a.m[] arr_m, int v) {
        luaj.a.m[] arr_m1 = new luaj.a.m[v];
        if(arr_m != null) {
            System.arraycopy(arr_m, 0, arr_m1, 0, Math.min(arr_m.length, v));
        }
        return arr_m1;
    }

    public static void c(e e0, int v) {
        e0.a(e0.a() & 0x7FFFFF | v << 23 & 0xFF800000);
    }

    public static void d(e e0, int v) {
        e0.a(e0.a() & 0xFF803FFF | v << 14 & 0x7FC000);
    }

    public static void e(e e0, int v) {
        e0.a(e0.a() & 0x3FFF | v << 14 & 0xFFFFC000);
    }

    public static void f(e e0, int v) {
        a.e(e0, v + 0x1FFFF);
    }
}

