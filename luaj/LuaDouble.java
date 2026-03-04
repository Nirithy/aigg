package luaj;

public class LuaDouble extends LuaNumber {
    public static final LuaDouble a;
    public static final LuaDouble b;
    public static final LuaDouble c;
    final double d;

    static {
        LuaDouble.a = new LuaDouble(NaN);
        LuaDouble.b = new LuaDouble(Infinity);
        LuaDouble.c = new LuaDouble(-Infinity);
    }

    private LuaDouble(double f) {
        this.d = f;
    }

    @Override  // luaj.LuaValue
    public boolean A() {
        return !Double.isNaN(this.d);
    }

    public static LuaNumber a(double f) {
        return new LuaDouble(f);
    }

    public static LuaValue a(double f, double f1) {
        if(f1 != 0.0) {
            return LuaDouble.a(f / f1);
        }
        if(f > 0.0) {
            return LuaDouble.b;
        }
        return f == 0.0 ? LuaDouble.a : LuaDouble.c;
    }

    @Override  // luaj.LuaValue
    public LuaString a(LuaString luaString0) {
        return LuaString.c(this.d_());
    }

    @Override  // luaj.LuaValue
    public long a_(long v) {
        return (long)this.d;
    }

    public static LuaValue b(double f, double f1) {
        if(f1 != 0.0) {
            return LuaDouble.a(Math.floor(f / f1));
        }
        if(f > 0.0) {
            return LuaDouble.b;
        }
        return f == 0.0 ? LuaDouble.a : LuaDouble.c;
    }

    @Override  // luaj.LuaValue
    public double b(double f) {
        return this.d;
    }

    @Override  // luaj.LuaValue
    public boolean b(LuaValue luaValue0) {
        return luaValue0.I() ? this.d == luaValue0.o() : super.b(luaValue0);
    }

    @Override  // luaj.LuaValue
    public int b_(int v) {
        return (int)(((long)this.d));
    }

    @Override  // luaj.LuaValue
    public String b_(String s) {
        return this.d_();
    }

    public static LuaValue c(double f, double f1) {
        if(f1 == 0.0 || f == Infinity || f == -Infinity) {
            return LuaDouble.a;
        }
        if(f1 == Infinity) {
            return f < 0.0 ? LuaDouble.b : LuaDouble.a(f);
        }
        if(f1 == -Infinity) {
            return f > 0.0 ? LuaDouble.c : LuaDouble.a(f);
        }
        return LuaDouble.a(f - Math.floor(f / f1) * f1);
    }

    @Override  // luaj.LuaValue
    public boolean c(LuaValue luaValue0) {
        return luaValue0.I() ? this.d == luaValue0.o() : false;
    }

    private boolean d(String s, LuaValue luaValue0) {
        if(!luaValue0.I()) {
            return true;
        }
        if(!this.n()) {
            throw new o("number \'" + this.d_() + "\' has no integer representation (for bitwise operation \'" + this.d_() + " " + s + " " + luaValue0.d_() + "\')");
        }
        if(!luaValue0.n()) {
            throw new o("number \'" + luaValue0.d_() + "\' has no integer representation (for bitwise operation \'" + this.d_() + " " + s + " " + luaValue0.d_() + "\')");
        }
        return false;
    }

    @Override  // luaj.LuaValue
    public LuaValue d(LuaValue luaValue0) {
        return !luaValue0.I() ? super.d(luaValue0) : LuaDouble.a(this.d + luaValue0.o());
    }

    @Override  // luaj.LuaValue
    public String d_() {
        String s;
        if(this.d == 0.0) {
            return Double.doubleToLongBits(this.d) >> 0x3F == 0L ? "0.0" : "-0.0";
        }
        if(Double.isNaN(this.d)) {
            return "nan";
        }
        if(Double.isInfinite(this.d)) {
            return this.d < 0.0 ? "-inf" : "inf";
        }
        long v = (long)this.d;
        if(((double)v) == this.d) {
            s = Long.toString(v);
            return s.indexOf(46) != -1 || s.indexOf(101) != -1 || s.indexOf(69) != -1 ? s : s + ".0";
        }
        s = Double.toString(this.d);
        return s.indexOf(46) != -1 || s.indexOf(101) != -1 || s.indexOf(69) != -1 ? s : s + ".0";
    }

    @Override  // luaj.LuaValue
    public LuaValue e(LuaValue luaValue0) {
        return !luaValue0.I() ? super.e(luaValue0) : LuaDouble.a(this.d - luaValue0.o());
    }

    @Override  // luaj.LuaValue
    public boolean equals(Object object0) {
        return object0 instanceof LuaDouble && Double.doubleToRawLongBits(((LuaDouble)object0).d) == Double.doubleToRawLongBits(this.d);
    }

    @Override  // luaj.LuaValue
    public LuaValue f(LuaValue luaValue0) {
        return !luaValue0.I() ? super.f(luaValue0) : LuaDouble.a(this.d * luaValue0.o());
    }

    @Override  // luaj.LuaValue
    public LuaValue g(LuaValue luaValue0) {
        return !luaValue0.I() ? super.g(luaValue0) : LuaDouble.a(Math.pow(this.d, luaValue0.o()));
    }

    @Override  // luaj.LuaValue
    public LuaValue h(LuaValue luaValue0) {
        return luaValue0.I() ? LuaDouble.a(this.d, luaValue0.o()) : super.h(luaValue0);
    }

    @Override
    public int hashCode() {
        int v = (int)this.d;
        if(((double)v) == this.d) {
            return (int)(((long)v) ^ ((long)v) >>> 0x20);
        }
        long v1 = Double.doubleToRawLongBits(this.d);
        return (int)(v1 ^ v1 >>> 0x20);
    }

    @Override  // luaj.LuaValue
    public LuaValue i(LuaValue luaValue0) {
        return luaValue0.I() ? LuaDouble.b(this.d, luaValue0.o()) : super.i(luaValue0);
    }

    @Override  // luaj.LuaValue
    public LuaValue j(LuaValue luaValue0) {
        return luaValue0.I() ? LuaDouble.c(this.d, luaValue0.o()) : super.j(luaValue0);
    }

    @Override  // luaj.LuaValue
    public LuaValue k(LuaValue luaValue0) {
        return this.d("&", luaValue0) ? super.k(luaValue0) : LuaDouble.d(this.q() & luaValue0.q());
    }

    @Override  // luaj.LuaValue
    public LuaValue l(LuaValue luaValue0) {
        return this.d("|", luaValue0) ? super.l(luaValue0) : LuaDouble.d(this.q() | luaValue0.q());
    }

    @Override  // luaj.LuaValue
    public LuaValue m(LuaValue luaValue0) {
        return this.d("~", luaValue0) ? super.m(luaValue0) : LuaDouble.d(this.q() ^ luaValue0.q());
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.LuaValue
    public LuaValue n(LuaValue luaValue0) {
        return this.d("<<", luaValue0) ? super.n(luaValue0) : LuaLong.a(this.q(), luaValue0.q());
    }

    @Override  // luaj.LuaValue
    public boolean n() {
        return -9007199254740992.0 <= this.d && this.d <= 9007199254740992.0 && ((double)(((long)this.d))) == this.d;
    }

    @Override  // luaj.LuaValue
    public double o() {
        return this.d;
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.LuaValue
    public LuaValue o(LuaValue luaValue0) {
        return this.d(">>", luaValue0) ? super.o(luaValue0) : LuaLong.b(this.q(), luaValue0.q());
    }

    @Override  // luaj.LuaValue
    public int p() {
        return (int)(((long)this.d));
    }

    @Override  // luaj.LuaValue
    public boolean p(LuaValue luaValue0) {
        return luaValue0 instanceof LuaNumber ? this.d < luaValue0.o() : super.p(luaValue0);
    }

    @Override  // luaj.LuaValue
    public long q() {
        return (long)this.d;
    }

    @Override  // luaj.LuaValue
    public boolean q(LuaValue luaValue0) {
        return luaValue0 instanceof LuaNumber ? this.d <= luaValue0.o() : super.q(luaValue0);
    }

    @Override  // luaj.LuaValue
    public boolean q_() {
        return ((double)(((int)this.d))) == this.d;
    }

    @Override  // luaj.LuaValue
    public LuaValue r() {
        return LuaDouble.a(-this.d);
    }

    @Override  // luaj.LuaValue
    public boolean r(LuaValue luaValue0) {
        return luaValue0 instanceof LuaNumber ? this.d > luaValue0.o() : super.r(luaValue0);
    }

    @Override  // luaj.LuaValue
    public LuaValue s() {
        return !this.n() ? super.s() : LuaDouble.d(~this.q());
    }

    @Override  // luaj.LuaValue
    public boolean s(LuaValue luaValue0) {
        return luaValue0 instanceof LuaNumber ? this.d >= luaValue0.o() : super.s(luaValue0);
    }

    @Override  // luaj.LuaValue
    public LuaString t() {
        return LuaString.c(this.d_());
    }

    @Override  // luaj.LuaValue
    public LuaValue u() {
        return LuaString.c(this.d_());
    }

    @Override  // luaj.LuaValue
    public int v() {
        int v = (int)(((long)this.d));
        if(((double)v) != this.d) {
            throw new o("number \'" + this.d_() + "\' has no integer representation");
        }
        return v;
    }

    @Override  // luaj.LuaValue
    public long w() {
        long v = (long)this.d;
        if(((double)v) != this.d) {
            throw new o("number \'" + this.d_() + "\' has no integer representation");
        }
        return v;
    }

    @Override  // luaj.LuaValue
    public double x() {
        return this.d;
    }

    @Override  // luaj.LuaValue
    public String y() {
        return this.d_();
    }

    @Override  // luaj.LuaValue
    public LuaString z() {
        return LuaString.c(this.d_());
    }
}

