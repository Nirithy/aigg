package android.ext;

import luaj.ap;
import luaj.lib.GgLib.saveVariable;

final class Script.saveVariable extends Script.ApiFunction {
    final Script d;

    Script.saveVariable(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.saveVariable(mixed variable, string filename) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        return new GgLib.saveVariable(this.d.a).a_(ap0);
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 2;
    }
}

