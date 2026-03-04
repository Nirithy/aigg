package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.clearList extends Script.ApiFunction {
    final Script d;

    Script.clearList(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.clearList() -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        try {
            MainService.instance.an.c();
            return LuaValue.v;
        }
        catch(Throwable throwable0) {
            la.c("Failed clear list", throwable0);
            return LuaValue.m(Script.a(throwable0));
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

