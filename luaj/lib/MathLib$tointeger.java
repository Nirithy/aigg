package luaj.lib;

import luaj.LuaValue;

final class MathLib.tointeger extends OneArgFunction {
    @Override  // luaj.lib.OneArgFunction
    public LuaValue a(LuaValue luaValue0) {
        return luaValue0.n() ? MathLib.tointeger.d(luaValue0.q()) : MathLib.tointeger.u;
    }
}

