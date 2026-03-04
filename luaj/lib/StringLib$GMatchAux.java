package luaj.lib;

import luaj.LuaString;
import luaj.ap;

class StringLib.GMatchAux extends VarArgFunction {
    private final int a;
    private final l b;
    private int c;
    private int d;

    public StringLib.GMatchAux(ap ap0, LuaString luaString0, LuaString luaString1) {
        this.a = luaString0.L();
        this.b = new l(ap0, luaString0, luaString1);
        this.c = 0;
        this.d = -1;
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        while(true) {
            if(this.c > this.a) {
                return StringLib.GMatchAux.u;
            }
            this.b.a();
            int v = this.b.b(this.c, 0);
            if(v >= 0 && v != this.d) {
                int v1 = this.c;
                this.c = v;
                this.d = v;
                return this.b.a(true, v1, v);
            }
            ++this.c;
        }
    }
}

