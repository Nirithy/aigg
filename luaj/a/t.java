package luaj.a;

import java.io.InputStream;
import luaj.Globals;
import luaj.LuaClosure;
import luaj.LuaFunction;
import luaj.LuaValue;
import luaj.al;
import luaj.b;
import luaj.c;

public class t extends a implements b, c {
    public static final t b;

    static {
        t.b = new t();
    }

    public static void a(Globals globals0) {
        globals0.m = t.b;
        globals0.l = t.b;
    }

    @Override  // luaj.c
    public LuaFunction a(al al0, String s, LuaValue luaValue0) {
        return new LuaClosure(al0, luaValue0, true);
    }

    @Override  // luaj.b
    public al a(InputStream inputStream0, String s) {
        return new u().a(inputStream0, s);
    }
}

