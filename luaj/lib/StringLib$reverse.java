package luaj.lib;

import luaj.LuaString;
import luaj.LuaValue;

final class StringLib.reverse extends OneArgFunction {
    @Override  // luaj.lib.OneArgFunction
    public LuaValue a(LuaValue luaValue0) {
        LuaString luaString0 = luaValue0.z();
        int v = luaString0.L();
        if(v == 0) {
            return StringLib.reverse.ad;
        }
        byte[] arr_b = new byte[v];
        byte[] arr_b1 = luaString0.b;
        int v1 = v - 1;
        int v2 = luaString0.c + v;
        int v3 = luaString0.c;
        while(v3 < v2) {
            arr_b[v1] = arr_b1[v3];
            ++v3;
            --v1;
        }
        return LuaString.b(arr_b);
    }
}

