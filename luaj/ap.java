package luaj;

import luaj.lib.VarArgFunction;

public abstract class ap {
    public static final ThreadLocal ah;

    static {
        ap.ah = new ThreadLocal();
    }

    private o a(int v, o o0) {
        String s = o0.getMessage();
        if(s.startsWith("bad argument: ")) {
            s = s.substring(14);
        }
        String s1 = (v > this.j_() ? "no value" : this.c(v).f_()) + ": " + s;
        VarArgFunction varArgFunction0 = (VarArgFunction)ap.ah.get();
        return varArgFunction0 == null ? new n(v, null, s1) : new n(v, varArgFunction0.g_(), s1);
    }

    public double a(int v, double f) {
        try {
            return this.c(v).b(f);
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public long a(int v, long v1) {
        try {
            return this.c(v).a_(v1);
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public LuaFunction a(int v, LuaFunction luaFunction0) {
        try {
            return this.c(v).a(luaFunction0);
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public LuaString a(int v, LuaString luaString0) {
        try {
            return this.c(v).a(luaString0);
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public LuaTable a(int v, LuaTable luaTable0) {
        try {
            return this.c(v).a(luaTable0);
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public void a(boolean z, int v, String s) {
        if(!z) {
            LuaValue.a(v, s);
        }
    }

    public boolean a(int v, boolean z) {
        try {
            return this.c(v).a(z);
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public ap ae() {
        int v = this.j_();
        switch(v) {
            case 0: {
                return LuaValue.x;
            }
            case 1: {
                return this.g();
            }
            case 2: {
                return new as(this.g(), this.c(2));
            }
            default: {
                LuaValue[] arr_luaValue = new LuaValue[v];
                this.b(arr_luaValue, 0, v);
                return new ar(arr_luaValue, LuaValue.x);
            }
        }
    }

    public ap b() {
        return this;
    }

    void b(LuaValue[] arr_luaValue, int v, int v1) {
        for(int v2 = 0; v2 < v1; ++v2) {
            arr_luaValue[v + v2] = this.c(v2 + 1);
        }
    }

    public String c(int v, String s) {
        try {
            return this.c(v).b_(s);
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public abstract LuaValue c(int arg1);

    public int d(int v, int v1) {
        try {
            return this.c(v).b_(v1);
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public LuaValue d(int v, LuaValue luaValue0) {
        return v <= 0 || v > this.j_() ? luaValue0 : this.c(v);
    }

    public String d_() {
        a a0 = new a();
        a0.a("(");
        int v = this.j_();
        for(int v1 = 1; v1 <= v; ++v1) {
            if(v1 > 1) {
                a0.a(",");
            }
            a0.a(this.c(v1).d_());
        }
        a0.a(")");
        return "";
    }

    public abstract ap e_(int arg1);

    public boolean f(int v) {
        return this.c(v).F();
    }

    public abstract LuaValue g();

    public boolean g(int v) {
        return this.c(v).B();
    }

    public boolean h(int v) {
        return this.c(v).I();
    }

    public boolean i(int v) {
        return this.c(v).J();
    }

    public boolean j(int v) {
        return this.c(v).p_();
    }

    public abstract int j_();

    public boolean k(int v) {
        try {
            return this.c(v).h();
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public LuaClosure l(int v) {
        try {
            return this.c(v).k();
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public boolean l_() {
        return false;
    }

    public double m(int v) {
        try {
            return this.c(v).x();
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public LuaFunction n(int v) {
        try {
            return this.c(v).C();
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public int o(int v) {
        try {
            return this.c(v).v();
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public long p(int v) {
        try {
            return this.c(v).w();
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public LuaNumber q(int v) {
        try {
            return this.c(v).G();
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public String r(int v) {
        try {
            return this.c(v).y();
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public LuaString s(int v) {
        try {
            return this.c(v).z();
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public LuaTable t(int v) {
        try {
            return this.c(v).O();
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    @Override
    public String toString() {
        return this.d_();
    }

    public LuaThread u(int v) {
        try {
            return this.c(v).R();
        }
        catch(o o0) {
            throw this.a(v, o0);
        }
    }

    public LuaValue v(int v) {
        return v > this.j_() ? LuaValue.a(v, "value expected") : this.c(v);
    }

    public boolean w(int v) {
        return this.c(v).i_();
    }

    public long x(int v) {
        return this.c(v).q();
    }

    public String y(int v) {
        return this.c(v).d_();
    }
}

