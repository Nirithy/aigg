package luaj.lib;

import luaj.LuaValue;

final class BaseLib.tostring extends LibFunction {
    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0) {
        return BaseLib.y(luaValue0);
    }
}

