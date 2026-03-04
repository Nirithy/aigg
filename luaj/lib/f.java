package luaj.lib;

import jeb.synthetic.FIN;
import luaj.Globals;
import luaj.LuaClosure;
import luaj.LuaFunction;
import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ag;
import luaj.ap;
import luaj.z;

public class f {
    static final e[] a;
    e[] b;
    int c;

    static {
        f.a = new e[0];
    }

    f() {
        this.b = f.a;
        this.c = 0;
    }

    private static LuaValue a(StringBuffer stringBuffer0, LuaTable luaTable0, LuaValue luaValue0, int v) {
        if(luaTable0 != null) {
            z z0 = luaTable0.S();
            while(z0.a()) {
                if(z0.b() == 0) {
                    LuaValue luaValue1 = z0.c();
                    if(luaValue1 instanceof LuaString) {
                        LuaValue luaValue2 = z0.d();
                        if(luaValue2 == luaValue0) {
                            if(v == 2) {
                                stringBuffer0.append("function \'");
                                stringBuffer0.append(luaValue1.d_());
                                stringBuffer0.append('\'');
                                return DebugLib.u;
                            }
                            return luaValue1;
                        }
                        if(v > 1 && luaValue2.N()) {
                            LuaValue luaValue3 = f.a(stringBuffer0, luaValue2.O(), luaValue0, v - 1);
                            if(luaValue3 != null) {
                                String s = luaValue1.d_();
                                stringBuffer0.append("function \'");
                                if(!s.equals("_G")) {
                                    stringBuffer0.append(s);
                                    stringBuffer0.append('.');
                                }
                                stringBuffer0.append(luaValue3.d_());
                                stringBuffer0.append('\'');
                                return DebugLib.u;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private e a(boolean z) {
        e e0;
        synchronized(this) {
            if(z) {
                e0 = this.b[this.c - 1];
            }
            else {
                if(this.c >= this.b.length) {
                    int v1 = Math.max(4, this.b.length * 3 / 2);
                    e[] arr_e = new e[v1];
                    System.arraycopy(this.b, 0, arr_e, 0, this.b.length);
                    for(int v2 = this.b.length; v2 < v1; ++v2) {
                        arr_e[v2] = new e();
                    }
                    this.b = arr_e;
                    for(int v3 = 1; v3 < v1; ++v3) {
                        arr_e[v3].c = arr_e[v3 - 1];
                    }
                }
                int v4 = this.c;
                this.c = v4 + 1;
                e0 = this.b[v4];
            }
            return e0;
        }
    }

    private static void a(StringBuffer stringBuffer0, Globals globals0, g g0) {
        if(f.a(stringBuffer0, globals0, g0.m.a, 2) == null) {
            if(g0.b.length() > 0) {
                stringBuffer0.append(g0.b);
                stringBuffer0.append(" \'");
                stringBuffer0.append(g0.a);
                stringBuffer0.append('\'');
                return;
            }
            switch(g0.c.charAt(0)) {
                case 74: {
                    stringBuffer0.append('?');
                    return;
                }
                case 109: {
                    stringBuffer0.append("main chunk");
                    return;
                }
                default: {
                    stringBuffer0.append("function <");
                    stringBuffer0.append(g0.l);
                    stringBuffer0.append(':');
                    stringBuffer0.append(g0.f);
                    stringBuffer0.append('>');
                }
            }
        }
    }

    int a() {
        synchronized(this) {
            return this.c <= 0 ? -1 : this.b[this.c - 1].c();
        }
    }

    String a(Globals globals0, int v) {
        StringBuffer stringBuffer0;
        synchronized(this) {
            stringBuffer0 = new StringBuffer();
            stringBuffer0.append("stack traceback:");
            e e0;
            while((e0 = this.a(v)) != null) {
                g g0 = this.a("Slnt", e0.a, e0);
                g0.m = e0;
                stringBuffer0.append("\n\t");
                stringBuffer0.append(g0.l);
                stringBuffer0.append(':');
                if(g0.e > 0) {
                    stringBuffer0.append(g0.e);
                }
                stringBuffer0.append(" in ");
                f.a(stringBuffer0, globals0, g0);
                if(g0.k) {
                    stringBuffer0.append("\n\t(...tail calls...)");
                }
                ++v;
            }
            stringBuffer0.append("\n\t[Java]: in ?");
        }
        return stringBuffer0.toString();
    }

    e a(int v) {
        synchronized(this) {
            return v >= 1 && v <= this.c ? this.b[this.c - v] : null;
        }
    }

    e a(LuaValue luaValue0) {
        e e0;
        __monitor_enter(this);
        int v1 = FIN.finallyOpen$NT();
        for(int v = 1; true; ++v) {
            if(v > this.c) {
                e0 = null;
            }
            else if(this.b[this.c - v].a == luaValue0) {
                e0 = this.b[v];
            }
            else {
                continue;
            }
            FIN.finallyCodeBegin$NT(v1);
            __monitor_exit(this);
            FIN.finallyCodeEnd$NT(v1);
            return e0;
        }
    }

    g a(String s, LuaFunction luaFunction0, e e0) {
        synchronized(this) {
            g g0 = new g();
            int v1 = s.length();
            for(int v2 = 0; v2 < v1; ++v2) {
                switch(s.charAt(v2)) {
                    case 83: {
                        g0.a(luaFunction0);
                        break;
                    }
                    case 108: {
                        g0.e = e0 == null || !e0.a.j() ? -1 : e0.c();
                        break;
                    }
                    case 110: {
                        if(e0 != null && !e0.e) {
                            if(e0.d) {
                                g0.b = "hook";
                                g0.a = "?";
                            }
                            else if(e0.c != null && e0.c.a.j()) {
                                h h0 = DebugLib.a(e0.c);
                                if(h0 != null) {
                                    g0.a = h0.a;
                                    g0.b = h0.b;
                                }
                            }
                        }
                        if(g0.b == null) {
                            g0.b = "";
                            g0.a = null;
                        }
                        break;
                    }
                    case 0x74: {
                        g0.k = e0 != null && e0.e;
                        break;
                    }
                    case 0x75: {
                        if(luaFunction0 == null || !luaFunction0.j()) {
                            g0.h = 0;
                            g0.j = true;
                            g0.i = 0;
                        }
                        else {
                            LuaClosure luaClosure0 = luaFunction0.k();
                            g0.h = (short)luaClosure0.a.v.length;
                            g0.i = (short)luaClosure0.a.z;
                            g0.j = luaClosure0.a.A != 0;
                        }
                    }
                }
            }
            return g0;
        }
    }

    final void a(int v, ap ap0, int v1) {
        synchronized(this) {
            int v3 = this.c;
            if(v3 > 0) {
                this.b[v3 - 1].a(v, ap0, v1);
            }
        }
    }

    final void a(LuaClosure luaClosure0, ap ap0, LuaValue[] arr_luaValue, boolean z, boolean z1) {
        synchronized(this) {
            this.a(z1).a(luaClosure0, ap0, arr_luaValue, z, z1);
        }
    }

    final void a(LuaFunction luaFunction0, boolean z, boolean z1) {
        synchronized(this) {
            this.a(z1).a(luaFunction0, z, z1);
        }
    }

    void a(ag ag0) {
        synchronized(this) {
            if(ag0.f && this.c > 0) {
                e e0 = this.b[this.c - 1];
                ag0.k = e0.c();
                ag0.l = e0.b;
            }
        }
    }

    final void b(ag ag0) {
        synchronized(this) {
            if(this.c > 0) {
                int v1 = this.c - 1;
                this.c = v1;
                this.b[v1].b();
            }
            this.a(ag0);
        }
    }
}

