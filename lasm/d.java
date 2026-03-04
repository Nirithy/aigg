package lasm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import luaj.LuaValue;
import luaj.a.a;
import luaj.a.g;
import luaj.al;
import luaj.ao;
import luaj.l;
import luaj.m;

public class d extends al {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    e[] h;
    int i;
    e[] j;
    int k;
    e[] l;
    g m;
    HashMap n;
    HashMap o;
    HashMap p;

    d() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.i = 0;
        this.k = 0;
        this.q = new LuaValue[8];
        this.r = new int[8];
        this.s = new al[8];
        this.t = new int[8];
        this.u = new l[8];
        this.v = new ao[8];
        this.h = new e[8];
        this.j = new e[8];
        this.n = new HashMap();
        this.o = new HashMap();
        this.p = new HashMap();
        this.m = new g(this);
    }

    public int a(int v) {
        if(this.c != 0) {
            if(this.t.length <= this.b) {
                this.t = Arrays.copyOf(this.t, android.c.d.a(this.b + 1));
            }
            this.t[this.b] = this.c;
            this.e = this.b + 1;
        }
        int v1 = this.b;
        this.b = v1 + 1;
        this.r = android.c.d.a(this.r, v1, v);
        return 0;
    }

    d a() {
        e e0;
        if(this.q.length != this.a) {
            this.q = (LuaValue[])Arrays.copyOf(this.q, this.a);
        }
        if(this.r.length != this.b) {
            this.r = Arrays.copyOf(this.r, this.b);
        }
        if(this.s.length != this.d) {
            this.s = (al[])Arrays.copyOf(this.s, this.d);
        }
        if(this.t.length != this.e) {
            this.t = Arrays.copyOf(this.t, this.e);
        }
        if(this.u.length != this.f) {
            this.u = (l[])Arrays.copyOf(this.u, this.f);
        }
        if(this.v.length != this.g) {
            this.v = (ao[])Arrays.copyOf(this.v, this.g);
        }
        int v = this.i;
        for(int v1 = 0; true; ++v1) {
            if(v1 >= v) {
                int v2 = this.k;
                for(int v3 = 0; true; ++v3) {
                    if(v3 >= v2) {
                        int v4;
                        for(v4 = 0; true; ++v4) {
                            if(v4 >= this.l.length) {
                                this.h = null;
                                this.j = null;
                                this.n = null;
                                this.o = null;
                                this.p = null;
                                this.m = null;
                                this.l = null;
                                return this;
                            }
                            e0 = this.l[v4];
                            if(e0 != null) {
                                break;
                            }
                        }
                        throw new c(e0.a, "No \'.end local\' for local variable v" + v4);
                    }
                    e e1 = this.j[v3];
                    e e2 = (e)this.p.get(e1.a.f.toLowerCase(Locale.ENGLISH));
                    if(e2 == null) {
                        throw new c(e1.a, "The function " + e1.a.f + " is missing");
                    }
                    a.e(new luaj.a.e(this.r, e1.b), e2.b);
                }
            }
            e e3 = this.h[v1];
            e e4 = (e)this.o.get(e3.a.f.toLowerCase(Locale.ENGLISH));
            if(e4 == null) {
                throw new c(e3.a, "The label " + e3.a.f + " is missing");
            }
            a.f(new luaj.a.e(this.r, e3.b), e4.b - e3.b - 1);
        }
    }

    void a(LasmBase.Internal lasmBase$Internal0, i i0) {
        int v = this.g;
        this.g = v + 1;
        this.v = (ao[])android.c.d.a(this.v, v, new ao(lasm.a.e(i0), lasmBase$Internal0 instanceof LasmBase.V, lasmBase$Internal0.a));
    }

    void a(LasmBase.V lasmBase$V0, i i0) {
        int v = lasmBase$V0.e_();
        if(this.l[v] != null) {
            throw new c(lasmBase$V0.b, "Try redefine not ended local variable v" + v + " (v" + v + " defined at line " + this.l[v].a.b + " as \'" + this.l[v].a.f + "\')");
        }
        e[] arr_e = this.l;
        arr_e[v] = new e(i0, this.f);
        int v1 = this.f;
        this.f = v1 + 1;
        this.u = (l[])android.c.d.a(this.u, v1, new l(lasm.a.e(i0), this.b, this.b + 1));
    }

    void a(LasmBase.V lasmBase$V0, i i0, int v) {
        int v1 = lasmBase$V0.e_();
        if(this.l[v1] == null) {
            throw new c(lasmBase$V0.b, "Try end not defined local variable v" + v1);
        }
        if(!this.l[v1].a.f.equals(i0.f)) {
            throw new c(lasmBase$V0.b, "Try end local variable v" + v1 + " with different name (v" + v1 + " defined at line " + this.l[v1].a.b + " as \'" + this.l[v1].a.f + "\')");
        }
        this.u[this.l[v1].b].c = this.b + v;
        this.l[v1] = null;
    }

    void a(i i0) {
        this.B = Math.max(2, LasmBase.a(i0, 0xFF));
        if(this.B < this.z) {
            throw new c(i0, ".maxstacksize (" + this.B + ") must be not less .numparams (" + this.z + ")");
        }
        this.l = new e[this.B];
    }

    void a(i i0, d d0) {
        String s = i0.f.toLowerCase(Locale.ENGLISH);
        e e0 = (e)this.p.get(s);
        if(e0 != null) {
            throw new c(i0, "Duplicate function name \'" + i0.f + "\' (used at line " + e0.a.b + ")");
        }
        this.p.put(s, new e(i0, this.d));
        int v = this.d;
        this.d = v + 1;
        this.s = (al[])android.c.d.a(this.s, v, d0);
    }

    void a(i i0, LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2, i i1, i i2) {
        int v12;
        int v10;
        int v9;
        int v8;
        int v7;
        int v6;
        try {
            int v = 1;
            int v1 = 0;
            switch(i0.a) {
                case 5: {
                    v6 = -1;
                    goto label_160;
                }
                case 6: {
                    this.m.i(luaValue0.e_(), this.b(luaValue1));
                    return;
                }
                case 7: {
                    g g0 = this.m;
                    int v2 = luaValue0.e_();
                    int v3 = lasm.a.a(i1);
                    if(i2 == null) {
                        v = 0;
                    }
                    g0.d(3, v2, v3, v);
                    return;
                }
                case 8: {
                    this.m.d(4, luaValue0.e_(), luaValue1.e_() - luaValue0.e_(), 0);
                    return;
                }
                case 9: {
                    v6 = 5;
                    goto label_50;
                }
                case 10: {
                    v7 = 6;
                    goto label_44;
                }
                case 11: {
                    v7 = -1;
                label_44:
                    if(v7 < 0) {
                        v7 = 7;
                    }
                    goto label_56;
                }
                case 12: {
                    v7 = -1;
                    goto label_58;
                }
                case 13: {
                    v6 = -1;
                label_50:
                    if(v6 >= 0) {
                        goto label_86;
                    }
                    v6 = 9;
                    goto label_86;
                }
                case 14: {
                    v7 = -1;
                    goto label_183;
                }
                case 15: {
                    this.m.d(11, luaValue0.e_(), lasm.a.a(i1), lasm.a.a(i2));
                    return;
                }
                case 16: {
                    v7 = -1;
                label_56:
                    if(v7 < 0) {
                        v7 = 12;
                    }
                label_58:
                    if(v7 < 0) {
                        v7 = 8;
                    }
                    goto label_62;
                }
                case 17: {
                    v7 = -1;
                label_62:
                    if(v7 < 0) {
                        v7 = 13;
                    }
                    goto label_66;
                }
                case 18: {
                    v7 = -1;
                label_66:
                    if(v7 < 0) {
                        v7 = 14;
                    }
                    goto label_70;
                }
                case 19: {
                    v7 = -1;
                label_70:
                    if(v7 < 0) {
                        v7 = 15;
                    }
                    goto label_74;
                }
                case 20: {
                    v7 = -1;
                label_74:
                    if(v7 < 0) {
                        v7 = 16;
                    }
                    goto label_78;
                }
                case 21: {
                    v7 = -1;
                label_78:
                    if(v7 < 0) {
                        v7 = 17;
                    }
                    goto label_82;
                }
                case 22: {
                    v7 = -1;
                label_82:
                    if(v7 < 0) {
                        v7 = 18;
                    }
                    goto label_154;
                }
                case 23: {
                    v6 = -1;
                label_86:
                    if(v6 < 0) {
                        v6 = 19;
                    }
                    goto label_90;
                }
                case 24: {
                    v6 = -1;
                label_90:
                    if(v6 < 0) {
                        v6 = 20;
                    }
                    goto label_94;
                }
                case 25: {
                    v6 = -1;
                label_94:
                    if(v6 >= 0) {
                        goto label_158;
                    }
                    v6 = 21;
                    goto label_158;
                }
                case 26: {
                    v7 = -1;
                    break;
                }
                case 27: {
                    v8 = 23;
                    goto label_126;
                }
                case 28: {
                    v9 = 24;
                    goto label_104;
                }
                case 29: {
                    v9 = -1;
                label_104:
                    if(v9 < 0) {
                        v9 = 25;
                    }
                    goto label_108;
                }
                case 30: {
                    v9 = -1;
                label_108:
                    if(v9 < 0) {
                        v9 = 26;
                    }
                    this.m.d(v9, lasm.a.a(i1), this.c(luaValue0), this.c(luaValue1));
                    return;
                }
                case 0x1F: {
                    v10 = 27;
                    goto label_115;
                }
                case 0x20: {
                    v10 = -1;
                label_115:
                    if(v10 < 0) {
                        v10 = 28;
                    }
                    g g1 = this.m;
                    int v11 = luaValue0.e_();
                    if(luaValue1 != null) {
                        v1 = luaValue1.e_();
                    }
                    g1.d(v10, v11, v1, lasm.a.a(i1));
                    return;
                }
                case 33: {
                    int v4 = luaValue1 == null ? 0 : luaValue1.e_() - luaValue0.e_() + 1;
                    if(i1 == null) {
                        v1 = luaValue2 == null ? 1 : luaValue2.e_() - luaValue0.e_() + 2;
                    }
                    this.m.d(29, luaValue0.e_(), v4, v1);
                    return;
                }
                case 34: {
                    v12 = 30;
                    goto label_145;
                }
                case 35: {
                    int v5 = luaValue0 == null ? 0 : luaValue0.e_();
                    if(luaValue0 != null) {
                        v = luaValue1 == null ? 0 : luaValue1.e_() - luaValue0.e_() + 2;
                    }
                    this.m.d(0x1F, v5, v, 0);
                    return;
                }
                case 36: {
                    v8 = -1;
                label_126:
                    if(v8 < 0) {
                        v8 = 0x20;
                    }
                    goto label_130;
                }
                case 37: {
                    v8 = -1;
                label_130:
                    if(v8 < 0) {
                        v8 = 33;
                    }
                    goto label_134;
                }
                case 38: {
                    this.m.d(34, luaValue0.e_(), 0, luaValue1.e_() - luaValue0.e_() - 2);
                    return;
                }
                case 39: {
                    v8 = -1;
                label_134:
                    if(v8 < 0) {
                        v8 = 35;
                    }
                    g g2 = this.m;
                    if(v8 != 23) {
                        v1 = luaValue0.e_();
                    }
                    else if(luaValue0 != null) {
                        v1 = luaValue0.e_() + 1;
                    }
                    g2.b(v8, v1, this.d(i1));
                    return;
                }
                case 40: {
                    if(luaValue1 == null) {
                        luaValue1 = luaValue0;
                    }
                    this.m.f(luaValue0.e_(), luaValue1.e_() - luaValue0.e_(), lasm.a.a(i1));
                    return;
                }
                case 41: {
                    this.m.d(37, luaValue0.e_(), this.e(i1));
                    return;
                }
                case 42: {
                    v12 = -1;
                label_145:
                    if(v12 < 0) {
                        v12 = 38;
                    }
                    g g3 = this.m;
                    int v13 = luaValue0.e_();
                    if(luaValue1 != null) {
                        v1 = luaValue1.e_() - luaValue0.e_() + 1;
                    }
                    g3.d(v12, v13, v1, 0);
                    return;
                }
                case 43: {
                    v7 = -1;
                label_154:
                    if(v7 < 0) {
                        v7 = 40;
                    }
                    goto label_165;
                }
                case 44: {
                    v6 = -1;
                label_158:
                    if(v6 < 0) {
                        v6 = 41;
                    }
                label_160:
                    if(v6 >= 0) {
                        v1 = v6;
                    }
                    this.m.d(v1, luaValue0.e_(), luaValue1.e_(), 0);
                    return;
                }
                case 45: {
                    v7 = -1;
                label_165:
                    if(v7 < 0) {
                        v7 = 42;
                    }
                    goto label_169;
                }
                case 46: {
                    v7 = -1;
                label_169:
                    if(v7 < 0) {
                        v7 = 43;
                    }
                    goto label_173;
                }
                case 0x2F: {
                    v7 = -1;
                label_173:
                    if(v7 < 0) {
                        v7 = 44;
                    }
                    goto label_177;
                }
                case 0x30: {
                    v7 = -1;
                label_177:
                    if(v7 < 0) {
                        v7 = 45;
                    }
                    goto label_181;
                }
                case 49: {
                    v7 = -1;
                label_181:
                    if(v7 < 0) {
                        v7 = 46;
                    }
                label_183:
                    if(v7 < 0) {
                        v7 = 10;
                    }
                    break;
                }
                case 0x4F: {
                    this.a(lasm.a.b(i1));
                    return;
                }
                default: {
                    throw new c(i0, "Unknow token for OP: \'" + i0.f + "\'");
                }
            }
            if(v7 < 0) {
                v7 = 22;
            }
            this.m.d(v7, luaValue0.e_(), this.c(luaValue1), this.c(luaValue2));
            return;
        }
        catch(Throwable throwable0) {
            if(!(throwable0 instanceof c)) {
                throw new c(i0, "Failed assemble OP \'" + i0.f + "\'", throwable0);
            }
            throw throwable0;
        }
    }

    void a(LuaValue luaValue0) {
    }

    int b(LuaValue luaValue0) {
        if(luaValue0 instanceof LasmBase.Const) {
            return luaValue0.e_();
        }
        Integer integer0 = (Integer)this.n.get(luaValue0);
        if(integer0 == null) {
            Integer integer1 = this.a;
            this.n.put(luaValue0, integer1);
            int v = this.a;
            this.a = v + 1;
            this.q = (LuaValue[])android.c.d.a(this.q, v, luaValue0);
            integer0 = integer1;
        }
        return (int)integer0;
    }

    void b(i i0) {
        String s = i0.f.toLowerCase(Locale.ENGLISH);
        e e0 = (e)this.o.get(s);
        if(e0 != null) {
            throw new c(i0, "Try redefine label \'" + i0.f + "\' (already defined at line " + e0.a.b + ")");
        }
        this.o.put(s, new e(i0, this.b));
    }

    // 去混淆评级： 低(20)
    int c(LuaValue luaValue0) {
        return luaValue0 instanceof LasmBase.Internal ? luaValue0.e_() : m.j(this.b(luaValue0));
    }

    void c(i i0) {
        this.c = lasm.a.a(i0);
    }

    int d(i i0) {
        int v = i0.a == 60 ? lasm.a.a(i0) : -1;
        if(i0.a != 60) {
            e e0 = (e)this.o.get(i0.f.toLowerCase(Locale.ENGLISH));
            if(e0 != null) {
                return e0.b - this.b - 1;
            }
            int v1 = this.i;
            this.i = v1 + 1;
            this.h = (e[])android.c.d.a(this.h, v1, new e(i0, this.b));
            return v;
        }
        return v;
    }

    int e(i i0) {
        if(i0.a == 0x4F) {
            return lasm.a.a(i0);
        }
        int v = this.k;
        this.k = v + 1;
        this.j = (e[])android.c.d.a(this.j, v, new e(i0, this.b));
        return 0x3FFFF;
    }
}

