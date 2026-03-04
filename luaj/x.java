package luaj;

class x extends v {
    private final int a;
    private LuaValue b;

    x(int v, LuaValue luaValue0) {
        this.a = v;
        this.b = luaValue0;
    }

    @Override  // luaj.v
    public int a(int v) {
        return ((int)(((long)this.a) >>> 0x20 ^ ((long)this.a))) & v;
    }

    @Override  // luaj.v
    public v a_(LuaValue luaValue0) {
        this.b = luaValue0;
        return this;
    }

    @Override  // luaj.v
    public int b(int v) {
        return this.a < 1 || this.a > v ? 0 : this.a;
    }

    @Override  // luaj.v
    public boolean b(LuaValue luaValue0) {
        return luaValue0.I() ? this.a == luaValue0.p() : false;
    }

    @Override  // luaj.v
    public LuaValue c() {
        return LuaTable.d(this.a);
    }

    @Override  // luaj.v
    public LuaValue t_() {
        return this.b;
    }
}

