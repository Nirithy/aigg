package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.getActiveTab extends Script.ApiFunction {
    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getActiveTab() -> int";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        return LuaValue.d(MainService.instance.r());
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

