package luaj.lib;

import luaj.LuaValue;
import luaj.ap;

public abstract class ZeroArgFunction extends LibFunction {
    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0) {
        return this.l();
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        return this.l();
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2) {
        return this.l();
    }

    @Override  // luaj.lib.LibFunction
    public ap a_(ap ap0) {
        return this.l();
    }

    @Override  // luaj.lib.LibFunction
    public abstract LuaValue l();
}

