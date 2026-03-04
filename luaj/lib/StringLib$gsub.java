package luaj.lib;

import luaj.LuaString;
import luaj.LuaValue;
import luaj.a;
import luaj.ap;

final class StringLib.gsub extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        int v7;
        int v6;
        LuaString luaString0 = ap0.s(1);
        int v = luaString0.L();
        LuaString luaString1 = ap0.s(2);
        int v1 = -1;
        LuaValue luaValue0 = ap0.c(3);
        int v2 = ap0.d(4, v + 1);
        boolean z = luaString1.L() > 0 && luaString1.f_(0) == 94;
        a a0 = new a(v);
        l l0 = new l(ap0, luaString0, luaString1);
        int v3 = 0;
        int v4 = 0;
        while(true) {
            if(v4 < v2) {
                l0.a();
                int v5 = l0.b(v3, (z ? 1 : 0));
                if(v5 != -1 && v5 != v1) {
                    v6 = v4 + 1;
                    l0.a(a0, v3, v5, luaValue0);
                    v3 = v5;
                    v1 = v5;
                    goto label_24;
                }
                else if(v3 < v) {
                    a0.a(((byte)luaString0.b(v3)));
                    v6 = v4;
                    ++v3;
                label_24:
                    if(z) {
                        v7 = v6;
                        break;
                    }
                    v4 = v6;
                    continue;
                }
            }
            v7 = v4;
            break;
        }
        a0.a(luaString0.a(v3, v));
        return StringLib.gsub.b(a0.b(), StringLib.gsub.d(v7));
    }
}

