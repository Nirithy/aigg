package android.ext;

import java.io.Writer;
import java.util.ArrayList;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.o;

final class Script.getResults extends Script.BusyApiFunction {
    final Script e;

    Script.getResults(Script script0) {
        this.e = script0;
        super(script0);
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getResults(int maxCount [, int skip = 0 [, long addressMin = nil [, long addressMax = nil [, string valueMin = nil [, string valueMax = nil [, int type = nil [, string fractional = nil [, int pointer = nil]]]]]]]]) -> table || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    protected boolean a(Writer writer0, int v, LuaValue luaValue0) {
        switch(v) {
            case 7: {
                return luaValue0.h_() ? Script.getResults.a(writer0, this.e.i.b, luaValue0) : super.a(writer0, 7, luaValue0);
            }
            case 9: {
                return luaValue0.h_() ? Script.getResults.a(writer0, this.e.i.h, luaValue0) : super.a(writer0, 9, luaValue0);
            }
            default: {
                return super.a(writer0, v, luaValue0);
            }
        }
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        int v = ap0.o(1);
        int v1 = ap0.d(2, 0);
        try {
            el el0 = ek.a(ap0.a(3, 0L), ap0.a(4, -1L), ap0.c(5, null), ap0.c(6, null), ap0.d(7, 0), ap0.c(8, null), ap0.d(9, 0));
            ek.a(this.e.a(), v, v1, el0);
            return null;
        }
        catch(o o0) {
            throw o0;
        }
        catch(Throwable throwable0) {
            return LuaValue.m(Script.a(throwable0));
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected ap f() {
        this.e.g = true;
        ap ap0 = new LuaTable();
        ArrayList arrayList0 = new ArrayList(MainService.instance.am.b());
        Object object0 = new Object();
        synchronized(object0) {
            rx.a(new Script.getResults.1(this, arrayList0, object0));
            Script.a(object0);
        }
        ((LuaTable)ap0).d_(arrayList0.size());
        int v1 = 1;
        for(Object object1: arrayList0) {
            d d0 = (d)object1;
            if(d0 != null) {
                ((LuaTable)ap0).b(v1, Script.b(null, d0));
                ++v1;
            }
        }
        return ap0;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 9;
    }
}

