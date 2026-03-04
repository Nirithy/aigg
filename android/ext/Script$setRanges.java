package android.ext;

import java.io.Writer;
import luaj.LuaValue;
import luaj.ap;

final class Script.setRanges extends Script.ApiFunction {
    final Script d;

    Script.setRanges(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.setRanges(int ranges) -> nil";
    }

    @Override  // android.ext.Script$ApiFunction
    protected boolean a(Writer writer0, int v, LuaValue luaValue0) {
        if(v != 1) {
            return super.a(writer0, v, luaValue0);
        }
        return luaValue0.h_() ? Script.setRanges.a(writer0, this.d.i.a, luaValue0) : super.a(writer0, 1, luaValue0);
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        Config.a(0x7F0B0081).d = ap0.o(1);  // id:config_ranges
        Config.c();
        return LuaValue.u;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

