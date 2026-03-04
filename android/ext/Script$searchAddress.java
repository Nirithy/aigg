package android.ext;

import java.io.Writer;
import luaj.LuaValue;
import luaj.ap;

class Script.searchAddress extends Script.BusyApiFunction {
    final Script f;

    Script.searchAddress(Script script0) {
        this.f = script0;
        super(script0);
    }

    // 去混淆评级： 低(30)
    @Override  // android.ext.Script$ApiFunction
    final String a() {
        return this instanceof Script.refineAddress ? "gg.refineAddress(string text [, long mask = -1 [, int type = gg.TYPE_AUTO [, int sign = gg.SIGN_EQUAL [, long memoryFrom = 0 [, long memoryTo = -1 [, long limit = 0]]]]]]) -> true || string with error" : "gg.searchAddress(string text [, long mask = -1 [, int type = gg.TYPE_AUTO [, int sign = gg.SIGN_EQUAL [, long memoryFrom = 0 [, long memoryTo = -1 [, long limit = 0]]]]]]) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    protected final boolean a(Writer writer0, int v, LuaValue luaValue0) {
        switch(v) {
            case 3: {
                return luaValue0.h_() ? Script.searchAddress.a(writer0, this.f.i.b, luaValue0) : super.a(writer0, 3, luaValue0);
            }
            case 4: {
                return luaValue0.h_() ? Script.searchAddress.a(writer0, this.f.i.d, luaValue0) : super.a(writer0, 4, luaValue0);
            }
            case 2: 
            case 5: 
            case 6: {
                return luaValue0.E() ? Script.searchAddress.a(writer0, luaValue0) : super.a(writer0, v, luaValue0);
            }
            default: {
                return super.a(writer0, v, luaValue0);
            }
        }
    }

    @Override  // android.ext.Script$ApiFunction
    public final ap d(ap ap0) {
        this.f.g = false;
        if(this instanceof Script.refineAddress && MainService.instance.aj == 0L) {
            return Script.searchAddress.v;
        }
        try {
            return ov.a(this.f.a(), Script.a(ap0.r(1)), ap0.a(2, -1L), Script.b(ap0.d(3, 0x7F)), Script.a(ap0.d(4, 0x20000000)), ap0.a(5, 0L), ap0.a(6, -1L), ((byte)false), ap0.a(7, 0L)) ? LuaValue.v : null;
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

