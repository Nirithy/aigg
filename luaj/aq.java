package luaj;

final class aq extends ap {
    private final int a;
    private final LuaValue[] b;
    private final int c;
    private final ap d;

    public aq(LuaValue[] arr_luaValue, int v, int v1, ap ap0) {
        this.b = arr_luaValue;
        this.a = v;
        this.c = v1;
        this.d = ap0;
    }

    @Override  // luaj.ap
    void b(LuaValue[] arr_luaValue, int v, int v1) {
        int v2 = Math.min(this.c, v1);
        System.arraycopy(this.b, this.a, arr_luaValue, v, v2);
        this.d.b(arr_luaValue, v + v2, v1 - v2);
    }

    @Override  // luaj.ap
    public LuaValue c(int v) {
        if(v < 1) {
            return LuaValue.u;
        }
        return v > this.c ? this.d.c(v - this.c) : this.b[this.a + v - 1];
    }

    @Override  // luaj.ap
    public ap e_(int v) {
        if(v <= 0) {
            LuaValue.a(1, "start must be > 0");
        }
        if(v == 1) {
            return this;
        }
        return v <= this.c ? LuaValue.a(this.b, this.a + v - 1, this.c - (v - 1), this.d) : this.d.e_(v - this.c);
    }

    @Override  // luaj.ap
    public LuaValue g() {
        return this.c <= 0 ? this.d.g() : this.b[this.a];
    }

    @Override  // luaj.ap
    public int j_() {
        int v = this.d.j_();
        return this.c + v;
    }
}

