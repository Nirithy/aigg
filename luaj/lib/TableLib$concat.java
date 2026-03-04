package luaj.lib;

import luaj.LuaValue;

class TableLib.concat extends TableLibFunction {
    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0) {
        return luaValue0.O().a(TableLib.concat.ad, 1, luaValue0.L());
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        return luaValue0.O().a(luaValue1.z(), 1, luaValue0.L());
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2) {
        return luaValue0.O().a(luaValue1.z(), luaValue2.v(), luaValue0.L());
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2, LuaValue luaValue3) {
        return luaValue0.O().a(luaValue1.z(), luaValue2.v(), luaValue3.v());
    }
}

