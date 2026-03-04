package luaj.lib;

import luaj.LuaFunction;
import luaj.LuaThread;
import luaj.ap;

final class DebugLib.sethook extends VarArgFunction {
    final DebugLib a;

    DebugLib.sethook(DebugLib debugLib0) {
        this.a = debugLib0;
        super();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        boolean z3;
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
        LuaFunction luaFunction0 = ap0.a(v, null);
        String s = ap0.c(v + 1, "");
        int v1 = ap0.d(v + 2, 0);
        int v2 = 0;
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        while(v2 < s.length()) {
            switch(s.charAt(v2)) {
                case 99: {
                    z3 = z;
                    z2 = true;
                    break;
                }
                case 108: {
                    z3 = z;
                    z1 = true;
                    break;
                }
                case 0x72: {
                    z3 = true;
                    break;
                }
                default: {
                    z3 = z;
                }
            }
            ++v2;
            z = z3;
        }
        luaThread0.d.e = luaFunction0;
        luaThread0.d.g = z2;
        luaThread0.d.f = z1;
        luaThread0.d.i = v1;
        luaThread0.d.h = z;
        this.a.T().a(luaThread0.d);
        return DebugLib.sethook.x;
    }
}

