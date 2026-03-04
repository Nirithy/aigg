package luaj.lib;

import luaj.LuaTable;
import luaj.ap;

final class BaseLib.pairs extends VarArgFunction {
    final BaseLib.next a;

    BaseLib.pairs(BaseLib.next baseLib$next0) {
        this.a = baseLib$next0;
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaTable luaTable0 = ap0.t(1);
        return BaseLib.pairs.a(this.a, luaTable0, BaseLib.pairs.u);
    }
}

