package luaj.lib;

import java.io.InputStream;
import luaj.LuaString;
import luaj.LuaValue;
import luaj.ap;

final class BaseLib.load extends VarArgFunction {
    final BaseLib a;

    BaseLib.load(BaseLib baseLib0) {
        this.a = baseLib0;
        super();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaValue luaValue0 = ap0.g();
        if(!luaValue0.J() && !luaValue0.B()) {
            BaseLib.load.a(1, "load", "string or function expected, got " + luaValue0.f_());
        }
        String s = ap0.c(2, (luaValue0.J() ? luaValue0.d_() : "=(load)"));
        String s1 = ap0.c(3, "bt");
        LuaValue luaValue1 = ap0.d(4, this.a.a);
        LuaString luaString0 = luaValue0.J() ? luaValue0.t() : null;
        InputStream inputStream0 = luaString0 == null ? new d(luaValue0.C()) : luaString0.r_();
        if(this.a.c != null) {
            inputStream0 = this.a.a(luaString0, null, false, inputStream0);
        }
        return this.a.a(inputStream0, s, s1, luaValue1);
    }
}

