package android.ext;

import java.io.Writer;
import luaj.LuaValue;
import luaj.ap;

final class Script.searchFuzzy extends Script.BusyApiFunction {
    final Script e;

    Script.searchFuzzy(Script script0) {
        this.e = script0;
        super(script0);
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.searchFuzzy([string difference = \'0\' [, int sign = gg.SIGN_FUZZY_EQUAL [, int type = gg.TYPE_AUTO [, long memoryFrom = 0 [, long memoryTo = -1 [, long limit = 0]]]]]]) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    protected boolean a(Writer writer0, int v, LuaValue luaValue0) {
        switch(v) {
            case 2: {
                return luaValue0.h_() ? Script.searchFuzzy.a(writer0, this.e.i.c, luaValue0) : super.a(writer0, 2, luaValue0);
            }
            case 3: {
                return luaValue0.h_() ? Script.searchFuzzy.a(writer0, this.e.i.b, luaValue0) : super.a(writer0, 3, luaValue0);
            }
            case 4: 
            case 5: {
                return luaValue0.E() ? Script.searchFuzzy.a(writer0, luaValue0) : super.a(writer0, v, luaValue0);
            }
            default: {
                return super.a(writer0, v, luaValue0);
            }
        }
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        int v1;
        int v;
        try {
            this.e.g = false;
            if((ap0.d(2, 0) & 0x7F) == 0) {
                v = Script.b(ap0.d(3, 0x7F));
                v1 = Script.a(ap0.d(2, 0x20000000));
            }
            else {
                v = Script.b(ap0.d(2, 0x7F));
                v1 = Script.a(ap0.d(3, 0x20000000));
            }
            return ik.a(this.e.a(), Script.a(ap0.c(1, "0")), v, v1, ((byte)1), ap0.a(4, 0L), ap0.a(5, -1L), ap0.a(6, 0L)) ? LuaValue.v : null;
        }
        catch(NumberFormatException numberFormatException0) {
            return LuaValue.m(Script.a(numberFormatException0));
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 6;
    }
}

