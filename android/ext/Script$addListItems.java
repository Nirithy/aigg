package android.ext;

import java.util.ArrayList;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.o;
import luaj.z;

final class Script.addListItems extends Script.ApiFunction {
    final ArrayList d;
    LuaValue e;
    final Script f;

    Script.addListItems(Script script0) {
        this.f = script0;
        super();
        this.d = new ArrayList();
        this.e = null;
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.addListItems(table items) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        qx qx0;
        ap ap1;
        ArrayList arrayList0;
        try {
            arrayList0 = this.d;
            arrayList0.clear();
            LuaTable luaTable0 = ap0.t(1);
            qh qh0 = MainService.instance.ap;
            boolean z = qh0 == null ? false : qh0.n;
            z z1 = luaTable0.S();
            while(true) {
                if(!z1.a()) {
                    this.e = null;
                    Object object0 = new Object();
                    synchronized(object0) {
                        rx.a(new Script.addListItems.1(this, object0));
                        Script.a(object0);
                    }
                    ap1 = this.e;
                    break;
                }
                LuaValue luaValue0 = z1.d();
                try {
                    qx0 = Script.a(luaValue0.O(), z);
                    if(qx0 == null) {
                        continue;
                    }
                }
                catch(NumberFormatException | o numberFormatException0) {
                    throw Script.a(z1.c(), luaValue0, numberFormatException0);
                }
                arrayList0.add(qx0);
            }
        }
        catch(o o0) {
            throw o0;
        }
        catch(Throwable throwable0) {
            la.c("Failed add list items", throwable0);
            ap1 = LuaValue.m(Script.a(throwable0));
        }
        try {
            arrayList0.clear();
            arrayList0.trimToSize();
        }
        catch(Throwable throwable1) {
            la.a(throwable1);
        }
        this.e = null;
        return ap1;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

