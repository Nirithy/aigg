package luaj.lib;

import java.util.Arrays;
import luaj.LuaString;
import luaj.LuaValue;
import luaj.ap;

final class Utf8Lib.codepoint extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaString luaString0 = ap0.s(1);
        int v = luaString0.d;
        int v1 = StringLib.a(ap0.d(2, 1), v);
        int v2 = StringLib.a(ap0.d(3, v1), v);
        if(v1 < 1 || v1 > v + 1) {
            Utf8Lib.a(this.g_(), 2, v1, v);
        }
        if(v2 > v) {
            Utf8Lib.b(this.g_(), 3, v2, v);
        }
        if(v1 > v2) {
            return Utf8Lib.codepoint.x;
        }
        LuaValue[] arr_luaValue = new LuaValue[v2 - v1 + 1];
        byte[] arr_b = luaString0.b;
        int v4 = luaString0.c;
        int v5 = luaString0.c + luaString0.d;
        int v6 = v1 - 1;
        for(int v3 = 0; true; ++v3) {
            if(v6 >= v2) {
                if(v3 == 0) {
                    return Utf8Lib.codepoint.x;
                }
                if(v3 < arr_luaValue.length) {
                    arr_luaValue = (LuaValue[])Arrays.copyOf(arr_luaValue, v3);
                }
                return Utf8Lib.codepoint.c(arr_luaValue);
            }
            int v7 = Utf8Lib.a(arr_b, v4 + v6, v5);
            int v8 = 0xFFFFFFF & v7;
            if(v7 >> 28 == 5) {
                throw Utf8Lib.e(v8 - v4 + 1);
            }
            v6 += v7 >> 28;
            arr_luaValue[v3] = Utf8Lib.codepoint.d(v8);
        }
    }
}

