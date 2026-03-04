package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.copyText extends Script.ApiFunction {
    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.copyText(string text [, bool fixLocale = true]) -> nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        String s = ap0.r(1);
        if(ap0.a(2, true)) {
            s = Script.a(s);
        }
        Tools.a(qk.a(s));
        return LuaValue.u;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 2;
    }
}

