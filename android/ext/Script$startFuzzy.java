package android.ext;

import java.io.Writer;
import luaj.LuaValue;
import luaj.ap;

final class Script.startFuzzy extends Script.BusyApiFunction {
    final Script e;

    Script.startFuzzy(Script script0) {
        this.e = script0;
        super(script0);
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.startFuzzy([int type = gg.TYPE_AUTO [, long memoryFrom = 0 [, long memoryTo = -1 [, long limit = 0]]]]) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    protected boolean a(Writer writer0, int v, LuaValue luaValue0) {
        switch(v) {
            case 1: {
                return luaValue0.h_() ? Script.startFuzzy.a(writer0, this.e.i.b, luaValue0) : super.a(writer0, 1, luaValue0);
            }
            case 2: 
            case 3: {
                return luaValue0.E() ? Script.startFuzzy.a(writer0, luaValue0) : super.a(writer0, v, luaValue0);
            }
            default: {
                return super.a(writer0, v, luaValue0);
            }
        }
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        try {
            this.e.g = false;
            return ik.a(this.e.a(), Script.b(ap0.d(1, 0x7F)), ap0.a(2, 0L), ap0.a(3, -1L), ap0.a(4, 0L)) ? LuaValue.v : null;
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

