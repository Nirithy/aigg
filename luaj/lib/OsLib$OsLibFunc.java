package luaj.lib;

import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.o;

class OsLib.OsLibFunc extends VarArgFunction {
    final OsLib a;

    public OsLib.OsLibFunc(OsLib osLib0, int v, String s) {
        this.a = osLib0;
        super();
        this.aj = v;
        this.ak = s;
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        try {
            switch(this.aj) {
                case 0: {
                    return OsLib.OsLibFunc.c(this.a.S());
                }
                case 1: {
                    String s = ap0.c(1, "%c");
                    long v = ap0.h(2) ? ap0.x(2) : this.a.b(null);
                    if(v == -1L) {
                        v = this.a.b(null);
                    }
                    if(v > 0x20C49BA5E353F7L || v < 0xFFDF3B645A1CAC09L) {
                        throw new o("time result cannot be represented in this installation");
                    }
                    Calendar calendar0 = Calendar.getInstance((s.startsWith("!") ? TimeZone.getTimeZone("UTC") : TimeZone.getDefault()));
                    calendar0.setTimeInMillis(v * 1000L);
                    if(s.startsWith("!")) {
                        s = s.substring(1);
                    }
                    if(s.equals("*t")) {
                        ap ap1 = LuaValue.ad();
                        this.a.a(((LuaTable)ap1), calendar0);
                        return ap1;
                    }
                    return OsLib.OsLibFunc.m(this.a.a(s, calendar0));
                }
                case 2: {
                    double f = ap0.m(1);
                    double f1 = ap0.m(2);
                    return OsLib.OsLibFunc.c(OsLib.a(this.a, f, f1));
                }
                case 3: {
                    String s1 = ap0.c(1, null);
                    return this.a.c(s1);
                }
                case 4: {
                    ap0.d(1, 0);
                    return OsLib.OsLibFunc.x;
                }
                case 5: {
                    String s2 = ap0.r(1);
                    String s3 = this.a.d(s2);
                    return s3 != null ? OsLib.OsLibFunc.m(s3) : OsLib.OsLibFunc.u;
                }
                case 6: {
                    String s4 = ap0.r(1);
                    this.a.a(s4);
                    return LuaValue.v;
                }
                case 7: {
                    String s5 = ap0.r(1);
                    String s6 = ap0.r(2);
                    this.a.a(s5, s6);
                    return LuaValue.v;
                }
                case 8: {
                    String s7 = ap0.c(1, null);
                    String s8 = ap0.c(2, "all");
                    String s9 = OsLib.a(this.a, s7, s8);
                    return s9 != null ? OsLib.OsLibFunc.m(s9) : OsLib.OsLibFunc.u;
                }
                case 9: {
                    LuaTable luaTable0 = ap0.a(1, null);
                    return OsLib.OsLibFunc.d(this.a.b(luaTable0));
                }
                case 10: {
                    return OsLib.OsLibFunc.m(OsLib.b(this.a));
                }
                default: {
                    return OsLib.OsLibFunc.x;
                }
            }
        }
        catch(IOException iOException0) {
            return OsLib.OsLibFunc.a(OsLib.OsLibFunc.u, OsLib.OsLibFunc.m(iOException0.getMessage()), OsLib.OsLibFunc.d(this.aj));
        }
    }
}

