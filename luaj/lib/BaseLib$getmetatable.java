package luaj.lib;

import luaj.LuaValue;

final class BaseLib.getmetatable extends LibFunction {
    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0) {
        LuaValue luaValue1 = luaValue0.i();
        return luaValue1 == null ? BaseLib.getmetatable.u : luaValue1.x(BaseLib.getmetatable.H).t(luaValue1);
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue l() {
        return BaseLib.getmetatable.a(1, "value expected");
    }
}

