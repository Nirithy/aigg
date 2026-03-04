package luaj.lib;

import luaj.LuaValue;

final class BaseLib.tonumber extends LibFunction {
    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0) {
        return luaValue0.H();
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        if(luaValue1.F()) {
            return luaValue0.H();
        }
        int v = luaValue1.v();
        if(v < 2 || v > 36) {
            BaseLib.tonumber.a(2, "base out of range");
        }
        return luaValue0.z().g_(v);
    }
}

