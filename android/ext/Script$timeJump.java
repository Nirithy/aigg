package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.timeJump extends Script.BusyApiFunction {
    final Script e;

    Script.timeJump(Script script0) {
        this.e = script0;
        super(script0);
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.timeJump(string time) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        try {
            long v = rz.a(Script.a(ap0.r(1)));
            MainService.instance.k.a(this.e.a(), v);
            return null;
        }
        catch(NumberFormatException numberFormatException0) {
            return LuaValue.m(Script.a(numberFormatException0));
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

