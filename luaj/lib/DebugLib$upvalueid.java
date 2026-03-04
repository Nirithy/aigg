package luaj.lib;

import luaj.LuaClosure;
import luaj.LuaFunction;
import luaj.ap;

final class DebugLib.upvalueid extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaFunction luaFunction0 = ap0.n(1);
        int v = ap0.o(2);
        return luaFunction0 instanceof LuaClosure && ((LuaClosure)luaFunction0).b != null && v > 0 && v <= ((LuaClosure)luaFunction0).b.length ? DebugLib.upvalueid.d(((LuaClosure)luaFunction0).b[v - 1].hashCode()) : DebugLib.upvalueid.a(2, "debug.upvalueid", "invalid upvalue index " + v);
    }
}

