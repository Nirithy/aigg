package luaj.lib;

import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;

class TableLib.sort extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaTable luaTable0 = ap0.t(1);
        LuaValue luaValue0 = ap0.f(2) ? TableLib.sort.u : ap0.n(2);
        luaTable0.D(luaValue0);
        return TableLib.sort.x;
    }
}

