package luaj.lib;

import luaj.LuaValue;

public abstract class MathLib.UnaryOp extends OneArgFunction {
    protected abstract double a(double arg1);

    @Override  // luaj.lib.OneArgFunction
    public LuaValue a(LuaValue luaValue0) {
        return MathLib.UnaryOp.c(this.a(MathLib.a(this, 1, luaValue0)));
    }
}

