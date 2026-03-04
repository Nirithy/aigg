package android.ext;

import java.io.Writer;
import luaj.LuaValue;
import luaj.ap;

final class Script.copyMemory extends Script.BusyApiFunction {
    final Script e;

    Script.copyMemory(Script script0) {
        this.e = script0;
        super(script0);
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.copyMemory(long from, long to, int bytes) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    protected boolean a(Writer writer0, int v, LuaValue luaValue0) {
        if(v != 1 && v != 2) {
            return super.a(writer0, v, luaValue0);
        }
        return luaValue0.E() ? Script.copyMemory.a(writer0, luaValue0) : super.a(writer0, v, luaValue0);
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        MainService.instance.k.a(this.e.a(), ap0.p(1), ap0.p(2), ap0.o(3));
        return null;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 3;
    }
}

