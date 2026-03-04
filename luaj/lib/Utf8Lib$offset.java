package luaj.lib;

import luaj.LuaString;
import luaj.ap;
import luaj.o;

final class Utf8Lib.offset extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        int v5;
        LuaString luaString0 = ap0.s(1);
        int v = luaString0.d;
        int v1 = ap0.o(2);
        int v2 = StringLib.a(ap0.d(3, (v1 < 0 ? v + 1 : 1)), v);
        if(v2 < 1 || v2 > v + 1) {
            Utf8Lib.a(this.g_(), 3, v2, v);
        }
        byte[] arr_b = luaString0.b;
        int v3 = luaString0.c;
        int v4 = v2 - 1;
        if(v1 == 0) {
            while(v4 > 0 && v4 < v) {
                if((arr_b[v3 + v4] & 0xC0) != 0x80) {
                    v5 = 0;
                    return v5 == 0 ? Utf8Lib.offset.d(v4 + 1) : Utf8Lib.offset.u;
                }
                --v4;
            }
            v5 = 0;
        }
        else {
            if(v4 < v && (arr_b[v3 + v4] & 0xC0) == 0x80) {
                throw new o("initial position (" + v4 + ") is a continuation byte (0x" + Integer.toHexString(arr_b[v4 + v3] & 0xFF) + ")");
            }
            if(v1 < 0) {
                for(v5 = v1; v5 < 0 && v4 > 0; ++v5) {
                    do {
                        --v4;
                    }
                    while(v4 > 0 && v4 < v && (arr_b[v3 + v4] & 0xC0) == 0x80);
                }
            }
            else {
                for(v5 = v1 - 1; v5 > 0 && v4 < v; --v5) {
                    do {
                        ++v4;
                    }
                    while(v4 >= 0 && v4 < v && (arr_b[v3 + v4] & 0xC0) == 0x80);
                }
            }
        }
        return v5 == 0 ? Utf8Lib.offset.d(v4 + 1) : Utf8Lib.offset.u;
    }
}

