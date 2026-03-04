package luaj.lib;

import luaj.LuaValue;

final class BaseLib.rawlen extends LibFunction {
    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0) {
        return BaseLib.rawlen.d(luaValue0.M());
    }
}

