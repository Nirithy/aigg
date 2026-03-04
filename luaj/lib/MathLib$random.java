package luaj.lib;

import java.util.Random;
import luaj.LuaValue;

class MathLib.random extends LibFunction {
    Random a;

    MathLib.random() {
        this.a = new Random();
    }

    private long S() {
        long v = this.a.nextLong();
        return v >= 0L ? v : v ^ 0x8000000000000000L;
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0) {
        long v = luaValue0.w();
        if(v < 1L) {
            MathLib.random.a(1, "interval is empty");
        }
        return MathLib.random.d(this.S() % v + 1L);
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        long v = luaValue0.w();
        long v1 = luaValue1.w();
        if(v1 < v) {
            MathLib.random.a(2, "interval is empty");
        }
        long v2 = v1 - v;
        if(v2 < 0L) {
            MathLib.random.a(2, "interval too large");
        }
        long v3 = this.S();
        if(v2 != 0x7FFFFFFFFFFFFFFFL) {
            v3 %= v2 + 1L;
        }
        return MathLib.random.d(v3 + v);
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1, LuaValue luaValue2) {
        return MathLib.random.a(3, "too many arguments");
    }

    @Override  // luaj.lib.LibFunction
    public LuaValue l() {
        return MathLib.random.c(this.a.nextDouble());
    }
}

