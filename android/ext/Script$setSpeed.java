package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.setSpeed extends Script.BusyApiFunction {
    final Script e;

    Script.setSpeed(Script script0) {
        this.e = script0;
        super(script0);
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.setSpeed(double speed) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        double f = ap0.m(1);
        if(f < 1.000000E-09 || f > 1000000000.0) {
            return LuaValue.m(("Speed outside range: " + f + " (" + 1.000000E-09 + "; " + 1000000000.0 + ')'));
        }
        MainService.instance.a(this.e.a(), f);
        return null;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

