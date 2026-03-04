package android.ext;

import luaj.LuaValue;
import luaj.ap;
import luaj.lib.VarArgFunction;

final class Script.format extends VarArgFunction {
    final LuaValue a;

    public Script.format(LuaValue luaValue0) {
        this.a = luaValue0;
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        ap ap1 = LuaValue.b(LuaValue.m(qk.a(ap0.r(1)).replace("%,d", "%d")), ap0.e_(2));
        return this.a.a_(ap1);
    }
}

