package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.getTargetPackage extends Script.ApiFunction {
    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getTargetPackage() -> string || nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        String s = null;
        qh qh0 = MainService.instance.ap;
        if(qh0 != null) {
            s = qh0.c;
        }
        return s == null ? LuaValue.u : LuaValue.m(s);
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

