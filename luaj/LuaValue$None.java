package luaj;

final class LuaValue.None extends LuaNil {
    private LuaValue.None() {
    }

    LuaValue.None(LuaValue.None luaValue$None0) {
    }

    @Override  // luaj.ap
    void b(LuaValue[] arr_luaValue, int v, int v1) {
        while(v1 > 0) {
            arr_luaValue[v] = LuaValue.None.u;
            --v1;
            ++v;
        }
    }

    @Override  // luaj.LuaValue
    public LuaValue c(int v) {
        return LuaValue.None.u;
    }

    @Override  // luaj.LuaNil
    public String d_() {
        return "none";
    }

    @Override  // luaj.LuaValue
    public ap e_(int v) {
        return v > 0 ? this : LuaValue.None.a(1, "start must be > 0");
    }

    @Override  // luaj.LuaValue
    public LuaValue g() {
        return LuaValue.None.u;
    }

    @Override  // luaj.LuaValue
    public int j_() {
        return 0;
    }
}

