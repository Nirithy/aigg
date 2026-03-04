package luaj.lib;

import luaj.LuaValue;
import luaj.ap;
import luaj.o;

final class BaseLib.print extends VarArgFunction {
    final BaseLib a;
    final BaseLib b;

    BaseLib.print(BaseLib baseLib0, BaseLib baseLib1) {
        this.b = baseLib0;
        super();
        this.a = baseLib1;
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaValue luaValue0 = this.b.a.j("tostring");
        int v = ap0.j_();
        for(int v1 = 1; true; ++v1) {
            if(v1 > v) {
                this.b.a.e.println();
                return BaseLib.print.x;
            }
            if(v1 > 1) {
                this.b.a.e.print(" \t");
            }
            LuaValue luaValue1 = luaValue0.a(ap0.c(v1));
            if(!luaValue1.J()) {
                throw new o("\'tostring\' must return a string to \'print\', got " + luaValue1.f_());
            }
            this.b.a.e.print(luaValue1.t().d_());
        }
    }
}

