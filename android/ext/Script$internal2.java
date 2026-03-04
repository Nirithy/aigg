package android.ext;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import luaj.LuaClosure;
import luaj.LuaValue;
import luaj.aj;
import luaj.ap;

final class Script.internal2 extends Script.ApiFunction {
    final Script d;

    Script.internal2(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "do not use";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        LuaClosure luaClosure0 = ap0.l(1);
        String s = ap0.r(2);
        ap ap1 = LuaValue.v;
        PrintStream printStream0 = aj.b;
        try {
            aj.b = new PrintStream(new BufferedOutputStream(new FileOutputStream(s), 0x10000));
            aj.a(luaClosure0.a);
            aj.b.close();
            aj.a(luaClosure0, s + ".tail");
        }
        catch(Throwable throwable0) {
            la.c(("Failed dump " + luaClosure0 + " into \'" + s + '\''), throwable0);
            ap1 = LuaValue.m(Script.a(throwable0));
        }
        aj.b = printStream0;
        return ap1;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 2;
    }
}

