package luaj;

class s extends af {
    private boolean b;

    s(LuaValue luaValue0, boolean z) {
        super(luaValue0);
        this.b = z;
    }

    @Override  // luaj.v
    public v a_(LuaValue luaValue0) {
        if(luaValue0 instanceof LuaBoolean) {
            this.b = luaValue0 == LuaValue.v;
            return this;
        }
        if(luaValue0 instanceof LuaLong) {
            long v = luaValue0.q();
            return ((long)(((int)v))) == v ? new y(this.a, ((int)v)) : new ab(this.a, v);
        }
        if(luaValue0 instanceof LuaDouble) {
            double f = luaValue0.o();
            return ((double)(((float)f))) == f ? new w(this.a, ((float)f)) : new u(this.a, f);
        }
        return new ac(this.a, luaValue0);
    }

    @Override  // luaj.v
    public LuaValue t_() {
        return LuaTable.b(this.b);
    }
}

