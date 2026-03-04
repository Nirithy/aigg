package luaj;

public class z {
    final LuaTable a;
    private int b;
    private ad c;
    private ae d;

    public z(LuaTable luaTable0) {
        this.a = luaTable0;
        super();
        this.b = -1;
        this.c = null;
        this.d = null;
    }

    public boolean a() {
        ae ae1;
        ad ad1;
        ad ad0 = this.c;
        while(true) {
            if(ad0 == null) {
                this.c = null;
                this.d = null;
                int v = this.b + 1;
                while(true) {
                    if(v >= this.a.b.length) {
                        int v1;
                        for(v1 = v - this.a.b.length; true; ++v1) {
                            if(v1 >= this.a.c.length) {
                                return false;
                            }
                            ad1 = this.a.c[v1];
                        label_10:
                            if(ad1 != null) {
                                break;
                            }
                        }
                        ae ae0 = ad1.a();
                        if(ae0 == null) {
                            ad1 = ad1.u_();
                            goto label_10;
                        }
                        this.b = v1 + this.a.b.length;
                        this.c = ad1;
                        this.d = ae0;
                        return true;
                    }
                    if(this.a.b[v] != null && (this.a.p == null || this.a.p.a(this.a.b, v) != null)) {
                        this.b = v;
                        return true;
                    }
                    ++v;
                }
            }
            ad0 = ad0.u_();
            if(ad0 != null) {
                ae1 = ad0.a();
                if(ae1 != null) {
                    break;
                }
            }
        }
        this.c = ad0;
        this.d = ae1;
        return true;
    }

    public int b() {
        return this.d == null ? this.b + 1 : 0;
    }

    public LuaValue c() {
        ae ae0 = this.d;
        return ae0 != null ? ae0.c() : LuaLong.b(this.b + 1);
    }

    public LuaValue d() {
        ae ae0 = this.d;
        if(ae0 != null) {
            return ae0.t_();
        }
        return this.a.p == null ? this.a.b[this.b] : this.a.p.a(this.a.b, this.b);
    }
}

