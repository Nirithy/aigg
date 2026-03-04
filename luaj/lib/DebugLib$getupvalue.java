package luaj.lib;

import luaj.LuaClosure;
import luaj.LuaFunction;
import luaj.LuaString;
import luaj.ap;

final class DebugLib.getupvalue extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaFunction luaFunction0 = ap0.n(1);
        int v = ap0.o(2);
        if(luaFunction0 instanceof LuaClosure) {
            LuaString luaString0 = DebugLib.a(((LuaClosure)luaFunction0), v);
            if(luaString0 != null) {
                return DebugLib.getupvalue.b(luaString0, ((LuaClosure)luaFunction0).b[v - 1].a());
            }
        }
        return DebugLib.getupvalue.u;
    }
}

