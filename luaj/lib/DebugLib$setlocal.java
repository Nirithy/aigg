package luaj.lib;

import luaj.LuaThread;
import luaj.LuaValue;
import luaj.ap;

final class DebugLib.setlocal extends VarArgFunction {
    final DebugLib a;

    DebugLib.setlocal(DebugLib debugLib0) {
        this.a = debugLib0;
        super();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        int v4;
        LuaThread luaThread0;
        int v;
        if(ap0.j(1)) {
            v = 2;
            luaThread0 = ap0.u(1);
        }
        else {
            luaThread0 = this.a.ai.h;
            v = 1;
        }
        int v1 = ap0.o(v);
        int v2 = ap0.o(v + 1);
        LuaValue luaValue0 = ap0.c(v + 2);
        f f0 = this.a.a(luaThread0);
        int v3 = f0.c;
        if(f0.a(1).a == this) {
            v4 = v1 + 1;
            --v3;
        }
        else {
            v4 = v1;
        }
        e e0 = f0.a(v4);
        return e0 != null ? e0.a(v2, luaValue0) : DebugLib.setlocal.a(v, "debug.setlocal", "level out of range: " + v4 + " not between 1 and " + v3);
    }
}

