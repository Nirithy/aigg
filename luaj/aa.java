package luaj;

class aa implements ae {
    private v a;
    private ad b;

    aa(v v0, ad ad0) {
        this.a = v0;
        this.b = ad0;
    }

    @Override  // luaj.ad
    public int a(int v) {
        return this.a.a(v);
    }

    @Override  // luaj.ad
    public ad a(ad ad0) {
        return this.c(this.b.a(ad0));
    }

    @Override  // luaj.ad
    public ad a(ae ae0) {
        if(this == ae0) {
            return new t(this.c(), this.b, null);
        }
        this.b = this.b.a(ae0);
        return this;
    }

    @Override  // luaj.ad
    public ad a(ae ae0, LuaValue luaValue0) {
        if(ae0 == this) {
            this.a = this.a.a_(luaValue0);
            return this;
        }
        return this.c(this.b.a(ae0, luaValue0));
    }

    @Override  // luaj.ad
    public ae a() {
        return this.a;
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.ad
    public ae a(LuaValue luaValue0) {
        return this.a.b(luaValue0) ? this : null;
    }

    @Override  // luaj.ad
    public int b(int v) {
        return this.a.b(v);
    }

    @Override  // luaj.ad
    public ad b(ad ad0) {
        return ad0 != null ? new aa(this.a, ad0) : this.a;
    }

    @Override  // luaj.ad
    public boolean b(LuaValue luaValue0) {
        return this.a.b(luaValue0);
    }

    private ad c(ad ad0) {
        if(ad0 != null) {
            this.b = ad0;
            return this;
        }
        return this.a;
    }

    @Override  // luaj.ae
    public LuaValue c() {
        return this.a.c();
    }

    @Override  // luaj.ae
    public ap f() {
        return this.a.f();
    }

    @Override  // luaj.ae
    public LuaValue t_() {
        return this.a.t_();
    }

    @Override
    public String toString() {
        return this.a + "; " + this.b;
    }

    @Override  // luaj.ad
    public ad u_() {
        return this.b;
    }
}

