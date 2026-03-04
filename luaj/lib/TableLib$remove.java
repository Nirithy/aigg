package luaj.lib;

import luaj.LuaTable;
import luaj.ap;
import luaj.o;

class TableLib.remove extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaTable luaTable0 = ap0.t(1);
        int v = luaTable0.L();
        int v1 = ap0.d(2, v);
        if(v1 != v && (v1 < 1 || v1 > v + 1)) {
            TableLib.remove.a(2, "table.remove", "position out of bounds: " + v1 + " not between 1 and " + (v + 1));
        }
        if(v1 >= 0xFFFFFF) {
            throw new o("position too big: " + v1 + " >= " + 0xFFFFFF);
        }
        return luaTable0.b(v1, v);
    }
}

