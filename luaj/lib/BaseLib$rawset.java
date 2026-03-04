package luaj.lib;

import luaj.LuaTable;
import luaj.LuaValue;

final class BaseLib.rawset extends TableLibFunction {
    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0) {
        return BaseLib.rawset.a(2, "value expected");
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        return BaseLib.rawset.a(3, "value expected");
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2) {
        LuaValue luaValue3 = luaValue0.O();
        if(!luaValue1.A()) {
            BaseLib.rawset.a(2, "table index is nil");
        }
        ((LuaTable)luaValue3).c(luaValue1, luaValue2);
        return luaValue3;
    }
}

