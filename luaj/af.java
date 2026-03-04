package luaj;

abstract class af extends v {
    protected final LuaValue a;

    af(LuaValue luaValue0) {
        this.a = luaValue0;
    }

    @Override  // luaj.v
    public final int a(int v) {
        return LuaTable.a(this.a, v);
    }

    @Override  // luaj.v
    public final boolean b(LuaValue luaValue0) {
        return luaValue0.c(this.a);
    }

    @Override  // luaj.v
    public final LuaValue c() {
        return this.a;
    }
}

