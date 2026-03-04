package luaj.lib;

import luaj.LuaString;
import luaj.LuaValue;
import luaj.a;
import luaj.ap;

class l {
    int a;
    final LuaString b;
    final LuaString c;
    final ap d;
    int e;
    int[] f;
    int[] g;

    l(ap ap0, LuaString luaString0, LuaString luaString1) {
        this.b = luaString0;
        this.c = luaString1;
        this.d = ap0;
        this.e = 0;
        this.f = new int[0x20];
        this.g = new int[0x20];
        this.a = 200;
    }

    private void a(a a0, LuaString luaString0, int v, int v1) {
        int v2 = luaString0.L();
        for(int v3 = 0; v3 < v2; ++v3) {
            int v4 = (byte)luaString0.b(v3);
            if(v4 == 37) {
                int v5 = v3 + 1 >= v2 ? 0 : luaString0.b(v3 + 1);
                if(!Character.isDigit(((char)(((byte)v5))))) {
                    if(((byte)v5) != 37) {
                        StringLib.f(("invalid use of \'%\' in replacement string: after \'%\' must be \'0\'-\'9\' or \'%\', but found " + (v3 + 1 >= v2 ? "end of string" : "symbol \'" + ((char)(((byte)v5))) + "\' with code " + ((byte)v5) + " at pos " + (v3 + 2))));
                    }
                    a0.a(((byte)v5));
                }
                else if(((byte)v5) == 0x30) {
                    a0.a(this.b.a(v, v1));
                }
                else {
                    a0.a(this.f(((byte)v5) - 49, v, v1).t());
                }
                ++v3;
            }
            else {
                a0.a(((byte)v4));
            }
        }
    }

    static boolean a(int v, int v1) {
        int v2 = StringLib.a[v];
        switch(Character.toLowerCase(((char)v1))) {
            case 97: {
                return (v2 & 1) == 0 ? 97 != v1 : 97 == v1;
            }
            case 99: {
                return (v2 & 0x40) == 0 ? 99 != v1 : 99 == v1;
            }
            case 100: {
                return (v2 & 8) == 0 ? 100 != v1 : 100 == v1;
            }
            case 103: {
                return (v2 & 25) == 0 ? 103 != v1 : 103 == v1;
            }
            case 108: {
                return (v2 & 2) == 0 ? 108 != v1 : 108 == v1;
            }
            case 0x70: {
                return (v2 & 16) == 0 ? 0x70 != v1 : 0x70 == v1;
            }
            case 0x73: {
                return (v2 & 0x20) == 0 ? 0x73 != v1 : 0x73 == v1;
            }
            case 0x75: {
                return (v2 & 4) == 0 ? 0x75 != v1 : 0x75 == v1;
            }
            case 0x77: {
                return (v2 & 9) == 0 ? 0x77 != v1 : 0x77 == v1;
            }
            case 120: {
                return (v2 & 0xFFFFFF80) == 0 ? 120 != v1 : 120 == v1;
            }
            case 0x7A: {
                return v == 0 ? 0x7A == v1 : 0x7A != v1;
            }
            default: {
                return v1 == v;
            }
        }
    }

    int a(int v) {
        int v1 = v + 1;
        switch(this.c.b(v)) {
            case 37: {
                if(v1 == this.c.L()) {
                    StringLib.f("malformed pattern (ends with \'%\')");
                }
                return v1 + 1;
            }
            case 91: {
                if(v1 != this.c.L() && this.c.b(v1) == 94) {
                    ++v1;
                }
                do {
                    if(v1 == this.c.L()) {
                        StringLib.f("malformed pattern (missing \']\')");
                    }
                    v1 = this.c.b(v1) != 37 || v1 + 1 >= this.c.L() ? v1 + 1 : v1 + 2;
                }
                while(v1 == this.c.L() || this.c.b(v1) != 93);
                return v1 + 1;
            }
            default: {
                return v1;
            }
        }
    }

    ap a(boolean z, int v, int v1) {
        int v3 = this.e != 0 || !z ? this.e : 1;
        switch(v3) {
            case 0: {
                return StringLib.x;
            }
            case 1: {
                return this.f(0, v, v1);
            }
            default: {
                LuaValue[] arr_luaValue = new LuaValue[v3];
                for(int v2 = 0; v2 < v3; ++v2) {
                    arr_luaValue[v2] = this.f(v2, v, v1);
                }
                return StringLib.c(arr_luaValue);
            }
        }
    }

    void a() {
        this.e = 0;
        this.a = 200;
    }

    public void a(a a0, int v, int v1, LuaValue luaValue0) {
        LuaValue luaValue1;
        switch(luaValue0.e_()) {
            case 3: 
            case 4: {
                this.a(a0, luaValue0.t(), v, v1);
                return;
            }
            case 5: {
                luaValue1 = luaValue0.w(this.f(0, v, v1));
                break;
            }
            case 6: {
                luaValue1 = luaValue0.a_(this.a(true, v, v1)).g();
                break;
            }
            default: {
                StringLib.f("bad argument: string/function/table expected");
                return;
            }
        }
        if(!luaValue1.i_()) {
            luaValue1 = this.b.a(v, v1);
        }
        else if(!luaValue1.J()) {
            StringLib.f(("invalid replacement value (a " + luaValue1.f_() + ')'));
        }
        a0.a(luaValue1.t());
    }

    boolean a(int v, int v1, int v2) {
        boolean z;
        if(this.c.b(v1 + 1) == 94) {
            ++v1;
            z = false;
        }
        else {
            z = true;
        }
        do {
            while(true) {
                while(true) {
                    ++v1;
                    if(v1 >= v2) {
                        return !z;
                    }
                    if(this.c.b(v1) != 37) {
                        break;
                    }
                    ++v1;
                    if(l.a(v, this.c.b(v1))) {
                        return z;
                    }
                }
                if(this.c.b(v1 + 1) != 45 || v1 + 2 >= v2) {
                    break;
                }
                v1 += 2;
                if(this.c.b(v1 - 2) <= v && v <= this.c.b(v1)) {
                    return z;
                }
            }
        }
        while(this.c.b(v1) != v);
        return z;
    }

    private int b() {
        int v;
        for(v = this.e - 1; true; --v) {
            if(v < 0) {
                StringLib.f("invalid pattern capture");
                return 0;
            }
            if(this.g[v] == -1) {
                break;
            }
        }
        return v;
    }

    private int b(int v) {
        if(v - 49 < 0 || v - 49 >= this.e || this.g[v - 49] == -1) {
            StringLib.f(("invalid capture index %" + (v - 0x30)));
        }
        return v - 49;
    }

    int b(int v, int v1) {
        int v10;
        int v2 = -1;
        int v3 = this.a;
        this.a = v3 - 1;
        if(v3 == 0) {
            StringLib.f("pattern too complex");
        }
        int v4 = v;
        try {
            while(true) {
                if(v1 == this.c.L()) {
                    return v4;
                }
                switch(this.c.b(v1)) {
                    case 36: {
                    label_36:
                        if(v1 + 1 == this.c.L()) {
                            if(v4 != this.b.L()) {
                                v4 = -1;
                            }
                            return v4;
                        }
                    label_41:
                        int v8 = this.a(v1);
                        boolean z = v4 < this.b.L() && this.b(this.b.b(v4), v1, v8);
                        switch((v8 >= this.c.L() ? 0 : this.c.b(v8))) {
                            case 42: {
                                return this.c(v4, v1, v8);
                            }
                            case 43: {
                                if(z) {
                                    v2 = this.c(v4 + 1, v1, v8);
                                }
                                return v2;
                            }
                            case 45: {
                                return this.d(v4, v1, v8);
                            label_55:
                                if(!z) {
                                    return -1;
                                }
                                ++v4;
                                v1 = v8;
                                break;
                            }
                            case 0x3F: {
                                if(z) {
                                    int v9 = this.b(v4 + 1, v8 + 1);
                                    if(v9 != -1) {
                                        return v9;
                                    }
                                }
                                v1 = v8 + 1;
                                break;
                            }
                            default: {
                                goto label_55;
                            }
                        }
                        continue;
                    label_69:
                        v4 = this.e(v4, v1 + 2);
                        if(v4 == -1) {
                            return -1;
                        }
                        v1 += 4;
                        continue;
                    label_75:
                        v10 = v1 + 2;
                        if(v10 == this.c.L() || this.c.b(v10) != 91) {
                            StringLib.f("missing \'[\' after \'%f\' in pattern");
                        }
                        break;
                    }
                    case 37: {
                        if(v1 + 1 == this.c.L()) {
                            StringLib.f("malformed pattern (ends with \'%\')");
                        }
                        switch(this.c.b(v1 + 1)) {
                            case 98: {
                                goto label_69;
                            }
                            case 102: {
                                goto label_75;
                            }
                            default: {
                                int v6 = this.c.b(v1 + 1);
                                if(Character.isDigit(((char)v6))) {
                                    int v7 = this.d(v4, v6);
                                    return v7 == -1 ? -1 : this.b(v7, v1 + 2);
                                }
                                goto label_36;
                            }
                        }
                    }
                    case 40: {
                        return v1 + 1 < this.c.L() && this.c.b(v1 + 1) == 41 ? this.e(v4, v1 + 2, -2) : this.e(v4, v1 + 1, -1);
                    }
                    case 41: {
                        return this.c(v4, v1 + 1);
                    }
                    default: {
                        goto label_41;
                    }
                }
                v1 = this.a(v10);
                if(this.a((v4 == 0 ? 0 : this.b.b(v4 - 1)), v10, v1 - 1) || !this.a((v4 == this.b.L() ? 0 : this.b.b(v4)), v10, v1 - 1)) {
                    break;
                }
            }
            return -1;
        }
        finally {
            ++this.a;
        }
    }

    boolean b(int v, int v1, int v2) {
        switch(this.c.b(v1)) {
            case 37: {
                return l.a(v, this.c.b(v1 + 1));
            }
            case 46: {
                return true;
            }
            case 91: {
                return this.a(v, v1, v2 - 1);
            }
            default: {
                return this.c.b(v1) == v;
            }
        }
    }

    int c(int v, int v1) {
        int v2 = this.b();
        this.g[v2] = v - this.f[v2];
        int v3 = this.b(v, v1);
        if(v3 == -1) {
            this.g[v2] = -1;
        }
        return v3;
    }

    int c(int v, int v1, int v2) {
        int v5;
        int v4;
        for(int v3 = 0; true; ++v3) {
            if(v + v3 >= this.b.L()) {
                v4 = v3;
                break;
            }
            if(!this.b(this.b.b(v + v3), v1, v2)) {
                v4 = v3;
                break;
            }
        }
        while(true) {
            if(v4 < 0) {
                return -1;
            }
            v5 = this.b(v + v4, v2 + 1);
            if(v5 != -1) {
                break;
            }
            --v4;
        }
        return v5;
    }

    int d(int v, int v1) {
        int v2 = this.b(v1);
        int v3 = this.g[v2];
        return this.b.L() - v < v3 || !LuaString.a(this.b, this.f[v2], this.b, v, v3) ? -1 : v + v3;
    }

    int d(int v, int v1, int v2) {
        while(true) {
            int v3 = this.b(v, v2 + 1);
            if(v3 != -1) {
                return v3;
            }
            if(v >= this.b.L() || !this.b(this.b.b(v), v1, v2)) {
                break;
            }
            ++v;
        }
        return -1;
    }

    int e(int v, int v1) {
        int v2 = this.c.L();
        if(v1 == v2 || v1 + 1 == v2) {
            StringLib.f("malformed pattern (missing arguments to \'%b\')");
        }
        int v3 = this.b.L();
        if(v < v3) {
            int v4 = this.c.b(v1);
            if(this.b.b(v) == v4) {
                int v5 = this.c.b(v1 + 1);
                int v6 = 1;
                while(true) {
                    ++v;
                    if(v >= v3) {
                        break;
                    }
                    if(this.b.b(v) == v5) {
                        --v6;
                        if(v6 != 0) {
                            continue;
                        }
                        return v + 1;
                    }
                    if(this.b.b(v) == v4) {
                        ++v6;
                    }
                }
            }
        }
        return -1;
    }

    int e(int v, int v1, int v2) {
        int v3 = this.e;
        if(v3 >= 0x20) {
            StringLib.f("too many captures");
        }
        this.f[v3] = v;
        this.g[v3] = v2;
        this.e = v3 + 1;
        int v4 = this.b(v, v1);
        if(v4 == -1) {
            --this.e;
        }
        return v4;
    }

    private LuaValue f(int v, int v1, int v2) {
        if(v >= this.e) {
            return v == 0 ? this.b.a(v1, v2) : StringLib.f(("invalid capture index %" + (v + 1)));
        }
        int v3 = this.g[v];
        if(v3 == -1) {
            return StringLib.f("unfinished capture");
        }
        if(v3 == -2) {
            return StringLib.d(this.f[v] + 1);
        }
        int v4 = this.f[v];
        return this.b.a(v4, v3 + v4);
    }
}

