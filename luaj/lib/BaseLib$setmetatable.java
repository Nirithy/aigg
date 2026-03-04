package luaj.lib;

import luaj.LuaValue;

final class BaseLib.setmetatable extends TableLibFunction {
    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0) {
        return BaseLib.setmetatable.a(2, "nil or table expected");
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        LuaValue luaValue2 = luaValue0.O().i();
        if(luaValue2 != null && !luaValue2.x(BaseLib.setmetatable.H).F()) {
            BaseLib.setmetatable.f("cannot change a protected metatable");
        }
        return luaValue1.F() ? luaValue0.v(null) : luaValue0.v(luaValue1.O());
    }
}

