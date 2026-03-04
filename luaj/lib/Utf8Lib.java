package luaj.lib;

import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.o;

public class Utf8Lib extends TwoArgFunction {
    static int a(byte[] arr_b, int v, int v1) {
        int v5;
        int v2 = 0x7F;
        int v4 = arr_b[v] & 0xFF;
        if(v4 <= 0x7F) {
            v2 = -1;
            v5 = 1;
            goto label_22;
        }
        if(v4 < 0xC0) {
            return 0x50000000 | v;
        }
        if(v4 < 0xE0) {
            v5 = 2;
            v4 ^= 0xC0;
            goto label_22;
        }
        if(v4 < 0xF0) {
            v5 = 3;
            v4 ^= 0xE0;
            v2 = 0x7FF;
            goto label_22;
        }
        if(v4 < 0xF8) {
            v5 = 4;
            v4 ^= 0xF0;
            v2 = 0xFFFF;
            for(int v3 = 1; true; ++v3) {
            label_22:
                if(v3 >= v5) {
                    return v4 <= 0x10FFFF && v4 > v2 ? v5 << 28 | v4 : 0x50000000 | v;
                }
                if(v3 >= v1) {
                    return 0x50000000 | v;
                }
                int v6 = arr_b[v + v3] & 0xFF;
                if((v6 & 0xC0) != 0x80) {
                    return 0x50000000 | v;
                }
                v4 = v4 << 6 | v6 & 0x3F;
            }
        }
        return 0x50000000 | v;
    }

    static void a(String s, int v, int v1, int v2) {
        Utf8Lib.a(v, s, "\'" + v1 + "\': position out of range [1; " + v2 + "]");
    }

    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        LuaTable luaTable0 = new LuaTable();
        luaTable0.a("char", new Utf8Lib._char());
        luaTable0.a("charpattern", LuaString.b(new byte[]{91, 0, 45, 0x7F, -62, 45, -12, 93, 91, 0xFFFFFF80, 45, -65, 93, 42}));
        luaTable0.a("codes", new Utf8Lib.codes());
        luaTable0.a("codepoint", new Utf8Lib.codepoint());
        luaTable0.a("len", new Utf8Lib.len());
        luaTable0.a("offset", new Utf8Lib.offset());
        luaValue1.a("utf8", luaTable0);
        if(!luaValue1.j("package").F()) {
            luaValue1.j("package").j("loaded").a("utf8", luaTable0);
        }
        return Utf8Lib.u;
    }

    static void b(String s, int v, int v1, int v2) {
        Utf8Lib.a(v, s, "\'" + v1 + "\': final position out of string length [" + v2 + "]");
    }

    static o e(int v) {
        return new o("invalid UTF-8 code at " + (v + 1) + " byte");
    }
}

