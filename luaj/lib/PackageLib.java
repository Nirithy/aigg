package luaj.lib;

import luaj.Globals;
import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaValue;

public class PackageLib extends TwoArgFunction {
    public static final String a;
    static final LuaString b;
    static final LuaString c;
    static final LuaString d;
    static final LuaString e;
    static final LuaString f;
    Globals g;
    LuaTable h;
    public PackageLib.preload_searcher i;
    public PackageLib.lua_searcher j;
    public PackageLib.java_searcher k;
    static final LuaString l;
    static final String m;
    private static final LuaString n;

    static {
        String s;
        try {
            s = System.getProperty("luaj.package.path");
        }
        catch(Exception exception0) {
            System.out.println(exception0.toString());
            s = null;
        }
        if(s == null) {
            s = "?.lua";
        }
        PackageLib.a = s;
        PackageLib.b = PackageLib.m("loaded");
        PackageLib.n = PackageLib.m("loadlib");
        PackageLib.c = PackageLib.m("preload");
        PackageLib.d = PackageLib.m("path");
        PackageLib.e = PackageLib.m("searchpath");
        PackageLib.f = PackageLib.m("searchers");
        PackageLib.l = PackageLib.m("\u0001");
        PackageLib.m = "/";
    }

    // 去混淆评级： 低(30)
    private static final boolean a(char c) {
        return (c < 97 || c > 0x7A) && (c < 65 || c > 90) && (c < 0x30 || c > 57) ? c == 36 || c == 46 || c == 0x5F : true;
    }

    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        this.g = luaValue1.c();
        this.g.a("require", new PackageLib.require(this));
        this.h = new LuaTable();
        LuaTable luaTable0 = this.h;
        LuaTable luaTable1 = new LuaTable();
        luaTable0.b(PackageLib.b, luaTable1);
        LuaTable luaTable2 = this.h;
        LuaTable luaTable3 = new LuaTable();
        luaTable2.b(PackageLib.c, luaTable3);
        LuaTable luaTable4 = this.h;
        LuaString luaString0 = LuaValue.m("?.lua");
        luaTable4.b(PackageLib.d, luaString0);
        LuaTable luaTable5 = this.h;
        PackageLib.loadlib packageLib$loadlib0 = new PackageLib.loadlib();
        luaTable5.b(PackageLib.n, packageLib$loadlib0);
        LuaTable luaTable6 = this.h;
        PackageLib.searchpath packageLib$searchpath0 = new PackageLib.searchpath(this);
        luaTable6.b(PackageLib.e, packageLib$searchpath0);
        LuaTable luaTable7 = new LuaTable();
        PackageLib.preload_searcher packageLib$preload_searcher0 = new PackageLib.preload_searcher(this);
        this.i = packageLib$preload_searcher0;
        luaTable7.a(1, packageLib$preload_searcher0);
        PackageLib.lua_searcher packageLib$lua_searcher0 = new PackageLib.lua_searcher(this);
        this.j = packageLib$lua_searcher0;
        luaTable7.a(2, packageLib$lua_searcher0);
        PackageLib.java_searcher packageLib$java_searcher0 = new PackageLib.java_searcher(this);
        this.k = packageLib$java_searcher0;
        luaTable7.a(3, packageLib$java_searcher0);
        this.h.b(PackageLib.f, luaTable7);
        this.h.c("config", "/\n;\n?\n!\n-\n");
        this.h.w(PackageLib.b).a("package", this.h);
        luaValue1.a("package", this.h);
        this.g.j = this;
        return luaValue1;
    }

    public static final String c(String s) {
        int v1 = s.length();
        int v2 = s.endsWith(".lua") ? v1 - 4 : v1;
        for(int v3 = 0; true; ++v3) {
            if(v3 >= v2) {
                return v1 == v2 ? s : s.substring(0, v2);
            }
            int v4 = s.charAt(v3);
            if(!PackageLib.a(((char)v4)) || (v4 == 0x2F || v4 == 92)) {
                StringBuffer stringBuffer0 = new StringBuffer(v2);
                for(int v = 0; v < v2; ++v) {
                    int v5 = s.charAt(v);
                    if(!PackageLib.a(((char)v5))) {
                        v5 = v5 != 0x2F && v5 != 92 ? 0x5F : 46;
                    }
                    stringBuffer0.append(((char)v5));
                }
                return stringBuffer0.toString();
            }
        }
    }

    @Override  // luaj.lib.LibFunction
    public String d_() {
        return "package";
    }
}

