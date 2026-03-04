package luaj.lib;

import luaj.LuaTable;
import luaj.ap;
import luaj.o;

class TableLib.insert extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        int v = 2;
        int v1 = ap0.j_();
        if(v1 != 2 && v1 != 3) {
            throw new o("wrong number of arguments to \'table.insert\': " + ap0.j_() + " (must be 2 or 3)");
        }
        LuaTable luaTable0 = ap0.t(1);
        int v2 = luaTable0.L();
        if(v2 >= 0xFFFFFF) {
            throw new o("array too big: " + v2 + " >= " + 0xFFFFFF);
        }
        int v3 = v1 == 2 ? v2 + 1 : ap0.o(2);
        if(v3 < 1 || v3 > v2 + 1) {
            TableLib.insert.a(2, "table.insert", "position out of bounds: " + v3 + " not between 1 and " + (v2 + 1));
        }
        if(v3 >= 0xFFFFFF) {
            throw new o("position too big: " + v3 + " >= " + 0xFFFFFF);
        }
        if(v1 != 2) {
            v = 3;
        }
        luaTable0.c(v3, ap0.c(v));
        return TableLib.insert.x;
    }
}

