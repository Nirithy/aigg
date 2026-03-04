package luaj.lib;

import luaj.LuaValue;

final class MathLib.fmod extends TwoArgFunction {
    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        return luaValue0.E() && luaValue1.E() ? MathLib.fmod.d(luaValue0.q() % luaValue1.q()) : MathLib.fmod.c(MathLib.a(this, 1, luaValue0) % MathLib.a(this, 2, luaValue1));
    }
}

