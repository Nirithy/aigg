package luaj.lib;

import luaj.Globals;
import luaj.LuaClosure;
import luaj.LuaFunction;
import luaj.LuaLong;
import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaThread;
import luaj.LuaValue;
import luaj.ag;
import luaj.al;
import luaj.ao;
import luaj.ap;
import luaj.m;
import luaj.o;
import luaj.p;

public class DebugLib extends TwoArgFunction {
    public static boolean a;
    Globals ai;
    private static final LuaString al;
    private static final LuaString am;
    private static final LuaString an;
    private static final LuaString ao;
    private static final LuaString ap;
    private static final LuaString aq;
    public static boolean b;
    static final LuaString c;
    static final LuaString d;
    static final LuaString e;
    static final LuaString f;
    static final LuaString g;
    static final LuaString h;
    static final LuaString i;
    static final LuaString j;
    static final LuaString k;
    static final LuaString l;
    static final LuaString m;
    static final LuaString n;
    static final LuaString o;
    static final LuaString p;
    static final LuaString q;
    static final LuaString r;

    static {
        boolean z = true;
        try {
            DebugLib.a = System.getProperty("CALLS") != null;
        }
        catch(Exception unused_ex) {
        }
        try {
            if(System.getProperty("TRACE") == null) {
                z = false;
            }
            DebugLib.b = z;
        }
        catch(Exception unused_ex) {
        }
        DebugLib.al = DebugLib.m("?");
        DebugLib.am = DebugLib.m("call");
        DebugLib.an = DebugLib.m("tail call");
        DebugLib.ao = DebugLib.m("line");
        DebugLib.ap = DebugLib.m("count");
        DebugLib.aq = DebugLib.m("return");
        DebugLib.c = DebugLib.m("func");
        DebugLib.d = DebugLib.m("istailcall");
        DebugLib.e = DebugLib.m("isvararg");
        DebugLib.f = DebugLib.m("nups");
        DebugLib.g = DebugLib.m("nparams");
        DebugLib.h = DebugLib.m("name");
        DebugLib.i = DebugLib.m("namewhat");
        DebugLib.j = DebugLib.m("what");
        DebugLib.k = DebugLib.m("source");
        DebugLib.l = DebugLib.m("short_src");
        DebugLib.m = DebugLib.m("linedefined");
        DebugLib.n = DebugLib.m("lastlinedefined");
        DebugLib.o = DebugLib.m("currentline");
        DebugLib.p = DebugLib.m("activelines");
        DebugLib.q = DebugLib.m("(*temporary)");
        DebugLib.r = DebugLib.m("(*vararg)");
    }

    public void S() {
        ag ag0 = this.ai.h.d;
        if(ag0.j == 0 && ag0.h) {
            this.a(ag0, DebugLib.aq, DebugLib.u);
        }
        this.T().b(ag0);
    }

    f T() {
        return this.a(this.ai.h);
    }

    public static String a(int v, int v1, al al0) {
        h h0 = DebugLib.a(al0, v, v1);
        return h0 == null ? null : h0.toString();
    }

    static LuaString a(LuaClosure luaClosure0, int v) {
        if(luaClosure0.b != null && v > 0 && v <= luaClosure0.b.length) {
            if(luaClosure0.a.v != null && v <= luaClosure0.a.v.length) {
                LuaString luaString0 = luaClosure0.a.v[v - 1].a;
                return luaString0 == null ? DebugLib.a(luaClosure0.a.v[v - 1], v) : luaString0;
            }
            return DebugLib.a(null, v);
        }
        return null;
    }

    private static LuaString a(ao ao0, int v) {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("(.upval ");
        if(ao0 == null) {
            stringBuilder0.append("???");
        }
        else {
            stringBuilder0.append(((char)(ao0.b ? 0x76 : 0x75)));
            stringBuilder0.append(((int)ao0.c));
        }
        stringBuilder0.append(" \"(*no name)\"; u");
        stringBuilder0.append(v);
        stringBuilder0.append(')');
        return LuaString.c(stringBuilder0.toString());
    }

    static h a(al al0, int v, int v1) {
        LuaString luaString2;
        int v5;
        LuaString luaString0 = al0.a(v1 + 1, v);
        if(luaString0 != null) {
            return new h(luaString0.d_(), "local");
        }
        int v2 = DebugLib.c(al0, v, v1);
        if(v2 != -1) {
            int v3 = al0.r[v2];
            switch(v3 & 0x3F) {
                case 0: {
                    int v4 = v3 >>> 23 & 0x1FF;
                    return v4 >= (v3 >>> 6 & 0xFF) ? null : DebugLib.a(al0, v2, v4);
                }
                case 1: 
                case 2: {
                    if((v3 & 0x3F) == 1) {
                        v5 = v3 >>> 14 & 0x3FFFF;
                        return al0.q[v5].J() ? new h(al0.q[v5].t().d_(), "constant") : null;
                    }
                    v5 = m.c(al0.r[v2 + 1]);
                    return al0.q[v5].J() ? new h(al0.q[v5].t().d_(), "constant") : null;
                }
                case 5: {
                    int v6 = v3 >>> 23 & 0x1FF;
                    if(v6 < al0.v.length) {
                        LuaString luaString1 = al0.v[v6].a;
                        return luaString1 == null ? null : new h(luaString1.d_(), "upvalue");
                    }
                    return DebugLib.al == null ? null : new h("?", "upvalue");
                }
                case 6: 
                case 7: {
                    int v7 = v3 >>> 23 & 0x1FF;
                    if((v3 & 0x3F) == 7) {
                        luaString2 = al0.a(v7 + 1, v2);
                    }
                    else {
                        luaString2 = v7 >= al0.v.length ? DebugLib.al : al0.v[v7].a;
                    }
                    String s = DebugLib.b(al0, v2, v3 >>> 14 & 0x1FF);
                    return luaString2 == null || !luaString2.b(DebugLib.C) ? new h(s, "field") : new h(s, "global");
                }
                case 12: {
                    return new h(DebugLib.b(al0, v2, v3 >>> 14 & 0x1FF), "method");
                }
                default: {
                    return null;
                }
            }
        }
        return null;
    }

    static h a(e e0) {
        if(!e0.a.j()) {
            return new h("LuaFunction", "Java");
        }
        al al0 = e0.a.k().a;
        int v = e0.b;
        if(v < al0.r.length) {
            int v1 = al0.r[v];
            switch(v1 & 0x3F) {
                case 8: 
                case 10: {
                    return new h("__newindex", "metamethod");
                }
                case 6: 
                case 7: 
                case 12: {
                    return new h("__index", "metamethod");
                }
                case 13: {
                    return new h("__add", "metamethod");
                }
                case 14: {
                    return new h("__sub", "metamethod");
                }
                case 15: {
                    return new h("__mul", "metamethod");
                }
                case 16: {
                    return new h("__div", "metamethod");
                }
                case 17: {
                    return new h("__mod", "metamethod");
                }
                case 18: {
                    return new h("__pow", "metamethod");
                }
                case 19: {
                    return new h("__unm", "metamethod");
                }
                case 21: {
                    return new h("__len", "metamethod");
                }
                case 22: {
                    return new h("__concat", "metamethod");
                }
                case 24: {
                    return new h("__eq", "metamethod");
                }
                case 25: {
                    return new h("__lt", "metamethod");
                }
                case 26: {
                    return new h("__le", "metamethod");
                }
                case 29: 
                case 30: {
                    return DebugLib.a(al0, v, v1 >>> 6 & 0xFF);
                }
                case 34: {
                    return new h("for iterator", "for iterator");
                }
                case 40: {
                    return new h("__idiv", "metamethod");
                }
                case 41: {
                    return new h("__bnot", "metamethod");
                }
                case 42: {
                    return new h("__band", "metamethod");
                }
                case 43: {
                    return new h("__bor", "metamethod");
                }
                case 44: {
                    return new h("__bxor", "metamethod");
                }
                case 45: {
                    return new h("__shl", "metamethod");
                }
                case 46: {
                    return new h("__shr", "metamethod");
                }
                default: {
                    return null;
                }
            }
        }
        return null;
    }

    public String a(Globals globals0, int v) {
        return this.T().a(globals0, v);
    }

    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        this.ai = luaValue1.c();
        this.ai.k = this;
        LuaValue luaValue2 = new LuaTable();
        ((LuaTable)luaValue2).a("debug", new DebugLib.debug());
        ((LuaTable)luaValue2).a("gethook", new DebugLib.gethook(this));
        ((LuaTable)luaValue2).a("getinfo", new DebugLib.getinfo(this));
        ((LuaTable)luaValue2).a("getlocal", new DebugLib.getlocal(this));
        ((LuaTable)luaValue2).a("getmetatable", new DebugLib.getmetatable());
        ((LuaTable)luaValue2).a("getregistry", new DebugLib.getregistry(this));
        ((LuaTable)luaValue2).a("getupvalue", new DebugLib.getupvalue());
        ((LuaTable)luaValue2).a("sethook", new DebugLib.sethook(this));
        ((LuaTable)luaValue2).a("setlocal", new DebugLib.setlocal(this));
        ((LuaTable)luaValue2).a("setmetatable", new DebugLib.setmetatable());
        ((LuaTable)luaValue2).a("setupvalue", new DebugLib.setupvalue());
        ((LuaTable)luaValue2).a("traceback", new DebugLib.traceback(this));
        ((LuaTable)luaValue2).a("upvalueid", new DebugLib.upvalueid());
        ((LuaTable)luaValue2).a("upvaluejoin", new DebugLib.upvaluejoin());
        luaValue1.a("debug", luaValue2);
        if(!luaValue1.j("package").F()) {
            luaValue1.j("package").j("loaded").a("debug", luaValue2);
        }
        return luaValue2;
    }

    f a(LuaThread luaThread0) {
        if(luaThread0.e == null) {
            luaThread0.e = new f();
        }
        return (f)luaThread0.e;
    }

    public void a(int v, ap ap0, int v1) {
        ag ag0 = this.ai.h.d;
        this.a(this.ai.h).a(v, ap0, v1);
        if(ag0.j == 0 && ag0.e != null) {
            if(ag0.i > 0) {
                int v2 = ag0.m + 1;
                ag0.m = v2;
                if(v2 % ag0.i == 0) {
                    this.a(ag0, DebugLib.ap, DebugLib.u);
                }
            }
            if(ag0.f) {
                int v3 = this.T().a();
                if(v3 != ag0.k || v <= ag0.l) {
                    ag0.k = v3;
                    LuaLong luaLong0 = LuaValue.d(v3);
                    this.a(ag0, DebugLib.ao, luaLong0);
                }
                ag0.l = v;
            }
        }
    }

    public void a(LuaClosure luaClosure0, ap ap0, LuaValue[] arr_luaValue, boolean z) {
        ag ag0 = this.ai.h.d;
        if(ag0.j == 1) {
            ag0.j = 2;
        }
        this.T().a(luaClosure0, ap0, arr_luaValue, true, z);
        if(ag0.j == 0) {
            if(ag0.f) {
                ag0.k = 0;
                ag0.l = 0;
            }
            if(ag0.g) {
                this.a(ag0, (z ? DebugLib.an : DebugLib.am), DebugLib.u);
            }
        }
    }

    public void a(LuaFunction luaFunction0, boolean z) {
        ag ag0 = this.ai.h.d;
        if(ag0.j == 1) {
            ag0.j = 2;
        }
        this.T().a(luaFunction0, true, z);
        if(ag0.j == 0) {
            if(ag0.f) {
                ag0.k = 0;
                ag0.l = 0;
            }
            if(ag0.g) {
                this.a(ag0, (z ? DebugLib.an : DebugLib.am), DebugLib.u);
            }
        }
    }

    void a(ag ag0, LuaValue luaValue0, LuaValue luaValue1) {
        boolean z = true;
        LuaFunction luaFunction0 = ag0.e;
        if(ag0.j != 0 || luaFunction0 == null) {
            return;
        }
        try {
            ag0.j = 1;
            if(luaFunction0.j()) {
                z = false;
            }
            else {
                this.a(luaFunction0, false);
            }
            try {
                luaFunction0.a(luaValue0, luaValue1);
            }
            catch(Throwable throwable0) {
                if(z) {
                    this.S();
                }
                throw throwable0;
            }
            if(z) {
                this.S();
            }
        }
        catch(o o0) {
            throw o0;
        }
        catch(RuntimeException runtimeException0) {
            throw new p(runtimeException0);
        }
        finally {
            ag0.j = 0;
        }
    }

    static String b(al al0, int v, int v1) {
        if(m.h(v1)) {
            LuaValue luaValue0 = al0.q[v1 & 0xFFFFFEFF];
            return luaValue0.J() ? luaValue0.d_() : "?";
        }
        h h0 = DebugLib.a(al0, v, v1);
        return h0 == null || !"constant".equals(h0.b) ? "?" : h0.a;
    }

    static int c(al al0, int v, int v1) {
        int v6;
        int v2 = -1;
        for(int v3 = 0; v3 < v; v3 = v6 + 1) {
            int v4 = al0.r[v3];
            int v5 = v4 & 0x3F;
            if(v5 < 0x2F) {
                int v7 = v4 >>> 6 & 0xFF;
                switch(v5) {
                    case 4: {
                        if(v7 <= v1 && v1 <= (v4 >>> 23 & 0x1FF) + v7) {
                            v2 = v3;
                            v6 = v3;
                            continue;
                        }
                        break;
                    }
                    case 23: {
                        int v8 = (v4 >>> 14 & 0x3FFFF) - 0x1FFFF;
                        int v9 = v3 + 1 + v8;
                        if(v3 < v9 && v9 <= v) {
                            v6 = v3 + v8;
                            continue;
                        }
                        break;
                    }
                    case 27: {
                        if(v1 == v7) {
                            v2 = v3;
                            v6 = v3;
                            continue;
                        }
                        break;
                    }
                    case 29: 
                    case 30: {
                        if(v1 >= v7) {
                            v2 = v3;
                            v6 = v3;
                            continue;
                        }
                        break;
                    }
                    case 34: {
                        if(v1 >= v7 + 2) {
                            v2 = v3;
                            v6 = v3;
                            continue;
                        }
                        break;
                    }
                    case 36: {
                        if((v4 >> 14 & 0x1FF) == 0) {
                            v6 = v3 + 1;
                            continue;
                        }
                        break;
                    }
                    default: {
                        if(m.n(v5) && v1 == v7) {
                            v2 = v3;
                            v6 = v3;
                            continue;
                        }
                    }
                }
            }
            v6 = v3;
        }
        return v2;
    }

    public e e(int v) {
        return this.T().a(v);
    }
}

