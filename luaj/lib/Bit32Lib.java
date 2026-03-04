package luaj.lib;

import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;

public class Bit32Lib extends TwoArgFunction {
    static LuaValue a(int v, int v1) {
        return v1 < 0 ? Bit32Lib.e(v << -v1) : Bit32Lib.e(v >> v1);
    }

    static LuaValue a(int v, int v1, int v2) {
        if(v1 < 0) {
            Bit32Lib.a(2, "field cannot be negative");
        }
        if(v2 < 0) {
            Bit32Lib.a(3, "width must be postive");
        }
        if(v1 + v2 > 0x20) {
            Bit32Lib.f("trying to access non-existent bits");
        }
        return Bit32Lib.e(v >>> v1 & -1 >>> 0x20 - v2);
    }

    static LuaValue a(int v, int v1, int v2, int v3) {
        if(v2 < 0) {
            Bit32Lib.a(3, "field cannot be negative");
        }
        if(v3 < 0) {
            Bit32Lib.a(4, "width must be postive");
        }
        if(v2 + v3 > 0x20) {
            Bit32Lib.f("trying to access non-existent bits");
        }
        int v4 = -1 >>> 0x20 - v3 << v2;
        return Bit32Lib.e(v4 & v1 << v2 | ~v4 & v);
    }

    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        LuaValue luaValue2 = new LuaTable();
        this.a(luaValue2, Bit32Lib.Bit32LibV.class, new String[]{"band", "bnot", "bor", "btest", "bxor", "extract", "replace"});
        this.a(luaValue2, Bit32Lib.Bit32Lib2.class, new String[]{"arshift", "lrotate", "lshift", "rrotate", "rshift"});
        luaValue1.a("bit32", luaValue2);
        if(!luaValue1.j("package").F()) {
            luaValue1.j("package").j("loaded").a("bit32", luaValue2);
        }
        return luaValue2;
    }

    static LuaValue b(int v, int v1) {
        if(v1 >= 0x20 || v1 <= 0xFFFFFFE0) {
            return Bit32Lib.y;
        }
        return v1 < 0 ? Bit32Lib.e(v << -v1) : Bit32Lib.e(v >>> v1);
    }

    static ap b(ap ap0) {
        int v = -1;
        for(int v1 = 1; v1 <= ap0.j_(); ++v1) {
            v &= (int)ap0.p(v1);
        }
        return Bit32Lib.e(v);
    }

    static LuaValue c(int v, int v1) {
        if(v1 >= 0x20 || v1 <= 0xFFFFFFE0) {
            return Bit32Lib.y;
        }
        return v1 < 0 ? Bit32Lib.e(v >>> -v1) : Bit32Lib.e(v << v1);
    }

    static ap c(ap ap0) {
        return Bit32Lib.e(~((int)ap0.p(1)));
    }

    static ap d(ap ap0) {
        int v = 0;
        for(int v1 = 1; v1 <= ap0.j_(); ++v1) {
            v |= (int)ap0.p(v1);
        }
        return Bit32Lib.e(v);
    }

    private static LuaValue e(int v) {
        return v >= 0 ? Bit32Lib.d(v) : Bit32Lib.d(((long)v) & 0xFFFFFFFFL);
    }

    static LuaValue e(int v, int v1) {
        return v1 >= 0 ? Bit32Lib.e(v >>> 0x20 - (v1 & 0x1F) | v << (v1 & 0x1F)) : Bit32Lib.f(v, -v1);
    }

    static ap e(ap ap0) {
        int v = -1;
        for(int v1 = 1; v1 <= ap0.j_(); ++v1) {
            v &= (int)ap0.p(v1);
        }
        return v == 0 ? Bit32Lib.b(false) : Bit32Lib.b(true);
    }

    static LuaValue f(int v, int v1) {
        return v1 >= 0 ? Bit32Lib.e(v << 0x20 - (v1 & 0x1F) | v >>> (v1 & 0x1F)) : Bit32Lib.e(v, -v1);
    }

    static ap f(ap ap0) {
        int v = 0;
        for(int v1 = 1; v1 <= ap0.j_(); ++v1) {
            v ^= (int)ap0.p(v1);
        }
        return Bit32Lib.e(v);
    }
}

