package luaj.lib;

import luaj.LuaLong;
import luaj.LuaNumber;
import luaj.LuaString;
import luaj.a;
import luaj.ap;

final class StringLib.pack extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaNumber luaNumber0;
        String s = ap0.r(1);
        m m0 = new m(s);
        a a0 = new a();
        int v = 1;
        int v1 = 0;
        int v2 = s.length();
        while(m0.e < v2) {
            int v3 = StringLib.a(m0, v1);
            int v4 = m0.h;
            int v5 = m0.i;
            v1 += v4 + v5;
            if(v4 > 0) {
                a0.a(new byte[v4], 0, v4);
            }
            ++v;
            switch(v3) {
                case 1: 
                case 2: {
                    long v6 = ap0.p(v);
                    if(v5 < 8) {
                        if(v3 == 1) {
                            long v7 = 1L << v5 * 8 - 1;
                            this.a(-v7 <= v6 && v6 < v7, v, "integer overflow");
                        }
                        else {
                            this.a((~((1L << v5 * 8) - 1L) & v6) == 0L, v, "unsigned overflow");
                        }
                    }
                    StringLib.a(m0, a0, v6);
                    continue;
                }
                case 3: {
                    StringLib.a(m0, a0, ((long)Float.floatToRawIntBits(((float)ap0.m(v)))));
                    continue;
                }
                case 4: {
                    LuaString luaString0 = ap0.s(v);
                    int v8 = luaString0.L();
                    this.a(v8 <= v5, v, "string longer (" + v8 + ") than given size (" + v5 + ")");
                    a0.a(luaString0);
                    int v9 = v5 - v8;
                    if(v9 <= 0) {
                        continue;
                    }
                    a0.a(new byte[v9], 0, v9);
                    continue;
                }
                case 5: {
                    LuaString luaString1 = ap0.s(v);
                    int v10 = luaString1.L();
                    this.a(v5 >= m0.a || ((long)v10) < 1L << v5 * 8, v, "string length (" + v10 + ") does not fit in given size (" + v5 + " bytes)");
                    StringLib.a(m0, a0, ((long)v10));
                    a0.a(luaString1);
                    v1 += v10;
                    continue;
                }
                case 6: {
                    LuaString luaString2 = ap0.s(v);
                    this.a(luaString2.d_().indexOf(0) == -1, v, "string contains zeros");
                    a0.a(luaString2);
                    a0.a(0);
                    v1 += luaString2.L() + 1;
                    continue;
                }
                case 7: {
                    a0.a(0);
                    --v;
                    continue;
                }
                case 0: 
                case 8: {
                    --v;
                    continue;
                }
                case 9: {
                    StringLib.a(m0, a0, Double.doubleToRawLongBits(ap0.m(v)));
                    continue;
                }
                case 10: {
                    luaNumber0 = ap0.q(v);
                    m0.i = 8;
                    if(luaNumber0 instanceof LuaLong) {
                        StringLib.a(m0, a0, luaNumber0.q());
                    }
                    else {
                        StringLib.a(m0, a0, Double.doubleToRawLongBits(luaNumber0.o()));
                    }
                    break;
                }
                default: {
                    continue;
                }
            }
            m0.i = 1;
            StringLib.a(m0, a0, ((long)(luaNumber0 instanceof LuaLong ? 1 : 0)));
        }
        return a0.b();
    }
}

