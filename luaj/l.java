package luaj;

public class l {
    public LuaString a;
    public int b;
    public int c;

    public l(LuaString luaString0, int v, int v1) {
        this.a = luaString0;
        this.b = v;
        this.c = v1;
    }

    public String a() {
        return this.a + ' ' + this.b + '-' + this.c;
    }

    @Override
    public String toString() {
        return this.a();
    }
}

