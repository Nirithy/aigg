package luaj;

public final class an {
    LuaValue[] a;
    int b;

    public an(LuaValue[] arr_luaValue, int v) {
        this.a = arr_luaValue;
        this.b = v;
    }

    public final LuaValue a() {
        return this.a[this.b];
    }

    public final void a(LuaValue luaValue0) {
        this.a[this.b] = luaValue0;
    }

    public final void b() {
        LuaValue[] arr_luaValue = this.a;
        this.a = new LuaValue[]{arr_luaValue[this.b]};
        arr_luaValue[this.b] = null;
        this.b = 0;
    }

    @Override
    public String toString() {
        return this.b + '/' + this.a.length + ' ' + this.a[this.b];
    }
}

