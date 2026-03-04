package luaj.lib;

import luaj.LuaValue;

final class MathLib.ult extends TwoArgFunction {
    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        long v = MathLib.b(this, 1, luaValue0);
        long v1 = MathLib.b(this, 2, luaValue1);
        int v2 = v >= v1 ? 0 : 1;
        int v3 = v >= 0L ? 0 : 1;
        if(v1 < 0L) {
            return (1 ^ (v3 ^ v2)) == 0 ? MathLib.ult.w : MathLib.ult.v;
        }
        return (v3 ^ v2) == 0 ? MathLib.ult.w : MathLib.ult.v;
    }
}

