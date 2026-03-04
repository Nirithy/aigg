package luaj.lib;

import luaj.LuaValue;
import luaj.ap;

final class BaseLib.loadfile extends VarArgFunction {
    final BaseLib a;

    BaseLib.loadfile(BaseLib baseLib0) {
        this.a = baseLib0;
        super();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaValue luaValue0 = ap0.g();
        if(!luaValue0.J() && !luaValue0.F()) {
            BaseLib.loadfile.a(1, "loadfile", "string expected, got " + luaValue0.f_());
        }
        String s = luaValue0.y();
        String s1 = ap0.c(2, "bt");
        LuaValue luaValue1 = ap0.d(3, this.a.a);
        return this.a.a(s, s1, luaValue1);
    }
}

