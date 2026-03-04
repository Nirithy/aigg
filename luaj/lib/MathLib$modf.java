package luaj.lib;

import luaj.LuaValue;
import luaj.ap;

class MathLib.modf extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        double f1;
        LuaValue luaValue0 = ap0.g();
        if(luaValue0.n()) {
            return MathLib.modf.b(luaValue0, MathLib.modf.c(0.0));
        }
        double f = luaValue0.x();
        if(f > 0.0) {
            f1 = Math.floor(f);
            return f == f1 ? MathLib.modf.b(MathLib.modf.c(f1), MathLib.modf.c(0.0)) : MathLib.modf.b(MathLib.modf.c(f1), MathLib.modf.c(f - f1));
        }
        f1 = Math.ceil(f);
        return f == f1 ? MathLib.modf.b(MathLib.modf.c(f1), MathLib.modf.c(0.0)) : MathLib.modf.b(MathLib.modf.c(f1), MathLib.modf.c(f - f1));
    }
}

