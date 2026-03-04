package luaj.a;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import luaj.LuaDouble;
import luaj.LuaLong;
import luaj.LuaString;
import luaj.LuaValue;
import luaj.al;
import luaj.l;

public class h extends a {
    protected static final String[] b;
    int c;
    int d;
    int e;
    final p f;
    final p g;
    c h;
    u i;
    InputStream j;
    char[] k;
    int l;
    k m;
    LuaString n;
    LuaString o;
    byte p;
    static final String[] q;
    static final Hashtable r;
    static n[] s;
    private static final Hashtable t;
    private i u;
    private final int[] v;

    static {
        h.b = new String[]{"(for control)", "(for generator)", "(for index)", "(for limit)", "(for state)", "(for step)", "break"};
        h.t = new Hashtable();
        for(int v = 0; v < h.b.length; ++v) {
            h.t.put(h.b[v], Boolean.TRUE);
        }
        h.q = new String[]{"and", "break", "do", "else", "elseif", "end", "false", "for", "function", "goto", "if", "in", "local", "nil", "not", "or", "repeat", "return", "then", "true", "until", "while", "//", "..", "...", "==", ">=", "<=", "~=", "<<", ">>", "::", "<eof>", "<number>", "<integer>", "<name>", "<string>"};
        h.r = new Hashtable();
        for(int v1 = 0; v1 < 22; ++v1) {
            LuaString luaString0 = LuaValue.m(h.q[v1]);
            h.r.put(luaString0, ((int)(v1 + 0x101)));
        }
        h.s = new n[]{new n(60, 60), new n(60, 60), new n(70, 70), new n(70, 70), new n(70, 70), new n(100, 90), new n(50, 40), new n(30, 30), new n(30, 30), new n(30, 30), new n(30, 30), new n(30, 30), new n(30, 30), new n(20, 20), new n(10, 10), new n(70, 70), new n(36, 36), new n(0x20, 0x20), new n(34, 34), new n(38, 38), new n(38, 38)};
    }

    public h(u u0, InputStream inputStream0) {
        this.f = new p(null);
        this.g = new p(null);
        this.m = new k();
        this.u = new i();
        this.v = new int[24];
        this.j = inputStream0;
        this.k = new char[0x20];
        this.i = u0;
    }

    void A() {
        while(true) {
            if(this.b(true)) {
                return;
            }
            if(this.f.a == 274) {
                this.z();
                return;
            }
            this.z();
        }
    }

    boolean A(int v) {
        if(this.f.a == v) {
            this.i();
            return true;
        }
        return false;
    }

    private void B() {
        if(this.c == 35) {
            while(!this.b() && this.c != -1) {
                this.a();
            }
        }
    }

    void B(int v) {
        if(this.f.a != v) {
            this.z(v);
        }
    }

    void C(int v) {
        this.B(v);
        this.i();
    }

    void D(int v) {
        c c0 = this.h;
        c0.n = (short)(c0.n + v);
        while(v > 0) {
            l l0 = c0.p(c0.n - v);
            l0.b = c0.g;
            --v;
        }
    }

    boolean E(int v) {
        d d0 = this.h.f;
        k k0 = this.m;
        m m0 = k0.c[v];
        for(int v1 = d0.b; true; ++v1) {
            if(v1 >= k0.f) {
                return false;
            }
            m m1 = k0.e[v1];
            if(m1.a.b(m0.a)) {
                if(m0.d > m1.d && (d0.e || k0.f > d0.b)) {
                    this.h.g(m0.b, ((int)m1.d));
                }
                this.a(v, m1);
                return true;
            }
        }
    }

    static int F(int v) {
        int v1 = 0;
        int v2 = v;
        while(v2 >= 16) {
            v2 = v2 + 1 >> 1;
            ++v1;
        }
        return v2 >= 8 ? v2 - 8 | v1 + 1 << 3 : v2;
    }

    int G(int v) {
        switch(v) {
            case 35: {
                return 2;
            }
            case 45: {
                return 0;
            }
            case 0x7E: {
                return 4;
            }
            case 0x10F: {
                return 1;
            }
            default: {
                return 3;
            }
        }
    }

    int H(int v) {
        switch(v) {
            case 37: {
                return 4;
            }
            case 38: {
                return 16;
            }
            case 42: {
                return 2;
            }
            case 43: {
                return 0;
            }
            case 45: {
                return 1;
            }
            case 0x2F: {
                return 3;
            }
            case 60: {
                return 9;
            }
            case 62: {
                return 11;
            }
            case 94: {
                return 5;
            }
            case 0x7C: {
                return 17;
            }
            case 0x7E: {
                return 18;
            }
            case 0x101: {
                return 13;
            }
            case 0x110: {
                return 14;
            }
            case 279: {
                return 15;
            }
            case 280: {
                return 6;
            }
            case 282: {
                return 8;
            }
            case 283: {
                return 12;
            }
            case 284: {
                return 10;
            }
            case 285: {
                return 7;
            }
            case 286: {
                return 19;
            }
            case 0x11F: {
                return 20;
            }
            default: {
                return 21;
            }
        }
    }

    void I(int v) {
        LuaString luaString0;
        int v1 = this.d;
        if(this.A(0x10A)) {
            luaString0 = this.k();
        }
        else {
            this.i();
            luaString0 = LuaString.c("break");
        }
        k k0 = this.m;
        m[] arr_m = h.a(this.m.c, this.m.d + 1);
        k0.c = arr_m;
        int v2 = this.m.d;
        this.m.d = v2 + 1;
        this.E(this.a(arr_m, v2, luaString0, v1, v));
    }

    void J(int v) {
        c c0 = this.h;
        d d0 = new d();
        this.i();
        int v1 = c0.c();
        int v2 = this.s();
        c0.a(d0, true);
        this.C(0x103);
        this.r();
        c0.f(c0.b(), v1);
        this.b(0x106, 278, v);
        c0.a();
        c0.x(v2);
    }

    void K(int v) {
        c c0 = this.h;
        int v1 = c0.c();
        d d0 = new d();
        d d1 = new d();
        c0.a(d0, true);
        c0.a(d1, false);
        this.i();
        this.A();
        this.b(277, 273, v);
        int v2 = this.s();
        if(d1.e) {
            c0.g(v2, ((int)d1.d));
        }
        c0.a();
        c0.f(v2, v1);
        c0.a();
    }

    void L(int v) {
        c c0 = this.h;
        c0.a(new d(), true);
        this.i();
        LuaString luaString0 = this.k();
        switch(this.f.a) {
            case 61: {
                this.b(luaString0, v);
                break;
            }
            case 44: 
            case 0x10C: {
                this.c(luaString0);
                break;
            }
            default: {
                this.c("\'=\' or \'in\' expected");
            }
        }
        this.b(0x106, 0x108, v);
        c0.a();
    }

    void M(int v) {
        f f0 = new f(-1);
        this.a(f0);
        while(this.f.a == 0x105) {
            this.a(f0);
        }
        if(this.A(260)) {
            this.r();
        }
        this.b(0x106, 0x10B, v);
        this.h.x(f0.a);
    }

    void N(int v) {
        r r0 = new r();
        r r1 = new r();
        this.i();
        this.a(r1, this.l(r0), v);
        this.h.a(r0, r1);
        this.h.C(v);
    }

    private static boolean O(int v) {
        return v < 0x20 || v == 0xFF;
    }

    private static final String a(Object object0) [...] // 潜在的解密器

    int a(LuaString luaString0) {
        c c0 = this.h;
        al al0 = c0.b;
        if(al0.u == null || c0.m + 1 > al0.u.length) {
            al0.u = h.a(al0.u, c0.m * 2 + 1);
        }
        l[] arr_l = al0.u;
        int v = c0.m;
        arr_l[v] = new l(luaString0, 0, 0);
        int v1 = c0.m;
        c0.m = (short)(v1 + 1);
        return v1;
    }

    int a(o o0) {
        this.l = 0;
        while(true) {
            switch(this.c) {
                case -1: {
                    return 289;
                }
                case 10: 
                case 13: {
                    this.d();
                    continue;
                }
                case 9: 
                case 11: 
                case 12: 
                case 0x20: {
                    this.a();
                    continue;
                }
                case 34: 
                case 39: {
                    this.a(this.c, o0);
                    return 293;
                }
                case 45: {
                    goto label_61;
                }
                case 46: {
                    goto label_17;
                }
                case 0x2F: {
                    goto label_24;
                }
                case 0x30: 
                case 49: 
                case 50: 
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: {
                    this.a(o0, true);
                    return 290;
                }
                case 58: {
                    goto label_31;
                }
                case 60: {
                    goto label_36;
                }
                case 61: {
                    goto label_82;
                }
                case 62: {
                    goto label_44;
                }
                case 91: {
                    goto label_75;
                }
                case 0x7E: {
                    goto label_52;
                }
            }
            if(h.q(this.c) || this.c == 0x5F) {
                do {
                    this.c();
                }
                while(h.p(this.c));
                LuaString luaString0 = this.a(this.k, 0, this.l);
                Integer integer0 = (Integer)h.r.get(luaString0);
                if(integer0 != null) {
                    return (int)integer0;
                }
                o0.b = luaString0;
                return 292;
            }
            int v = this.c;
            this.a();
            return v;
        label_17:
            this.c();
            if(this.e(".")) {
                return this.e(".") ? 281 : 280;
            }
            if(!h.r(this.c)) {
                return 46;
            }
            this.a(o0, false);
            return 290;
        label_24:
            this.a();
            if(this.c == 0x2F) {
                this.a();
                return 279;
            }
            return 0x2F;
        label_31:
            this.a();
            if(this.c != 58) {
                return 58;
            }
            this.a();
            return 0x120;
        label_36:
            this.a();
            if(this.c == 61) {
                this.a();
                return 284;
            }
            if(this.c == 60) {
                this.a();
                return 286;
            }
            return 60;
        label_44:
            this.a();
            if(this.c == 61) {
                this.a();
                return 283;
            }
            if(this.c == 62) {
                this.a();
                return 0x11F;
            }
            return 62;
        label_52:
            this.a();
            if(this.c == 61) {
                this.a();
                return 285;
            }
            return 0x7E;
        label_61:
            this.a();
            if(this.c == 45) {
                this.a();
                if(this.c == 91) {
                    int v1 = this.e();
                    this.l = 0;
                    if(v1 >= 0) {
                        this.a(null, v1);
                        this.l = 0;
                        continue;
                    }
                }
            label_71:
                if(this.b() || this.c == -1) {
                    continue;
                }
                break;
            }
            return 45;
        }
        this.a();
        goto label_71;
    label_75:
        int v2 = this.e();
        if(v2 == -1) {
            return 91;
        }
        if(v2 >= 0) {
            this.a(o0, v2);
            return 293;
        }
        this.a("invalid long string delimiter", 293);
    label_82:
        this.a();
        if(this.c != 61) {
            return 61;
        }
        this.a();
        return 282;
    }

    int a(m[] arr_m, int v, LuaString luaString0, int v1, int v2) {
        arr_m[v] = new m(luaString0, v2, v1, this.h.n);
        return v;
    }

    LuaString a(char[] arr_c, int v, int v1) {
        return this.i.a(new String(arr_c, v, v1));
    }

    void a() {
        try {
            this.c = this.j.read();
        }
        catch(IOException iOException0) {
            iOException0.printStackTrace();
            this.c = -1;
        }
    }

    void a(int v, int v1, int v2, boolean z) {
        int v4;
        d d0 = new d();
        c c0 = this.h;
        this.D(3);
        this.C(0x103);
        int v3 = z ? c0.b(33, v, -1) : c0.b();
        c0.a(d0, false);
        this.D(v2);
        c0.z(v2);
        this.r();
        c0.a();
        c0.x(v3);
        if(z) {
            v4 = c0.b(0x20, v, -1);
        }
        else {
            c0.d(34, v, 0, v2);
            c0.C(v1);
            v4 = c0.b(35, v + 2, -1);
        }
        c0.f(v4, v3 + 1);
        c0.C(v1);
    }

    void a(int v, int v1, String s) {
        this.v[0] = 0x75;
        this.v[1] = v;
        this.a(v1, s);
    }

    void a(int v, int v1, r r0) {
        c c0 = this.h;
        int v2 = v - v1;
        if(this.y(r0.a)) {
            int v3 = v2 + 1 >= 0 ? v2 + 1 : 0;
            c0.a(r0, v3);
            if(v3 > 1) {
                c0.z(v3 - 1);
            }
        }
        else {
            if(r0.a != 0) {
                c0.h(r0);
            }
            if(v2 > 0) {
                int v4 = c0.p;
                c0.z(v2);
                c0.b(v4, v2);
            }
        }
    }

    void a(int v, String s) {
        this.u(92);
        for(int v1 = 0; v1 < v && this.v[v1] != -1; ++v1) {
            this.u(this.v[v1]);
        }
        this.a(s, 293);
    }

    void a(int v, m m0) {
        c c0 = this.h;
        m[] arr_m = this.m.c;
        m m1 = arr_m[v];
        h.a(m1.a.b(m0.a));
        if(m1.d < m0.d) {
            LuaString luaString0 = c0.p(((int)m1.d)).a;
            this.f(this.i.b("<goto " + m1.a + "> at line " + m1.c + " jumps into the scope of local \'" + luaString0.d_() + '\''));
        }
        c0.f(m1.b, m0.b);
        System.arraycopy(arr_m, v + 1, arr_m, v, this.m.d - v - 1);
        int v1 = this.m.d - 1;
        this.m.d = v1;
        arr_m[v1] = null;
    }

    void a(int v, o o0) {
        int v1;
        this.c();
        while(this.c != v) {
        alab1:
            switch(this.c) {
                case -1: {
                    this.a("unfinished string", 289);
                    continue;
                }
                case 10: 
                case 13: {
                    this.a("unfinished string", 293);
                    continue;
                }
                case 92: {
                    this.a();
                    switch(this.c) {
                        case -1: {
                            continue;
                        }
                        case 10: 
                        case 13: {
                            this.u(10);
                            this.d();
                            continue;
                        }
                        case 34: 
                        case 39: 
                        case 92: {
                            this.c();
                            continue;
                        }
                        case 97: {
                            v1 = 7;
                            this.u(v1);
                            this.a();
                            continue;
                        }
                        case 98: {
                            v1 = 8;
                            this.u(v1);
                            this.a();
                            continue;
                        }
                        case 102: {
                            v1 = 12;
                            this.u(v1);
                            this.a();
                            continue;
                        }
                        case 110: {
                            v1 = 10;
                            this.u(v1);
                            this.a();
                            continue;
                        }
                        case 0x72: {
                            v1 = 13;
                            this.u(v1);
                            this.a();
                            continue;
                        }
                        case 0x74: {
                            v1 = 9;
                            this.u(v1);
                            this.a();
                            continue;
                        }
                        case 0x75: {
                            this.h();
                            continue;
                        }
                        case 0x76: {
                            v1 = 11;
                            this.u(v1);
                            this.a();
                            continue;
                        }
                        case 120: {
                            v1 = this.f();
                            this.u(v1);
                            this.a();
                            continue;
                        }
                        case 0x7A: {
                            break;
                        }
                        default: {
                            if(h.r(this.c)) {
                                this.u(this.g());
                            }
                            else {
                                this.v[0] = this.c;
                                this.a(1, "invalid escape sequence");
                            }
                            continue;
                        }
                    }
                    this.a();
                    while(true) {
                        if(!h.t(this.c)) {
                            break alab1;
                        }
                        if(this.b()) {
                            this.d();
                        }
                        else {
                            this.a();
                        }
                    }
                }
                default: {
                    this.c();
                }
            }
        }
        this.c();
        o0.b = this.i.a(LuaString.a(this.k, 1, this.l - 2));
    }

    void a(String s, int v) {
        String s1 = luaj.m.a(this.n.d_());
        if(v != 0) {
            s = s + " near " + this.w(v);
        }
        throw new luaj.o(s1, this.d, s);
    }

    void a(LuaString luaString0, int v) {
        this.h.a(this.m.e, this.m.f, luaString0);
        this.C(0x120);
        k k0 = this.m;
        m[] arr_m = h.a(this.m.e, this.m.f + 1);
        k0.e = arr_m;
        int v1 = this.m.f;
        this.m.f = v1 + 1;
        int v2 = this.a(arr_m, v1, luaString0, v, this.h.c());
        this.t();
        if(this.b(false)) {
            this.m.e[v2].d = this.h.f.d;
        }
        this.a(this.m.e[v2]);
    }

    public void a(c c0) {
        this.a(c0, new d());
        this.h.b.A = 1;
        r r0 = new r();
        r0.a(7, 0);
        this.h.a(this.o, r0);
        this.i();
        this.A();
        this.B(289);
        this.p();
    }

    void a(c c0, d d0) {
        c0.d = this.h;
        c0.e = this;
        this.h = c0;
        c0.g = 0;
        c0.h = -1;
        c0.i = new f(-1);
        c0.p = 0;
        c0.j = 0;
        c0.k = 0;
        c0.o = 0;
        c0.m = 0;
        c0.n = 0;
        c0.l = this.m.b;
        c0.f = null;
        c0.b.w = this.n;
        c0.b.B = 2;
        c0.a(d0, false);
    }

    void a(f f0) {
        int v;
        r r0 = new r();
        d d0 = new d();
        this.i();
        this.k(r0);
        this.C(275);
        if(this.f.a != 0x102 && this.f.a != 0x10A) {
            this.h.n(r0);
            this.h.a(d0, false);
            v = r0.d.a;
        }
        else {
            this.h.o(r0);
            this.h.a(d0, false);
            this.I(r0.c.a);
            this.t();
            if(this.b(false)) {
                this.h.a();
                return;
            }
            v = this.h.b();
        }
        this.A();
        this.h.a();
        if(this.f.a == 260 || this.f.a == 0x105) {
            this.h.a(f0, this.h.b());
        }
        this.h.x(v);
    }

    void a(j j0) {
        c c0 = this.h;
        int v = this.h.p;
        r r0 = new r();
        r r1 = new r();
        if(this.f.a == 292) {
            c0.a(j0.c, 0x7FFFFFFD, "items in a constructor");
            this.a(r0);
        }
        else {
            this.e(r0);
        }
        ++j0.c;
        this.C(61);
        int v1 = c0.l(r0);
        this.k(r1);
        c0.d(10, j0.b.b.e, v1, c0.l(r1));
        c0.p = (short)v;
    }

    void a(luaj.a.l l0, int v) {
        r r0 = new r();
        this.a(7 <= l0.b.a && l0.b.a <= 9, "syntax error");
        if(this.A(44)) {
            luaj.a.l l1 = new luaj.a.l();
            l1.a = l0;
            this.i(l1.b);
            if(l1.b.a != 9) {
                this.a(l0, l1.b);
            }
            this.a(l1, v + 1);
            r0.a(6, this.h.p - 1);
            this.h.a(l0.b, r0);
            return;
        }
        this.C(61);
        int v1 = this.g(r0);
        if(v1 != v) {
            this.a(v, v1, r0);
            if(v1 > v) {
                this.h.p = (short)(this.h.p - (v1 - v));
            }
            r0.a(6, this.h.p - 1);
            this.h.a(l0.b, r0);
            return;
        }
        this.h.e(r0);
        this.h.a(l0.b, r0);
    }

    void a(luaj.a.l l0, r r0) {
        c c0 = this.h;
        short v = c0.p;
        boolean z = false;
        while(l0 != null) {
            if(l0.b.a == 9) {
                if(l0.b.b.c == r0.a && l0.b.b.b == r0.b.e) {
                    l0.b.b.c = 7;
                    l0.b.b.b = v;
                    z = true;
                }
                if(r0.a == 7 && l0.b.b.a == r0.b.e) {
                    l0.b.b.a = v;
                    z = true;
                }
            }
            l0 = l0.a;
        }
        if(z) {
            c0.d((r0.a == 7 ? 0 : 5), ((int)v), r0.b.e, 0);
            c0.z(1);
        }
    }

    void a(m m0) {
        m[] arr_m = this.m.c;
        int v = this.h.f.c;
        while(v < this.m.d) {
            if(arr_m[v].a.b(m0.a)) {
                this.a(v, m0);
            }
            else {
                ++v;
            }
        }
    }

    void a(m m0, c c0, d d0) {
        this.d = m0.c;
        String s = m0.a.d_();
        boolean z = h.b(s);
        String s1 = z ? "<" + m0.a + "> at line " + m0.c + " not inside a loop" : "no visible label \'" + m0.a + "\' for <goto> at line " + m0.c;
        if(!z) {
            k k0 = this.m;
            for(int v = d0.b; v < k0.f; ++v) {
                m m1 = k0.e[v];
                if(m1 != null && m1.a != null) {
                    String s2 = m1.a.d_();
                    if(s2.equalsIgnoreCase(s)) {
                        s1 = s1 + "\ndid you mean label \'" + s2 + "\' at line " + m1.c + '?';
                    }
                }
            }
        }
        this.f(s1);
    }

    void a(o o0, int v) {
        this.c();
        if(this.b()) {
            this.d();
        }
        int v1 = 0;
        boolean z = false;
        while(!z) {
            switch(this.c) {
                case -1: {
                    this.a((o0 == null ? "unfinished long comment" : "unfinished long string"), 289);
                    continue;
                }
                case 10: 
                case 13: {
                    this.u(10);
                    this.d();
                    if(o0 != null) {
                        continue;
                    }
                    this.l = 0;
                    continue;
                }
                case 91: {
                    if(this.e() != v) {
                        continue;
                    }
                    this.c();
                    if(v == 0) {
                        this.a("nesting of [[...]] is deprecated", 91);
                    }
                    ++v1;
                    continue;
                }
                case 93: {
                    if(this.e() == v) {
                        break;
                    }
                    continue;
                }
                default: {
                    if(o0 == null) {
                        this.a();
                    }
                    else {
                        this.c();
                    }
                    continue;
                }
            }
            this.c();
            z = true;
        }
        if(o0 != null) {
            o0.b = this.i.a(LuaString.a(this.k, v + 2, this.l - (v + 2) * 2));
        }
    }

    void a(o o0, boolean z) {
        LuaValue luaValue0;
        int v = 0;
        int v1 = this.c;
        this.c();
        boolean z1 = v1 == 0x30 && this.e("Xx");
        while(true) {
            if(this.e((z1 ? "Pp" : "Ee"))) {
                this.e("+-");
                z = false;
            }
            int v2 = this.c;
            if(v2 >= 0x30 && v2 <= 57 || z1 && (v2 >= 97 && v2 <= 102 || v2 >= 65 && v2 <= 70)) {
                this.c();
            }
            else {
                if(v2 != 46) {
                    break;
                }
                this.c();
                z = false;
            }
        }
        if(!z1 && z && this.l > 19) {
            z = false;
        }
        try {
            if(z1) {
                this.u.a = this.k;
                this.u.b = this.l;
                luaValue0 = LuaValue.a(this.u);
            }
            else if(z) {
                long v3 = 0L;
                char[] arr_c = this.k;
                int v4 = this.l;
                if(v4 == 19) {
                    while(true) {
                        if(v >= 18) {
                            long v5 = v3 * 10L + ((long)(arr_c[18] - 0x30));
                            if(v5 < v3) {
                                luaValue0 = LuaDouble.a(Double.parseDouble(new String(arr_c, 0, 19)));
                                break;
                            }
                            luaValue0 = LuaLong.b(v5);
                            break;
                        }
                        v3 = v3 * 10L + ((long)(arr_c[v] - 0x30));
                        ++v;
                    }
                }
                else {
                    while(true) {
                        if(v >= v4) {
                            luaValue0 = LuaLong.b(v3);
                            break;
                        }
                        v3 = v3 * 10L + ((long)(arr_c[v] - 0x30));
                        ++v;
                    }
                }
            }
            else {
                luaValue0 = LuaDouble.a(Double.parseDouble(new String(this.k, 0, this.l)));
            }
            o0.a = luaValue0;
        }
        catch(NumberFormatException numberFormatException0) {
            this.a("malformed number (" + numberFormatException0.getMessage() + ")", 290);
        }
    }

    void a(r r0) {
        this.a(r0, this.k());
    }

    void a(r r0, int v) {
        int v2;
        boolean z = false;
        c c0 = this.h;
        r r1 = new r();
        switch(this.f.a) {
            case 40: {
                this.i();
                if(this.f.a == 41) {
                    r1.a = 0;
                }
                else {
                    this.g(r1);
                    c0.c(r1);
                }
                this.b(41, 40, v);
                break;
            }
            case 0x7B: {
                this.f(r1);
                break;
            }
            case 293: {
                this.a(r1, this.f.b.b);
                this.i();
                break;
            }
            default: {
                this.c("function arguments expected");
                return;
            }
        }
        if(r0.a == 6) {
            z = true;
        }
        h.a(z);
        int v1 = r0.b.e;
        if(this.y(r1.a)) {
            v2 = -1;
        }
        else {
            if(r1.a != 0) {
                c0.h(r1);
            }
            v2 = c0.p - (v1 + 1);
        }
        r0.a(12, c0.d(29, v1, v2 + 1, 2));
        c0.C(v);
        c0.p = (short)(v1 + 1);
    }

    void a(r r0, LuaString luaString0) {
        r0.a(4, this.h.c(luaString0));
    }

    void a(r r0, boolean z, int v) {
        c c0 = new c();
        d d0 = new d();
        c0.b = this.o();
        c0.b.x = v;
        this.a(c0, d0);
        this.C(40);
        if(z) {
            this.g("self");
            this.D(1);
        }
        this.q();
        this.C(41);
        this.A();
        c0.b.y = this.d;
        this.b(0x106, 0x109, v);
        this.c(r0);
        this.p();
    }

    void a(u u0, int v, InputStream inputStream0, LuaString luaString0) {
        this.p = 46;
        this.i = u0;
        this.g.a = 289;
        this.j = inputStream0;
        this.h = null;
        this.d = 1;
        this.e = 1;
        this.n = luaString0;
        this.o = LuaValue.C;
        this.l = 0;
        this.c = v;
        this.B();
    }

    void a(boolean z, String s) {
        if(!z) {
            this.c(s);
        }
    }

    public static boolean b(String s) {
        return h.t.containsKey(s);
    }

    int b(r r0, int v) {
        this.l();
        int v1 = this.G(this.f.a);
        if(v1 == 3) {
            this.j(r0);
        }
        else {
            int v2 = this.d;
            this.i();
            this.b(r0, 80);
            this.h.a(v1, r0, v2);
        }
        int v3;
        for(v3 = this.H(this.f.a); v3 != 21 && h.s[v3].a > v; v3 = v5) {
            r r1 = new r();
            int v4 = this.d;
            this.i();
            this.h.a(v3, r0);
            int v5 = this.b(r1, ((int)h.s[v3].b));
            this.h.b(v3, r0, r1, v4);
        }
        this.m();
        return v3;
    }

    void b(int v, int v1, int v2) {
        if(!this.A(v)) {
            if(v2 == this.d) {
                this.z(v);
                return;
            }
            this.c(this.i.b(h.h(this.v(v)) + " expected " + "(to close " + h.h(this.v(v1)) + " at line " + v2 + ')'));
        }
    }

    void b(int v, String s) {
        this.a(0x7B, v, s);
    }

    void b(LuaString luaString0) {
        int v = this.a(luaString0);
        this.h.a(this.m.b + 1, 200, "local variables");
        if(this.m.a == null || this.m.b + 1 > this.m.a.length) {
            k k0 = this.m;
            k0.a = h.a(this.m.a, Math.max(1, this.m.b * 2));
        }
        q[] arr_q = this.m.a;
        int v1 = this.m.b;
        this.m.b = v1 + 1;
        arr_q[v1] = new q(v);
    }

    void b(LuaString luaString0, int v) {
        c c0 = this.h;
        int v1 = c0.p;
        this.g("(for index)");
        this.g("(for limit)");
        this.g("(for step)");
        this.b(luaString0);
        this.C(61);
        this.u();
        this.C(44);
        this.u();
        if(this.A(44)) {
            this.u();
        }
        else {
            c0.i(((int)c0.p), c0.b(LuaLong.b(1L)));
            c0.z(1);
        }
        this.a(v1, v, 1, true);
    }

    void b(j j0) {
        this.k(j0.a);
        this.h.a(j0.d, 0x7FFFFFFD, "items in a constructor");
        ++j0.d;
        ++j0.e;
    }

    void b(r r0) {
        boolean z = true;
        LuaString luaString0 = this.k();
        c c0 = this.h;
        if(c.a(c0, luaString0, r0, 1) == 0) {
            r r1 = new r();
            c.a(c0, this.o, r0, 1);
            if(r0.a != 7 && r0.a != 8) {
                z = false;
            }
            h.a(z);
            this.a(r1, luaString0);
            c0.c(r0, r1);
        }
    }

    boolean b() {
        return this.c == 10 || this.c == 13;
    }

    boolean b(boolean z) {
        switch(this.f.a) {
            case 277: {
                return z;
            }
            case 260: 
            case 0x105: 
            case 0x106: 
            case 289: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    void c() {
        this.u(this.c);
        this.a();
    }

    void c(String s) {
        this.a(s, this.f.a);
    }

    void c(LuaString luaString0) {
        c c0 = this.h;
        r r0 = new r();
        int v = 4;
        int v1 = c0.p;
        this.g("(for generator)");
        this.g("(for state)");
        this.g("(for control)");
        this.b(luaString0);
        while(this.A(44)) {
            this.b(this.k());
            ++v;
        }
        this.C(0x10C);
        int v2 = this.d;
        this.a(3, this.g(r0), r0);
        c0.y(3);
        this.a(v1, v2, v - 3, false);
    }

    void c(r r0) {
        c c0 = this.h.d;
        r0.a(11, c0.d(37, 0, c0.k - 1));
        c0.h(r0);
    }

    LuaString d(String s) {
        return this.i.a(s);
    }

    void d() {
        int v = this.c;
        h.a(this.b());
        this.a();
        if(this.b() && this.c != v) {
            this.a();
        }
        int v1 = this.d + 1;
        this.d = v1;
        if(v1 >= 0x7FFFFFFD) {
            this.c("chunk has too many lines (> 2147483645)");
        }
    }

    void d(r r0) {
        c c0 = this.h;
        r r1 = new r();
        c0.j(r0);
        this.i();
        this.a(r1);
        c0.c(r0, r1);
    }

    int e() {
        int v = 0;
        int v1 = this.c;
        this.c();
        while(this.c == 61) {
            this.c();
            ++v;
        }
        return this.c == v1 ? v : -v - 1;
    }

    void e(r r0) {
        this.i();
        this.k(r0);
        this.h.k(r0);
        this.C(93);
    }

    boolean e(String s) {
        if(s.indexOf(this.c) < 0) {
            return false;
        }
        this.c();
        return true;
    }

    int f() {
        int v = 0;
        for(int v1 = 1; v1 < 3; ++v1) {
            this.a();
            int v2 = this.c;
            this.v[v1] = v2;
            if(!h.s(v2)) {
                this.v[0] = 120;
                this.a(v1 + 1, "hexadecimal digit expected");
            }
            v = (v << 4) + h.x(v2);
        }
        return v;
    }

    void f(String s) {
        this.f.a = 0;
        this.c(s);
    }

    void f(r r0) {
        c c0 = this.h;
        int v = this.d;
        int v1 = c0.d(11, 0, 0, 0);
        j j0 = new j();
        j0.e = 0;
        j0.c = 0;
        j0.d = 0;
        j0.b = r0;
        r0.a(11, v1);
        j0.a.a(0, 0);
        c0.h(r0);
        this.C(0x7B);
        do {
            h.a(j0.a.a == 0 || j0.e > 0);
            if(this.f.a == 0x7D) {
                break;
            }
            c0.a(j0);
            switch(this.f.a) {
                case 91: {
                    this.a(j0);
                    break;
                }
                case 292: {
                    this.j();
                    if(this.g.a == 61) {
                        this.a(j0);
                    }
                    else {
                        this.b(j0);
                    }
                    break;
                }
                default: {
                    this.b(j0);
                }
            }
        }
        while(this.A(44) || this.A(59));
        this.b(0x7D, 0x7B, v);
        c0.b(j0);
        e e0 = new e(c0.b.r, v1);
        h.c(e0, h.F(j0.d));
        h.d(e0, h.F(j0.c));
    }

    int g() {
        int v = 0;
        int v1;
        for(v1 = 0; v < 3 && h.r(this.c); v1 = v1 * 10 + v2 - 0x30) {
            int v2 = this.c;
            this.v[v] = v2;
            this.a();
            ++v;
        }
        if(v1 > 0xFF) {
            this.v[v] = this.c;
            this.a(v + 1, "decimal escape too large");
        }
        return v1;
    }

    int g(r r0) {
        int v = 1;
        this.k(r0);
        while(this.A(44)) {
            this.h.h(r0);
            this.k(r0);
            ++v;
        }
        return v;
    }

    void g(String s) {
        this.b(this.d(s));
    }

    private static final String h(String s) [...] // Inlined contents

    void h() {
        int v4;
        this.a();
        int v1 = this.c;
        if(v1 != 0x7B) {
            this.a(v1, 2, "missing \'{\', got \'" + ((char)v1) + "\'");
        }
        int v2 = 2;
        int v3 = 0;
        while(true) {
            this.a();
            if(v2 == 23) {
                this.b(23, "unicode escape too long");
            }
            v4 = this.c;
            this.v[v2] = v4;
            if(!h.s(v4)) {
                break;
            }
            v3 = (v3 << 4) + h.x(v4);
            if(v3 > 0x10FFFF) {
                this.b(v2 + 1, "UTF-8 value too large: 0x" + Integer.toHexString(v3) + " (max allowed = 0x" + "10ffff" + ")");
            }
            ++v2;
        }
        if(v2 == 2) {
            this.b(3, "hexadecimal digit expected, got \'" + ((char)v4) + "\'");
        }
        if(v4 != 0x7D) {
            this.b(v2 + 1, "missing \'}\', got \'" + ((char)v4) + "\'");
        }
        byte[] arr_b = new String(Character.toChars(v3)).getBytes();
        for(int v = 0; v < arr_b.length; ++v) {
            this.u(((int)arr_b[v]));
        }
        this.a();
    }

    void h(r r0) {
        switch(this.f.a) {
            case 40: {
                int v = this.d;
                this.i();
                this.k(r0);
                this.b(41, 40, v);
                this.h.f(r0);
                return;
            }
            case 292: {
                this.b(r0);
                return;
            }
            default: {
                this.c("unexpected symbol");
            }
        }
    }

    void i() {
        this.e = this.d;
        if(this.g.a != 289) {
            this.f.a(this.g);
            this.g.a = 289;
            return;
        }
        this.f.a = this.a(this.f.b);
    }

    void i(r r0) {
        int v = this.d;
        this.h(r0);
    alab1:
        while(true) {
            switch(this.f.a) {
                case 46: {
                    this.d(r0);
                    break;
                }
                case 58: {
                    r r1 = new r();
                    this.i();
                    this.a(r1);
                    this.h.b(r0, r1);
                    this.a(r0, v);
                    break;
                }
                case 91: {
                    r r2 = new r();
                    this.h.j(r0);
                    this.e(r2);
                    this.h.c(r0, r2);
                    break;
                }
                case 40: 
                case 0x7B: 
                case 293: {
                    this.h.h(r0);
                    this.a(r0, v);
                    break;
                }
                default: {
                    break alab1;
                }
            }
        }
    }

    void j() {
        h.a(this.g.a == 289);
        this.g.a = this.a(this.g.b);
    }

    void j(r r0) {
        switch(this.f.a) {
            case 0x7B: {
                this.f(r0);
                return;
            }
            case 0x107: {
                r0.a(3, 0);
                break;
            }
            case 0x109: {
                this.i();
                this.a(r0, false, this.d);
                return;
            }
            case 270: {
                r0.a(1, 0);
                break;
            }
            case 276: {
                r0.a(2, 0);
                break;
            }
            case 281: {
                c c0 = this.h;
                this.a(c0.b.A != 0, "cannot use \'...\' outside a vararg function");
                r0.a(13, c0.d(38, 0, 1, 0));
                break;
            }
            case 290: {
                r0.a(5, 0);
                r0.b.a(this.f.b.a);
                break;
            }
            case 293: {
                this.a(r0, this.f.b.b);
                break;
            }
            default: {
                this.i(r0);
                return;
            }
        }
        this.i();
    }

    LuaString k() {
        this.B(292);
        LuaString luaString0 = this.f.b.b;
        this.i();
        return luaString0;
    }

    void k(r r0) {
        this.b(r0, 0);
    }

    void l() {
        int v = this.i.a + 1;
        this.i.a = v;
        if(v > 200) {
            this.a("chunk has too many syntax levels", 0);
        }
    }

    boolean l(r r0) {
        this.b(r0);
        while(true) {
            switch(this.f.a) {
                case 46: {
                    this.d(r0);
                    break;
                }
                case 58: {
                    this.d(r0);
                    return true;
                }
                default: {
                    return false;
                }
            }
        }
    }

    void m() {
        --this.i.a;
    }

    void n() {
        LuaString luaString0 = LuaString.c("break");
        k k0 = this.m;
        m[] arr_m = h.a(this.m.e, this.m.f + 1);
        k0.e = arr_m;
        int v = this.m.f;
        this.m.f = v + 1;
        this.a(this.m.e[this.a(arr_m, v, luaString0, 0, this.h.g)]);
    }

    al o() {
        al al0 = this.h.b;
        if(al0.s == null || this.h.k >= al0.s.length) {
            al0.s = h.a(al0.s, Math.max(1, this.h.k * 2));
        }
        al[] arr_al = al0.s;
        int v = this.h.k;
        this.h.k = v + 1;
        al al1 = new al();
        arr_al[v] = al1;
        return al1;
    }

    // 去混淆评级： 低(30)
    public static boolean p(int v) {
        return v >= 0x30 && v <= 57 || v >= 97 && v <= 0x7A || v >= 65 && v <= 90 || v == 0x5F;
    }

    void p() {
        boolean z = false;
        c c0 = this.h;
        al al0 = c0.b;
        c0.c(0, 0);
        c0.a();
        al0.r = h.a(al0.r, c0.g);
        al0.t = h.a(al0.t, c0.g);
        al0.q = h.a(al0.q, c0.j);
        al0.s = h.a(al0.s, c0.k);
        al0.u = h.a(al0.u, ((int)c0.m));
        al0.v = h.a(al0.v, ((int)c0.o));
        if(c0.f == null) {
            z = true;
        }
        h.a(z);
        this.h = c0.d;
    }

    // 去混淆评级： 低(20)
    public static boolean q(int v) {
        return v >= 97 && v <= 0x7A || v >= 65 && v <= 90;
    }

    void q() {
        int v = 0;
        c c0 = this.h;
        al al0 = c0.b;
        al0.A = 0;
        if(this.f.a != 41) {
            while(true) {
                switch(this.f.a) {
                    case 281: {
                        this.i();
                        al0.A = 1;
                        break;
                    }
                    case 292: {
                        this.b(this.k());
                        ++v;
                        break;
                    }
                    default: {
                        this.c("<name> or \'...\' expected");
                    }
                }
                if(al0.A != 0 || !this.A(44)) {
                    break;
                }
            }
        }
        this.D(v);
        al0.z = c0.n;
        c0.z(((int)c0.n));
    }

    public static boolean r(int v) {
        return v >= 0x30 && v <= 57;
    }

    void r() {
        c c0 = this.h;
        c0.a(new d(), false);
        this.A();
        c0.a();
    }

    // 去混淆评级： 低(30)
    public static boolean s(int v) {
        return v >= 0x30 && v <= 57 || v >= 97 && v <= 102 || v >= 65 && v <= 70;
    }

    int s() {
        r r0 = new r();
        this.k(r0);
        if(r0.a == 1) {
            r0.a = 3;
        }
        this.h.n(r0);
        return r0.d.a;
    }

    public static boolean t(int v) {
        return v >= 0 && v <= 0x20;
    }

    void t() {
        while(this.f.a == 59 || this.f.a == 0x120) {
            this.z();
        }
    }

    int u() {
        r r0 = new r();
        this.k(r0);
        int v = r0.a;
        this.h.h(r0);
        return v;
    }

    void u(int v) {
        char[] arr_c = this.k;
        int v1 = this.l;
        if(arr_c == null || v1 + 1 > arr_c.length) {
            arr_c = h.a(arr_c, v1 * 2 + 1);
            this.k = arr_c;
        }
        arr_c[v1] = (char)v;
        this.l = v1 + 1;
    }

    String v(int v) {
        if(v < 0x101) {
            return h.O(v) ? "\'<\\" + v + ">\' (symbol with decimal code " + v + " or 0x" + Integer.toHexString(v) + ")" : String.valueOf(((char)v));
        }
        String s = h.q[v - 0x101];
        return v == 289 || v == 290 || v == 291 || v == 292 || v == 293 ? s : "\'" + s + '\'';
    }

    void v() {
        r r0 = new r();
        c c0 = this.h;
        this.b(this.k());
        this.D(1);
        this.a(r0, false, this.d);
        l l0 = c0.p(c0.n - 1);
        l0.b = c0.g;
    }

    String w(int v) {
        return v == 290 || v == 291 || v == 292 || v == 293 ? "\'" + new String(this.k, 0, this.l) + '\'' : this.v(v);
    }

    void w() {
        int v = 0;
        r r0 = new r();
        int v1 = 0;
        do {
            this.b(this.k());
            ++v1;
        }
        while(this.A(44));
        if(this.A(61)) {
            v = this.g(r0);
        }
        else {
            r0.a = 0;
        }
        this.a(v1, v, r0);
        this.D(v1);
    }

    public static int x(int v) {
        if(v <= 57) {
            return v - 0x30;
        }
        return v > 70 ? v - 87 : v - 55;
    }

    void x() {
        c c0 = this.h;
        luaj.a.l l0 = new luaj.a.l();
        this.i(l0.b);
        if(this.f.a == 44 || this.f.a == 61) {
            l0.a = null;
            this.a(l0, 1);
            return;
        }
        this.a(l0.b.a == 12, "syntax error");
        h.d(c0.a(l0.b), 1);
    }

    void y() {
        int v1;
        int v;
        boolean z = true;
        c c0 = this.h;
        r r0 = new r();
        if(!this.b(true) && this.f.a != 59) {
            int v2 = this.g(r0);
            if(this.y(r0.a)) {
                c0.c(r0);
                if(r0.a == 12 && v2 == 1) {
                    h.a(c0.a(r0), 30);
                    if(luaj.m.b(c0.b(r0)) != c0.n) {
                        z = false;
                    }
                    h.a(z);
                }
                v = -1;
                v1 = c0.n;
            }
            else if(v2 == 1) {
                v = 1;
                v1 = c0.i(r0);
            }
            else {
                c0.h(r0);
                v1 = c0.n;
                if(v2 != c0.p - v1) {
                    z = false;
                }
                h.a(z);
                v = v2;
            }
        }
        else {
            v = 0;
            v1 = 0;
        }
        c0.c(v1, v);
        this.A(59);
    }

    boolean y(int v) {
        return v == 12 || v == 13;
    }

    void z() {
        int v = this.d;
        this.l();
        switch(this.f.a) {
            case 59: {
                this.i();
                break;
            }
            case 0x103: {
                this.i();
                this.r();
                this.b(0x106, 0x103, v);
                break;
            }
            case 0x108: {
                this.L(v);
                break;
            }
            case 0x109: {
                this.N(v);
                break;
            }
            case 0x102: 
            case 0x10A: {
                this.I(this.h.b());
                break;
            }
            case 0x10B: {
                this.M(v);
                break;
            }
            case 0x10D: {
                this.i();
                if(this.A(0x109)) {
                    this.v();
                }
                else {
                    this.w();
                }
                break;
            }
            case 273: {
                this.K(v);
                break;
            }
            case 274: {
                this.i();
                this.y();
                break;
            }
            case 278: {
                this.J(v);
                break;
            }
            case 0x120: {
                this.i();
                this.a(this.k(), v);
                break;
            }
            default: {
                this.x();
            }
        }
        h.a(this.h.b.B >= this.h.p && this.h.p >= this.h.n);
        this.h.p = this.h.n;
        this.m();
    }

    void z(int v) {
        this.c(this.i.b(h.h(this.v(v)) + " expected"));
    }
}

