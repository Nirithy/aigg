package android.ext;

import java.io.Writer;
import luaj.LuaValue;
import luaj.ap;

class Script.searchNumber extends Script.BusyApiFunction {
    final Script f;

    Script.searchNumber(Script script0) {
        this.f = script0;
        super(script0);
    }

    // 去混淆评级： 低(30)
    @Override  // android.ext.Script$ApiFunction
    final String a() {
        return this instanceof Script.refineNumber ? "gg.refineNumber(string text [, int type = gg.TYPE_AUTO [, bool encrypted = false [, int sign = gg.SIGN_EQUAL [, long memoryFrom = 0 [, long memoryTo = -1 [, long limit = 0]]]]]]) -> true || string with error" : "gg.searchNumber(string text [, int type = gg.TYPE_AUTO [, bool encrypted = false [, int sign = gg.SIGN_EQUAL [, long memoryFrom = 0 [, long memoryTo = -1 [, long limit = 0]]]]]]) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    protected final boolean a(Writer writer0, int v, LuaValue luaValue0) {
        switch(v) {
            case 2: {
                return luaValue0.h_() ? Script.searchNumber.a(writer0, this.f.i.b, luaValue0) : super.a(writer0, 2, luaValue0);
            }
            case 4: {
                return luaValue0.h_() ? Script.searchNumber.a(writer0, this.f.i.d, luaValue0) : super.a(writer0, 4, luaValue0);
            }
            case 5: 
            case 6: {
                return luaValue0.E() ? Script.searchNumber.a(writer0, luaValue0) : super.a(writer0, v, luaValue0);
            }
            default: {
                return super.a(writer0, v, luaValue0);
            }
        }
    }

    @Override  // android.ext.Script$ApiFunction
    public final ap d(ap ap0) {
        this.f.g = false;
        if(this instanceof Script.refineNumber && MainService.instance.aj == 0L) {
            return Script.searchNumber.v;
        }
        try {
            return ra.a(this.f.a(), Script.a(ap0.r(1)), Script.b(ap0.d(2, 0x7F)), ap0.a(3, false), Script.a(ap0.d(4, 0x20000000)), ap0.a(5, 0L), ap0.a(6, -1L), ((byte)false), ap0.a(7, 0L)) ? LuaValue.v : null;
        }
        catch(NumberFormatException numberFormatException0) {
            return LuaValue.m(Script.a(numberFormatException0));
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected final int m_() {
        return 7;
    }
}

