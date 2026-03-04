package luaj.lib;

import java.util.Locale;
import luaj.LuaString;
import luaj.a;
import luaj.ap;

class k {
    int a;
    public final int b;
    public final int c;
    public final String d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;

    public k(ap ap0, LuaString luaString0, int v) {
        int v4;
        boolean z = false;
        super();
        int v1 = luaString0.L();
        int v2 = 0;
        int v3 = v;
        boolean z1 = true;
        while(z1) {
            if(v3 < v1) {
                v2 = luaString0.b(v3);
                ++v3;
            }
            else {
                v2 = 0;
            }
            switch(v2) {
                case 0x20: {
                    this.h = true;
                    break;
                }
                case 35: {
                    this.i = true;
                    break;
                }
                case 43: {
                    this.g = true;
                    break;
                }
                case 45: {
                    this.e = true;
                    break;
                }
                case 0x30: {
                    this.f = true;
                    break;
                }
                default: {
                    z1 = false;
                }
            }
        }
        if(v3 - v > 5) {
            StringLib.f("invalid format (repeated flags)");
        }
        this.j = -1;
        if(Character.isDigit(((char)v2))) {
            this.j = v2 - 0x30;
            if(v3 < v1) {
                v4 = v3 + 1;
                v2 = luaString0.b(v3);
            }
            else {
                v2 = 0;
                v4 = v3;
            }
            if(Character.isDigit(((char)v2))) {
                this.j = v2 - 0x30 + this.j * 10;
                if(v4 < v1) {
                    v2 = luaString0.b(v4);
                    ++v4;
                }
                else {
                    v2 = 0;
                }
            }
        }
        else {
            v4 = v3;
        }
        this.a = -1;
        if(v2 == 46) {
            if(v4 < v1) {
                v2 = luaString0.b(v4);
                ++v4;
            }
            else {
                v2 = 0;
            }
            if(Character.isDigit(((char)v2))) {
                this.a = v2 - 0x30;
                if(v4 < v1) {
                    v2 = luaString0.b(v4);
                    ++v4;
                }
                else {
                    v2 = 0;
                }
                if(Character.isDigit(((char)v2))) {
                    this.a = v2 - 0x30 + this.a * 10;
                    if(v4 < v1) {
                        v2 = luaString0.b(v4);
                        ++v4;
                    }
                    else {
                        v2 = 0;
                    }
                }
            }
        }
        if(Character.isDigit(((char)v2))) {
            StringLib.f(("invalid format (width or precision too long) at pos " + v4));
        }
        boolean z2 = this.f;
        if(!this.e) {
            z = true;
        }
        this.f = z & z2;
        this.b = v2;
        this.c = v4 - v;
        this.d = luaString0.a(v - 1, v4).d_();
    }

    public static final void a(a a0, char c, int v) {
        while(v > 0) {
            a0.a(((byte)c));
            --v;
        }
    }

    public void a(a a0, byte b) {
        a0.a(b);
    }

    public void a(a a0, double f) {
        String s = null;
        if(Double.isNaN(f)) {
            s = "nan";
        }
        else if(Double.isInfinite(f)) {
            s = f < 0.0 ? "-inf" : "inf";
        }
        if(s == null) {
            s = String.format(Locale.US, this.d, f);
        }
        else if(this.b < 97) {
            s = s.toUpperCase(Locale.US);
        }
        a0.a(s);
    }

    public void a(a a0, long v) {
        int v6;
        int v5;
        int v4;
        String s;
        int v1 = 0;
        if(v != 0L || this.a != 0) {
            switch(this.b) {
                case 0x6F: {
                    s = Long.toOctalString(v);
                    break;
                }
                case 0x75: {
                    if(v >= 0L) {
                        s = Long.toString(v);
                    }
                    else {
                        long v2 = (v >>> 1) / 5L;
                        s = Long.toString(v2) + (v - 10L * v2);
                    }
                    break;
                }
                case 88: 
                case 120: {
                    s = Long.toHexString(v);
                    break;
                }
                default: {
                    s = Long.toString(v);
                }
            }
            if(this.b == 88) {
                s = s.toUpperCase(Locale.US);
            }
        }
        else {
            s = "";
        }
        int v3 = s.length();
        if(v < 0L) {
            v4 = v3 - 1;
            v5 = v3;
        }
        else if(!this.g && !this.h) {
            v4 = v3;
            v5 = v3;
        }
        else {
            v5 = v3 + 1;
            v4 = v3;
        }
        if(this.a > v4) {
            v6 = this.a - v4;
        }
        else {
            v6 = this.a != -1 || !this.f || this.j <= v5 ? 0 : this.j - v5;
        }
        int v7 = v5 + v6;
        if(this.j > v7) {
            v1 = this.j - v7;
        }
        if(!this.e) {
            k.a(a0, ' ', v1);
        }
        if(v >= 0L) {
            if(this.g) {
                a0.a(43);
            }
            else if(this.h) {
                a0.a(0x20);
            }
        }
        else if(v6 > 0) {
            a0.a(45);
            s = s.substring(1);
        }
        if(v6 > 0) {
            k.a(a0, '0', v6);
        }
        a0.a(s);
        if(this.e) {
            k.a(a0, ' ', v1);
        }
    }

    public void a(a a0, LuaString luaString0) {
        int v = 0x30;
        int v1 = luaString0.L();
        int v2 = this.j;
        int v3 = this.a == -1 ? v1 : this.a;
        if(v1 > v3) {
            v1 = v3;
        }
        if(v1 < v2 && !this.e) {
            int v4 = this.f ? 0x30 : 0x20;
            for(int v5 = v2 - v1; v5 > 0; --v5) {
                a0.a(((byte)v4));
            }
        }
        a0.a(luaString0.b, luaString0.c, v1);
        if(v1 < v2 && this.e) {
            if(!this.f) {
                v = 0x20;
            }
            for(int v6 = v2 - v1; v6 > 0; --v6) {
                a0.a(((byte)v));
            }
        }
    }
}

