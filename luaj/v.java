package luaj;

abstract class v extends ap implements ae {
    @Override  // luaj.ad
    public abstract int a(int arg1);

    @Override  // luaj.ad
    public ad a(ad ad0) {
        return new aa(this, ad0);
    }

    @Override  // luaj.ad
    public ad a(ae ae0) {
        return new t(this.c(), null, null);
    }

    @Override  // luaj.ad
    public ad a(ae ae0, LuaValue luaValue0) {
        return this.a_(luaValue0);
    }

    @Override  // luaj.ad
    public ae a() {
        return this;
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.ad
    public ae a(LuaValue luaValue0) {
        return this.b(luaValue0) ? this : null;
    }

    abstract v a_(LuaValue arg1);

    @Override  // luaj.ad
    public int b(int v) {
        return 0;
    }

    @Override  // luaj.ad
    public ad b(ad ad0) {
        return ad0 != null ? new aa(this, ad0) : this;
    }

    @Override  // luaj.ad
    public abstract boolean b(LuaValue arg1);

    @Override  // luaj.ae
    public abstract LuaValue c();

    @Override  // luaj.ap
    public LuaValue c(int v) {
        switch(v) {
            case 1: {
                return this.c();
            }
            case 2: {
                return this.t_();
            }
            default: {
                return LuaTable.u;
            }
        }
    }

    @Override  // luaj.ap
    public ap e_(int v) {
        switch(v) {
            case 1: {
                return this;
            }
            case 2: {
                return this.t_();
            }
            default: {
                return LuaTable.x;
            }
        }
    }

    @Override  // luaj.ae
    public ap f() {
        return this;
    }

    @Override  // luaj.ap
    public LuaValue g() {
        return this.c();
    }

    @Override  // luaj.ap
    public int j_() {
        return 2;
    }

    @Override  // luaj.ae
    public abstract LuaValue t_();

    @Override  // luaj.ad
    public ad u_() {
        return null;
    }
}

