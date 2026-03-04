package luaj.lib;

import luaj.LuaValue;

public abstract class MathLib.BinaryOp extends TwoArgFunction {
    protected abstract double a(double arg1, double arg2);

    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        return MathLib.BinaryOp.c(this.a(MathLib.a(this, 1, luaValue0), MathLib.a(this, 2, luaValue1)));
    }
}

