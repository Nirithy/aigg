package luaj.lib;

import luaj.LuaString;
import luaj.ap;

final class Utf8Lib.len extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaString luaString0 = ap0.s(1);
        int v = luaString0.d;
        int v1 = StringLib.a(ap0.d(2, 1), v);
        int v2 = StringLib.a(ap0.d(3, -1), v);
        if(v1 < 1 || v1 > v + 1) {
            Utf8Lib.a(this.g_(), 2, v1, v);
        }
        if(v2 > v) {
            Utf8Lib.b(this.g_(), 3, v2, v);
        }
        if(v1 > v2) {
            return Utf8Lib.len.y;
        }
        byte[] arr_b = luaString0.b;
        int v4 = luaString0.c;
        int v5 = luaString0.c + luaString0.d;
        int v6 = v1 - 1;
        for(int v3 = 0; true; ++v3) {
            if(v6 >= v2) {
                return Utf8Lib.len.d(v3);
            }
            int v7 = Utf8Lib.a(arr_b, v4 + v6, v5);
            if(v7 >> 28 == 5) {
                return Utf8Lib.len.b(Utf8Lib.len.u, Utf8Lib.len.d((0xFFFFFFF & v7) - v4 + 1));
            }
            v6 += v7 >> 28;
        }
    }
}

