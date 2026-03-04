package luaj.a;

import java.util.Hashtable;
import luaj.LuaString;
import luaj.LuaValue;
import luaj.al;
import luaj.ao;
import luaj.l;

public class c extends a {
    al b;
    Hashtable c;
    c d;
    h e;
    d f;
    int g;
    int h;
    f i;
    int j;
    int k;
    int l;
    short m;
    short n;
    short o;
    short p;

    void A(int v) {
        if(!c.h(v) && v >= this.n) {
            this.p = (short)(this.p - 1);
            c.a(v == this.p);
        }
    }

    static boolean B(int v) {
        return v == 6 || v == 7;
    }

    void C(int v) {
        this.b.t[this.g - 1] = v;
    }

    int D(int v) {
        c.a(v <= 0x3FFFFFF);
        return this.h(c.a(39, v), this.e.e);
    }

    static int a(c c0, LuaString luaString0, r r0, int v) {
        if(c0 == null) {
            return 0;
        }
        int v1 = c0.b(luaString0);
        if(v1 >= 0) {
            r0.a(7, v1);
            if(v == 0) {
                c0.r(v1);
                return 7;
            }
            return 7;
        }
        int v2 = c0.a(luaString0);
        if(v2 < 0) {
            if(c.a(c0.d, luaString0, r0, 0) == 0) {
                return 0;
            }
            v2 = c0.a(luaString0, r0);
        }
        r0.a(8, v2);
        return 8;
    }

    int a(LuaString luaString0) {
        ao[] arr_ao = this.b.v;
        int v;
        for(v = 0; true; ++v) {
            if(v >= this.o) {
                return -1;
            }
            if(arr_ao[v].a.b(luaString0)) {
                break;
            }
        }
        return v;
    }

    int a(LuaString luaString0, r r0) {
        boolean z = true;
        this.a(this.o + 1, 0xFF, "upvalues");
        if(this.b.v == null || this.o + 1 > this.b.v.length) {
            al al0 = this.b;
            al0.v = c.a(this.b.v, (this.o <= 0 ? 1 : this.o * 2));
        }
        ao[] arr_ao = this.b.v;
        int v = this.o;
        if(r0.a != 7) {
            z = false;
        }
        arr_ao[v] = new ao(luaString0, z, r0.b.e);
        int v1 = this.o;
        this.o = (short)(v1 + 1);
        return v1;
    }

    int a(LuaValue luaValue0) {
        Hashtable hashtable1;
        Hashtable hashtable0 = this.c;
        if(hashtable0 == null) {
            hashtable1 = new Hashtable();
            this.c = hashtable1;
        }
        else {
            Integer integer0 = (Integer)hashtable0.get(luaValue0);
            if(integer0 != null) {
                return (int)integer0;
            }
            hashtable1 = hashtable0;
        }
        int v = this.j;
        hashtable1.put(luaValue0, v);
        al al0 = this.b;
        if(al0.q == null || this.j + 1 >= al0.q.length) {
            al0.q = c.a(al0.q, this.j * 2 + 1);
        }
        int v1 = this.j;
        this.j = v1 + 1;
        al0.q[v1] = luaValue0;
        return v;
    }

    e a(r r0) {
        return new e(this.b.r, r0.b.e);
    }

    void a() {
        d d0 = this.f;
        if(d0.a != null && d0.e) {
            int v = this.b();
            this.g(v, ((int)d0.d));
            this.x(v);
        }
        if(d0.f) {
            this.e.n();
        }
        this.f = d0.a;
        this.q(((int)d0.d));
        c.a(d0.d == this.n);
        this.p = this.n;
        this.e.m.f = d0.b;
        if(d0.a != null) {
            this.a(d0);
            return;
        }
        if(d0.c < this.e.m.d) {
            this.e.a(this.e.m.c[d0.c], this, d0);
        }
    }

    void a(int v, int v1, String s) {
        if(v > v1) {
            this.a(v1, s);
        }
    }

    void a(int v, int v1, r r0, r r1) {
        int v5;
        int v4;
        int v2 = this.l(r0);
        int v3 = this.l(r1);
        this.d(r1);
        this.d(r0);
        if(v1 != 0 || v == 24) {
            v4 = v3;
            v5 = v2;
        }
        else {
            v1 = 1;
            v4 = v2;
            v5 = v3;
        }
        r0.b.e = this.b(v, v1, v5, v4);
        r0.a = 10;
    }

    void a(int v, String s) {
        this.e.a((this.b.x == 0 ? "main function has more than " + v + ' ' + s : "function at line " + this.b.x + " has more than " + v + ' ' + s), 0);
    }

    void a(int v, r r0) {
        switch(v) {
            case 6: {
                this.h(r0);
                return;
            }
            case 13: {
                this.n(r0);
                return;
            }
            case 14: {
                this.o(r0);
                return;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: {
                if(!r0.b()) {
                    this.l(r0);
                    return;
                }
                return;
            }
            default: {
                this.l(r0);
            }
        }
    }

    void a(int v, r r0, int v1) {
        r r1 = new r();
        r1.a(5, 0);
        switch(v) {
            case 0: {
                if(r0.b()) {
                    LuaValue luaValue0 = r0.b.a().r();
                    r0.b.a(luaValue0);
                    return;
                }
                this.i(r0);
                this.a(19, r0, r1, v1);
                return;
            }
            case 1: {
                this.p(r0);
                return;
            }
            case 2: {
                this.i(r0);
                this.a(21, r0, r1, v1);
                return;
            }
            case 4: {
                if(r0.b()) {
                    LuaValue luaValue1 = r0.b.a().s();
                    r0.b.a(luaValue1);
                    return;
                }
                this.i(r0);
                this.a(41, r0, r1, v1);
                return;
            }
            default: {
                c.a(false);
            }
        }
    }

    void a(int v, r r0, r r1, int v1) {
        if(this.a(v, r0, r1)) {
            return;
        }
        int v2 = v == 19 || v == 21 || v == 41 ? 0 : this.l(r1);
        int v3 = this.l(r0);
        if(v3 > v2) {
            this.d(r0);
            this.d(r1);
        }
        else {
            this.d(r1);
            this.d(r0);
        }
        r0.b.e = this.d(v, 0, v3, v2);
        r0.a = 11;
        this.C(v1);
    }

    void a(d d0) {
        int v = d0.c;
        m[] arr_m = this.e.m.c;
        while(v < this.e.m.d) {
            m m0 = arr_m[v];
            if(m0.d > d0.d) {
                if(d0.e) {
                    this.g(m0.b, ((int)d0.d));
                }
                m0.d = d0.d;
            }
            if(!this.e.E(v)) {
                ++v;
            }
        }
    }

    void a(d d0, boolean z) {
        boolean z1 = false;
        d0.f = z;
        d0.d = this.n;
        d0.b = (short)this.e.m.f;
        d0.c = (short)this.e.m.d;
        d0.e = false;
        d0.a = this.f;
        this.f = d0;
        if(this.p == this.n) {
            z1 = true;
        }
        c.a(z1);
    }

    void a(f f0, int v) {
        if(v == -1) {
            return;
        }
        if(f0.a == -1) {
            f0.a = v;
            return;
        }
        int v1 = f0.a;
        int v2;
        while((v2 = this.t(v1)) != -1) {
            v1 = v2;
        }
        this.d(v1, v);
    }

    void a(j j0) {
        if(j0.a.a != 0) {
            this.h(j0.a);
            j0.a.a = 0;
            if(j0.e == 50) {
                this.e(j0.b.b.e, j0.d, j0.e);
                j0.e = 0;
            }
        }
    }

    void a(r r0, int v) {
        switch(r0.a) {
            case 12: {
                c.d(this.a(r0), v + 1);
                return;
            }
            case 13: {
                c.c(this.a(r0), v + 1);
                c.b(this.a(r0), ((int)this.p));
                this.z(1);
            }
        }
    }

    void a(r r0, r r1) {
        switch(r0.a) {
            case 7: {
                this.d(r1);
                this.c(r1, r0.b.e);
                return;
            }
            case 8: {
                this.d(9, this.i(r1), r0.b.e, 0);
                break;
            }
            case 9: {
                int v = r0.b.c == 7 ? 10 : 8;
                int v1 = this.l(r1);
                this.d(v, ((int)r0.b.b), ((int)r0.b.a), v1);
                break;
            }
            default: {
                c.a(false);
                break;
            }
        }
        this.d(r1);
    }

    void a(m[] arr_m, int v, LuaString luaString0) {
        for(int v1 = this.f.b; v1 < v; ++v1) {
            if(luaString0.b(arr_m[v1].a)) {
                this.e.f(this.e.i.b("label \'" + luaString0 + "\' already defined on line " + arr_m[v1].c));
            }
        }
    }

    boolean a(int v, r r0, r r1) {
        LuaValue luaValue2;
        if(r0.b() && r1.b() && (v != 16 && v != 17 && v != 40 || !r1.b.a().b(LuaValue.y))) {
            LuaValue luaValue0 = r0.b.a();
            LuaValue luaValue1 = r1.b.a();
            switch(v) {
                case 13: {
                    luaValue2 = luaValue0.d(luaValue1);
                    goto label_40;
                }
                case 14: {
                    luaValue2 = luaValue0.e(luaValue1);
                    goto label_40;
                }
                case 15: {
                    luaValue2 = luaValue0.f(luaValue1);
                    goto label_40;
                }
                case 16: {
                    luaValue2 = luaValue0.h(luaValue1);
                    goto label_40;
                }
                case 17: {
                    luaValue2 = luaValue0.j(luaValue1);
                    goto label_40;
                }
                case 18: {
                    luaValue2 = luaValue0.g(luaValue1);
                    goto label_40;
                }
                case 19: {
                    luaValue2 = luaValue0.r();
                    goto label_40;
                }
                case 21: {
                    break;
                }
                case 40: {
                    luaValue2 = luaValue0.i(luaValue1);
                    goto label_40;
                }
                case 41: {
                    if(luaValue0.n()) {
                        luaValue2 = luaValue0.s();
                        goto label_40;
                    }
                    break;
                }
                case 42: {
                    if(luaValue0.n() && luaValue1.n()) {
                        luaValue2 = luaValue0.k(luaValue1);
                        goto label_40;
                    }
                    break;
                }
                case 43: {
                    if(luaValue0.n() && luaValue1.n()) {
                        luaValue2 = luaValue0.l(luaValue1);
                        goto label_40;
                    }
                    break;
                }
                case 44: {
                    if(luaValue0.n() && luaValue1.n()) {
                        luaValue2 = luaValue0.m(luaValue1);
                        goto label_40;
                    }
                    break;
                }
                case 45: {
                    if(luaValue0.n() && luaValue1.n()) {
                        luaValue2 = luaValue0.n(luaValue1);
                        goto label_40;
                    }
                    break;
                }
                case 46: {
                    if(luaValue0.n() && luaValue1.n()) {
                        luaValue2 = luaValue0.o(luaValue1);
                    label_40:
                        if(luaValue2 != null && !Double.isNaN(luaValue2.o())) {
                            r0.b.a(luaValue2);
                            return true;
                        }
                    }
                    break;
                }
                default: {
                    c.a(false);
                    luaValue2 = null;
                    goto label_40;
                }
            }
        }
        return false;
    }

    int b() {
        int v = this.i.a;
        this.i.a = -1;
        f f0 = new f(this.b(23, 0, -1));
        this.a(f0, v);
        return f0.a;
    }

    int b(int v, int v1, int v2) {
        return this.d(v, v1, v2 + 0x1FFFF);
    }

    int b(int v, int v1, int v2, int v3) {
        this.d(v, v1, v2, v3);
        return this.b();
    }

    int b(LuaString luaString0) {
        int v;
        for(v = this.n - 1; true; --v) {
            if(v < 0) {
                return -1;
            }
            if(luaString0.b(this.p(v).a)) {
                break;
            }
        }
        return v;
    }

    int b(LuaValue luaValue0) {
        return this.a(luaValue0);
    }

    int b(r r0) {
        return this.b.r[r0.b.e];
    }

    // 去混淆评级： 低(20)
    int b(boolean z) {
        return z ? this.a(LuaValue.v) : this.a(LuaValue.w);
    }

    void b(int v, int v1) {
        int v2 = v + v1 - 1;
        if(this.g > this.h && this.g > 0) {
            int v3 = this.b.r[this.g - 1];
            if(c.a(v3) == 4) {
                int v4 = c.b(v3);
                int v5 = c.d(v3) + v4;
                if(v4 <= v && v <= v5 + 1 || v <= v4 && v4 <= v2 + 1) {
                    if(v4 < v) {
                        v = v4;
                    }
                    if(v5 <= v2) {
                        v5 = v2;
                    }
                    e e0 = new e(this.b.r, this.g - 1);
                    c.b(e0, v);
                    c.c(e0, v5 - v);
                    return;
                }
            }
        }
        this.d(4, v, v1 - 1, 0);
    }

    void b(int v, r r0, r r1, int v1) {
        boolean z = true;
        switch(v) {
            case 0: {
                this.a(13, r0, r1, v1);
                return;
            }
            case 1: {
                this.a(14, r0, r1, v1);
                return;
            }
            case 2: {
                this.a(15, r0, r1, v1);
                return;
            }
            case 3: {
                this.a(16, r0, r1, v1);
                return;
            }
            case 4: {
                this.a(17, r0, r1, v1);
                return;
            }
            case 5: {
                this.a(18, r0, r1, v1);
                return;
            }
            case 6: {
                this.k(r1);
                if(r1.a == 11 && c.a(this.b(r1)) == 22) {
                    if(r0.b.e != c.d(this.b(r1)) - 1) {
                        z = false;
                    }
                    c.a(z);
                    this.d(r0);
                    c.c(this.a(r1), r0.b.e);
                    r0.a = 11;
                    r0.b.e = r1.b.e;
                    return;
                }
                this.h(r1);
                this.a(22, r0, r1, v1);
                return;
            }
            case 7: {
                this.a(24, 0, r0, r1);
                return;
            }
            case 8: {
                this.a(24, 1, r0, r1);
                return;
            }
            case 9: {
                this.a(25, 1, r0, r1);
                return;
            }
            case 10: {
                this.a(26, 1, r0, r1);
                return;
            }
            case 11: {
                this.a(25, 0, r0, r1);
                return;
            }
            case 12: {
                this.a(26, 0, r0, r1);
                return;
            }
            case 13: {
                if(r0.c.a != -1) {
                    z = false;
                }
                c.a(z);
                this.f(r1);
                this.a(r1.d, r0.d.a);
                r0.a(r1);
                return;
            }
            case 14: {
                if(r0.d.a != -1) {
                    z = false;
                }
                c.a(z);
                this.f(r1);
                this.a(r1.c, r0.c.a);
                r0.a(r1);
                return;
            }
            case 15: {
                this.a(40, r0, r1, v1);
                return;
            }
            case 16: {
                this.a(42, r0, r1, v1);
                return;
            }
            case 17: {
                this.a(43, r0, r1, v1);
                return;
            }
            case 18: {
                this.a(44, r0, r1, v1);
                return;
            }
            case 19: {
                this.a(45, r0, r1, v1);
                return;
            }
            case 20: {
                this.a(46, r0, r1, v1);
                return;
            }
            default: {
                c.a(false);
            }
        }
    }

    void b(j j0) {
        if(j0.e == 0) {
            return;
        }
        if(this.s(j0.a.a)) {
            this.c(j0.a);
            this.e(j0.b.b.e, j0.d, -1);
            --j0.d;
            return;
        }
        if(j0.a.a != 0) {
            this.h(j0.a);
        }
        this.e(j0.b.b.e, j0.d, j0.e);
    }

    void b(r r0, int v) {
        int v1 = 1;
        boolean z = false;
        this.f(r0);
        switch(r0.a) {
            case 1: {
                this.b(v, 1);
                break;
            }
            case 2: 
            case 3: {
                if(r0.a != 2) {
                    v1 = 0;
                }
                this.d(3, v, v1, 0);
                break;
            }
            case 4: {
                this.i(v, r0.b.e);
                break;
            }
            case 5: {
                this.i(v, this.b(r0.b.a()));
                break;
            }
            case 6: {
                if(v != r0.b.e) {
                    this.d(0, v, r0.b.e, 0);
                }
                break;
            }
            case 11: {
                c.b(this.a(r0), v);
                break;
            }
            default: {
                if(r0.a == 0 || r0.a == 10) {
                    z = true;
                }
                c.a(z);
                return;
            }
        }
        r0.b.e = v;
        r0.a = 6;
    }

    void b(r r0, r r1) {
        this.i(r0);
        this.d(r0);
        int v = this.p;
        this.z(2);
        this.d(12, v, r0.b.e, this.l(r1));
        this.d(r1);
        r0.b.e = v;
        r0.a = 6;
    }

    int c() {
        this.h = this.g;
        return this.g;
    }

    int c(int v, int v1, int v2) {
        this.c();
        return this.d(3, v, v1, v2);
    }

    int c(LuaString luaString0) {
        return this.a(luaString0);
    }

    void c(int v, int v1) {
        this.d(0x1F, v, v1 + 1, 0);
    }

    void c(int v, int v1, int v2, int v3) {
        while(v != -1) {
            int v4 = this.t(v);
            if(this.e(v, v2)) {
                this.d(v, v1);
            }
            else {
                this.d(v, v3);
            }
            v = v4;
        }
    }

    void c(r r0) {
        this.a(r0, -1);
    }

    void c(r r0, int v) {
        int v4;
        int v2;
        this.b(r0, v);
        if(r0.a == 10) {
            this.a(r0.c, r0.b.e);
        }
        if(r0.a()) {
            if(!this.v(r0.c.a) && !this.v(r0.d.a)) {
                v4 = -1;
                v2 = -1;
            }
            else {
                int v1 = r0.a == 10 ? -1 : this.b();
                v2 = this.c(v, 0, 1);
                int v3 = this.c(v, 1, 0);
                this.x(v1);
                v4 = v3;
            }
            int v5 = this.c();
            this.c(r0.d.a, v5, v, v2);
            this.c(r0.c.a, v5, v, v4);
        }
        r0.c.a = -1;
        r0.d.a = -1;
        r0.b.e = v;
        r0.a = 6;
    }

    void c(r r0, r r1) {
        r0.b.b = (short)r0.b.e;
        r0.b.a = (short)this.l(r1);
        t.a(r0.a == 8 || c.B(r0.a));
        r0.b.c = (short)(r0.a == 8 ? 8 : 7);
        r0.a = 9;
    }

    int d(int v, int v1, int v2) {
        boolean z1;
        boolean z = true;
        switch(c.k(v)) {
            case 1: 
            case 2: {
                z1 = true;
                break;
            }
            default: {
                z1 = false;
            }
        }
        c.a(z1);
        c.a(c.m(v) == 0);
        if(v2 < 0 || v2 > 0x3FFFF) {
            z = false;
        }
        c.a(z);
        return this.h(c.a(v, v1, v2), this.e.e);
    }

    int d(int v, int v1, int v2, int v3) {
        boolean z = false;
        c.a(c.k(v) == 0);
        c.a(c.l(v) != 0 || v2 == 0);
        if(c.m(v) != 0 || v3 == 0) {
            z = true;
        }
        c.a(z);
        return this.h(c.a(v, v1, v2, v3), this.e.e);
    }

    int d(r r0, int v) {
        if(r0.a == 11) {
            int v1 = this.b(r0);
            if(c.a(v1) == 20) {
                --this.g;
                int v2 = c.d(v1);
                return v == 0 ? this.b(27, v2, 0, 1) : this.b(27, v2, 0, 0);
            }
        }
        this.g(r0);
        this.d(r0);
        return this.b(28, 0xFF, r0.b.e, v);
    }

    void d() {
        this.c(this.i.a, this.g, 0xFF, this.g);
        this.i.a = -1;
    }

    void d(int v, int v1) {
        e e0 = new e(this.b.r, v);
        int v2 = v1 - (v + 1);
        c.a(v1 != -1);
        if(Math.abs(v2) > 0x1FFFF) {
            this.e.c("control structure too long");
        }
        c.f(e0, v2);
    }

    void d(r r0) {
        if(r0.a == 6) {
            this.A(r0.b.e);
        }
    }

    int e() {
        return this.a(LuaValue.u);
    }

    void e(int v, int v1, int v2) {
        int v3 = (v1 - 1) / 50 + 1;
        if(v2 == -1) {
            v2 = 0;
        }
        if(v3 <= 0x1FF) {
            this.d(36, v, v2, v3);
        }
        else {
            this.d(36, v, v2, 0);
            this.h(v3, this.e.e);
        }
        this.p = (short)(v + 1);
    }

    void e(r r0) {
        switch(r0.a) {
            case 12: {
                r0.a = 6;
                r0.b.e = c.b(this.b(r0));
                return;
            }
            case 13: {
                c.c(this.a(r0), 2);
                r0.a = 11;
            }
        }
    }

    boolean e(int v, int v1) {
        e e0 = this.u(v);
        if(c.a(e0.a()) != 28) {
            return false;
        }
        if(v1 != 0xFF && v1 != c.d(e0.a())) {
            c.b(e0, v1);
            return true;
        }
        e0.a(c.a(27, c.d(e0.a()), 0, luaj.m.e(e0.a())));
        return true;
    }

    void f(int v, int v1) {
        if(v1 == this.g) {
            this.x(v);
            return;
        }
        c.a(v1 < this.g);
        this.c(v, v1, 0xFF, v1);
    }

    void f(r r0) {
        int v = 7;
        switch(r0.a) {
            case 7: {
                r0.a = 6;
                return;
            }
            case 8: {
                r0.b.e = this.d(5, 0, r0.b.e, 0);
                r0.a = 11;
                return;
            }
            case 9: {
                this.A(((int)r0.b.a));
                if(r0.b.c == 7) {
                    this.A(((int)r0.b.b));
                }
                else {
                    v = 6;
                }
                r0.b.e = this.d(v, 0, ((int)r0.b.b), ((int)r0.b.a));
                r0.a = 11;
                return;
            }
            case 12: 
            case 13: {
                this.e(r0);
            }
        }
    }

    void g(int v, int v1) {
        while(v != -1) {
            int v2 = this.t(v);
            c.a(c.a(this.b.r[v]) == 23 && (c.b(this.b.r[v]) == 0 || c.b(this.b.r[v]) >= v1 + 1));
            c.a(this.b.r, v, v1 + 1);
            v = v2;
        }
    }

    void g(r r0) {
        if(r0.a != 6) {
            this.z(1);
            this.b(r0, this.p - 1);
        }
    }

    int h(int v, int v1) {
        al al0 = this.b;
        this.d();
        if(al0.r == null || this.g + 1 > al0.r.length) {
            al0.r = t.a(al0.r, this.g * 2 + 1);
        }
        al0.r[this.g] = v;
        if(al0.t == null || this.g + 1 > al0.t.length) {
            al0.t = t.a(al0.t, this.g * 2 + 1);
        }
        al0.t[this.g] = v1;
        int v2 = this.g;
        this.g = v2 + 1;
        return v2;
    }

    void h(r r0) {
        this.f(r0);
        this.d(r0);
        this.z(1);
        this.c(r0, this.p - 1);
    }

    int i(int v, int v1) {
        if(v1 <= 0x3FFFF) {
            return this.d(1, v, v1);
        }
        int v2 = this.d(2, v, 0);
        this.D(v1);
        return v2;
    }

    int i(r r0) {
        this.f(r0);
        if(r0.a == 6) {
            if(!r0.a()) {
                return r0.b.e;
            }
            if(r0.b.e >= this.n) {
                this.c(r0, r0.b.e);
                return r0.b.e;
            }
        }
        this.h(r0);
        return r0.b.e;
    }

    void j(r r0) {
        if(r0.a != 8 || r0.a()) {
            this.i(r0);
        }
    }

    void k(r r0) {
        if(r0.a()) {
            this.i(r0);
            return;
        }
        this.f(r0);
    }

    int l(r r0) {
        int v;
        boolean z = true;
        this.k(r0);
        switch(r0.a) {
            case 1: 
            case 2: 
            case 3: {
                if(this.j <= 0xFF) {
                    s s0 = r0.b;
                    if(r0.a == 1) {
                        v = this.e();
                    }
                    else {
                        if(r0.a != 2) {
                            z = false;
                        }
                        v = this.b(z);
                    }
                    s0.e = v;
                    r0.a = 4;
                    return c.j(r0.b.e);
                }
                return this.i(r0);
            }
            case 4: {
                break;
            }
            case 5: {
                r0.b.e = this.b(r0.b.a());
                r0.a = 4;
                break;
            }
            default: {
                return this.i(r0);
            }
        }
        return r0.b.e > 0xFF ? this.i(r0) : c.j(r0.b.e);
    }

    void m(r r0) {
        int v = 0;
        e e0 = this.u(r0.b.e);
        c.a(c.o(c.a(e0.a())) && c.a(e0.a()) != 28 && luaj.m.a(e0.a()) != 27);
        if(c.b(e0.a()) == 0) {
            v = 1;
        }
        c.b(e0, v);
    }

    void n(r r0) {
        int v;
        this.f(r0);
        switch(r0.a) {
            case 2: 
            case 4: 
            case 5: {
                v = -1;
                break;
            }
            case 10: {
                this.m(r0);
                v = r0.b.e;
                break;
            }
            default: {
                v = this.d(r0, 0);
            }
        }
        this.a(r0.d, v);
        this.x(r0.c.a);
        r0.c.a = -1;
    }

    void o(r r0) {
        int v;
        this.f(r0);
        switch(r0.a) {
            case 1: 
            case 3: {
                v = -1;
                break;
            }
            case 10: {
                v = r0.b.e;
                break;
            }
            default: {
                v = this.d(r0, 1);
            }
        }
        this.a(r0.c, v);
        this.x(r0.d.a);
        r0.d.a = -1;
    }

    l p(int v) {
        int v1 = this.e.m.a[this.l + v].a;
        c.a(v1 < this.m);
        return this.b.u[v1];
    }

    void p(r r0) {
        this.f(r0);
        switch(r0.a) {
            case 1: 
            case 3: {
                r0.a = 2;
                break;
            }
            case 2: 
            case 4: 
            case 5: {
                r0.a = 3;
                break;
            }
            case 10: {
                this.m(r0);
                break;
            }
            case 6: 
            case 11: {
                this.g(r0);
                this.d(r0);
                r0.b.e = this.d(20, 0, r0.b.e, 0);
                r0.a = 11;
                break;
            }
            default: {
                c.a(false);
            }
        }
        int v = r0.d.a;
        r0.d.a = r0.c.a;
        r0.c.a = v;
        this.w(r0.d.a);
        this.w(r0.c.a);
    }

    void q(int v) {
        this.e.m.b -= this.n - v;
        while(this.n > v) {
            short v1 = (short)(this.n - 1);
            this.n = v1;
            l l0 = this.p(((int)v1));
            l0.c = this.g;
        }
    }

    void r(int v) {
        d d0;
        for(d0 = this.f; d0.d > v; d0 = d0.a) {
        }
        d0.e = true;
    }

    boolean s(int v) {
        return v == 12 || v == 13;
    }

    int t(int v) {
        int v1 = c.g(this.b.r[v]);
        return v1 == -1 ? -1 : v + 1 + v1;
    }

    @Override
    public String toString() {
        return "FuncState [pc=" + this.g + ", lasttarget=" + this.h + ", nk=" + this.j + ", np=" + this.k + ", firstlocal=" + this.l + ", nlocvars=" + ((int)this.m) + ", nactvar=" + ((int)this.n) + ", nups=" + ((int)this.o) + ", freereg=" + ((int)this.p) + ']';
    }

    e u(int v) {
        e e0 = new e(this.b.r, v);
        return v < 1 || !c.o(c.a(e0.a[e0.b - 1])) ? e0 : new e(e0.a, e0.b - 1);
    }

    boolean v(int v) {
        while(true) {
            if(v == -1) {
                return false;
            }
            if(c.a(this.u(v).a()) != 28) {
                return true;
            }
            v = this.t(v);
        }
    }

    void w(int v) {
        while(v != -1) {
            this.e(v, 0xFF);
            v = this.t(v);
        }
    }

    void x(int v) {
        this.c();
        this.a(this.i, v);
    }

    void y(int v) {
        int v1 = this.p + v;
        if(v1 > this.b.B) {
            if(v1 >= 0xFA) {
                this.e.c("function or expression needs too many registers");
            }
            this.b.B = v1;
        }
    }

    void z(int v) {
        this.y(v);
        this.p = (short)(this.p + v);
    }
}

