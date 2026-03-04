package android.ext;

import android.fix.j;
import android.util.SparseIntArray;

public class d {
    public static final long[] a;
    public long b;
    public long c;
    public int d;
    private static j e;
    private static j f;
    private static j g;
    private static j h;
    private static SparseIntArray i;
    private static int j;
    private static final int[] k;

    static {
        d.a = new long[]{0L, 0xFFL, 0xFFFFL, 0xFFFFFFL, 0xFFFFFFFFL, 0xFFFFFFFFFFL, 0xFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFL, -1L};
        d.e = null;
        d.f = null;
        d.g = null;
        d.h = null;
        d.i = null;
        d.j = 0xFFFFFF;
        Object[] arr_object = ps.a();
        j j0 = new j();
        j j1 = new j();
        d.a(j0, j1, 1, "B: %s (%,d - %,d)", 0x7F070007, arr_object[0], arr_object[1]);  // string:type_byte "Byte"
        d.a(j0, j1, 2, "W: %s (%,d - %,d)", 0x7F070008, arr_object[2], arr_object[3]);  // string:type_word "Word"
        d.a(j0, j1, 4, "D: %s (%,d - %,d)", 0x7F070009, arr_object[4], arr_object[5]);  // string:type_dword "Dword"
        d.a(j0, j1, 8, "X: %s (%,d - %,d)", 0x7F07000A, arr_object[4], arr_object[5]);  // string:type_xor "Xor"
        d.a(j0, j1, 16, "F: %s (%.1e - %.1e)", 0x7F07000B, -3.402823E+38f, 3.402823E+38f);  // string:type_float "Float"
        d.a(j0, j1, 0x20, "Q: %s (%,d - %,d)", 0x7F07000C, arr_object[6], arr_object[7]);  // string:type_qword "Qword"
        d.a(j0, j1, 0x40, "E: %s (%.1e - %.1e)", 0x7F07000D, -1.797693E+308, 1.797693E+308);  // string:type_double "Double"
        d.f = j1;
        d.e = j0;
        d.updateLocale();
        j j2 = new j();
        j2.append(0x20000000, "=");
        j2.append(0x4000000, "≥");
        j2.append(0x8000000, "≤");
        j2.append(0x10000000, "≠");
        d.g = j2;
        j j3 = new j();
        j3.append(0x20000000, "=");
        j3.append(0x10000000, "≠");
        d.h = j3;
        ad.a(d.class);
        d.k = new int[]{8, 0x20, 1, 2, 0x40, 16, 4};
    }

    protected d() {
    }

    public d(long v, long v1, int v2) {
        this.b = v;
        this.c = v1;
        this.d = v2;
    }

    public d(d d0) {
        this(d0.b, d0.c, d0.d);
    }

    public static int a(int v) {
        switch(v) {
            case 1: {
                return 50;
            }
            case 2: {
                return 40;
            }
            case 4: {
                return 10;
            }
            case 8: {
                return 70;
            }
            case 16: {
                return 20;
            }
            case 0x20: {
                return 60;
            }
            case 0x40: {
                return 30;
            }
            default: {
                return 0xFA;
            }
        }
    }

    public static int a(int v, long v1, boolean z) {
        int v2 = 1;
        if(v == 0x40 || v == 80) {
            return v;
        }
        if(z) {
            if(v1 >> 7 == -1L) {
                v2 = 0;
            }
            if(v1 >> 15 != -1L) {
                v2 |= 2;
            }
            if(v1 >> 0x1F != -1L) {
                v2 |= 12;
            }
            return v & ~v2;
        }
        if(v1 >> 8 == 0L) {
            v2 = 0;
        }
        if(v1 >> 16 != 0L) {
            v2 |= 2;
        }
        return v1 >> 0x20 == 0L ? v & ~v2 : v & ~(v2 | 12);
    }

    public static int a(long v, boolean z) {
        return d.a(v, z, null);
    }

    public static int a(long v, boolean z, SparseIntArray sparseIntArray0) {
        int v1 = 0x20;
        if((3L & v) != 0L) {
        label_6:
            int v2 = 0;
            if((3L & v) == 0L) {
                if(z) {
                    return 4;
                }
                if(sparseIntArray0 != null) {
                    sparseIntArray0.put(4, sparseIntArray0.get(4) + 1);
                    sparseIntArray0.put(8, sparseIntArray0.get(8) + 1);
                    sparseIntArray0.put(16, sparseIntArray0.get(16) + 1);
                }
            }
            if((1L & v) == 0L) {
                v2 = 2;
                if(z) {
                    return 2;
                }
                if(sparseIntArray0 != null) {
                    sparseIntArray0.put(2, sparseIntArray0.get(2) + 1);
                }
            }
            v1 = v2 | 1;
            if(sparseIntArray0 != null) {
                sparseIntArray0.put(1, sparseIntArray0.get(1) + 1);
                return v1;
            }
        }
        else if(!z) {
            if(sparseIntArray0 != null) {
                sparseIntArray0.put(0x20, sparseIntArray0.get(0x20) + 1);
                sparseIntArray0.put(0x40, sparseIntArray0.get(0x40) + 1);
            }
            goto label_6;
        }
        return v1;
    }

    public static long a(long v, int v1) [...] // Inlined contents

    public static long a(long v, String s, int v1) {
        long v2 = d.a(null, s, v1 & 0x7F, 0x7F0700CF, v).a;  // string:number_name "number"
        return (v1 & 0x7F) == 8 ? v2 ^ v : v2;
    }

    public static long a(pv pv0, String s, int v) {
        return d.a(pv0, s, v & 0x7F, 0x7F0700CF, 0L).a;  // string:number_name "number"
    }

    public static pv a(pv pv0, String s, int v, int v1, long v2) {
        try {
            return ps.a(pv0, s, v, true, v2);
        }
        catch(NumberFormatException numberFormatException0) {
            String s1 = qk.a(v1);
            la.b(("Failed parse \'" + s + "\' as " + v + " on \'" + s1 + '\''), numberFormatException0);
            if(numberFormatException0 instanceof pt || numberFormatException0 instanceof ak) {
                throw numberFormatException0;
            }
            NumberFormatException numberFormatException1 = new NumberFormatException(s1 + ": " + numberFormatException0.getMessage());
            numberFormatException1.initCause(numberFormatException0);
            throw numberFormatException1;
        }
    }

    public static j a(int v, long v1) {
        j j0 = d.b(v);
        j0.remove(0x7F);
        if((v1 & 3L) != 0L) {
            j0.remove(0x20);
            j0.remove(0x40);
        }
        if((v1 & 3L) != 0L) {
            j0.remove(4);
            j0.remove(8);
            j0.remove(16);
        }
        if((1L & v1) != 0L) {
            j0.remove(2);
        }
        return j0;
    }

    public static j a(int v, boolean z) {
        j j0 = new j();
        int v1 = d.e.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            int v3 = d.e.keyAt(v2);
            if((v & v3) == v3) {
                j0.append(v3, ((CharSequence)d.e.valueAt(v2)));
            }
        }
        if(z && j0.get(v) == null) {
            j0.append(v, ((CharSequence)d.e.get(0x7F)));
        }
        return j0;
    }

    public static String a(long v, long v1, int v2) {
        return d.b(v, v1, v2).trim();
    }

    private static String a(long v, long v1, int v2, boolean z) {
        long v3 = (v2 & 0x7F) == 8 ? v1 ^ v : v1;
        if(z) {
            int v4 = d.d(v2 & 0x7F);
            v3 = Long.reverseBytes(v3) >> 0x40 - v4 * 8;
            if(v4 != 8) {
                v3 &= (1L << v4 * 8) - 1L;
            }
        }
        return gv.b(v3, v2 & 0x7F, true);
    }

    private static void a(j j0, j j1, int v, String s, int v1, Object object0, Object object1) {
        String s1 = qk.a(v1);
        int v2 = d.k(v);
        j0.append(v, Tools.a(Tools.a(s, new Object[]{s1, object0, object1}), v2));
        j1.append(v, Tools.a(s1, v2));
    }

    public static e[] a(j j0, SparseIntArray sparseIntArray0) {
        int v11;
        int v8;
        int v = j0.size();
        e[] arr_e = new e[v];
        if(v == 1) {
            int v1 = j0.keyAt(0);
            arr_e[0] = new e(v1, ((CharSequence)j0.valueAt(0)), (sparseIntArray0 == null ? 0 : sparseIntArray0.get(v1)));
            return arr_e;
        }
        boolean[] arr_z = new boolean[v];
        int v2 = v - 1;
        for(int v3 = 0; v3 < v; ++v3) {
            int v4 = j0.keyAt(v3);
            if(v4 > -10) {
                break;
            }
            arr_e[v2] = new e(v4, ((CharSequence)j0.valueAt(v3)), (sparseIntArray0 == null ? 0 : sparseIntArray0.get(v4)));
            arr_z[v3] = true;
            --v2;
        }
        int[] arr_v = d.k;
        int v5 = 0;
        while(v5 < arr_v.length) {
            int v6 = arr_v[v5];
            int v7 = j0.indexOfKey(v6);
            if(v7 < 0) {
                v8 = v2;
            }
            else if(arr_z[v7]) {
                v8 = v2;
            }
            else {
                arr_e[v2] = new e(v6, ((CharSequence)j0.valueAt(v7)), (sparseIntArray0 == null ? 0 : sparseIntArray0.get(v6)));
                arr_z[v7] = true;
                v8 = v2 - 1;
            }
            ++v5;
            v2 = v8;
        }
        int v9 = 0;
        for(int v10 = 0; v9 < v; v10 = v11) {
            if(arr_z[v9]) {
                v11 = v10;
            }
            else {
                int v12 = j0.keyAt(v9);
                arr_e[v10] = new e(v12, ((CharSequence)j0.valueAt(v9)), (sparseIntArray0 == null ? 0 : sparseIntArray0.get(v12)));
                v11 = v10 + 1;
            }
            ++v9;
        }
        return arr_e;
    }

    public d a() {
        return new d(this);
    }

    public f a(f f0, pv pv0, String s, long v, String s1, int v1) {
        long v3;
        if(pv0 == null) {
            pv0 = d.a(null, s, this.d, 0x7F0700CF, v);  // string:number_name "number"
        }
        long v2 = pv0.a;
        if(v1 == 0) {
            v3 = v2;
        }
        else {
            if(f0 == null) {
                pv pv1 = d.a(null, s1, this.d, 0x7F0700D0, 0L);  // string:step_name "increment"
                f0 = new f();
                f0.a = Float.intBitsToFloat(((int)pv1.a));
                f0.b = Double.longBitsToDouble(pv1.a);
                f0.c = pv1.a;
            }
            switch(pv0.c) {
                case 16: {
                    v3 = (long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)v2)) + f0.a * ((float)v1));
                    break;
                }
                case 0x40: {
                    v3 = Double.doubleToRawLongBits(Double.longBitsToDouble(v2) + f0.b * ((double)v1));
                    break;
                }
                default: {
                    v3 = f0.c * ((long)v1) + v2;
                }
            }
        }
        if(this.d == 8) {
            v3 ^= this.b;
        }
        this.c = v3;
        return f0;
    }

    public void a(String s) {
        this.c = d.a(this.b, s, this.d);
    }

    public static j b() {
        return d.g;
    }

    public static j b(int v) {
        return d.a(v, false);
    }

    public static String b(long v, int v1) {
        return ts.a(8, v);
    }

    public static String b(long v, long v1, int v2) {
        String s;
        switch(v2 & 0x7F) {
            case 8: {
                return gv.a(v1 ^ v, v2 & 0x7F);
            }
            case 16: {
                s = ek.c(v1);
                return s == null ? gv.a(v1, v2 & 0x7F) : s;
            }
            case 0x40: 
            case 80: {
                s = ek.b(v1);
                return s == null ? gv.a(v1, v2 & 0x7F) : s;
            }
            default: {
                return gv.a(v1, v2 & 0x7F);
            }
        }
    }

    public static long c(long v, int v1) {
        long v2;
        switch(v1 & 0x7F) {
            case 1: {
                v2 = (long)(((byte)(((int)v))));
                break;
            }
            case 2: {
                v2 = (long)(((short)(((int)v))));
                break;
            }
            case 4: 
            case 8: {
                v2 = (long)(((int)v));
                break;
            }
            default: {
                v2 = v;
            }
        }
        if(v != v2) {
            la.a(("fixValue[" + v1 + ", " + Integer.toHexString(v1) + "]: " + v + '[' + Long.toHexString(v) + "] -> " + v2 + '[' + Long.toHexString(v2) + ']'));
        }
        return v2;
    }

    public static j c() {
        return d.h;
    }

    public static j c(int v) {
        return d.a(v, 0L);
    }

    public static String c(long v, long v1, int v2) {
        return d.a(v, v1, v2, true);
    }

    public static int d(int v) [...] // 潜在的解密器

    public static String d(long v, long v1, int v2) {
        return d.a(v, v1, v2, false);
    }

    public int d() {
        return d.d(this.d);
    }

    public static int e(int v) {
        if((v & 0x60) == 0 && (v & 28) == 0) {
            if((v & 2) != 0) {
                return 2;
            }
            return (v & 1) == 0 ? 4 : 1;
        }
        return 4;
    }

    public int e() {
        return d.e(this.d);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        return this.b == ((d)object0).b ? ((this.d ^ ((d)object0).d) & 0x7F) == 0 : false;
    }

    public static int f(int v) {
        if((v & 0x60) != 0) {
            return 3;
        }
        if((v & 28) != 0) {
            return 2;
        }
        if((v & 2) != 0) {
            return 1;
        }
        return (v & 1) == 0 ? 3 : 0;
    }

    public long f() {
        return this.b;
    }

    public static CharSequence g(int v) {
        return d.j(v & 0x7F).toString().substring(0, 1).intern();
    }

    public String g() [...] // 潜在的解密器

    public static int h(int v) {
        switch(v & 0x7F) {
            case 0: 
            case 1: 
            case 2: 
            case 4: 
            case 8: 
            case 16: 
            case 0x20: 
            case 0x40: 
            case 0x7F: {
                return v & 0x7F;
            }
            default: {
                return 0x7F;
            }
        }
    }

    public String h() {
        return d.a(this.b, this.c, this.d);
    }

    @Override
    public int hashCode() {
        return (((int)(this.b ^ this.b >>> 0x20)) + 0x1F) * 0x1F + (this.d & 0x7F);
    }

    public static CharSequence i(int v) {
        CharSequence charSequence0 = (CharSequence)d.f.get(d.h(v));
        return charSequence0 == null ? "Unknown" : charSequence0;
    }

    public String i() {
        return d.b(this.b, this.c, this.d);
    }

    public static CharSequence j(int v) {
        CharSequence charSequence0 = (CharSequence)d.e.get(d.h(v));
        return charSequence0 == null ? "Unknown" : charSequence0;
    }

    public String j() [...] // 潜在的解密器

    public static int k(int v) {
        try {
            SparseIntArray sparseIntArray0 = d.i;
            if(sparseIntArray0 == null) {
                sparseIntArray0 = new SparseIntArray(8);
                sparseIntArray0.append(1, Tools.e(0x7F0A0005));  // color:type_byte
                sparseIntArray0.append(2, Tools.e(0x7F0A0006));  // color:type_word
                sparseIntArray0.append(4, Tools.e(0x7F0A0007));  // color:type_dword
                sparseIntArray0.append(8, Tools.e(0x7F0A0009));  // color:type_xor
                sparseIntArray0.append(16, Tools.e(0x7F0A000A));  // color:type_float
                sparseIntArray0.append(0x20, Tools.e(0x7F0A0008));  // color:type_qword
                sparseIntArray0.append(0x40, Tools.e(0x7F0A000B));  // color:type_double
                d.i = sparseIntArray0;
                d.j = Tools.e(0x7F0A0004);  // color:type_unknown
            }
            int v1 = sparseIntArray0.get(d.h(v));
            return v1 == 0 ? d.j : v1;
        }
        catch(Throwable throwable0) {
            la.c(("Failed getColor for: " + v), throwable0);
            return d.j;
        }
    }

    public String k() [...] // 潜在的解密器

    public static String l(int v) {
        if(v == 0 || (v & 0x40) != 0) {
            return Tools.a(qk.a(0x7F0700CE), new Object[]{Tools.a("%.1e", new Object[]{-1.797693E+308}), Tools.a("%.1e", new Object[]{1.797693E+308})});  // string:type_edit_limit "Input value from __s__ to __s__"
        }
        if((v & 16) != 0) {
            return Tools.a(qk.a(0x7F0700CE), new Object[]{Tools.a("%.1e", new Object[]{-3.402823E+38f}), Tools.a("%.1e", new Object[]{3.402823E+38f})});  // string:type_edit_limit "Input value from __s__ to __s__"
        }
        Object[] arr_object = ps.a();
        int v1 = d.f(v);
        return Tools.a(qk.a(0x7F0700CE), new Object[]{Tools.a("%,d", new Object[]{arr_object[v1 * 2]}), Tools.a("%,d", new Object[]{arr_object[v1 * 2 + 1]})});  // string:type_edit_limit "Input value from __s__ to __s__"
    }

    public CharSequence l() {
        return d.g(this.d);
    }

    public int m() {
        return d.h(this.d);
    }

    public void m(int v) {
        MainService.instance.k.a(this, v);
    }

    public CharSequence n() {
        return d.i(this.d);
    }

    public int o() {
        return d.k(this.d);
    }

    public void p() {
        this.m(0);
    }

    public boolean q() {
        return (this.b & ((long)(this.e() - 1))) == 0L;
    }

    @Override
    public String toString() {
        return this.g() + ": " + this.i() + ' ' + this.n() + " (" + this.d + ')';
    }

    public static void updateLocale() {
        d.a(d.e, d.f, 0x7F, "A: %s (%.1e - %.1e) (" + qk.a(0x7F0700C5) + ')', 0x7F07000E, -1.797693E+308, 1.797693E+308);  // string:slow "slow"
    }
}

