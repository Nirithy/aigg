package luaj.lib;

import android.ext.la;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import luaj.Globals;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.a;
import luaj.ap;
import luaj.o;

public class OsLib extends TwoArgFunction {
    private static final long a;
    private static long b;
    private Globals c;

    static {
        OsLib.a = System.currentTimeMillis();
        OsLib.b = OsLib.a;
    }

    private double S() {
        return ((double)(System.currentTimeMillis() - OsLib.a - ((long)this.c.d))) / 1000.0;
    }

    private String T() [...] // 潜在的解密器

    private double a(double f, double f1) [...] // Inlined contents

    static double a(OsLib osLib0, double f, double f1) {
        return f - f1;
    }

    private int a(Calendar calendar0, boolean z) {
        int v = calendar0.get(6);
        int v1 = calendar0.get(7);
        if(z) {
            v1 = (v1 + 5) % 7 + 1;
        }
        if(v <= v1) {
            return 0;
        }
        int v2 = (v - v1) % 7;
        int v3 = ((int)Math.ceil(((float)(v - v2)) / 7.0f)) - 1;
        return v2 == 0 ? v3 : v3 + 1;
    }

    static String a(OsLib osLib0, String s, String s1) {
        return "C";
    }

    private Calendar a(Calendar calendar0) {
        int v = calendar0.get(6);
        int v1 = calendar0.get(7);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setLenient(true);
        calendar1.set(1, calendar0.get(1));
        calendar1.set(6, v - (v1 + 5) % 7 + 3);
        return calendar1;
    }

    private LuaValue a(LuaValue luaValue0, boolean z) {
        if(luaValue0.F()) {
            if(z) {
                throw new o("missing in date table");
            }
        }
        else if(!luaValue0.q_()) {
            throw new o("is not an integer");
        }
        return luaValue0;
    }

    private static LuaValue a(byte[] arr_b, int v, int v1) {
        return OsLib.a(1, "os.date", "invalid conversion specifier \'" + OsLib.e(arr_b, v, v1 - v) + "\' at offset " + v);
    }

    static void a(OsLib osLib0, int v) {
    }

    public String a(String s, Calendar calendar0) {
        int v5;
        int v3;
        byte[] arr_b = s.getBytes();
        a a0 = new a(arr_b.length);
        int v = 0;
        while(v < arr_b.length) {
            int v1 = arr_b[v];
            switch(v1) {
                case 10: {
                    a0.a("\n");
                    ++v;
                    continue;
                }
                case 37: {
                    if(v + 1 >= arr_b.length) {
                        OsLib.a(arr_b, v, v + 1);
                    }
                    int v2 = arr_b[v + 1];
                    if(v2 != 69 && v2 != 0x4F) {
                        v3 = v + 2;
                    }
                    else {
                        if(v + 2 >= arr_b.length) {
                            OsLib.a(arr_b, v, v + 2);
                        }
                        v3 = v + 3;
                        int v4 = arr_b[v + 2];
                        if((v2 == 69 ? "cCxXyY" : "deHImMSuUVwwy").indexOf(((int)(((char)(v4 & 0xFF))))) == -1) {
                            OsLib.a(arr_b, v, v3);
                        }
                        v2 = v4;
                    }
                    switch(v2) {
                        case 37: {
                            a0.a("%");
                            v5 = 0;
                            break;
                        }
                        case 67: {
                            a0.a(String.valueOf(calendar0.get(1) / 100 + 100).substring(1));
                            v5 = 0;
                            break;
                        }
                        case 71: {
                            a0.a(String.valueOf(this.c(calendar0) + 10000).substring(1));
                            v5 = 0;
                            break;
                        }
                        case 85: {
                            a0.a(String.valueOf(this.a(calendar0, false) + 100).substring(1));
                            v5 = 0;
                            break;
                        }
                        case 86: {
                            a0.a(String.valueOf(this.b(calendar0) + 100).substring(1));
                            v5 = 0;
                            break;
                        }
                        case 87: {
                            a0.a(String.valueOf(this.a(calendar0, true) + 100).substring(1));
                            v5 = 0;
                            break;
                        }
                        case 88: {
                            v5 = 84;
                            break;
                        }
                        case 99: {
                            a0.a(this.a("%a %b %d %H:%M:%S %Y", calendar0));
                            v5 = 0;
                            break;
                        }
                        case 101: {
                            int v6 = calendar0.get(5);
                            if(v6 < 10) {
                                a0.a(" ");
                            }
                            a0.a(String.valueOf(v6));
                            v5 = 0;
                            break;
                        }
                        case 103: {
                            a0.a(String.valueOf(this.c(calendar0) + 10000).substring(3));
                            v5 = 0;
                            break;
                        }
                        case 104: {
                            v5 = 98;
                            break;
                        }
                        case 110: {
                            a0.a("\n");
                            v5 = 0;
                            break;
                        }
                        case 0x74: {
                            a0.a("\t");
                            v5 = 0;
                            break;
                        }
                        case 0x75: {
                            a0.a(String.valueOf((calendar0.get(7) + 5) % 7 + 1));
                            v5 = 0;
                            break;
                        }
                        case 0x77: {
                            a0.a(String.valueOf((calendar0.get(7) + 6) % 7));
                            v5 = 0;
                            break;
                        }
                        case 120: {
                            v5 = 68;
                            break;
                        }
                        case 65: 
                        case 66: 
                        case 68: 
                        case 70: 
                        case 72: 
                        case 73: 
                        case 77: 
                        case 82: 
                        case 83: 
                        case 84: 
                        case 89: 
                        case 90: 
                        case 97: 
                        case 98: 
                        case 100: 
                        case 106: 
                        case 107: 
                        case 108: 
                        case 109: 
                        case 0x70: 
                        case 0x72: 
                        case 0x73: 
                        case 0x79: 
                        case 0x7A: {
                            v5 = v2;
                            break;
                        }
                        default: {
                            OsLib.a(arr_b, v, v3);
                            a0.a("%");
                            v5 = 0;
                        }
                    }
                    if(v5 != 0) {
                        a0.a(String.format(Locale.US, "%" + ((char)(v5 == 0x70 ? 84 : 0x74)) + ((char)(v5 & 0xFF)), calendar0));
                    }
                    break;
                }
                default: {
                    a0.a(((byte)v1));
                    ++v;
                    continue;
                }
            }
            v = v3;
        }
        return "";
    }

    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        String[] arr_s = {"clock", "date", "difftime", "execute", "exit", "getenv", "remove", "rename", "setlocale", "time", "tmpname"};
        this.c = luaValue1.c();
        LuaValue luaValue2 = new LuaTable();
        for(int v = 0; v < 11; ++v) {
            if(this.c.a || v != 3 && v != 4 && v != 6 && v != 7 && v != 10) {
                ((LuaTable)luaValue2).a(arr_s[v], new OsLib.OsLibFunc(this, v, arr_s[v]));
            }
        }
        luaValue1.a("os", luaValue2);
        if(!luaValue1.j("package").F()) {
            luaValue1.j("package").j("loaded").a("os", luaValue2);
        }
        return luaValue2;
    }

    protected void a(String s) {
        File file0 = this.c.d(s);
        if(!file0.exists()) {
            throw new IOException("No such file or directory: \'" + s + "\'");
        }
        if(!file0.delete()) {
            throw new IOException("Failed to delete: \'" + s + "\'");
        }
    }

    protected void a(String s, String s1) {
        File file0 = this.c.d(s);
        if(!file0.exists()) {
            throw new IOException("No such file or directory: \'" + s + "\'");
        }
        if(!file0.renameTo(this.c.d(s1))) {
            throw new IOException("Failed to rename \'" + s + "\' to \'" + s1 + "\'");
        }
    }

    void a(LuaTable luaTable0, Calendar calendar0) {
        luaTable0.a("year", LuaValue.d(calendar0.get(1)));
        luaTable0.a("month", LuaValue.d(calendar0.get(2) + 1));
        luaTable0.a("day", LuaValue.d(calendar0.get(5)));
        luaTable0.a("hour", LuaValue.d(calendar0.get(11)));
        luaTable0.a("min", LuaValue.d(calendar0.get(12)));
        luaTable0.a("sec", LuaValue.d(calendar0.get(13)));
        luaTable0.a("wday", LuaValue.d(calendar0.get(7)));
        luaTable0.a("yday", LuaValue.d(calendar0.get(6)));
        luaTable0.a("isdst", LuaValue.b(calendar0.getTimeZone().inDaylightTime(calendar0.getTime())));
    }

    private int b(Calendar calendar0) {
        return (this.a(calendar0).get(6) - 1) / 7 + 1;
    }

    private long b(LuaTable luaTable0) {
        String s;
        Calendar calendar0 = Calendar.getInstance();
        if(luaTable0 == null) {
            calendar0.add(14, -this.c.d);
            return calendar0.getTimeInMillis() / 1000L;
        }
        try {
            s = "year";
            calendar0.set(1, this.a(luaTable0.j("year"), true).v());
            s = "month";
            calendar0.set(2, this.a(luaTable0.j("month"), true).v() - 1);
            s = "day";
            calendar0.set(5, this.a(luaTable0.j("day"), true).v());
            s = "hour";
            calendar0.set(11, this.a(luaTable0.j("hour"), false).b_(12));
            s = "min";
            calendar0.set(12, this.a(luaTable0.j("min"), false).b_(0));
            s = "sec";
            calendar0.set(13, this.a(luaTable0.j("sec"), false).b_(0));
        }
        catch(o o0) {
            throw new o("field \'" + s + "\' " + o0.getMessage(), o0);
        }
        calendar0.set(14, 0);
        this.a(luaTable0, calendar0);
        return calendar0.getTimeInMillis() / 1000L;
    }

    // 去混淆评级： 低(20)
    static String b(OsLib osLib0) {
        return "/data/user/0/catch_.me_.if_.you_.can_/cache/.gg.2180788974413307940.tmp";
    }

    private int c(Calendar calendar0) {
        return this.a(calendar0).get(1);
    }

    private ap c(String s) {
        throw new o("Failed os.execute(\'" + s + "\'): disabled by security reason");
    }

    private String d(String s) {
        String s1 = null;
        if(s != null && s.length() != 0) {
            try {
                s1 = System.getenv(s);
            }
            catch(Throwable throwable0) {
                la.a(("Failed getenv \'" + s + "\'"), throwable0);
            }
            if(s1 == null) {
                try {
                    return System.getProperty(s);
                }
                catch(Throwable throwable1) {
                    la.a(("Failed getProperty \'" + s + "\'"), throwable1);
                    return null;
                }
            }
        }
        return s1;
    }

    private String e(String s, String s1) [...] // Inlined contents

    private void e(int v) {
    }
}

