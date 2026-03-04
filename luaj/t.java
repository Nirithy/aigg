package luaj;

import java.lang.ref.WeakReference;

class t implements ad {
    private final Object a;
    private ad b;

    private t(LuaValue luaValue0, ad ad0) {
        if(LuaTable.C(luaValue0)) {
            luaValue0 = new WeakReference(luaValue0);
        }
        this.a = luaValue0;
        this.b = ad0;
    }

    t(LuaValue luaValue0, ad ad0, t t0) {
        this(luaValue0, ad0);
    }

    @Override  // luaj.ad
    public int a(int v) {
        return 0;
    }

    @Override  // luaj.ad
    public ad a(ad ad0) {
        return this.b == null ? ad0 : this.b.a(ad0);
    }

    @Override  // luaj.ad
    public ad a(ae ae0) {
        if(this.c() != null) {
            this.b = this.b.a(ae0);
            return this;
        }
        return this.b;
    }

    @Override  // luaj.ad
    public ad a(ae ae0, LuaValue luaValue0) {
        ad ad0 = this.b == null ? null : this.b.a(ae0, luaValue0);
        if(this.c() != null) {
            this.b = ad0;
            return this;
        }
        return ad0;
    }

    @Override  // luaj.ad
    public ae a() {
        return null;
    }

    @Override  // luaj.ad
    public ae a(LuaValue luaValue0) {
        return null;
    }

    @Override  // luaj.ad
    public int b(int v) {
        return -1;
    }

    @Override  // luaj.ad
    public ad b(ad ad0) {
        return ad0;
    }

    @Override  // luaj.ad
    public boolean b(LuaValue luaValue0) {
        LuaValue luaValue1 = this.c();
        return luaValue1 != null && luaValue0.c(luaValue1);
    }

    // 去混淆评级： 低(20)
    private LuaValue c() {
        return this.a instanceof WeakReference ? ((LuaValue)((WeakReference)this.a).get()) : ((LuaValue)this.a);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("<dead");
        LuaValue luaValue0 = this.c();
        if(luaValue0 != null) {
            stringBuilder0.append(": ");
            stringBuilder0.append(luaValue0.toString());
        }
        stringBuilder0.append('>');
        if(this.b != null) {
            stringBuilder0.append("; ");
            stringBuilder0.append(this.b.toString());
        }
        return stringBuilder0.toString();
    }

    @Override  // luaj.ad
    public ad u_() {
        return this.b;
    }
}

