package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.toast extends Script.ApiFunction {
    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.toast(string text [, bool fast = false]) -> nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        rx.a(new Script.toast.1(this, Tools.c(0x7F07021A) + ": " + ap0.r(1), ap0.a(2, false)));  // string:script "Script:"
        return LuaValue.u;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 2;
    }
}

