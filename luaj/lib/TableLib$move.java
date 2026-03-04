package luaj.lib;

import luaj.LuaLong;
import luaj.LuaTable;
import luaj.ap;
import luaj.o;

class TableLib.move extends VarArgFunction {
    private static long a(long v, long v1) {
        long v2 = v - v1;
        return ((v ^ v1) & (v ^ v2)) >= 0L ? v2 : 0x7FFFFFFFFFFFFFFFL;
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaTable luaTable0 = ap0.t(1);
        long v = ap0.p(2);
        long v1 = ap0.p(3);
        long v2 = ap0.p(4);
        ap ap1 = ap0.a(5, luaTable0);
        if(v <= v1) {
            long v3 = TableLib.move.a(v1, v);
            if(v3 > 0xFFFFFEL) {
                throw new o("too many elements to move: " + v3 + " (max is " + 0xFFFFFFL + ')');
            }
            if(v2 > 0L && v3 > 0x7FFFFFFFFFFFFFFFL - v2) {
                throw new o("move: destination wrap around");
            }
            boolean z = ((long)(((int)v))) == v && ((long)(((int)v1))) == v1;
            if(luaTable0 == ap1) {
                if(v2 > v && v1 >= v2) {
                    for(long v5 = v1; v5 >= v; --v5) {
                        ((LuaTable)ap1).b(LuaLong.b(v5 - v + v2), (z ? luaTable0.c_(((int)v5)) : luaTable0.w(LuaLong.b(v5))));
                        if(v5 == v) {
                            return ap1;
                        }
                    }
                }
                else {
                    for(long v4 = v; v4 <= v1; ++v4) {
                        ((LuaTable)ap1).b(LuaLong.b(v4 - v + v2), (z ? luaTable0.c_(((int)v4)) : luaTable0.w(LuaLong.b(v4))));
                        if(v4 == v1) {
                            return ap1;
                        }
                    }
                }
                return ap1;
            }
            else {
                for(long v6 = v; v6 <= v1; ++v6) {
                    ((LuaTable)ap1).b(LuaLong.b(v6 - v + v2), (z ? luaTable0.c_(((int)v6)) : luaTable0.w(LuaLong.b(v6))));
                    if(v6 == v1) {
                        break;
                    }
                }
            }
        }
        return ap1;
    }
}

