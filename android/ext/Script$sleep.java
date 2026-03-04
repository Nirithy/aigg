package android.ext;

import luaj.LuaValue;
import luaj.ap;
import luaj.o;

final class Script.sleep extends Script.ApiFunction {
    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.sleep(int milliseconds) -> nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        int v = ap0.o(1);
        if(v < 0) {
            throw new o("milliseconds < 0: " + v);
        }
        try {
            Thread.sleep(v);
            return LuaValue.u;
        }
        catch(InterruptedException interruptedException0) {
            la.b("Interrupted sleep", interruptedException0);
            throw new o(interruptedException0);
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

