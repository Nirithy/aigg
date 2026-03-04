package luaj;

import luaj.lib.DebugLib;

public class am extends ap {
    private LuaValue a;
    private ap b;
    private ap c;
    private final Globals d;

    public am(Globals globals0, LuaValue luaValue0, ap ap0) {
        this.d = globals0;
        this.a = luaValue0;
        this.b = ap0;
    }

    @Override  // luaj.ap
    public ap b() {
        ap ap0 = this.c;
        if(ap0 == null) {
            DebugLib debugLib0 = this.d == null ? null : this.d.k;
            LuaValue luaValue0 = this.a;
            ap ap1 = this.b;
            while(ap0 == null) {
                if(debugLib0 != null && !luaValue0.j() && luaValue0.B()) {
                    debugLib0.a(luaValue0.C(), true);
                }
                ap ap2 = luaValue0.a(ap1, true);
                if(ap2.l_()) {
                    luaValue0 = ((am)ap2).a;
                    this.a = luaValue0;
                    ap ap3 = ((am)ap2).b;
                    this.b = ap3;
                    ap1 = ap3;
                }
                else {
                    this.c = ap2;
                    this.a = null;
                    this.b = null;
                    ap0 = ap2;
                }
            }
        }
        return ap0;
    }

    @Override  // luaj.ap
    public LuaValue c(int v) {
        if(this.c == null) {
            this.b();
        }
        return this.c.c(v);
    }

    @Override  // luaj.ap
    public ap e_(int v) {
        if(this.c == null) {
            this.b();
        }
        return this.c.e_(v);
    }

    @Override  // luaj.ap
    public LuaValue g() {
        if(this.c == null) {
            this.b();
        }
        return this.c.g();
    }

    @Override  // luaj.ap
    public int j_() {
        if(this.c == null) {
            this.b();
        }
        return this.c.j_();
    }

    @Override  // luaj.ap
    public boolean l_() {
        return true;
    }
}

