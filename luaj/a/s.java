package luaj.a;

import luaj.LuaLong;
import luaj.LuaValue;

class s {
    short a;
    short b;
    short c;
    LuaValue d;
    int e;

    public LuaValue a() {
        return this.d == null ? LuaLong.b(this.e) : this.d;
    }

    public void a(LuaValue luaValue0) {
        this.d = luaValue0;
    }
}

