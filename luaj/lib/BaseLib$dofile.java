package luaj.lib;

import luaj.LuaValue;
import luaj.ap;

final class BaseLib.dofile extends VarArgFunction {
    final BaseLib a;

    BaseLib.dofile(BaseLib baseLib0) {
        this.a = baseLib0;
        super();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaValue luaValue0 = ap0.g();
        if(!luaValue0.J() && !luaValue0.F()) {
            BaseLib.dofile.a(1, "dofile", "string expected, got " + luaValue0.f_());
        }
        String s = luaValue0.y();
        ap ap1 = this.a.a(s, "bt", this.a.a);
        return ap1.f(1) ? BaseLib.dofile.f(ap1.y(2)) : ap1.g().Y();
    }
}

