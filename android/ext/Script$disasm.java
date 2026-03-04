package android.ext;

import java.io.Writer;
import luaj.LuaString;
import luaj.LuaValue;
import luaj.ap;

final class Script.disasm extends Script.ApiFunction {
    final Script d;

    Script.disasm(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.disasm(int type, long address, int opcode) -> string";
    }

    @Override  // android.ext.Script$ApiFunction
    protected boolean a(Writer writer0, int v, LuaValue luaValue0) {
        switch(v) {
            case 1: {
                return luaValue0.h_() ? Script.disasm.a(writer0, this.d.i.j, luaValue0) : super.a(writer0, 1, luaValue0);
            }
            case 2: 
            case 3: {
                return luaValue0.E() ? Script.disasm.a(writer0, luaValue0) : super.a(writer0, v, luaValue0);
            }
            default: {
                return super.a(writer0, v, luaValue0);
            }
        }
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        long v = ap0.p(2);
        int v1 = ap0.o(3);
        switch(ap0.o(1)) {
            case 4: {
                return LuaString.c(ai.a(new ai(), v, ((long)v1)));
            }
            case 5: {
                return LuaString.c(ai.b(new ai(), v, ((long)v1)));
            }
            case 6: {
                StringBuilder stringBuilder0 = new StringBuilder();
                ag.a(ag.a(), v, v1, stringBuilder0);
                return LuaString.c(stringBuilder0.toString());
            }
            default: {
                return Script.disasm.a(1, "gg.disasm", "unknown type: " + ap0.o(1));
            }
        }
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 3;
    }
}

