package luaj.lib;

import luaj.LuaValue;

final class DebugLib.getmetatable extends LibFunction {
    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0) {
        LuaValue luaValue1 = luaValue0.i();
        return luaValue1 == null ? DebugLib.getmetatable.u : luaValue1;
    }
}

