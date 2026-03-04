package android.ext;

import java.util.ArrayList;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.o;

final class Script.getListItems extends Script.ApiFunction {
    final Script d;

    Script.getListItems(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getListItems() -> table || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        try {
            ArrayList arrayList0 = new ArrayList(MainService.instance.an.getCount());
            Object object0 = new Object();
            synchronized(object0) {
                rx.a(new Script.getListItems.1(this, arrayList0, object0));
                Script.a(object0);
            }
            LuaTable luaTable0 = new LuaTable();
            luaTable0.d_(arrayList0.size());
            int v1 = 1;
            for(Object object1: arrayList0) {
                qx qx0 = (qx)object1;
                if(qx0 != null) {
                    luaTable0.b(v1, Script.a(qx0));
                    ++v1;
                }
            }
            return luaTable0;
        }
        catch(o o0) {
            throw o0;
        }
        catch(Throwable throwable0) {
            la.c("Failed get list items", throwable0);
            return LuaValue.m(Script.a(throwable0));
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

