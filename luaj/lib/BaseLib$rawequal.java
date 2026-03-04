package luaj.lib;

import luaj.LuaValue;

final class BaseLib.rawequal extends LibFunction {
    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0) {
        return BaseLib.rawequal.a(2, "value expected");
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        return BaseLib.rawequal.b(luaValue0.c(luaValue1));
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue l() {
        return BaseLib.rawequal.a(1, "value expected");
    }
}

