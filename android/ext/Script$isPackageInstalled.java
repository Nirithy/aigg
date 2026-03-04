package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.isPackageInstalled extends Script.ApiFunction {
    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.isPackageInstalled(string pkg) -> bool";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        return LuaValue.b(Tools.e(ap0.r(1)));
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

