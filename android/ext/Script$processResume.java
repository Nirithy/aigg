package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.processResume extends Script.ApiFunction {
    final Script d;

    Script.processResume(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.processResume() -> bool";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        return LuaValue.b(MainService.instance.c(this.d.a()));
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

