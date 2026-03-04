package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.gotoAddress extends Script.ApiFunction {
    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.gotoAddress(long address) -> nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        MainService.instance.b(ap0.p(1));
        return LuaValue.u;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

