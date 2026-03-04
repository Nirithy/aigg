package luaj;

class ai implements ah {
    private final LuaValue a;

    public ai(LuaValue luaValue0) {
        this.a = luaValue0;
    }

    @Override  // luaj.ah
    public LuaValue E(LuaValue luaValue0) {
        return luaValue0;
    }

    @Override  // luaj.ah
    public boolean U() {
        return false;
    }

    @Override  // luaj.ah
    public boolean V() {
        return false;
    }

    @Override  // luaj.ah
    public LuaValue W() {
        return this.a;
    }

    @Override  // luaj.ah
    public LuaValue a(LuaValue[] arr_luaValue, int v) {
        return arr_luaValue[v];
    }

    @Override  // luaj.ah
    public ad e(LuaValue luaValue0, LuaValue luaValue1) {
        return LuaTable.f(luaValue0, luaValue1);
    }
}

