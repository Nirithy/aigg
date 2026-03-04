package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.getRanges extends Script.ApiFunction {
    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getRanges() -> int";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        return LuaValue.d(Config.i);
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

