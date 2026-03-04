package luaj.lib;

import luaj.LuaValue;

final class StringLib.len extends OneArgFunction {
    @Override  // luaj.lib.OneArgFunction
    public LuaValue a(LuaValue luaValue0) {
        return luaValue0.z().K();
    }
}

