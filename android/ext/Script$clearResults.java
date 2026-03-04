package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.clearResults extends Script.ApiFunction {
    final Script d;

    Script.clearResults(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.clearResults() -> nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        MainService.instance.a(this.d.a());
        return LuaValue.u;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

