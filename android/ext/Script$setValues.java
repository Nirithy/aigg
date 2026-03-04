package android.ext;

import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.z;

final class Script.setValues extends Script.ApiFunction {
    final Script d;

    Script.setValues(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.setValues(table values) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        d d0;
        LuaTable luaTable0 = ap0.t(1);
        MainService mainService0 = MainService.instance;
        boolean z = mainService0.ap == null ? false : mainService0.ap.n;
        ex ex0 = mainService0.k;
        LuaString luaString0 = Script.n[1];
        z z1 = luaTable0.S();
        while(true) {
            if(!z1.a()) {
                mainService0.k.g(this.d.a());
                Object object0 = new Object();
                synchronized(object0) {
                    rx.a(new Script.setValues.1(this, object0));
                    Script.a(object0);
                    return LuaValue.v;
                }
            }
            LuaTable luaTable1 = z1.d().O();
            try {
                d0 = Script.a(null, luaTable1, 1, z);
                d0.d &= 0x7F;
                if(d0.d == 0) {
                    continue;
                }
            }
            catch(NumberFormatException numberFormatException0) {
                throw Script.a(z1.c(), luaTable1, numberFormatException0);
            }
            rd rd0 = ra.a(Script.a(Script.c(luaTable1, luaString0)), false);
            ex0.a(d0, (rd0 == null ? 0 : rd0.b));
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

