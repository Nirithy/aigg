package luaj;

class w extends af {
    private float b;

    w(LuaValue luaValue0, float f) {
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
            this.b = (float)f;
            return this;
        }
        return new u(this.a, f);
    }

    @Override  // luaj.v
    public LuaValue t_() {
        return LuaTable.c(this.b);
    }
}

