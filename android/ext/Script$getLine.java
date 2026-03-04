package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.getLine extends Script.DebugFunction {
    final Script e;

    Script.getLine(Script script0) {
        this.e = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getLine() -> int";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        return LuaValue.d((this.d == null || this.d.a == null || this.d.a.t == null || this.d.e < 0 || this.d.e >= this.d.a.t.length ? -1 : this.d.a.t[this.d.e]));
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

