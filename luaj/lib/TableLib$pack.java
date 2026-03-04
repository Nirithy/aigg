package luaj.lib;

import luaj.LuaValue;
import luaj.ap;

class TableLib.pack extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        ap ap1 = TableLib.pack.a(ap0, 1);
        ((LuaValue)ap1).a("n", ap0.j_());
        return ap1;
    }
}

