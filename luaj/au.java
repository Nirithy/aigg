package luaj;

class au extends av {
    private final int d;

    protected au(LuaValue luaValue0, LuaValue luaValue1, ad ad0) {
        super(WeakTable.a(luaValue0), luaValue1, ad0);
        this.d = luaValue0.hashCode();
    }

    protected au(au au0, ad ad0) {
        super(au0.a, au0.b, ad0);
        this.d = au0.d;
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
        this.b = luaValue0;
        return this;
    }

    @Override  // luaj.av
    protected av c(ad ad0) {
        return new au(this, ad0);
    }
}

