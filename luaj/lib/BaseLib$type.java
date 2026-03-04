package luaj.lib;

import luaj.LuaValue;

final class BaseLib.type extends LibFunction {
    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0) {
        return BaseLib.type.m(luaValue0.f_());
    }
}

