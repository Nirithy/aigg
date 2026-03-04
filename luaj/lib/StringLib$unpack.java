package luaj.lib;

import android.ext.ts;
import java.util.ArrayList;
import luaj.LuaDouble;
import luaj.LuaLong;
import luaj.LuaString;
import luaj.LuaValue;
import luaj.ap;

final class StringLib.unpack extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        int v8;
        String s = ap0.r(1);
        LuaString luaString0 = ap0.s(2);
        int v = luaString0.L();
        int v1 = StringLib.a(ap0.d(3, 1), v);
        this.a(v1 - 1 >= 0 && v1 - 1 <= v, 3, "initial position (" + v1 + ") out of string (length = " + v + ")");
        m m0 = new m(s);
        int v2 = s.length();
        ArrayList arrayList0 = new ArrayList();
        int v3;
        for(v3 = v1 - 1; m0.e < v2; v3 = v8 + v6) {
            int v4 = StringLib.a(m0, v3);
            int v5 = m0.h;
            int v6 = m0.i;
            if(v3 + v5 + v6 > v) {
                StringLib.unpack.a(2, ts.a("data string too short (%d) for option \'%c\' (need %d) at pos %d", new Object[]{v, Character.valueOf(m0.f), ((int)(v3 + v5 + v6)), m0.e}));
            }
            int v7 = v5 + v3;
            switch(v4) {
                case 1: 
                case 2: {
                    arrayList0.add(LuaLong.b(StringLib.a(m0, luaString0, v7, v4 == 1)));
                    v8 = v7;
                    break;
                }
                case 3: {
                    arrayList0.add(LuaDouble.a(Float.intBitsToFloat(((int)StringLib.a(m0, luaString0, v7, false)))));
                    v8 = v7;
                    break;
                }
                case 4: {
                    arrayList0.add(luaString0.a(v7, v7 + v6));
                    v8 = v7;
                    break;
                }
                case 5: {
                    int v9 = (int)StringLib.a(m0, luaString0, v7, false);
                    this.a(v7 + v9 + v6 <= v, 2, "data string too short (" + v + " but need " + (v7 + v9 + v6) + ") at pos " + m0.e);
                    arrayList0.add(luaString0.a(v7 + v6, v7 + v6 + v9));
                    v8 = v7 + v9;
                    break;
                }
                case 6: {
                    int v10 = luaString0.a(0, v7);
                    this.a(v10 != -1, 2, ts.a("zero char not found for option \'%c\' at pos %d", new Object[]{Character.valueOf(m0.f), m0.e}));
                    arrayList0.add(luaString0.a(v7, v10));
                    v8 = v10 + 1;
                    break;
                }
                case 9: {
                    arrayList0.add(LuaDouble.a(Double.longBitsToDouble(StringLib.a(m0, luaString0, v7, false))));
                    v8 = v7;
                    break;
                }
                case 10: {
                    m0.i = 8;
                    long v11 = StringLib.a(m0, luaString0, v7, false);
                    m0.i = 1;
                    if(StringLib.a(m0, luaString0, v7 + 8, false) == 1L) {
                        arrayList0.add(LuaLong.b(v11));
                    }
                    else {
                        arrayList0.add(LuaDouble.a(Double.longBitsToDouble(v11)));
                    }
                    v8 = v7;
                    break;
                }
                default: {
                    v8 = v7;
                }
            }
        }
        arrayList0.add(LuaValue.d(v3 + 1));
        return StringLib.unpack.c(((LuaValue[])arrayList0.toArray(new LuaValue[arrayList0.size()])));
    }
}

