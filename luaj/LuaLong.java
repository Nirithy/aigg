package luaj;

public class LuaLong extends LuaNumber {
    public static final LuaLong a;
    public static final LuaLong b;
    public final long c;
    private static final LuaLong[] d;
    private static final LuaString[] f;
    private static final String[] g;

    static {
        LuaLong.a = new LuaLong(0x7FFFFFFFFFFFFFFFL);
        LuaLong.b = new LuaLong(0x8000000000000000L);
        LuaLong.d = new LuaLong[0x200];
        LuaLong.f = new LuaString[0x200];
        LuaLong.g = new String[0x200];
    }

    LuaLong(long v) {
        this.c = v;
    }

    @Override  // luaj.LuaValue
    public boolean E() {
        return true;
    }

    private String S() {
        if(this.c <= 0xFFL && this.c >= 0xFFFFFFFFFFFFFF00L) {
            String s = LuaLong.g[((int)(this.c + 0x100L))];
            if(s == null) {
                s = Long.toString(this.c);
                LuaLong.g[((int)(this.c + 0x100L))] = s;
            }
            return s;
        }
        return Long.toString(this.c);
    }

    private LuaString T() {
        if(this.c <= 0xFFL && this.c >= 0xFFFFFFFFFFFFFF00L) {
            LuaString luaString0 = LuaLong.f[((int)(this.c + 0x100L))];
            if(luaString0 == null) {
                luaString0 = LuaString.c(this.S());
                LuaLong.f[((int)(this.c + 0x100L))] = luaString0;
            }
            return luaString0;
        }
        return LuaString.c(this.S());
    }

    public static LuaValue a(long v, long v1) {
        if(v1 < 0L) {
            return LuaLong.b(v, -v1);
        }
        return v1 > 0x3FL ? LuaLong.y : LuaLong.b(v << ((int)v1));
    }

    @Override  // luaj.LuaValue
    public LuaString a(LuaString luaString0) {
        return this.T();
    }

    @Override  // luaj.LuaValue
    public long a_(long v) {
        return this.c;
    }

    public static LuaLong b(long v) {
        if(v <= 0xFFL && v >= 0xFFFFFFFFFFFFFF00L) {
            LuaLong luaLong0 = LuaLong.d[((int)(v + 0x100L))];
            if(luaLong0 == null) {
                luaLong0 = new LuaLong(v);
                LuaLong.d[((int)(v + 0x100L))] = luaLong0;
            }
            return luaLong0;
        }
        if(v == 0x7FFFFFFFFFFFFFFFL) {
            return LuaLong.a;
        }
        return v == 0x8000000000000000L ? LuaLong.b : new LuaLong(v);
    }

    public static LuaValue b(long v, long v1) {
        if(v1 < 0L) {
            return LuaLong.a(v, -v1);
        }
        return v1 > 0x3FL ? LuaLong.y : LuaLong.b(v >>> ((int)v1));
    }

    @Override  // luaj.LuaValue
    public double b(double f) {
        return (double)this.c;
    }

    @Override  // luaj.LuaValue
    public boolean b(LuaValue luaValue0) {
        if(!luaValue0.I()) {
            return super.b(luaValue0);
        }
        return luaValue0.n() ? this.c == luaValue0.q() : ((double)this.c) == luaValue0.o();
    }

    @Override  // luaj.LuaValue
    public int b_(int v) {
        return (int)this.c;
    }

    @Override  // luaj.LuaValue
    public String b_(String s) {
        return this.S();
    }

    public static int c(long v) [...] // Inlined contents

    public static long c(long v, long v1) {
        if(v1 == 0L) {
            throw new o("attempt to divide by zero (as \'" + v + " // " + 0L + "\')");
        }
        long v2 = v / v1;
        return (v ^ v1) >= 0L || v2 * v1 == v ? v2 : v2 - 1L;
    }

    @Override  // luaj.LuaValue
    public boolean c(LuaValue luaValue0) {
        if(!luaValue0.I()) {
            return false;
        }
        return luaValue0.n() ? this.c == luaValue0.q() : ((double)this.c) == luaValue0.o();
    }

    public static long d(long v, long v1) {
        if(v1 == 0L) {
            throw new o("attempt to perform \'n%0\' (as \'" + v + " % " + 0L + "\')");
        }
        long v2 = v % v1;
        if(v2 != 0L) {
            int v3 = v2 >= 0L ? 0 : 1;
            if(v1 < 0L) {
                return (1 ^ v3) == 0 ? v2 : v2 + v1;
            }
            return v3 == 0 ? v2 : v2 + v1;
        }
        return 0L;
    }

    @Override  // luaj.LuaValue
    public LuaValue d(LuaValue luaValue0) {
        if(!luaValue0.I()) {
            return super.d(luaValue0);
        }
        return luaValue0.n() ? LuaLong.b(this.c + luaValue0.q()) : LuaLong.c(((double)this.c) + luaValue0.o());
    }

    @Override  // luaj.LuaValue
    public String d_() {
        return this.S();
    }

    @Override  // luaj.LuaValue
    public LuaValue e(LuaValue luaValue0) {
        if(!luaValue0.I()) {
            return super.e(luaValue0);
        }
        return luaValue0.n() ? LuaLong.b(this.c - luaValue0.q()) : LuaLong.c(((double)this.c) - luaValue0.o());
    }

    @Override  // luaj.LuaValue
    public boolean equals(Object object0) {
        return object0 instanceof LuaLong && ((LuaLong)object0).c == this.c;
    }

    @Override  // luaj.LuaValue
    public LuaValue f(LuaValue luaValue0) {
        if(!luaValue0.I()) {
            return super.f(luaValue0);
        }
        return luaValue0.n() ? LuaLong.b(this.c * luaValue0.q()) : LuaLong.c(((double)this.c) * luaValue0.o());
    }

    @Override  // luaj.LuaValue
    public LuaValue g(LuaValue luaValue0) {
        return !luaValue0.I() ? super.g(luaValue0) : LuaLong.c(Math.pow(this.c, luaValue0.o()));
    }

    @Override  // luaj.LuaValue
    public LuaValue h(LuaValue luaValue0) {
        if(!luaValue0.I()) {
            return super.h(luaValue0);
        }
        return luaValue0.n() && luaValue0.q() != 0L ? LuaLong.b(this.c / luaValue0.q()) : LuaDouble.a(this.c, luaValue0.o());
    }

    @Override  // luaj.LuaValue
    public boolean h_() {
        return true;
    }

    @Override
    public int hashCode() {
        return (int)(this.c >>> 0x20 ^ this.c);
    }

    @Override  // luaj.LuaValue
    public LuaValue i(LuaValue luaValue0) {
        if(!luaValue0.I()) {
            return super.i(luaValue0);
        }
        return luaValue0.E() ? LuaLong.b(LuaLong.c(this.c, luaValue0.q())) : LuaDouble.b(this.c, luaValue0.o());
    }

    @Override  // luaj.LuaValue
    public LuaValue j(LuaValue luaValue0) {
        if(!luaValue0.I()) {
            return super.j(luaValue0);
        }
        return luaValue0.E() ? LuaLong.b(LuaLong.d(this.c, luaValue0.q())) : LuaDouble.c(this.c, luaValue0.o());
    }

    @Override  // luaj.LuaValue
    public LuaValue k(LuaValue luaValue0) {
        return !luaValue0.n() ? super.k(luaValue0) : LuaLong.b(this.c & luaValue0.q());
    }

    @Override  // luaj.LuaValue
    public LuaValue l(LuaValue luaValue0) {
        return !luaValue0.n() ? super.l(luaValue0) : LuaLong.b(this.c | luaValue0.q());
    }

    @Override  // luaj.LuaValue
    public LuaValue m(LuaValue luaValue0) {
        return !luaValue0.n() ? super.m(luaValue0) : LuaLong.b(this.c ^ luaValue0.q());
    }

    @Override  // luaj.LuaValue
    public LuaValue n(LuaValue luaValue0) {
        return luaValue0.n() ? LuaLong.a(this.c, luaValue0.q()) : super.n(luaValue0);
    }

    @Override  // luaj.LuaValue
    public boolean n() {
        return true;
    }

    @Override  // luaj.LuaValue
    public double o() {
        return (double)this.c;
    }

    @Override  // luaj.LuaValue
    public LuaValue o(LuaValue luaValue0) {
        return luaValue0.n() ? LuaLong.b(this.c, luaValue0.q()) : super.o(luaValue0);
    }

    @Override  // luaj.LuaValue
    public int p() {
        return (int)this.c;
    }

    @Override  // luaj.LuaValue
    public boolean p(LuaValue luaValue0) {
        if(!(luaValue0 instanceof LuaNumber)) {
            return super.p(luaValue0);
        }
        return luaValue0.n() ? this.c < luaValue0.q() : ((double)this.c) < luaValue0.o();
    }

    @Override  // luaj.LuaValue
    public long q() {
        return this.c;
    }

    @Override  // luaj.LuaValue
    public boolean q(LuaValue luaValue0) {
        if(!(luaValue0 instanceof LuaNumber)) {
            return super.q(luaValue0);
        }
        return luaValue0.n() ? this.c <= luaValue0.q() : ((double)this.c) <= luaValue0.o();
    }

    @Override  // luaj.LuaValue
    public boolean q_() {
        return ((long)(((int)this.c))) == this.c;
    }

    @Override  // luaj.LuaValue
    public LuaValue r() {
        return LuaLong.b(-this.c);
    }

    @Override  // luaj.LuaValue
    public boolean r(LuaValue luaValue0) {
        if(!(luaValue0 instanceof LuaNumber)) {
            return super.r(luaValue0);
        }
        return luaValue0.n() ? this.c > luaValue0.q() : ((double)this.c) > luaValue0.o();
    }

    @Override  // luaj.LuaValue
    public LuaValue s() {
        return LuaLong.b(~this.c);
    }

    @Override  // luaj.LuaValue
    public boolean s(LuaValue luaValue0) {
        if(!(luaValue0 instanceof LuaNumber)) {
            return super.s(luaValue0);
        }
        return luaValue0.n() ? this.c >= luaValue0.q() : ((double)this.c) >= luaValue0.o();
    }

    @Override  // luaj.LuaValue
    public LuaString t() {
        return this.T();
    }

    @Override  // luaj.LuaValue
    public LuaValue u() {
        return this.T();
    }

    @Override  // luaj.LuaValue
    public int v() {
        return (int)this.c;
    }

    @Override  // luaj.LuaValue
    public long w() {
        return this.c;
    }

    @Override  // luaj.LuaValue
    public double x() {
        return (double)this.c;
    }

    @Override  // luaj.LuaValue
    public String y() {
        return String.valueOf(this.c);
    }

    @Override  // luaj.LuaValue
    public LuaString z() {
        return LuaLong.m(String.valueOf(this.c));
    }
}

