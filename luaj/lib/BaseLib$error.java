package luaj.lib;

import luaj.LuaValue;
import luaj.o;

final class BaseLib.error extends TwoArgFunction {
    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        if(!luaValue0.F()) {
            throw luaValue0.J() && luaValue1.b_(1) != 0 ? new o(luaValue0.d_(), luaValue1.b_(1)) : new o(luaValue0);
        }
        throw new o(BaseLib.error.u);
    }
}

