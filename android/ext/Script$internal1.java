package android.ext;

import luaj.LuaString;
import luaj.LuaValue;
import luaj.ap;

final class Script.internal1 extends Script.BusyApiFunction {
    final Script e;

    Script.internal1(Script script0) {
        this.e = script0;
        super(script0);
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "do not use";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        try {
            int v = 2;
            this.e.g = false;
            LuaString luaString0 = ap0.s(1);
            byte[] arr_b = new byte[luaString0.d];
            luaString0.a(0, arr_b, 0, luaString0.d);
            if(ap0.a(4, 1L) != 2L) {
                v = 1;
            }
            return ra.a(this.e.a(), v, arr_b, ap0.a(2, 0L), ap0.a(3, -1L), ((byte)false), ap0.a(4, 0L)) ? LuaValue.v : null;
        }
        catch(NumberFormatException numberFormatException0) {
            return LuaValue.m(Script.a(numberFormatException0));
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 4;
    }
}

