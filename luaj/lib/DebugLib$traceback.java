package luaj.lib;

import luaj.LuaThread;
import luaj.LuaValue;
import luaj.ap;

final class DebugLib.traceback extends VarArgFunction {
    final DebugLib a;

    DebugLib.traceback(DebugLib debugLib0) {
        this.a = debugLib0;
        super();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
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
        LuaValue luaValue0 = ap0.c(v);
        if(!luaValue0.J() && !luaValue0.F()) {
            return luaValue0;
        }
        int v1 = ap0.d(v + 1, 1);
        f f0 = this.a.a(luaThread0);
        int v2 = f0.a(1).a == this ? v1 + 1 : v1;
        String s = f0.a(this.a.ai, v2);
        if(luaValue0.J()) {
            s = luaValue0.d_() + '\n' + s;
        }
        return DebugLib.traceback.m(s);
    }
}

