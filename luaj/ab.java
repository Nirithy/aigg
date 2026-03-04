package luaj;

class ab extends af {
    private long b;

    ab(LuaValue luaValue0, long v) {
        super(luaValue0);
        this.b = v;
    }

    @Override  // luaj.v
    public v a_(LuaValue luaValue0) {
        if(luaValue0 instanceof LuaBoolean) {
            return new s(this.a, luaValue0.i_());
        }
        LuaValue luaValue1 = luaValue0.H();
        if(luaValue1.F()) {
            return new ac(this.a, luaValue0);
        }
        if(luaValue1 instanceof LuaLong) {
            long v = luaValue1.q();
            if(((long)(((int)v))) == v) {
                return new y(this.a, ((int)v));
            }
            this.b = v;
            return this;
        }
        double f = luaValue1.o();
        return ((double)(((float)f))) == f ? new w(this.a, ((float)f)) : new u(this.a, f);
    }

    long h() {
        return this.b;
    }

    @Override  // luaj.v
    public LuaValue t_() {
        return LuaTable.d(this.b);
    }
}

