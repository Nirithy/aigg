package luaj.lib;

import luaj.LuaDouble;
import luaj.LuaLong;
import luaj.LuaValue;

final class MathLib.type extends OneArgFunction {
    @Override  // luaj.lib.OneArgFunction
    public LuaValue a(LuaValue luaValue0) {
        if(luaValue0 instanceof LuaLong) {
            return MathLib.type.m("integer");
        }
        return luaValue0 instanceof LuaDouble ? MathLib.type.m("float") : MathLib.type.u;
    }
}

