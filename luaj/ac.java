package luaj;

class ac extends af {
    private LuaValue b;

    ac(LuaValue luaValue0, LuaValue luaValue1) {
        super(luaValue0);
        this.b = luaValue1;
    }

    @Override  // luaj.v
    public v a_(LuaValue luaValue0) {
        if(luaValue0 instanceof LuaBoolean) {
            return new s(this.a, luaValue0.i_());
        }
        if(luaValue0 instanceof LuaLong) {
            long v = luaValue0.q();
            return ((long)(((int)v))) == v ? new y(this.a, ((int)v)) : new ab(this.a, v);
        }
        if(luaValue0 instanceof LuaDouble) {
            double f = luaValue0.o();
            return ((double)(((float)f))) == f ? new w(this.a, ((float)f)) : new u(this.a, f);
        }
        this.b = luaValue0;
        return this;
    }

    @Override  // luaj.v
    public ap f() {
        return this;
    }

    @Override  // luaj.v
    public LuaValue t_() {
        return this.b;
    }
}

