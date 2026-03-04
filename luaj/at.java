package luaj;

class at extends av {
    private final int d;

    protected at(LuaValue luaValue0, LuaValue luaValue1, ad ad0) {
        super(WeakTable.a(luaValue0), WeakTable.a(luaValue1), ad0);
        this.d = luaValue0.hashCode();
    }

    protected at(at at0, ad ad0) {
        super(at0.a, at0.b, ad0);
        this.d = at0.d;
    }

    @Override  // luaj.ad
    public int a(int v) {
        return this.d & v;
    }

    @Override  // luaj.av
    public LuaValue c() {
        return WeakTable.a(this.a);
    }

    @Override  // luaj.av
    public ad c(LuaValue luaValue0) {
        this.b = WeakTable.a(luaValue0);
        return this;
    }

    @Override  // luaj.av
    protected av c(ad ad0) {
        return new at(this, ad0);
    }

    @Override  // luaj.av
    public LuaValue d() {
        return WeakTable.a(this.b);
    }
}

