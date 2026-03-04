package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.getResultsCount extends Script.ApiFunction {
    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getResultsCount() -> long";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        return LuaValue.d(MainService.instance.aj);
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

