package luaj;

import luaj.a.h;

public abstract class LuaValue extends ap {
    public static final LuaNumber A;
    public static final LuaValue[] B;
    public static final LuaString C;
    public static final LuaString D;
    public static final LuaString E;
    public static final LuaString F;
    public static final LuaString G;
    public static final LuaString H;
    public static final LuaString I;
    public static final LuaString J;
    public static final LuaString K;
    public static final LuaString L;
    public static final LuaString M;
    public static final LuaString N;
    public static final LuaString O;
    public static final LuaString P;
    public static final LuaString Q;
    public static final LuaString R;
    public static final LuaString S;
    public static final LuaString T;
    public static final LuaString U;
    public static final LuaString V;
    public static final LuaString W;
    public static final LuaString X;
    public static final LuaString Y;
    public static final LuaString Z;
    public static final LuaString aa;
    public static final LuaString ab;
    public static final LuaString ac;
    public static final LuaString ad;
    public static final LuaString ae;
    public static final LuaString af;
    public static final LuaValue[] ag;
    public static final String[] t;
    public static final LuaValue u;
    public static final LuaBoolean v;
    public static final LuaBoolean w;
    public static final LuaValue x;
    public static final LuaNumber y;
    public static final LuaNumber z;

    static {
        LuaValue.t = new String[]{"nil", "boolean", "lightuserdata", "number", "string", "table", "function", "userdata", "thread", "value"};
        LuaValue.u = new LuaNil();
        LuaValue.v = new LuaBoolean(true);
        LuaValue.w = new LuaBoolean(false);
        LuaValue.x = new LuaValue.None(null);
        LuaValue.y = LuaLong.b(0L);
        LuaValue.z = LuaLong.b(1L);
        LuaValue.A = LuaLong.b(-1L);
        LuaValue.B = new LuaValue[0];
        LuaValue.C = LuaString.d("_ENV");
        LuaValue.D = LuaString.d("__index");
        LuaValue.E = LuaString.d("__newindex");
        LuaValue.F = LuaString.d("__call");
        LuaValue.G = LuaString.d("__mode");
        LuaValue.H = LuaString.d("__metatable");
        LuaValue.I = LuaString.d("__add");
        LuaValue.J = LuaString.d("__sub");
        LuaValue.K = LuaString.d("__div");
        LuaValue.L = LuaString.d("__mul");
        LuaValue.M = LuaString.d("__pow");
        LuaValue.N = LuaString.d("__mod");
        LuaValue.O = LuaString.d("__unm");
        LuaValue.P = LuaString.d("__len");
        LuaValue.Q = LuaString.d("__eq");
        LuaValue.R = LuaString.d("__lt");
        LuaValue.S = LuaString.d("__le");
        LuaValue.T = LuaString.d("__tostring");
        LuaValue.U = LuaString.d("__concat");
        LuaValue.V = LuaString.d("__idiv");
        LuaValue.W = LuaString.d("__bnot");
        LuaValue.X = LuaString.d("__band");
        LuaValue.Y = LuaString.d("__bor");
        LuaValue.Z = LuaString.d("__bxor");
        LuaValue.aa = LuaString.d("__shl");
        LuaValue.ab = LuaString.d("__shr");
        LuaValue.ac = LuaString.d("__name");
        LuaValue.ad = LuaString.d("");
        LuaValue.ae = LuaString.d("0");
        LuaValue.af = LuaString.d("1");
        LuaValue.ag = new LuaValue[0xFA];
        for(int v = 0; v < 0xFA; ++v) {
            LuaValue.ag[v] = LuaValue.u;
        }
    }

    public ap A(LuaValue luaValue0) {
        return this.h("table");
    }

    public boolean A() {
        return true;
    }

    public ap B(LuaValue luaValue0) {
        return this.h("table");
    }

    public boolean B() {
        return false;
    }

    public LuaFunction C() {
        this.g("function");
        return null;
    }

    public boolean E() {
        return false;
    }

    public LuaValue F(LuaValue luaValue0) {
        return luaValue0.a(LuaValue.ad, this);
    }

    public boolean F() {
        return false;
    }

    public static String G(LuaValue luaValue0) {
        if(luaValue0 == LuaValue.X) {
            return "&";
        }
        if(luaValue0 == LuaValue.Y) {
            return "|";
        }
        if(luaValue0 == LuaValue.Z) {
            return "~";
        }
        if(luaValue0 == LuaValue.aa) {
            return "<<";
        }
        return luaValue0 == LuaValue.ab ? ">>" : luaValue0.d_();
    }

    public LuaNumber G() {
        this.g("number");
        return null;
    }

    public LuaValue H() {
        return LuaValue.u;
    }

    public LuaValue H(LuaValue luaValue0) {
        LuaValue luaValue1 = this.I(LuaValue.U);
        if(luaValue1.F()) {
            LuaValue luaValue2 = null;
            luaValue1 = luaValue0.I(LuaValue.U);
            if(luaValue1.F()) {
                if(!this.J()) {
                    luaValue2 = this;
                }
                else if(!luaValue0.J()) {
                    luaValue2 = luaValue0;
                }
                if(luaValue2 != null) {
                    throw new o("attempt to concatenate a " + luaValue2.f_() + " value");
                }
                LuaValue.f(("attempt to concatenate " + this.f_() + " and " + luaValue0.f_()));
            }
        }
        return luaValue1.a(this, luaValue0);
    }

    public LuaValue I(LuaValue luaValue0) {
        LuaValue luaValue1 = this.i();
        return luaValue1 == null ? LuaValue.u : luaValue1.x(luaValue0);
    }

    public boolean I() {
        return false;
    }

    protected static ah J(LuaValue luaValue0) {
        boolean z = false;
        if(luaValue0 != null && luaValue0.N()) {
            LuaValue luaValue1 = luaValue0.x(LuaValue.G);
            if(luaValue1.J()) {
                String s = luaValue1.d_();
                boolean z1 = s.indexOf(107) >= 0;
                if(s.indexOf(0x76) >= 0) {
                    z = true;
                }
                if(z1 || z) {
                    return new WeakTable(z1, z, luaValue0);
                }
            }
            return (LuaTable)luaValue0;
        }
        return luaValue0 != null ? new ai(luaValue0) : null;
    }

    public boolean J() {
        return false;
    }

    public LuaValue K() {
        return this.a(LuaValue.P, "attempt to get length of ").a(this);
    }

    public void K(LuaValue luaValue0) {
    }

    public int L() {
        return this.K().p();
    }

    public int M() {
        this.h("table or string");
        return 0;
    }

    public boolean N() {
        return false;
    }

    public LuaTable O() {
        this.g("table");
        return null;
    }

    public boolean Q() {
        return false;
    }

    public LuaThread R() {
        this.g("thread");
        return null;
    }

    public ap Y() {
        return this.a_(LuaValue.x);
    }

    protected LuaValue Z() {
        return this.a(LuaValue.F, "attempt to call ");
    }

    public static LuaTable a(ap ap0, int v) {
        return new LuaTable(ap0, v);
    }

    public static LuaValue a(int v, String s) {
        throw new n(v, null, s);
    }

    public static LuaValue a(int v, String s, String s1) {
        throw new n(v, s, s1);
    }

    public static LuaValue a(CharSequence charSequence0) {
        int v16;
        int v15;
        double f4;
        int v14;
        int v13;
        int v10;
        double f1;
        double f;
        int v = charSequence0.length();
        int v1;
        for(v1 = 0; true; ++v1) {
            f = 1.0;
            if(v1 >= v || !h.t(charSequence0.charAt(v1))) {
                break;
            }
        }
        if(v1 < v) {
            int v2 = charSequence0.charAt(v1);
            if(v2 != 43 && v2 != 45) {
                f1 = 1.0;
            }
            else {
                if(v2 == 45) {
                    f = -1.0;
                }
                ++v1;
                f1 = f;
            }
        }
        else {
            f1 = 1.0;
        }
        if(v1 + 2 >= v) {
            return null;
        }
        if(charSequence0.charAt(v1) != 0x30) {
            return null;
        }
        switch(charSequence0.charAt(v1 + 1)) {
            case 88: 
            case 120: {
                int v3 = v1 + 2;
                double f2 = 0.0;
                long v4 = 0L;
                int v5 = 0;
                int v6 = 0;
                while(v3 < v) {
                    int v7 = charSequence0.charAt(v3);
                    if(!h.s(v7)) {
                        break;
                    }
                    int v8 = h.x(v7);
                    if(v6 != 0 || v8 != 0) {
                        if(v6 < 30) {
                            f2 = f2 * 16.0 + ((double)v8);
                        }
                        else {
                            v5 += 4;
                        }
                        v4 = v4 * 16L + ((long)v8);
                        ++v6;
                    }
                    ++v3;
                }
                if(v3 >= v || charSequence0.charAt(v3) != 46) {
                    v10 = v5;
                    f4 = f2;
                }
                else {
                    v6 += 0x800000;
                    ++v3;
                    int v9 = 0x7FFFFFFF;
                    v10 = v5;
                    double f3 = f2;
                    while(v3 < v) {
                        int v11 = charSequence0.charAt(v3);
                        if(!h.s(v11)) {
                            break;
                        }
                        int v12 = v9 != 0x7FFFFFFF || f3 == 0.0 ? v9 : v3 + 30;
                        if(v3 < v12) {
                            f3 = f3 * 16.0 + ((double)h.x(v11));
                            v13 = v10 - 4;
                            v14 = v6 + 1;
                        }
                        else {
                            v14 = v6;
                            v13 = v10;
                        }
                        ++v3;
                        v9 = v12;
                        v6 = v14;
                        v10 = v13;
                    }
                    f4 = f3;
                }
                if((0x7FFFFF & v6) == 0) {
                    return null;
                }
                if(v3 < v) {
                    switch(charSequence0.charAt(v3)) {
                        case 80: 
                        case 0x70: {
                            int v17 = v3 + 1;
                            int v18 = 0;
                            boolean z = false;
                            if(v17 < v) {
                                int v19 = charSequence0.charAt(v17);
                                if(v19 == 43 || v19 == 45) {
                                    if(v19 == 45) {
                                        z = true;
                                    }
                                    ++v17;
                                }
                            }
                            boolean z1 = false;
                            v3 = v17;
                            while(v3 < v) {
                                int v20 = charSequence0.charAt(v3);
                                if(!h.r(v20)) {
                                    break;
                                }
                                v18 = v20 + v18 * 10 - 0x30;
                                ++v3;
                                z1 = true;
                            }
                            if(!z1) {
                                return null;
                            }
                            v15 = v6 + 0x1000000;
                            v16 = v10 + (z ? -v18 : v18);
                            break;
                        }
                        default: {
                            v15 = v6;
                            v16 = v10;
                        }
                    }
                }
                else {
                    v15 = v6;
                    v16 = v10;
                }
                while(v3 < v && h.t(charSequence0.charAt(v3))) {
                    ++v3;
                }
                if(v3 != v) {
                    return null;
                }
                if(v15 < 0x800000) {
                    return f1 > 0.0 ? LuaLong.b(v4) : LuaLong.b(-v4);
                }
                return LuaValue.c(f1 * f4 * Math.pow(2.0, v16));
            }
            default: {
                return null;
            }
        }
    }

    public static LuaValue a(String s, Throwable throwable0) {
        throw new o(s, throwable0);
    }

    public static ap a(LuaValue luaValue0, LuaValue luaValue1, ap ap0) {
        return ap0.j_() != 0 ? new aq(new LuaValue[]{luaValue0, luaValue1}, 0, 2, ap0) : new as(luaValue0, luaValue1);
    }

    public static ap a(LuaValue[] arr_luaValue, int v, int v1) {
        switch(v1) {
            case 0: {
                return LuaValue.x;
            }
            case 1: {
                return arr_luaValue[v];
            }
            case 2: {
                return new as(arr_luaValue[v], arr_luaValue[v + 1]);
            }
            default: {
                return new aq(arr_luaValue, v, v1, LuaValue.x);
            }
        }
    }

    public static ap a(LuaValue[] arr_luaValue, int v, int v1, ap ap0) {
        switch(v1) {
            case 0: {
                return ap0;
            }
            case 1: {
                return ap0.j_() > 0 ? new as(arr_luaValue[v], ap0) : arr_luaValue[v];
            }
            case 2: {
                return ap0.j_() > 0 ? new aq(arr_luaValue, v, 2, ap0) : new as(arr_luaValue[v], arr_luaValue[v + 1]);
            }
            default: {
                return new aq(arr_luaValue, v, v1, ap0);
            }
        }
    }

    public LuaFunction a(LuaFunction luaFunction0) {
        this.g("function");
        return null;
    }

    public LuaString a(LuaString luaString0) {
        this.g("string");
        return null;
    }

    public LuaTable a(LuaTable luaTable0) {
        this.g("table");
        return null;
    }

    public LuaValue a(LuaNumber luaNumber0) {
        return luaNumber0.H(this);
    }

    public LuaValue a(LuaValue luaValue0) {
        return this.Z().a(this, luaValue0);
    }

    protected LuaValue a(LuaValue luaValue0, String s) {
        LuaValue luaValue1 = this.I(luaValue0);
        if(luaValue1.F()) {
            throw luaValue0 != LuaValue.W || !this.I() ? new o(s + "a " + this.aa() + " value") : new o("number has no integer representation (for bitwise operation \'~" + this.d_() + "\')");
        }
        return luaValue1;
    }

    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        return this.Z().a(this, luaValue0, luaValue1);
    }

    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2) {
        return this.Z().a(new LuaValue[]{this, luaValue0, luaValue1, luaValue2}).g();
    }

    public ap a(LuaValue luaValue0, ap ap0) {
        return this.a_(LuaValue.b(luaValue0, ap0));
    }

    public ap a(ap ap0, boolean z) {
        return this.a_(ap0);
    }

    public ap a(LuaValue[] arr_luaValue) {
        return this.a_(LuaValue.c(arr_luaValue));
    }

    public void a(int v, LuaValue luaValue0) {
        if(luaValue0 != null) {
            this.b(LuaLong.b(v), luaValue0);
        }
    }

    public void a(String s, double f) {
        if(s != null) {
            this.b(LuaValue.m(s), LuaValue.c(f));
        }
    }

    public void a(String s, int v) {
        if(s != null) {
            this.b(LuaValue.m(s), LuaValue.d(v));
        }
    }

    public void a(String s, LuaValue luaValue0) {
        if(s != null && luaValue0 != null) {
            this.b(LuaValue.m(s), luaValue0);
        }
    }

    public boolean a(boolean z) {
        this.g("boolean");
        return false;
    }

    public long a_(long v) {
        this.g("long");
        return 0L;
    }

    public ap a_(ap ap0) {
        return this.Z().a(this, ap0);
    }

    public String aa() {
        LuaValue luaValue0 = this.I(LuaValue.ac);
        return luaValue0.J() ? luaValue0.d_() : this.f_();
    }

    public a ab() {
        return new a(this);
    }

    public LuaValue ac() {
        return this;
    }

    public static LuaTable ad() {
        return new LuaTable();
    }

    // 去混淆评级： 低(20)
    public static LuaBoolean b(boolean z) {
        return z ? LuaValue.v : LuaValue.w;
    }

    public static LuaTable b(LuaValue[] arr_luaValue) {
        return new LuaTable(arr_luaValue, null, null);
    }

    public static LuaValue b(LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2) {
        LuaValue luaValue3 = luaValue1.I(luaValue0);
        if(luaValue3.F()) {
            luaValue3 = luaValue2.I(luaValue0);
            if(luaValue3.F()) {
                LuaValue.f(("attempt to perform arithmetic " + luaValue0 + " on a " + luaValue1.aa() + " value and a " + luaValue2.aa() + " value"));
            }
        }
        return luaValue3.a(luaValue1, luaValue2);
    }

    public static ap b(LuaValue luaValue0, ap ap0) {
        return ap0.j_() != 0 ? new as(luaValue0, ap0) : luaValue0;
    }

    public double b(double f) {
        this.g("number");
        return 0.0;
    }

    public LuaNumber b(String s) {
        throw new o(s);
    }

    protected LuaValue b(String s, String s1) {
        throw new o("illegal operation \'" + s + "\' for " + s1);
    }

    public LuaValue b(LuaString luaString0) {
        return luaString0.H(this);
    }

    public void b(int v, String s) {
        if(s != null) {
            this.b(v, LuaValue.m(s));
        }
    }

    public void b(int v, LuaValue luaValue0) {
        if(luaValue0 != null) {
            this.c(LuaValue.d(v), luaValue0);
        }
    }

    public void b(String s, double f) {
        if(s != null) {
            this.c(LuaValue.m(s), LuaValue.c(f));
        }
    }

    public void b(String s, int v) {
        if(s != null) {
            this.c(LuaValue.m(s), LuaValue.d(v));
        }
    }

    public void b(String s, LuaValue luaValue0) {
        if(s != null && luaValue0 != null) {
            this.c(LuaValue.m(s), luaValue0);
        }
    }

    public void b(LuaValue luaValue0, LuaValue luaValue1) {
        if(luaValue0 != null && luaValue1 != null) {
            LuaValue.d(this, luaValue0, luaValue1);
        }
    }

    public boolean b(LuaValue luaValue0) {
        return this == luaValue0;
    }

    public int b_(int v) {
        this.g("int");
        return 0;
    }

    public String b_(String s) {
        this.g("String");
        return null;
    }

    public static LuaNumber c(double f) {
        return LuaDouble.a(f);
    }

    public static LuaString c(byte[] arr_b) {
        return LuaString.a(arr_b);
    }

    public static LuaValue c(String s, LuaValue luaValue0) {
        try {
            LuaValue luaValue1 = LuaValue.n(s);
            return luaValue1 == null ? luaValue0 : luaValue1;
        }
        catch(NumberFormatException unused_ex) {
            return luaValue0;
        }
    }

    public static LuaValue c(LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2) {
        LuaValue luaValue3 = luaValue1.I(luaValue0);
        if(luaValue3.F()) {
            LuaValue luaValue4 = null;
            LuaValue luaValue5 = luaValue2.I(luaValue0);
            if(luaValue5.F()) {
                if(luaValue1.I() && !luaValue1.n()) {
                    luaValue4 = luaValue1;
                }
                else if(luaValue2.I() && !luaValue2.n()) {
                    luaValue4 = luaValue2;
                }
                String s = LuaValue.G(luaValue0);
                if(luaValue4 != null) {
                    throw new o("number \'" + luaValue4.d_() + "\' has no integer representation (for bitwise operation \'" + luaValue1.d_() + " " + s + " " + luaValue2.d_() + "\')");
                }
                LuaValue.f(("attempt to perform bitwise operation " + s + " on a " + luaValue1.f_() + " value and a " + luaValue2.f_() + " value"));
            }
            luaValue3 = luaValue5;
        }
        return luaValue3.a(luaValue1, luaValue2);
    }

    public static ap c(LuaValue[] arr_luaValue) {
        switch(arr_luaValue.length) {
            case 0: {
                return LuaValue.x;
            }
            case 1: {
                return arr_luaValue[0];
            }
            case 2: {
                return new as(arr_luaValue[0], arr_luaValue[1]);
            }
            default: {
                return new ar(arr_luaValue, LuaValue.x);
            }
        }
    }

    private void c(String s) {
        LuaValue.f(("attempt to index ? (a " + this.f_() + " value) with key \'" + s + '\''));
    }

    public int c(LuaString luaString0) {
        LuaValue.f(("attempt to compare " + this.f_()));
        return 0;
    }

    public Globals c() {
        this.g("globals");
        return null;
    }

    @Override  // luaj.ap
    public LuaValue c(int v) {
        return v == 1 ? this : LuaValue.u;
    }

    public void c(String s, String s1) {
        if(s != null && s1 != null) {
            this.b(LuaValue.m(s), LuaValue.m(s1));
        }
    }

    public void c(LuaValue luaValue0, LuaValue luaValue1) {
        if(luaValue0 != null && luaValue1 != null) {
            this.i("rawset");
        }
    }

    public boolean c(LuaValue luaValue0) {
        return this == luaValue0;
    }

    public LuaValue c_(int v) {
        return this.w(LuaLong.b(v));
    }

    public static LuaLong d(long v) {
        return LuaLong.b(v);
    }

    protected static boolean d(LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2) {
        LuaValue luaValue3;
        int v = 0;
        while(true) {
            if(luaValue0.N()) {
                if(luaValue0.x(luaValue1).F()) {
                    luaValue3 = luaValue0.I(LuaValue.E);
                    if(luaValue3.F()) {
                        luaValue0.c(luaValue1, luaValue2);
                        return true;
                    }
                    goto label_10;
                }
                luaValue0.c(luaValue1, luaValue2);
                return true;
            }
            else {
                luaValue3 = luaValue0.I(LuaValue.E);
                if(luaValue3.F()) {
                    throw new o("table expected for set index (\'" + luaValue1 + "\') value, got " + luaValue0.f_());
                }
            }
        label_10:
            if(luaValue3.B()) {
                luaValue3.a(luaValue0, luaValue1, luaValue2);
                return true;
            }
            ++v;
            if(v >= 100) {
                LuaValue.f("loop in settable");
                return false;
            }
            luaValue0 = luaValue3;
        }
    }

    public LuaValue d(int v) {
        return this.x(LuaValue.d(v));
    }

    public LuaValue d(LuaValue luaValue0) {
        return LuaValue.b(LuaValue.I, this, luaValue0);
    }

    public void d(String s, String s1) {
        if(s != null && s1 != null) {
            this.c(LuaValue.m(s), LuaValue.m(s1));
        }
    }

    public boolean d(LuaString luaString0) {
        return false;
    }

    @Override  // luaj.ap
    public String d_() {
        return this.aa() + ": " + Integer.toHexString(this.hashCode());
    }

    public void d_(int v) {
        this.h("table");
    }

    public static LuaString e(byte[] arr_b, int v, int v1) {
        return LuaString.a(arr_b, v, v1);
    }

    public LuaValue e(LuaValue luaValue0) {
        return LuaValue.b(LuaValue.J, this, luaValue0);
    }

    public abstract int e_();

    @Override  // luaj.ap
    public ap e_(int v) {
        if(v == 1) {
            return this;
        }
        return v <= 1 ? LuaValue.a(1, "start must be > 0") : LuaValue.x;
    }

    @Override
    public boolean equals(Object object0) {
        return this == object0;
    }

    public static LuaValue f(String s) {
        throw new o(s);
    }

    public LuaValue f(LuaValue luaValue0) {
        return LuaValue.b(LuaValue.L, this, luaValue0);
    }

    public abstract String f_();

    public static final boolean g(LuaValue luaValue0, LuaValue luaValue1) {
        LuaValue luaValue2 = LuaValue.u;
        LuaValue luaValue3 = luaValue0.i();
        if(luaValue3 != null) {
            luaValue2 = luaValue3.x(LuaValue.Q);
        }
        if(luaValue2.F()) {
            LuaValue luaValue4 = luaValue1.i();
            if(luaValue4 != null) {
                luaValue2 = luaValue4.x(LuaValue.Q);
            }
        }
        return luaValue2.F() ? false : luaValue2.a(luaValue0, luaValue1).i_();
    }

    @Override  // luaj.ap
    public LuaValue g() {
        return this;
    }

    protected LuaValue g(String s) {
        throw new o("bad argument: " + s + " expected, got " + this.aa());
    }

    public LuaValue g(LuaValue luaValue0) {
        return LuaValue.b(LuaValue.M, this, luaValue0);
    }

    protected LuaValue h(String s) {
        throw new o(s + " expected, got " + this.aa());
    }

    public LuaValue h(LuaValue luaValue0) {
        return LuaValue.b(LuaValue.K, this, luaValue0);
    }

    public LuaValue h(LuaValue luaValue0, LuaValue luaValue1) {
        LuaValue luaValue2 = this.I(luaValue0);
        if(luaValue2.F()) {
            luaValue2 = luaValue1.I(luaValue0);
            if(luaValue2.F()) {
                if(LuaValue.S.c(luaValue0)) {
                    LuaValue luaValue3 = this.I(LuaValue.R);
                    if(!luaValue3.F()) {
                        return luaValue3.a(luaValue1, this).k_();
                    }
                    luaValue3 = luaValue1.I(LuaValue.R);
                    if(!luaValue3.F()) {
                        return luaValue3.a(luaValue1, this).k_();
                    }
                }
                String s = this.aa();
                String s1 = luaValue1.aa();
                return s.equals(s1) ? LuaValue.f(("attempt to compare " + ("two " + s + " values"))) : LuaValue.f(("attempt to compare " + (s + " with " + s1)));
            }
        }
        return luaValue2.a(this, luaValue1);
    }

    public boolean h() {
        this.g("boolean");
        return false;
    }

    public boolean h_() {
        return false;
    }

    protected static LuaValue i(LuaValue luaValue0, LuaValue luaValue1) {
        LuaValue luaValue3;
        int v = 0;
        while(true) {
            if(luaValue0.N()) {
                LuaValue luaValue2 = luaValue0.x(luaValue1);
                if(luaValue2.F()) {
                    luaValue3 = luaValue0.I(LuaValue.D);
                    if(luaValue3.F()) {
                        return luaValue2;
                    }
                    goto label_10;
                }
                return luaValue2;
            }
            else {
                luaValue3 = luaValue0.I(LuaValue.D);
                if(luaValue3.F()) {
                    luaValue0.c(luaValue1.d_());
                }
            }
        label_10:
            if(luaValue3.B()) {
                return luaValue3.a(luaValue0, luaValue1);
            }
            ++v;
            if(v >= 100) {
                LuaValue.f("loop in gettable");
                return LuaValue.u;
            }
            luaValue0 = luaValue3;
        }
    }

    public LuaValue i() {
        return null;
    }

    protected LuaValue i(String s) {
        throw new o("\'" + s + "\' not implemented for " + this.f_());
    }

    public LuaValue i(LuaValue luaValue0) {
        return LuaValue.b(LuaValue.V, this, luaValue0);
    }

    public boolean i_() {
        return true;
    }

    public LuaValue j(String s) {
        return this.w(LuaValue.m(s));
    }

    public LuaValue j(LuaValue luaValue0) {
        return LuaValue.b(LuaValue.N, this, luaValue0);
    }

    public boolean j() {
        return false;
    }

    @Override  // luaj.ap
    public int j_() {
        return 1;
    }

    public LuaClosure k() {
        this.g("closure");
        return null;
    }

    public LuaValue k(String s) {
        return this.x(LuaValue.m(s));
    }

    public LuaValue k(LuaValue luaValue0) {
        return LuaValue.c(LuaValue.X, this, luaValue0);
    }

    public LuaValue k_() {
        return LuaValue.w;
    }

    public static LuaNumber l(String s) {
        if(s.length() <= 20 && s.indexOf(46) == -1 && s.indexOf(101) == -1 && s.indexOf(69) == -1) {
            try {
                return LuaLong.b(Long.parseLong(s));
            }
            catch(NumberFormatException unused_ex) {
            }
        }
        return LuaDouble.a(Double.parseDouble(s));
    }

    public LuaValue l() {
        return this.Z().a(this);
    }

    public LuaValue l(LuaValue luaValue0) {
        return LuaValue.c(LuaValue.Y, this, luaValue0);
    }

    public static LuaString m(String s) {
        return LuaString.c(s);
    }

    public LuaValue m(LuaValue luaValue0) {
        return LuaValue.c(LuaValue.Z, this, luaValue0);
    }

    public static LuaValue n(String s) {
        return s.indexOf(120) >= 0 || s.indexOf(88) >= 0 ? LuaValue.a(s) : LuaValue.l(s.trim());
    }

    public LuaValue n(LuaValue luaValue0) {
        return LuaValue.c(LuaValue.aa, this, luaValue0);
    }

    public boolean n() {
        return false;
    }

    public boolean n_() {
        return false;
    }

    public double o() {
        return 0.0;
    }

    public LuaValue o(LuaValue luaValue0) {
        return LuaValue.c(LuaValue.ab, this, luaValue0);
    }

    public int p() {
        return 0;
    }

    public boolean p(LuaValue luaValue0) {
        return this.h(LuaValue.R, luaValue0).i_();
    }

    public boolean p_() {
        return false;
    }

    public long q() {
        return 0L;
    }

    public boolean q(LuaValue luaValue0) {
        return this.h(LuaValue.S, luaValue0).i_();
    }

    public boolean q_() {
        return false;
    }

    public LuaValue r() {
        return this.a(LuaValue.O, "attempt to perform arithmetic on ").a(this);
    }

    public boolean r(LuaValue luaValue0) {
        return luaValue0.h(LuaValue.S, this).i_();
    }

    public LuaValue s() {
        return this.a(LuaValue.W, "attempt to perform bitwise on ").a(this);
    }

    public boolean s(LuaValue luaValue0) {
        return luaValue0.h(LuaValue.R, this).i_();
    }

    public LuaString t() {
        this.h("string or number");
        return null;
    }

    public LuaValue t(LuaValue luaValue0) {
        return this;
    }

    @Override  // luaj.ap
    public String toString() {
        return this.d_();
    }

    public LuaValue u() {
        return LuaValue.u;
    }

    public LuaValue u(LuaValue luaValue0) {
        return this.H(luaValue0);
    }

    public int v() {
        this.g("int");
        return 0;
    }

    public LuaValue v(LuaValue luaValue0) {
        return this.g("table");
    }

    public long w() {
        this.g("long");
        return 0L;
    }

    public LuaValue w(LuaValue luaValue0) {
        return LuaValue.i(this, luaValue0);
    }

    public double x() {
        this.g("number");
        return 0.0;
    }

    public LuaValue x(LuaValue luaValue0) {
        return this.i("rawget");
    }

    public String y() {
        this.g("string");
        return null;
    }

    public LuaString z() {
        this.g("string");
        return null;
    }
}

