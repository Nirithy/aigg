package luaj.a;

import java.io.InputStream;
import java.util.Hashtable;
import luaj.LuaString;
import luaj.LuaValue;
import luaj.al;

class u {
    int a;
    private Hashtable b;

    protected u() {
        this.a = 0;
        this.b = new Hashtable();
    }

    public LuaString a(String s) {
        return this.b(LuaString.c(s));
    }

    public LuaString a(LuaString luaString0) {
        return this.b(luaString0);
    }

    al a(InputStream inputStream0, String s) {
        boolean z = false;
        h h0 = new h(this, inputStream0);
        c c0 = new c();
        h0.h = c0;
        h0.a(this, inputStream0.read(), inputStream0, LuaValue.m(s));
        c0.b = new al();
        al al0 = c0.b;
        al0.w = LuaValue.m(s);
        h0.a(c0);
        t.a(c0.d == null);
        if(h0.m == null || h0.m.b == 0 && h0.m.d == 0 && h0.m.f == 0) {
            z = true;
        }
        t.a(z);
        return c0.b;
    }

    public String b(String s) [...] // Inlined contents

    public LuaString b(LuaString luaString0) {
        LuaString luaString1 = (LuaString)this.b.get(luaString0);
        if(luaString1 != null) {
            return luaString1;
        }
        this.b.put(luaString0, luaString0);
        return luaString0;
    }
}

