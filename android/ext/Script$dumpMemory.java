package android.ext;

import java.io.Writer;
import luaj.LuaValue;
import luaj.ap;

final class Script.dumpMemory extends Script.BusyApiFunction {
    final Script e;

    Script.dumpMemory(Script script0) {
        this.e = script0;
        super(script0);
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.dumpMemory(long from, long to, string dir [, int flags = nil]) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    protected boolean a(Writer writer0, int v, LuaValue luaValue0) {
        switch(v) {
            case 1: 
            case 2: {
                return luaValue0.E() ? Script.dumpMemory.a(writer0, luaValue0) : super.a(writer0, v, luaValue0);
            }
            case 4: {
                return luaValue0.h_() ? Script.dumpMemory.a(writer0, this.e.i.i, luaValue0) : super.a(writer0, 4, luaValue0);
            }
            default: {
                return super.a(writer0, v, luaValue0);
            }
        }
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        MainService mainService0 = MainService.instance;
        String s = mainService0.ap == null ? "unknown" : mainService0.ap.c;
        if(mainService0.S()) {
            mainService0.k.a(this.e.a(), ap0.p(1), ap0.p(2), ap0.d(4, 0), ap0.r(3), s);
            return null;
        }
        return LuaValue.m(qk.a(0x7F070222));  // string:busy_dialog_fail "The progress dialog could not be displayed."
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 4;
    }
}

