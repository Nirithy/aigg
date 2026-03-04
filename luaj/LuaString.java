package luaj;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;

public class LuaString extends LuaValue {
    public static LuaValue a;
    public final byte[] b;
    public final int c;
    public final int d;
    public final int e;
    private LuaValue f;
    private static final boolean[] g;

    static {
        LuaString.g = new boolean[0x80];
        for(int v = 0x30; v <= 57; v = (byte)(v + 1)) {
            LuaString.g[v] = true;
        }
        for(int v1 = 65; v1 <= 70; v1 = (byte)(v1 + 1)) {
            LuaString.g[v1] = true;
        }
        for(int v2 = 97; v2 <= 102; v2 = (byte)(v2 + 1)) {
            LuaString.g[v2] = true;
        }
        LuaString.g[13] = true;
        LuaString.g[10] = true;
        LuaString.g[9] = true;
        LuaString.g[0x20] = true;
        LuaString.g[43] = true;
        LuaString.g[45] = true;
        LuaString.g[46] = true;
        LuaString.g[80] = true;
        LuaString.g[0x70] = true;
        LuaString.g[88] = true;
        LuaString.g[120] = true;
    }

    private LuaString(byte[] arr_b, int v, int v1) {
        this.f = null;
        this.b = arr_b;
        this.c = v;
        this.d = v1;
        this.e = LuaString.c(arr_b, v, v1);
    }

    LuaString(byte[] arr_b, int v, int v1, LuaString luaString0) {
        this(arr_b, v, v1);
    }

    @Override  // luaj.LuaValue
    public boolean E() {
        return this.S().E();
    }

    @Override  // luaj.LuaValue
    public LuaNumber G() {
        LuaValue luaValue0 = this.S();
        return luaValue0.F() ? super.G() : luaValue0.G();
    }

    @Override  // luaj.LuaValue
    public LuaValue H() {
        byte[] arr_b = this.b;
        int v = this.c;
        int v1 = this.d;
        boolean[] arr_z = LuaString.g;
        for(int v2 = 0; true; ++v2) {
            if(v2 >= v1) {
                try {
                    return LuaValue.c(new String(arr_b, v, v1), LuaString.u);
                }
                catch(Throwable unused_ex) {
                    return LuaString.u;
                }
            }
            int v3 = arr_b[v + v2];
            if(v3 < 9 || !arr_z[v3]) {
                return LuaString.u;
            }
        }
    }

    @Override  // luaj.LuaValue
    public boolean I() {
        return this.S().I();
    }

    @Override  // luaj.LuaValue
    public boolean J() {
        return true;
    }

    @Override  // luaj.LuaValue
    public LuaValue K() {
        return LuaLong.b(this.d);
    }

    @Override  // luaj.LuaValue
    public int L() {
        return this.d;
    }

    @Override  // luaj.LuaValue
    public int M() {
        return this.d;
    }

    public LuaString P() {
        return new LuaString.DeprecatedLuaString(this.b, this.c, this.d);
    }

    private LuaValue S() {
        LuaValue luaValue0 = this.f;
        if(luaValue0 == null) {
            luaValue0 = this.H();
            this.f = luaValue0;
        }
        return luaValue0;
    }

    public static LuaString a(byte[] arr_b) {
        return LuaString.a(arr_b, 0, arr_b.length);
    }

    public static LuaString a(byte[] arr_b, int v, int v1) {
        LuaString luaString0 = LuaString.g(arr_b, v, v1);
        if(luaString0 == null) {
            if(v1 > 0x20) {
                return LuaString.f(arr_b, v, v1);
            }
            int v2 = LuaString.c(arr_b, v, v1);
            luaString0 = r.a[v2 & 0x7F];
            if(luaString0 == null || luaString0.e != v2 || !luaString0.h(arr_b, v, v1)) {
                luaString0 = LuaString.f(arr_b, v, v1);
                r.a[v2 & 0x7F] = luaString0;
                return luaString0;
            }
        }
        return luaString0;
    }

    public static LuaString a(char[] arr_c, int v, int v1) {
        byte[] arr_b = new byte[v1];
        for(int v2 = 0; v2 < v1; ++v2) {
            arr_b[v2] = (byte)arr_c[v2 + v];
        }
        return LuaString.b(arr_b, 0, v1);
    }

    public static boolean a(LuaString luaString0, int v, LuaString luaString1, int v1, int v2) {
        return LuaString.a(luaString0.b, luaString0.c + v, luaString1.b, luaString1.c + v1, v2);
    }

    public static boolean a(byte[] arr_b, int v, byte[] arr_b1, int v1, int v2) {
        if(arr_b.length >= v + v2 && arr_b1.length >= v1 + v2) {
            while(true) {
                --v2;
                if(v2 < 0) {
                    return true;
                }
                if(arr_b[v] != arr_b1[v1]) {
                    break;
                }
                ++v1;
                ++v;
            }
        }
        return false;
    }

    public int a(byte b, int v) {
        while(true) {
            if(v >= this.d) {
                return -1;
            }
            if(this.b[this.c + v] == b) {
                break;
            }
            ++v;
        }
        return v;
    }

    public int a(LuaString luaString0, int v) {
        int v1 = luaString0.L();
        int v2 = this.d - v1;
        int v3;
        for(v3 = v; true; ++v3) {
            if(v3 > v2) {
                return -1;
            }
            if(LuaString.a(this.b, this.c + v3, luaString0.b, luaString0.c, v1)) {
                break;
            }
        }
        return v3;
    }

    public LuaString a(int v, int v1) {
        int v2 = this.c + v;
        int v3 = v1 - v;
        return v3 < this.d / 2 ? LuaString.a(this.b, v2, v3) : LuaString.b(this.b, v2, v3);
    }

    @Override  // luaj.LuaValue
    public LuaString a(LuaString luaString0) {
        return this;
    }

    @Override  // luaj.LuaValue
    public LuaValue a(LuaNumber luaNumber0) {
        return this.b(luaNumber0.t());
    }

    public void a(int v, byte[] arr_b, int v1, int v2) {
        System.arraycopy(this.b, this.c + v, arr_b, v1, v2);
    }

    public void a(DataOutputStream dataOutputStream0, int v, int v1) {
        dataOutputStream0.write(this.b, this.c + v, v1);
    }

    @Override  // luaj.LuaValue
    public long a_(long v) {
        return this.w();
    }

    public static LuaString b(byte[] arr_b) {
        return LuaString.b(arr_b, 0, arr_b.length);
    }

    public static LuaString b(byte[] arr_b, int v, int v1) {
        LuaString luaString0 = LuaString.g(arr_b, v, v1);
        if(luaString0 == null) {
            if(arr_b.length > 0x20) {
                return new LuaString(arr_b, v, v1);
            }
            int v2 = LuaString.c(arr_b, v, v1);
            luaString0 = r.a[v2 & 0x7F];
            if(luaString0 == null || luaString0.e != v2 || !luaString0.h(arr_b, v, v1)) {
                luaString0 = new LuaString(arr_b, v, v1);
                r.a[v2 & 0x7F] = luaString0;
                return luaString0;
            }
        }
        return luaString0;
    }

    @Override  // luaj.LuaValue
    public double b(double f) {
        return this.x();
    }

    public int b(int v) {
        return this.b[this.c + v] & 0xFF;
    }

    @Override  // luaj.LuaValue
    public LuaNumber b(String s) {
        LuaValue luaValue0 = this.S();
        return luaValue0.F() ? super.b(s) : luaValue0.b(s);
    }

    @Override  // luaj.LuaValue
    public LuaValue b(LuaString luaString0) {
        byte[] arr_b = new byte[luaString0.d + this.d];
        System.arraycopy(luaString0.b, luaString0.c, arr_b, 0, luaString0.d);
        System.arraycopy(this.b, this.c, arr_b, luaString0.d, this.d);
        return LuaString.b(arr_b, 0, arr_b.length);
    }

    @Override  // luaj.LuaValue
    public boolean b(LuaValue luaValue0) {
        return luaValue0.d(this);
    }

    @Override  // luaj.LuaValue
    public int b_(int v) {
        return this.v();
    }

    @Override  // luaj.LuaValue
    public String b_(String s) {
        return this.d_();
    }

    public static int c(byte[] arr_b, int v, int v1) {
        int v2 = (v1 >> 5) + 1;
        int v3 = v1;
        int v4 = v1;
        while(v3 >= v2) {
            v4 ^= (v4 << 5) + (v4 >> 2) + (arr_b[v + v3 - 1] & 0xFF);
            v3 -= v2;
        }
        return v4 >>> 6 | v4 << 26;
    }

    public static LuaString c(String s) {
        LuaString luaString0 = LuaString.e(s);
        if(luaString0 != null) {
            return luaString0;
        }
        byte[] arr_b = s.getBytes();
        return LuaString.b(arr_b, 0, arr_b.length);
    }

    @Override  // luaj.LuaValue
    public int c(LuaString luaString0) {
        int v = 0;
        for(int v1 = 0; true; ++v1) {
            if(v1 >= this.d || v >= luaString0.d) {
                return this.d - luaString0.d;
            }
            if(this.b[this.c + v1] != luaString0.b[luaString0.c + v]) {
                return this.b[v1 + this.c] - luaString0.b[v + luaString0.c];
            }
            ++v;
        }
    }

    @Override  // luaj.LuaValue
    public boolean c(LuaValue luaValue0) {
        return luaValue0.d(this);
    }

    public static String d(byte[] arr_b, int v, int v1) {
        return new String(arr_b, v, v1);
    }

    static LuaString d(String s) {
        byte[] arr_b = s.getBytes();
        return new LuaString(arr_b, 0, arr_b.length);
    }

    @Override  // luaj.LuaValue
    public LuaValue d(LuaValue luaValue0) {
        LuaValue luaValue1 = this.S();
        return luaValue1.F() ? super.d(luaValue0) : luaValue1.d(luaValue0);
    }

    @Override  // luaj.LuaValue
    public boolean d(LuaString luaString0) {
        if(this == luaString0) {
            return true;
        }
        if(luaString0.d == this.d) {
            if(luaString0.b == this.b && luaString0.c == this.c) {
                return true;
            }
            if(luaString0.hashCode() == this.hashCode()) {
                for(int v = 0; true; ++v) {
                    if(v >= this.d) {
                        return true;
                    }
                    if(luaString0.b[luaString0.c + v] != this.b[this.c + v]) {
                        break;
                    }
                }
            }
        }
        return false;
    }

    @Override  // luaj.LuaValue
    public String d_() {
        return LuaString.d(this.b, this.c, this.d);
    }

    private static LuaString e(String s) {
        int v = s.length();
        if(v == 0) {
            return LuaString.ad;
        }
        if(v == 1) {
            int v1 = s.charAt(0);
            if(v1 == 0x30) {
                return LuaString.ae;
            }
            return v1 == 49 ? LuaString.af : null;
        }
        return null;
    }

    public int e(LuaString luaString0) {
        int v3;
        int v = this.c + this.d;
        int v1 = luaString0.c + luaString0.d;
        int v2;
        for(v2 = this.c; true; ++v2) {
            if(v2 >= v) {
                return -1;
            }
            v3 = luaString0.c;
        label_6:
            if(v3 < v1) {
                break;
            }
        }
        if(this.b[v2] != luaString0.b[v3]) {
            ++v3;
            goto label_6;
        }
        return v2 - this.c;
    }

    @Override  // luaj.LuaValue
    public LuaValue e(LuaValue luaValue0) {
        LuaValue luaValue1 = this.S();
        return luaValue1.F() ? super.e(luaValue0) : luaValue1.e(luaValue0);
    }

    @Override  // luaj.LuaValue
    public int e_() {
        return 4;
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.LuaValue
    public boolean equals(Object object0) {
        return object0 instanceof LuaString ? this.d(((LuaString)object0)) : false;
    }

    private static LuaString f(byte[] arr_b, int v, int v1) {
        byte[] arr_b1 = new byte[v1];
        System.arraycopy(arr_b, v, arr_b1, 0, v1);
        return new LuaString(arr_b1, 0, v1);
    }

    @Override  // luaj.LuaValue
    public LuaValue f(LuaValue luaValue0) {
        LuaValue luaValue1 = this.S();
        return luaValue1.F() ? super.f(luaValue0) : luaValue1.f(luaValue0);
    }

    public int f_(int v) {
        if(v < 0 || v >= this.d) {
            throw new IndexOutOfBoundsException();
        }
        return this.b(v);
    }

    @Override  // luaj.LuaValue
    public String f_() {
        return "string";
    }

    private static LuaString g(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return LuaString.ad;
        }
        if(v1 == 1) {
            switch(arr_b[v]) {
                case 0x30: {
                    return LuaString.ae;
                }
                case 49: {
                    return LuaString.af;
                }
                default: {
                    return null;
                }
            }
        }
        return null;
    }

    @Override  // luaj.LuaValue
    public LuaValue g(LuaValue luaValue0) {
        LuaValue luaValue1 = this.S();
        return luaValue1.F() ? super.g(luaValue0) : luaValue1.g(luaValue0);
    }

    public LuaValue g_(int v) {
        int v8;
        int v3;
        byte[] arr_b = this.b;
        int v1 = this.c;
        int v2 = this.d + v1;
        while(true) {
            if(v1 >= v2 || arr_b[v1] > 0x20) {
                v3 = v2;
                break;
            }
            if(arr_b[v1] <= 0) {
                v3 = v2;
                break;
            }
            ++v1;
        }
        while(v1 < v3 && arr_b[v3 - 1] <= 0x20 && arr_b[v3 - 1] > 0) {
            --v3;
        }
        if(v1 == v3) {
            return LuaString.u;
        }
        int v4 = arr_b[v1];
        if(v4 == 43 || v4 == 45) {
            ++v1;
        }
        if(v1 == v3) {
            return LuaString.u;
        }
        long v5 = 0L;
        for(int v6 = v1; true; ++v6) {
            if(v6 >= v3) {
                if(v4 != 45) {
                    v5 = -v5;
                    if(v5 < 0L) {
                        return LuaString.u;
                    }
                }
                return LuaLong.b(v5);
            }
            int v7 = arr_b[v6];
            if(v > 10 && (v7 < 0x30 || v7 > 57)) {
                v8 = v7 < 65 || v7 > 90 ? 87 : 55;
            }
            else {
                v8 = 0x30;
            }
            int v9 = v7 - v8;
            if(v9 < 0 || v9 >= v) {
                return LuaString.u;
            }
            if(0x8000000000000000L / ((long)v) > v5) {
                return LuaString.u;
            }
            long v10 = ((long)v) * v5 - ((long)v9);
            if(v10 > v5) {
                return LuaString.u;
            }
            v5 = v10;
        }
    }

    private boolean h(byte[] arr_b, int v, int v1) {
        return this.d == v1 && LuaString.a(this.b, this.c, arr_b, v, v1);
    }

    @Override  // luaj.LuaValue
    public LuaValue h(LuaValue luaValue0) {
        LuaValue luaValue1 = this.S();
        return luaValue1.F() ? super.h(luaValue0) : luaValue1.h(luaValue0);
    }

    @Override  // luaj.LuaValue
    public boolean h_() {
        return this.S().h_();
    }

    @Override
    public int hashCode() {
        return this.e;
    }

    @Override  // luaj.LuaValue
    public LuaValue i() {
        return LuaString.a;
    }

    @Override  // luaj.LuaValue
    public LuaValue i(LuaValue luaValue0) {
        LuaValue luaValue1 = this.S();
        return luaValue1.F() ? super.i(luaValue0) : luaValue1.i(luaValue0);
    }

    @Override  // luaj.LuaValue
    public LuaValue j(LuaValue luaValue0) {
        LuaValue luaValue1 = this.S();
        return luaValue1.F() ? super.j(luaValue0) : luaValue1.j(luaValue0);
    }

    @Override  // luaj.LuaValue
    public LuaValue k(LuaValue luaValue0) {
        LuaValue luaValue1 = this.S();
        return luaValue1.F() ? super.k(luaValue0) : luaValue1.k(luaValue0);
    }

    @Override  // luaj.LuaValue
    public LuaValue l(LuaValue luaValue0) {
        LuaValue luaValue1 = this.S();
        return luaValue1.F() ? super.l(luaValue0) : luaValue1.l(luaValue0);
    }

    @Override  // luaj.LuaValue
    public LuaValue m(LuaValue luaValue0) {
        LuaValue luaValue1 = this.S();
        return luaValue1.F() ? super.m(luaValue0) : luaValue1.m(luaValue0);
    }

    @Override  // luaj.LuaValue
    public LuaValue n(LuaValue luaValue0) {
        LuaValue luaValue1 = this.S();
        return luaValue1.F() ? super.n(luaValue0) : luaValue1.n(luaValue0);
    }

    @Override  // luaj.LuaValue
    public boolean n() {
        return this.S().n();
    }

    @Override  // luaj.LuaValue
    public double o() {
        return this.S().o();
    }

    @Override  // luaj.LuaValue
    public LuaValue o(LuaValue luaValue0) {
        LuaValue luaValue1 = this.S();
        return luaValue1.F() ? super.o(luaValue0) : luaValue1.o(luaValue0);
    }

    @Override  // luaj.LuaValue
    public int p() {
        return this.S().p();
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.LuaValue
    public boolean p(LuaValue luaValue0) {
        return luaValue0.J() ? luaValue0.c(this) > 0 : super.p(luaValue0);
    }

    @Override  // luaj.LuaValue
    public long q() {
        return this.S().q();
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.LuaValue
    public boolean q(LuaValue luaValue0) {
        return luaValue0.J() ? luaValue0.c(this) >= 0 : super.q(luaValue0);
    }

    @Override  // luaj.LuaValue
    public LuaValue r() {
        LuaValue luaValue0 = this.S();
        return luaValue0.F() ? super.r() : luaValue0.r();
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.LuaValue
    public boolean r(LuaValue luaValue0) {
        return luaValue0.J() ? luaValue0.c(this) < 0 : super.r(luaValue0);
    }

    public InputStream r_() {
        return new ByteArrayInputStream(this.b, this.c, this.d);
    }

    @Override  // luaj.LuaValue
    public LuaValue s() {
        LuaValue luaValue0 = this.S();
        return luaValue0.F() ? super.s() : luaValue0.s();
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.LuaValue
    public boolean s(LuaValue luaValue0) {
        return luaValue0.J() ? luaValue0.c(this) <= 0 : super.s(luaValue0);
    }

    public boolean s_() {
        byte[] arr_b = this.b;
        int v = this.c;
        int v1 = this.d + this.c;
        while(true) {
            if(v >= v1) {
                return true;
            }
            int v2 = v + 1;
            int v3 = arr_b[v];
            if(v3 >= 0) {
                v = v2;
            }
            else {
                if((v3 & 0xE0) != 0xC0 || v2 >= v1) {
                    v = v2;
                }
                else {
                    v = v2 + 1;
                    if((arr_b[v2] & 0xC0) == 0x80) {
                        continue;
                    }
                }
                if((v3 & 0xF0) == 0xE0 && v + 1 < v1) {
                    int v4 = v + 1;
                    if((arr_b[v] & 0xC0) == 0x80) {
                        v = v4 + 1;
                        if((arr_b[v4] & 0xC0) == 0x80) {
                            continue;
                        }
                    }
                    else {
                        v = v4;
                    }
                }
                if((v3 & 0xF8) != 0xF0 || v + 2 >= v1 || (arr_b[v] & 0xC0) != 0x80) {
                    break;
                }
                int v5 = v + 2;
                if((arr_b[v + 1] & 0xC0) != 0x80) {
                    break;
                }
                v = v5 + 1;
                if((arr_b[v5] & 0xC0) != 0x80) {
                    break;
                }
            }
        }
        return false;
    }

    @Override  // luaj.LuaValue
    public LuaString t() {
        return this;
    }

    @Override  // luaj.LuaValue
    public LuaValue u() {
        return this;
    }

    @Override  // luaj.LuaValue
    public LuaValue u(LuaValue luaValue0) {
        return luaValue0.b(this);
    }

    @Override  // luaj.LuaValue
    public int v() {
        LuaValue luaValue0 = this.S();
        return luaValue0.F() ? super.v() : luaValue0.v();
    }

    @Override  // luaj.LuaValue
    public long w() {
        LuaValue luaValue0 = this.S();
        return luaValue0.F() ? super.w() : luaValue0.w();
    }

    @Override  // luaj.LuaValue
    public double x() {
        LuaValue luaValue0 = this.S();
        return luaValue0.F() ? super.x() : luaValue0.x();
    }

    @Override  // luaj.LuaValue
    public String y() {
        return this.d_();
    }

    @Override  // luaj.LuaValue
    public LuaString z() [...] // Inlined contents
}

