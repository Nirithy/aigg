package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.isVisible extends Script.ApiFunction {
    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.isVisible() -> bool";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        return MainService.instance.p == null ? LuaValue.b(false) : LuaValue.b(true);
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

