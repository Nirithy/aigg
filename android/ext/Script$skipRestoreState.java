package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.skipRestoreState extends Script.ApiFunction {
    final Script d;

    Script.skipRestoreState(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.skipRestoreState() -> nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        this.d.q = null;
        return LuaValue.u;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

