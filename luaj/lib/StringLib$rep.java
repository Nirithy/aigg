package luaj.lib;

import luaj.LuaString;
import luaj.ap;
import luaj.o;

final class StringLib.rep extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaString luaString0 = ap0.s(1);
        int v = ap0.o(2);
        if(v <= 0) {
            return StringLib.rep.ad;
        }
        LuaString luaString1 = ap0.a(3, StringLib.rep.ad);
        int v1 = luaString0.L();
        int v2 = luaString1.L();
        if(v1 + v2 < v1 || v1 + v2 > 0x7FFFFFFF / v) {
            throw new o("resulting string too large");
        }
        byte[] arr_b = new byte[(v1 + v2) * (v - 1) + v1];
        byte[] arr_b1 = luaString0.b;
        int v3 = luaString0.c;
        byte[] arr_b2 = luaString1.b;
        int v4 = luaString1.c;
        int v5 = 0;
        while(v > 1) {
            System.arraycopy(arr_b1, v3, arr_b, v5, v1);
            v5 += v1;
            if(v2 > 0) {
                System.arraycopy(arr_b2, v4, arr_b, v5, v2);
                v5 += v2;
            }
            --v;
        }
        System.arraycopy(arr_b1, v3, arr_b, v5, v1);
        return LuaString.b(arr_b);
    }
}

