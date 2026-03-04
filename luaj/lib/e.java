package luaj.lib;

import luaj.LuaClosure;
import luaj.LuaFunction;
import luaj.LuaString;
import luaj.LuaValue;
import luaj.aj;
import luaj.ap;

public class e {
    LuaFunction a;
    int b;
    e c;
    boolean d;
    boolean e;
    private LuaValue[] f;

    // 去混淆评级： 低(40)
    public String a() {
        return this.a.j() ? "null" : "[Java]";
    }

    ap a(int v) {
        if(v < 0) {
            if(!this.a.j()) {
                return DebugLib.u;
            }
            ap ap0 = this.a.k().m();
            if(ap0 == null || -v > ap0.j_()) {
                return DebugLib.u;
            }
            LuaValue luaValue0 = ap0.c(-v);
            return DebugLib.b(DebugLib.r, luaValue0);
        }
        LuaString luaString0 = this.b(v);
        if(this.f != null && v >= 1 && v <= this.f.length && this.f[v - 1] != null) {
            if(luaString0 == null) {
                luaString0 = DebugLib.q;
            }
            return DebugLib.b(luaString0, this.f[v - 1]);
        }
        return DebugLib.u;
    }

    ap a(int v, LuaValue luaValue0) {
        if(v < 0) {
            if(!this.a.j()) {
                return DebugLib.u;
            }
            LuaClosure luaClosure0 = this.a.k();
            ap ap0 = luaClosure0.m();
            if(ap0 == null || -v > ap0.j_()) {
                return DebugLib.u;
            }
            int v2 = ap0.j_();
            LuaValue[] arr_luaValue = new LuaValue[v2];
            for(int v1 = 1; v1 <= v2; ++v1) {
                arr_luaValue[v1 - 1] = -v == v1 ? luaValue0 : ap0.c(v1);
            }
            luaClosure0.b(DebugLib.c(arr_luaValue));
            return DebugLib.r;
        }
        ap ap1 = this.b(v);
        if(this.f != null && v >= 1 && v <= this.f.length && this.f[v - 1] != null) {
            this.f[v - 1] = luaValue0;
            return ap1 == null ? DebugLib.q : ap1;
        }
        return DebugLib.u;
    }

    void a(int v, ap ap0, int v1) {
        this.b = v;
        if(DebugLib.b) {
            aj.a(this.a.k(), v, this.f, v1, ap0);
        }
    }

    void a(LuaClosure luaClosure0, ap ap0, LuaValue[] arr_luaValue, boolean z, boolean z1) {
        this.a = luaClosure0;
        this.f = arr_luaValue;
        this.b = 0;
        this.d = z;
        this.e = z1;
    }

    void a(LuaFunction luaFunction0, boolean z, boolean z1) {
        this.a = luaFunction0;
        this.f = null;
        this.b = 0;
        this.d = z;
        this.e = z1;
    }

    LuaString b(int v) {
        return this.a.j() ? this.a.k().a.a(v, this.b) : null;
    }

    void b() {
        this.a = null;
        this.f = null;
        this.b = 0;
        this.d = false;
        this.e = false;
    }

    public int c() {
        if(!this.a.j()) {
            return -1;
        }
        int[] arr_v = this.a.k().a.t;
        return arr_v == null || this.b < 0 || this.b >= arr_v.length ? -1 : arr_v[this.b];
    }

    @Override
    public String toString() {
        return "CallFrame [f=" + this.a + ", pc=" + this.b + ", hookcall=" + this.d + "]";
    }
}

