package android.ext;

import java.util.regex.Pattern;
import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;

final class Script.getRangesList extends Script.ApiFunction {
    final Script d;

    Script.getRangesList(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getRangesList([string filter = \'\']) -> table";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        String s = ap0.c(1, "");
        if(s.length() > 0) {
            s = Tools.l(s);
        }
        ap ap1 = new LuaTable();
        Pattern pattern0 = null;
        if(s.length() > 0) {
            try {
                pattern0 = Pattern.compile(s);
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
            }
        }
        LuaString luaString0 = LuaString.c("state");
        LuaString luaString1 = LuaString.c("start");
        LuaString luaString2 = LuaString.c("end");
        LuaString luaString3 = LuaString.c("type");
        LuaString luaString4 = LuaString.c("name");
        LuaString luaString5 = LuaString.c("internalName");
        int v = 1;
        for(Object object0: RegionList.getList()) {
            qs qs0 = (qs)object0;
            String s1 = qs0.d();
            if(pattern0 == null || pattern0.matcher(s1).find()) {
                LuaTable luaTable0 = new LuaTable(0, 6);
                luaTable0.c(luaString0, LuaValue.m(qs0.b().toString()));
                luaTable0.c(luaString1, LuaValue.d(qs0.b));
                luaTable0.c(luaString2, LuaValue.d(qs0.c));
                luaTable0.c(luaString3, LuaValue.m(qs0.a()));
                luaTable0.c(luaString4, LuaValue.m(qs0.c()));
                luaTable0.c(luaString5, LuaValue.m(s1));
                ((LuaTable)ap1).a(v, luaTable0);
                ++v;
            }
        }
        return ap1;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 1;
    }
}

