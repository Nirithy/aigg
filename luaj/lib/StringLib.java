package luaj.lib;

import android.ext.ts;
import java.nio.ByteOrder;
import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.a;
import luaj.ap;

public class StringLib extends TwoArgFunction {
    static final byte[] a;
    private static final LuaString b;

    static {
        StringLib.b = StringLib.m("^$*+?.([%-");
        StringLib.a = new byte[0x100];
        for(int v = 0; v < 0x80; ++v) {
            StringLib.a[v] = (byte)((((char)v) >= 0x20 && ((char)v) != 0x7F ? 0 : 0x40) | ((Character.isLowerCase(((char)v)) ? 2 : 0) | (Character.isDigit(((char)v)) ? 8 : 0) | (Character.isUpperCase(((char)v)) ? 4 : 0)));
            if(((char)v) >= 97 && ((char)v) <= 102 || ((char)v) >= 65 && ((char)v) <= 70 || ((char)v) >= 0x30 && ((char)v) <= 57) {
                StringLib.a[v] = (byte)(StringLib.a[v] | 0xFFFFFF80);
            }
            if(((char)v) >= 33 && ((char)v) <= 0x2F || ((char)v) >= 58 && ((char)v) <= 0x40 || ((char)v) >= 91 && ((char)v) <= 0x60 || ((char)v) >= 0x7B && ((char)v) <= 0x7E) {
                StringLib.a[v] = (byte)(StringLib.a[v] | 16);
            }
            if((StringLib.a[v] & 6) != 0) {
                StringLib.a[v] = (byte)(StringLib.a[v] | 1);
            }
        }
        StringLib.a[0x20] = 0x20;
        StringLib.a[13] = (byte)(StringLib.a[13] | 0x20);
        StringLib.a[10] = (byte)(StringLib.a[10] | 0x20);
        StringLib.a[9] = (byte)(StringLib.a[9] | 0x20);
        StringLib.a[11] = (byte)(StringLib.a[11] | 0x20);
        StringLib.a[12] = (byte)(StringLib.a[12] | 0x20);
    }

    static byte a(m m0) {
        int v5;
        int v = 4;
        int v1 = 1;
        int v2 = m0.e;
        m0.e = v2 + 1;
        char c = m0.d.charAt(v2);
        m0.f = c;
        try {
            switch(c) {
                case 0x20: {
                    goto label_105;
                }
                case 33: {
                    m0.c = StringLib.a(m0, ((int)m0.a), true);
                    goto label_105;
                }
                case 60: 
                case 61: {
                    m0.b = true;
                    goto label_105;
                }
                case 62: {
                    m0.b = false;
                    goto label_105;
                }
                case 66: {
                    m0.i = 1;
                    m0.g = 1;
                    return 2;
                }
                case 72: {
                    m0.i = 2;
                    m0.g = 2;
                    return 2;
                }
                case 73: {
                    int v3 = StringLib.a(m0, 4, true);
                    m0.i = v3;
                    v1 = v3 >= 8 ? 4 : v3;
                    m0.g = v1;
                    return 2;
                }
                case 74: {
                    m0.i = 8;
                    m0.g = 4;
                    return 2;
                }
                case 76: {
                    m0.i = 8;
                    m0.g = 4;
                    return 2;
                }
                case 84: {
                    int v4 = m0.a;
                    m0.i = v4;
                    v1 = v4 >= 8 ? 4 : v4;
                    m0.g = v1;
                    return 2;
                }
                case 88: {
                    m0.i = 0;
                    m0.g = 0;
                    return 8;
                }
                case 98: {
                    m0.i = 1;
                    m0.g = 1;
                    return 1;
                }
                case 99: {
                    v5 = StringLib.a(m0, -1, false);
                    if(v5 == -1) {
                        try {
                            StringLib.f(("missing size for format option \'c\' at pos " + m0.e));
                        }
                        catch(Throwable throwable1) {
                            throwable0 = throwable1;
                            break;
                        }
                    }
                    m0.i = v5;
                    m0.g = 1;
                    return 4;
                }
                case 100: {
                    m0.i = 8;
                    m0.g = 4;
                    return 9;
                }
                case 102: {
                    m0.i = 4;
                    m0.g = 4;
                    return 3;
                }
                case 104: {
                    m0.i = 2;
                    m0.g = 2;
                    return 1;
                }
                case 105: {
                    int v6 = StringLib.a(m0, 4, true);
                    m0.i = v6;
                    if(v6 < 8) {
                        v = v6;
                    }
                    m0.g = v;
                    return 1;
                }
                case 106: {
                    m0.i = 8;
                    m0.g = 4;
                    return 1;
                }
                case 108: {
                    m0.i = 8;
                    m0.g = 4;
                    return 1;
                }
                case 110: {
                    m0.i = 9;
                    m0.g = 4;
                    return 10;
                }
                case 0x73: {
                    int v7 = StringLib.a(m0, ((int)m0.a), true);
                    m0.i = v7;
                    v1 = v7 >= 8 ? 4 : v7;
                    m0.g = v1;
                    return 5;
                }
                case 120: {
                    m0.i = 1;
                    m0.g = 1;
                    return 7;
                }
                case 0x7A: {
                    m0.i = 0;
                    m0.g = 0;
                    return 6;
                }
                default: {
                    StringLib.f(ts.a("invalid format option \'%c\' at pos %d", new Object[]{Character.valueOf(c), m0.e}));
                    goto label_105;
                }
            }
        }
        catch(Throwable throwable0) {
            v5 = 0;
        }
        m0.i = v5;
        if(c != 99) {
            v1 = v5 < 8 ? v5 : 4;
        }
        m0.g = v1;
        throw throwable0;
    label_105:
        m0.i = 0;
        if(c != 99) {
            v1 = 0;
        }
        m0.g = v1;
        return 0;
    }

    static byte a(m m0, int v) {
        byte b = StringLib.a(m0);
        int v1 = m0.g;
        if(b == 8) {
            if(m0.d.length() <= m0.e) {
                StringLib.a(1, "no next option for option \'X\' at pos " + m0.e);
            }
            if(StringLib.a(m0) == 4) {
                StringLib.a(1, ts.a("invalid next option \'%c\' for option \'X\' at pos %d", new Object[]{Character.valueOf(m0.f), m0.e}));
            }
            else {
                v1 = m0.g;
                if(v1 == 0) {
                    StringLib.a(1, ts.a("invalid next option \'%c\' for option \'X\' at pos %d", new Object[]{Character.valueOf(m0.f), m0.e}));
                }
            }
            m0.i = 0;
        }
        if(v1 <= 1 || b == 4) {
            m0.h = 0;
            return b;
        }
        if(v1 > m0.c) {
            v1 = m0.c;
            m0.g = v1;
        }
        if((v1 - 1 & v1) != 0) {
            StringLib.a(1, ts.a("format option \'%c\' asks for alignment not power of 2 at pos %d", new Object[]{Character.valueOf(m0.f), m0.e}));
        }
        m0.h = v1 - 1 & v1 - (v1 - 1 & v);
        return b;
    }

    static int a(int v, int v1) {
        return v < 0 ? v1 + v + 1 : v;
    }

    static int a(m m0, int v, boolean z) {
        String s = m0.d;
        int v1 = s.length();
        int v2 = m0.e;
        if(v2 < v1) {
            int v3 = s.charAt(v2);
            if(v3 <= 57 && v3 >= 0x30) {
                v = 0;
                do {
                    v = v * 10 + (v3 - 0x30);
                    ++v2;
                    if(v2 >= v1) {
                        break;
                    }
                    v3 = s.charAt(v2);
                }
                while(v3 <= 57 && v3 >= 0x30 && v <= 0xCCCCCCB);
                m0.e = v2;
            }
        }
        if(z && (v > 8 || v <= 0)) {
            StringLib.f(ts.a("integral size (%d) out of limits [1,%d] at pos %d", new Object[]{v, 8, m0.e}));
        }
        return v;
    }

    static long a(m m0, LuaString luaString0, int v, boolean z) {
        int v4;
        long v2;
        int v1 = m0.i;
        if(v1 == 1) {
            v2 = (long)luaString0.b[luaString0.c + v];
            return z ? v2 : v2 & 0xFFL;
        }
        byte[] arr_b = m0.j;
        if(v1 >= 8) {
            v4 = 0;
        }
        else if(m0.b) {
            int v3 = v1 - 1;
            while(true) {
                ++v3;
                if(v3 >= 8) {
                    break;
                }
                arr_b[v3] = 0;
            }
            v4 = 0;
        }
        else {
            v4 = 8 - v1;
            int v5 = v4;
            while(true) {
                --v5;
                if(v5 < 0) {
                    break;
                }
                arr_b[v5] = 0;
            }
        }
        luaString0.a(v, arr_b, v4, v1);
        v2 = m0.k.order((m0.b ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN)).getLong(0);
        if(v1 < 8 && z) {
            long v6 = 1L << v1 * 8 - 1;
            return (v2 ^ v6) - v6;
        }
        return v2;
    }

    static void a(a a0, LuaString luaString0) {
        a0.a(34);
        int v1 = luaString0.L();
        for(int v = 0; v < v1; ++v) {
            int v2 = luaString0.b(v);
            if(v2 == 10 || v2 == 34 || v2 == 92) {
                a0.a(92);
                a0.a(((byte)v2));
            }
            else if(v2 > 0x1F && v2 != 0x7F) {
                a0.a(((byte)v2));
            }
            else {
                a0.a(92);
                if(v + 1 != v1 && luaString0.b(v + 1) >= 0x30 && luaString0.b(v + 1) <= 57) {
                    a0.a(0x30);
                    a0.a(((byte)(((char)(v2 / 10 + 0x30)))));
                    a0.a(((byte)(((char)(v2 % 10 + 0x30)))));
                }
                else {
                    a0.a(Integer.toString(v2));
                }
            }
        }
        a0.a(34);
    }

    static void a(m m0, a a0, long v) {
        m0.k.order((m0.b ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN)).putLong(0, v);
        a0.a(m0.j, (m0.b ? 0 : 8 - m0.i), m0.i);
    }

    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        LuaValue luaValue2 = new LuaTable();
        ((LuaTable)luaValue2).a("byte", new StringLib._byte());
        ((LuaTable)luaValue2).a("char", new StringLib._char());
        ((LuaTable)luaValue2).a("dump", new StringLib.dump());
        ((LuaTable)luaValue2).a("find", new StringLib.find());
        ((LuaTable)luaValue2).a("format", new StringLib.format());
        ((LuaTable)luaValue2).a("gmatch", new StringLib.gmatch());
        ((LuaTable)luaValue2).a("gsub", new StringLib.gsub());
        ((LuaTable)luaValue2).a("len", new StringLib.len());
        ((LuaTable)luaValue2).a("lower", new StringLib.lower());
        ((LuaTable)luaValue2).a("match", new StringLib.match());
        ((LuaTable)luaValue2).a("pack", new StringLib.pack());
        ((LuaTable)luaValue2).a("packsize", new StringLib.packsize());
        ((LuaTable)luaValue2).a("rep", new StringLib.rep());
        ((LuaTable)luaValue2).a("reverse", new StringLib.reverse());
        ((LuaTable)luaValue2).a("sub", new StringLib.sub());
        ((LuaTable)luaValue2).a("unpack", new StringLib.unpack());
        ((LuaTable)luaValue2).a("upper", new StringLib.upper());
        luaValue1.a("string", luaValue2);
        if(!luaValue1.j("package").F()) {
            luaValue1.j("package").j("loaded").a("string", luaValue2);
        }
        if(LuaString.a == null) {
            LuaString.a = LuaValue.b(new LuaValue[]{StringLib.D, luaValue2});
        }
        return luaValue2;
    }

    static ap b(ap ap0, boolean z) {
        boolean z1;
        int v4;
        LuaString luaString0 = ap0.s(1);
        LuaString luaString1 = ap0.s(2);
        int v = luaString0.L();
        int v1 = StringLib.a(ap0.d(3, 1), v);
        if(v1 < 1) {
            v1 = 1;
        }
        else if(v1 > v + 1) {
            return StringLib.u;
        }
        int v2 = v1 - 1;
        if(z && (ap0.c(4).i_() || luaString1.e(StringLib.b) == -1)) {
            int v3 = luaString0.a(luaString1, v2);
            return v3 == -1 ? StringLib.u : StringLib.b(StringLib.d(v3 + 1), StringLib.d(v3 + luaString1.L()));
        }
        l l0 = new l(ap0, luaString0, luaString1);
        if(luaString1.L() <= 0 || luaString1.b(0) != 94) {
            v4 = 0;
            z1 = false;
        }
        else {
            v4 = 1;
            z1 = true;
        }
        while(true) {
            l0.a();
            int v5 = l0.b(v2, v4);
            if(v5 != -1) {
                return z ? StringLib.a(StringLib.d(v2 + 1), StringLib.d(v5), l0.a(false, v2, v5)) : l0.a(true, v2, v5);
            }
            if(v2 >= v || z1) {
                return StringLib.u;
            }
            ++v2;
        }
    }
}

