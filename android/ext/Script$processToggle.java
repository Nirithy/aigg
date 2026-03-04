package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.processToggle extends Script.ApiFunction {
    final Script d;

    Script.processToggle(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.processToggle() -> bool";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        return LuaValue.b(MainService.instance.b(this.d.a(), true));
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

