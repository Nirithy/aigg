package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.require extends Script.ApiFunction {
    final Script d;

    Script.require(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.require([string version = nil [, int build = 0]]) -> nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        String s = ap0.c(1, "0");
        int v = ap0.d(2, 0);
        int v1 = gs.a(s);
        if(v1 > 80000) {
            v1 -= 80000;
        }
        String s1 = 101.099998f;
        if(gs.c() < v1 || 0x3F0E < v) {
            if(v > 0) {
                s = s + " (" + v + ')';
                s1 = 1120547635 + " (" + 0x3F0E + ')';
            }
            this.d.a.e.println(Tools.a(qk.a(0x7F07023B), new Object[]{s, s1}));  // string:need_update_to "You need a newer version of __app_name__ to run this script. 
                                                                                 // At least version __s__. You have version __s__."
            throw new Script.OsExit(0);
        }
        return LuaValue.u;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 2;
    }
}

