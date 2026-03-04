package luaj.lib;

import luaj.LuaValue;

final class MathLib.log extends TwoArgFunction {
    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        double f = Math.log(MathLib.a(this, 1, luaValue0));
        double f1 = MathLib.a(this, 2, luaValue1, 2.718282);
        if(f1 != 2.718282) {
            f /= Math.log(f1);
        }
        return MathLib.log.c(f);
    }
}

