package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.getLocale extends Script.ApiFunction {
    final Script d;

    Script.getLocale(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getLocale() -> string";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        return LuaValue.m(qk.a(0x7F070083).replace("~", ""));  // string:lang_code "~~~en_US~~~"
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

