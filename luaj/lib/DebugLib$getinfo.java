package luaj.lib;

import luaj.LuaBoolean;
import luaj.LuaFunction;
import luaj.LuaLong;
import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaThread;
import luaj.LuaValue;
import luaj.ap;

final class DebugLib.getinfo extends VarArgFunction {
    final DebugLib a;

    DebugLib.getinfo(DebugLib debugLib0) {
        this.a = debugLib0;
        super();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        e e1;
        LuaThread luaThread0;
        int v;
        if(ap0.j(1)) {
            v = 2;
            luaThread0 = ap0.u(1);
        }
        else {
            luaThread0 = this.a.ai.h;
            v = 1;
        }
        LuaValue luaValue0 = ap0.c(v);
        String s = ap0.c(v + 1, "flnStu");
        f f0 = this.a.a(luaThread0);
        if(luaValue0.I()) {
            int v1 = luaValue0.p();
            if(f0.a(1).a == this) {
                ++v1;
            }
            e e0 = f0.a(v1);
            if(e0 == null) {
                return DebugLib.getinfo.x;
            }
            luaValue0 = e0.a;
            e1 = e0;
        }
        else if(luaValue0.B()) {
            e1 = f0.a(luaValue0);
        }
        else {
            return DebugLib.getinfo.a(v, "function or level");
        }
        g g0 = f0.a(s, ((LuaFunction)luaValue0), e1);
        LuaTable luaTable0 = new LuaTable();
        for(int v2 = 0; v2 < s.length(); ++v2) {
            switch(s.charAt(v2)) {
                case 76: {
                    if(luaValue0.j()) {
                        LuaTable luaTable1 = new LuaTable();
                        luaTable0.b(DebugLib.p, luaTable1);
                        int[] arr_v = luaValue0.k().a.t;
                        for(int v4 = 0; v4 < arr_v.length; ++v4) {
                            luaTable1.c(DebugLib.getinfo.d(arr_v[v4]), DebugLib.getinfo.v);
                        }
                    }
                    break;
                }
                case 83: {
                    LuaString luaString0 = DebugLib.getinfo.m(g0.c);
                    luaTable0.b(DebugLib.j, luaString0);
                    LuaString luaString1 = DebugLib.getinfo.m(g0.d);
                    luaTable0.b(DebugLib.k, luaString1);
                    LuaString luaString2 = DebugLib.getinfo.m(g0.l);
                    luaTable0.b(DebugLib.l, luaString2);
                    LuaLong luaLong0 = DebugLib.getinfo.d(g0.f);
                    luaTable0.b(DebugLib.m, luaLong0);
                    LuaLong luaLong1 = DebugLib.getinfo.d(g0.g);
                    luaTable0.b(DebugLib.n, luaLong1);
                    break;
                }
                case 102: {
                    if(luaValue0 != null) {
                        luaTable0.b(DebugLib.c, luaValue0);
                    }
                    break;
                }
                case 108: {
                    LuaLong luaLong2 = DebugLib.getinfo.d(g0.e);
                    luaTable0.b(DebugLib.o, luaLong2);
                    break;
                }
                case 110: {
                    LuaString luaString3 = DebugLib.h;
                    LuaValue luaValue1 = g0.a == null ? DebugLib.getinfo.u : LuaValue.m(g0.a);
                    luaTable0.b(luaString3, luaValue1);
                    LuaString luaString4 = LuaValue.m(g0.b);
                    luaTable0.b(DebugLib.i, luaString4);
                    break;
                }
                case 0x74: {
                    LuaBoolean luaBoolean0 = DebugLib.getinfo.b(g0.k);
                    luaTable0.b(DebugLib.d, luaBoolean0);
                    break;
                }
                case 0x75: {
                    LuaLong luaLong3 = DebugLib.getinfo.d(g0.h);
                    luaTable0.b(DebugLib.f, luaLong3);
                    LuaLong luaLong4 = DebugLib.getinfo.d(g0.i);
                    luaTable0.b(DebugLib.g, luaLong4);
                    luaTable0.b(DebugLib.e, (g0.j ? DebugLib.getinfo.v : DebugLib.getinfo.w));
                    break;
                }
                default: {
                    int v3 = s.charAt(v2);
                    DebugLib.getinfo.a(v + 1, "debug.getinfo", "invalid option: \'" + ((char)v3) + "\' [0x" + Integer.toHexString(v3) + "] at index " + (v2 + 1) + " in \'" + s + "\'");
                }
            }
        }
        return luaTable0;
    }
}

