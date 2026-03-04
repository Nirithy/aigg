package luaj;

import java.util.Locale;

public abstract class LuaFunction extends LuaValue {
    private static final String a;
    public static LuaValue s;

    static {
        LuaFunction.a = "android.ext.Script";
    }

    @Override  // luaj.LuaValue
    public boolean B() {
        return true;
    }

    @Override  // luaj.LuaValue
    public LuaFunction C() {
        return this;
    }

    public String D() [...] // 潜在的解密器

    @Override  // luaj.LuaValue
    public LuaFunction a(LuaFunction luaFunction0) {
        return this;
    }

    // 去混淆评级： 低(40)
    @Override  // luaj.LuaValue
    public String d_() [...] // 潜在的解密器

    public static String e(String s) {
        int v = s.lastIndexOf(36);
        int v1 = s.lastIndexOf(46);
        int v2 = Math.max(v1, v) + 1;
        String s1 = s.substring((s.charAt(v2) == 0x5F ? v2 + 1 : Math.max(v1, v) + 1));
        if(s.startsWith("android.ext.Script")) {
            return "gg." + s1;
        }
        if(v > v1 && s.contains("Lib$") && !s.contains("BaseLib$")) {
            String s2 = s.substring(v1 + 1, v - 3).toLowerCase(Locale.ENGLISH) + '.';
            return s2 == null ? s1 : s2 + s1;
        }
        return s1;
    }

    @Override  // luaj.LuaValue
    public int e_() {
        return 6;
    }

    @Override  // luaj.LuaValue
    public String f_() {
        return "function";
    }

    // 去混淆评级： 低(20)
    public String g_() {
        return "LuaFunction";
    }

    @Override  // luaj.LuaValue
    public LuaValue i() {
        return LuaFunction.s;
    }

    // 去混淆评级： 低(20)
    @Override  // luaj.LuaValue
    public LuaString t() {
        return LuaFunction.m("function: LuaFunction");
    }
}

