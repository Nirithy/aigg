package luaj.lib;

import luaj.LuaValue;

final class MathLib.abs extends OneArgFunction {
    @Override  // luaj.lib.OneArgFunction
    public LuaValue a(LuaValue luaValue0) {
        return luaValue0.E() ? MathLib.abs.d(Math.abs(luaValue0.q())) : MathLib.abs.c(Math.abs(MathLib.a(this, 1, luaValue0)));
    }
}

