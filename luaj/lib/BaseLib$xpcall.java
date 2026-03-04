package luaj.lib;

import luaj.LuaClosure;
import luaj.LuaThread;
import luaj.LuaValue;
import luaj.ap;

final class BaseLib.xpcall extends VarArgFunction {
    final BaseLib a;

    BaseLib.xpcall(BaseLib baseLib0) {
        this.a = baseLib0;
        super();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaThread luaThread0 = this.a.a.h;
        LuaValue luaValue0 = luaThread0.g;
        luaThread0.g = ap0.v(2);
        try {
            ap ap1 = LuaClosure.a(this.a.a, this, ap0.v(1), ap0.e_(3));
            luaThread0.g = luaValue0;
            return ap1;
        }
        catch(Throwable throwable0) {
            luaThread0.g = luaValue0;
            throw throwable0;
        }
    }
}

