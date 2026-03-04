package luaj;

class aw extends av {
    protected aw(LuaValue luaValue0, LuaValue luaValue1, ad ad0) {
        super(luaValue0, WeakTable.a(luaValue1), ad0);
    }

    protected aw(aw aw0, ad ad0) {
        super(aw0.a, aw0.b, ad0);
    }

    @Override  // luaj.ad
    public int a(int v) {
        return LuaTable.a(this.c(), v);
    }

    @Override  // luaj.av
    public ad c(LuaValue luaValue0) {
        this.b = WeakTable.a(luaValue0);
        return this;
    }

    @Override  // luaj.av
    protected av c(ad ad0) {
        return new aw(this, ad0);
    }

    @Override  // luaj.av
    public LuaValue d() {
        return WeakTable.a(this.b);
    }
}

