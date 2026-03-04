package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.numberToLocale extends Script.ApiFunction {
    final Script d;

    Script.numberToLocale(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.numberToLocale(string num) -> string";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        return LuaValue.m(Script.a(ap0.y(1)));
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

