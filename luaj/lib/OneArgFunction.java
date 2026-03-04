package luaj.lib;

import luaj.LuaValue;
import luaj.ap;

public abstract class OneArgFunction extends LibFunction {
    @Override  // luaj.lib.LibFunction
    public abstract LuaValue a(LuaValue arg1);

    @Override  // luaj.lib.LibFunction
    public final LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        return this.a(luaValue0);
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2) {
        return this.a(luaValue0);
    }

    @Override  // luaj.lib.LibFunction
    public ap a_(ap ap0) {
        return this.a(ap0.g());
    }

    @Override  // luaj.lib.LibFunction
    public final LuaValue l() {
        return this.a(OneArgFunction.u);
    }
}

