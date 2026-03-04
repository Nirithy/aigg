package android.ext;

import luaj.LuaValue;
import luaj.ap;

final class Script.searchPointer extends Script.BusyApiFunction {
    final Script e;

    Script.searchPointer(Script script0) {
        this.e = script0;
        super(script0);
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.searchPointer(int maxOffset [, long memoryFrom = 0 [, long memoryTo = -1 [, long limit = 0]]]) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        try {
            this.e.g = false;
            int v = (short)ap0.o(1);
            return ra.a(this.e.a(), ((short)v), ap0.a(2, 0L), ap0.a(3, -1L), ap0.a(4, 0L)) ? LuaValue.v : null;
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

