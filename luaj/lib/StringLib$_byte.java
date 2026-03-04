package luaj.lib;

import luaj.LuaString;
import luaj.LuaValue;
import luaj.ap;

final class StringLib._byte extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        int v = 1;
        LuaString luaString0 = ap0.s(1);
        int v1 = luaString0.d;
        int v2 = StringLib.a(ap0.d(2, 1), v1);
        int v3 = StringLib.a(ap0.d(3, v2), v1);
        if(v2 > 0) {
            v = v2;
        }
        if(v3 <= v1) {
            v1 = v3;
        }
        if(v > v1) {
            return StringLib._byte.x;
        }
        int v4 = v1 - v + 1;
        if(v + v4 <= v1) {
            StringLib._byte.f("string slice too long");
        }
        LuaValue[] arr_luaValue = new LuaValue[v4];
        for(int v5 = 0; v5 < v4; ++v5) {
            arr_luaValue[v5] = StringLib._byte.d(luaString0.b(v + v5 - 1));
        }
        return StringLib._byte.c(arr_luaValue);
    }
}

