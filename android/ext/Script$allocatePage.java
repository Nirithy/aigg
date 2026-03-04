package android.ext;

import java.io.Writer;
import luaj.LuaValue;
import luaj.ap;

final class Script.allocatePage extends Script.BusyApiFunction {
    final Script e;

    Script.allocatePage(Script script0) {
        this.e = script0;
        super(script0);
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.allocatePage([int mode = gg.PROT_READ | gg.PROT_EXEC [, long address = 0]) -> long || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    protected boolean a(Writer writer0, int v, LuaValue luaValue0) {
        switch(v) {
            case 1: {
                return luaValue0.h_() ? Script.allocatePage.a(writer0, this.e.i.g, luaValue0) : super.a(writer0, 1, luaValue0);
            }
            case 2: {
                return luaValue0.E() ? Script.allocatePage.a(writer0, luaValue0) : super.a(writer0, 2, luaValue0);
            }
            default: {
                return super.a(writer0, v, luaValue0);
            }
        }
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        int v = ap0.d(1, 6);
        long v1 = ap0.a(2, 0L);
        Script.m = 0L;
        MainService.instance.k.b(this.e.a(), v1, v);
        return null;
    }

    @Override  // android.ext.Script$ApiFunction
    protected ap f() {
        long v = Script.m;
        return 0xFFFFFFFFFFFFFC00L < v && v <= 0L ? LuaValue.m((qk.a(0x7F0702DB) + ' ' + -v)) : LuaValue.d(Script.m);  // string:allocate_fail "Could not allocate memory page. Error"
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 2;
    }
}

