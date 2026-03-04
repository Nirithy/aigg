package luaj.lib;

import luaj.LuaValue;

final class BaseLib.rawget extends TableLibFunction {
    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0) {
        return BaseLib.rawget.a(2, "value expected");
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        return luaValue0.O().x(luaValue1);
    }
}

