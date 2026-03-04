package luaj;

final class as extends ap {
    private final LuaValue a;
    private final ap b;

    as(LuaValue luaValue0, ap ap0) {
        this.a = luaValue0;
        this.b = ap0;
    }

    @Override  // luaj.ap
    public LuaValue c(int v) {
        return v == 1 ? this.a : this.b.c(v - 1);
    }

    @Override  // luaj.ap
    public ap e_(int v) {
        switch(v) {
            case 1: {
                return this;
            }
            case 2: {
                return this.b;
            }
            default: {
                return v > 2 ? this.b.e_(v - 1) : LuaValue.a(1, "start must be > 0");
            }
        }
    }

    @Override  // luaj.ap
    public LuaValue g() {
        return this.a;
    }

    @Override  // luaj.ap
    public int j_() {
        return this.b.j_() + 1;
    }
}

