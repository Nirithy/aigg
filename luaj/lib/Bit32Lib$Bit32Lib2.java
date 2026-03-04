package luaj.lib;

import luaj.LuaValue;

final class Bit32Lib.Bit32Lib2 extends TwoArgFunction {
    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        switch(this.aj) {
            case 0: {
                return Bit32Lib.a(((int)luaValue0.w()), ((int)luaValue1.w()));
            }
            case 1: {
                return Bit32Lib.e(((int)luaValue0.w()), ((int)luaValue1.w()));
            }
            case 2: {
                return Bit32Lib.c(((int)luaValue0.w()), ((int)luaValue1.w()));
            }
            case 3: {
                return Bit32Lib.f(((int)luaValue0.w()), ((int)luaValue1.w()));
            }
            case 4: {
                return Bit32Lib.b(((int)luaValue0.w()), ((int)luaValue1.w()));
            }
            default: {
                return Bit32Lib.Bit32Lib2.u;
            }
        }
    }
}

