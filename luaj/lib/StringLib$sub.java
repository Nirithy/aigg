package luaj.lib;

import luaj.LuaString;
import luaj.ap;

final class StringLib.sub extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        int v = 1;
        LuaString luaString0 = ap0.s(1);
        int v1 = luaString0.L();
        int v2 = StringLib.a(ap0.o(2), v1);
        int v3 = StringLib.a(ap0.d(3, -1), v1);
        if(v2 >= 1) {
            v = v2;
        }
        if(v3 > v1) {
            return v > v1 ? StringLib.sub.ad : luaString0.a(v - 1, v1);
        }
        return v > v3 ? StringLib.sub.ad : luaString0.a(v - 1, v3);
    }
}

