package luaj;

class u extends af {
    private double b;

    u(LuaValue luaValue0, double f) {
        super(luaValue0);
        this.b = f;
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
            return ((long)(((int)v))) == v ? new y(this.a, ((int)v)) : new ab(this.a, v);
        }
        double f = luaValue1.o();
        if(((double)(((float)f))) == f) {
            return new w(this.a, ((float)f));
        }
        this.b = f;
        return this;
    }

    @Override  // luaj.v
    public LuaValue t_() {
        return LuaTable.c(this.b);
    }
}

