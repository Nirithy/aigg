package luaj;

final class ar extends ap {
    private final LuaValue[] a;
    private final ap b;

    ar(LuaValue[] arr_luaValue, ap ap0) {
        this.a = arr_luaValue;
        this.b = ap0;
    }

    @Override  // luaj.ap
    void b(LuaValue[] arr_luaValue, int v, int v1) {
        int v2 = Math.min(this.a.length, v1);
        System.arraycopy(this.a, 0, arr_luaValue, v, v2);
        this.b.b(arr_luaValue, v + v2, v1 - v2);
    }

    @Override  // luaj.ap
    public LuaValue c(int v) {
        if(v < 1) {
            return LuaValue.u;
        }
        return v > this.a.length ? this.b.c(v - this.a.length) : this.a[v - 1];
    }

    @Override  // luaj.ap
    public ap e_(int v) {
        if(v <= 0) {
            LuaValue.a(1, "start must be > 0");
        }
        if(v == 1) {
            return this;
        }
        return v <= this.a.length ? LuaValue.a(this.a, v - 1, this.a.length - (v - 1), this.b) : this.b.e_(v - this.a.length);
    }

    @Override  // luaj.ap
    public LuaValue g() {
        return this.a.length <= 0 ? this.b.g() : this.a[0];
    }

    @Override  // luaj.ap
    public int j_() {
        int v = this.b.j_();
        return this.a.length + v;
    }
}

