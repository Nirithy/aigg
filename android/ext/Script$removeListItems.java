package android.ext;

import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.o;
import luaj.z;

final class Script.removeListItems extends Script.ApiFunction {
    final Script d;

    Script.removeListItems(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.removeListItems(table items) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        try {
            LuaTable luaTable0 = ap0.t(1);
            luaTable0.M();
            long[] arr_v = new long[luaTable0.P() + luaTable0.X()];
            LuaString luaString0 = Script.n[0];
            z z0 = luaTable0.S();
            for(int v = 0; true; ++v) {
                if(!z0.a()) {
                    Object object0 = new Object();
                    synchronized(object0) {
                        rx.a(new Script.removeListItems.1(this, arr_v, v, object0));
                        Script.a(object0);
                        return LuaValue.v;
                    }
                }
                LuaValue luaValue0 = z0.d();
                arr_v[v] = luaValue0.N() ? Script.b(((LuaTable)luaValue0), luaString0) : luaValue0.w();
            }
        }
        catch(o o0) {
            throw o0;
        }
        catch(Throwable throwable0) {
            la.c("Failed remove list items", throwable0);
            return LuaValue.m(Script.a(throwable0));
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

