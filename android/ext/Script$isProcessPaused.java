package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.isProcessPaused extends Script.ApiFunction {
    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.isProcessPaused() -> bool";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        return LuaValue.b(MainService.instance.N);
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

