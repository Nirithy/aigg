package luaj.lib;

import java.io.InputStream;
import luaj.LuaString;
import luaj.LuaValue;

class d extends InputStream {
    final LuaValue a;
    byte[] b;
    int c;
    int d;

    d(LuaValue luaValue0) {
        this.d = 0;
        this.a = luaValue0;
    }

    @Override
    public int read() {
        if(this.d >= 0) {
            if(this.d != 0) {
                goto label_11;
            }
            LuaValue luaValue0 = this.a.l();
            if(luaValue0.F()) {
                this.d = -1;
                return -1;
            }
            LuaString luaString0 = luaValue0.t();
            this.b = luaString0.b;
            this.c = luaString0.c;
            this.d = luaString0.d;
            if(this.d > 0) {
            label_11:
                --this.d;
                int v = this.c;
                this.c = v + 1;
                return this.b[v] & 0xFF;
            }
        }
        return -1;
    }
}

