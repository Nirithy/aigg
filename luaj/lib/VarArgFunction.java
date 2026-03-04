package luaj.lib;

import luaj.LuaValue;
import luaj.ap;

public abstract class VarArgFunction extends LibFunction {
    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0) {
        return this.a_(luaValue0).g();
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        return this.a_(VarArgFunction.b(luaValue0, luaValue1)).g();
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2) {
        return this.a_(VarArgFunction.a(luaValue0, luaValue1, luaValue2)).g();
    }

    @Override  // luaj.lib.LibFunction
    public ap a_(ap ap0) {
        return this.a(ap0, false).b();
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue l() {
        return this.a_(VarArgFunction.x).g();
    }
}

