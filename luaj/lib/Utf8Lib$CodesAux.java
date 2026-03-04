package luaj.lib;

import luaj.LuaString;
import luaj.ap;

class Utf8Lib.CodesAux extends VarArgFunction {
    private int a;
    private final LuaString b;

    public Utf8Lib.CodesAux(LuaString luaString0) {
        this.b = luaString0;
        this.a = 0;
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        int v = this.a;
        int v1 = this.b.c + this.b.d;
        if(v >= v1) {
            return Utf8Lib.CodesAux.u;
        }
        int v2 = Utf8Lib.a(this.b.b, this.b.c + v, v1);
        if(v2 >> 28 == 5) {
            throw Utf8Lib.e((v2 & 0xFFFFFFF) - this.b.c + 1);
        }
        this.a = (v2 >> 28) + v;
        return Utf8Lib.CodesAux.b(Utf8Lib.CodesAux.d(v + 1), Utf8Lib.CodesAux.d(v2 & 0xFFFFFFF));
    }
}

