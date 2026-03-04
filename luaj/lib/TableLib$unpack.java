package luaj.lib;

import luaj.LuaTable;
import luaj.ap;

class TableLib.unpack extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaTable luaTable0 = ap0.t(1);
        if(ap0.c(3).F()) {
            int v = luaTable0.L();
            return luaTable0.a(ap0.a(2, 1L), ap0.a(3, ((long)v)));
        }
        return luaTable0.a(ap0.a(2, 1L), ap0.a(3, 0L));
    }
}

