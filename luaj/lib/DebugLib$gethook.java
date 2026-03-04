package luaj.lib;

import luaj.LuaValue;
import luaj.ag;
import luaj.ap;

final class DebugLib.gethook extends VarArgFunction {
    final DebugLib a;

    DebugLib.gethook(DebugLib debugLib0) {
        this.a = debugLib0;
        super();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        ag ag0 = (ap0.j_() <= 0 ? this.a.ai.h : ap0.u(1)).d;
        LuaValue luaValue0 = ag0.e == null ? DebugLib.gethook.u : ag0.e;
        StringBuilder stringBuilder0 = new StringBuilder(String.valueOf((ag0.g ? "c" : ""))).append((ag0.h ? "r" : ""));
        return ag0.f ? DebugLib.gethook.a(luaValue0, DebugLib.gethook.m(stringBuilder0.append("l").toString()), DebugLib.gethook.d(ag0.i)) : DebugLib.gethook.a(luaValue0, DebugLib.gethook.m(stringBuilder0.append("").toString()), DebugLib.gethook.d(ag0.i));
    }
}

