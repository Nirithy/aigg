package luaj;

public class ao {
    public LuaString a;
    public final boolean b;
    public final short c;

    public ao(LuaString luaString0, boolean z, int v) {
        this.a = luaString0;
        this.b = z;
        this.c = (short)v;
    }

    // 去混淆评级： 低(40)
    @Override
    public String toString() {
        return this.b ? "v" + ((int)this.c) + " \"" + this.a + "\"" : "u" + ((int)this.c) + " \"" + this.a + "\"";
    }
}

