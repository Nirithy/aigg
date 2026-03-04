package luaj.lib;

import luaj.LuaValue;
import luaj.ap;

final class BaseLib.assert2 extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        String s;
        LuaValue luaValue0 = ap0.c(1);
        LuaValue luaValue1 = ap0.c(2);
        if(!luaValue0.b(luaValue1)) {
            if(luaValue0.u().equals(luaValue1.u())) {
                s = luaValue0.f_().equals(luaValue1.f_()) ? luaValue0 + " {" + luaValue0.getClass() + "} ~= " + luaValue1 + " {" + luaValue1.getClass() + "}" : luaValue0 + " [" + luaValue0.f_() + "] ~= " + luaValue1 + " [" + luaValue1.f_() + "]";
            }
            else {
                s = luaValue0 + " ~= " + luaValue1;
            }
            BaseLib.assert2.f((s + ": " + ap0.c(3, "assertion failed!")));
        }
        return ap0;
    }
}

