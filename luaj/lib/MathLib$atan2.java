package luaj.lib;

import luaj.LuaValue;

final class MathLib.atan2 extends TwoArgFunction {
    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        return MathLib.atan2.c(Math.atan2(MathLib.a(this, 1, luaValue0), MathLib.a(this, 2, luaValue1, 1.0)));
    }
}

