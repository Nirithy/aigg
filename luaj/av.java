package luaj;

public abstract class av implements ad {
    protected Object a;
    protected Object b;
    protected ad c;

    protected av(Object object0, Object object1, ad ad0) {
        this.a = object0;
        this.b = object1;
        this.c = ad0;
    }

    @Override  // luaj.ad
    public ad a(ad ad0) {
        if(this.c != null) {
            ad0 = this.c.a(ad0);
        }
        this.c = ad0;
        return this.c() != null && this.d() != null ? this : this.c;
    }

    @Override  // luaj.ad
    public ad a(ae ae0) {
        LuaValue luaValue0 = this.c();
        if(luaValue0 == null) {
            return this.c.a(ae0);
        }
        if(ae0.b(luaValue0)) {
            this.b = null;
            return this;
        }
        this.c = this.c.a(ae0);
        return this;
    }

    @Override  // luaj.ad
    public ad a(ae ae0, LuaValue luaValue0) {
        LuaValue luaValue1 = this.c();
        if(luaValue1 != null && ae0.a(luaValue1) != null) {
            return this.c(luaValue0);
        }
        if(luaValue1 != null) {
            this.c = this.c.a(ae0, luaValue0);
            return this;
        }
        return this.c.a(ae0, luaValue0);
    }

    @Override  // luaj.ad
    public ae a() {
        LuaValue luaValue0 = this.c();
        LuaValue luaValue1 = this.d();
        if(luaValue0 != null && luaValue1 != null) {
            return new ac(luaValue0, luaValue1);
        }
        this.a = null;
        this.b = null;
        return null;
    }

    @Override  // luaj.ad
    public ae a(LuaValue luaValue0) {
        ae ae0 = this.a();
        return ae0 == null ? null : ae0.a(luaValue0);
    }

    @Override  // luaj.ad
    public int b(int v) {
        return 0;
    }

    @Override  // luaj.ad
    public ad b(ad ad0) {
        if(this.c() != null && this.d() != null) {
            return ad0 != null || this.c != null ? this.c(ad0) : this;
        }
        return ad0;
    }

    @Override  // luaj.ad
    public boolean b(LuaValue luaValue0) {
        ae ae0 = this.a();
        return ae0 != null && ae0.b(luaValue0);
    }

    public LuaValue c() {
        return (LuaValue)this.a;
    }

    public abstract ad c(LuaValue arg1);

    protected abstract av c(ad arg1);

    public LuaValue d() {
        return (LuaValue)this.b;
    }

    @Override  // luaj.ad
    public ad u_() {
        return this.c;
    }
}

