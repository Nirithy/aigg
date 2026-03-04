package android.ext;

import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.z;

final class Script.getValuesRange extends Script.ApiFunction {
    final Script d;

    Script.getValuesRange(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getValuesRange(table values) -> table || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        LuaTable luaTable0 = ap0.t(1);
        ap ap1 = new LuaTable();
        ((LuaTable)ap1).a(luaTable0.P(), ((LuaTable)ap1).o_());
        LuaString luaString0 = Script.n[0];
        z z0 = luaTable0.S();
        while(z0.a()) {
            LuaValue luaValue0 = z0.d();
            long v = luaValue0.N() ? Script.b(luaValue0.O(), luaString0) : luaValue0.w();
            int v1 = z0.b();
            if(v1 == 0) {
                ((LuaTable)ap1).c(z0.c(), LuaValue.m(RegionList.a(v).toString()));
            }
            else {
                ((LuaTable)ap1).b(v1, LuaValue.m(RegionList.a(v).toString()));
            }
        }
        return ap1;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

